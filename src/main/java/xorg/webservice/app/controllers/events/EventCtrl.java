package xorg.webservice.app.controllers.events;

import lombok.Getter;
import org.eclipse.jetty.http.HttpHeader;
import spark.Route;
import xorg.webservice.app.models.dao.factory.AbstractDaoFactory;
import xorg.webservice.app.models.dao.services.database.daoimpl.EventDaoService;
import xorg.webservice.app.models.dao.services.database.daoimpl.UserDaoService;
import xorg.webservice.app.models.pojo.dto.EventSearchDto;
import xorg.webservice.app.models.pojo.dto.InEvent;
import xorg.webservice.app.models.pojo.entity.Event;
import xorg.webservice.app.models.pojo.entity.User;
import xorg.webservice.app.utils.json.gson.GsonConverter;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.List;

/**
 * Created by akimaleo on 12.11.16.
 */
public class EventCtrl {
    private static EventDaoService service = AbstractDaoFactory.getDataBaseDaoFactory().getEventDaoService();
    private static UserDaoService userDaoService = AbstractDaoFactory.getDataBaseDaoFactory().getUserDaoService();
    /*CREATE TABLE `userEvents` (
      `eventId` int(11) NOT NULL AUTO_INCREMENT,
      `eventName` text NOT NULL,
      `createDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
      `latitude` double NOT NULL DEFAULT '0',
      `longitude` double NOT NULL DEFAULT '0',
      `userId` int(11) NOT NULL,
      PRIMARY KEY (`eventId`),
      KEY `userId` (`userId`),
      CONSTRAINT `userEvents_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `users` (`userId`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
    */
    @Getter
    private static Route createEvent = (request, response) -> {
        InEvent event = GsonConverter.fromJson(request.body(), InEvent.class);
        User user = userDaoService.getUserByToken(request.headers(HttpHeader.AUTHORIZATION.asString()));
        System.out.println("REQUEST AUTHORIZATION HEADER:" + request.headers(HttpHeader.AUTHORIZATION.asString()));
        if (user == null) {
            System.out.println("404");
            return "404 no user auth";
        }
        service.createEvent(new Event(event.getContent(), event.getLatitude(), event.getLongitude(), user.getUserId()));
        System.out.println("May create");

        return response;
    };

    @Getter
    private static Route getEventByLocation = (request, response) -> {
        User user = userDaoService.getUserByToken(request.headers(HttpHeader.AUTHORIZATION.asString()));
        EventSearchDto eventSearchDto = GsonConverter.fromJson(request.body(), EventSearchDto.class);
        List<Event> eventList = service.getEventsByLocation(new Point((int) eventSearchDto.getLatitude(), (int) eventSearchDto.getLongitude()), eventSearchDto.getRadius());
        return GsonConverter.toJson(eventList);
    };
    @Getter
    private static Route getEventByLocationAndDatetime = (request, response) -> {
//		User user = userDaoService.getUserByToken ( request.headers ( HttpHeader.AUTHORIZATION.asString () ) );
        EventSearchDto eventSearchDto = GsonConverter.fromJson(request.body(), EventSearchDto.class);
        List<Event> eventList = service.getEventsByLocationAndTime(
                new Point2D.Double(
                        eventSearchDto.getLatitude(),
                        eventSearchDto.getLongitude()),
                eventSearchDto.getRadius(),
                eventSearchDto.getFrom(),
                eventSearchDto.getTo());
        System.out.print("Return events: " + eventList);
        return GsonConverter.toJson(eventList);
    };

}
