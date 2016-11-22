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
import java.util.List;

/**
 * Created by akimaleo on 12.11.16.
 */
public class EventCtrl {
	private static EventDaoService service = AbstractDaoFactory.getDataBaseDaoFactory ().getEventDaoService ();
	private static UserDaoService userDaoService = AbstractDaoFactory.getDataBaseDaoFactory ().getUserDaoService ();
	
	@Getter
	private static Route createEvent = ( request, response ) -> {
		InEvent event = GsonConverter.fromJson ( request.body (), InEvent.class );
		
		User user = userDaoService.getUserByToken ( request.headers ( HttpHeader.AUTHORIZATION.asString () ) );
		service.createEvent ( new Event ( event.getContent (), event.getLongitude (), event.getLatitude (), user.getUserId () ) );
		return response;
	};

	@Getter
	private static Route getEventByLocation = ( request, response ) -> {
		User user = userDaoService.getUserByToken ( request.headers ( HttpHeader.AUTHORIZATION.asString () ) );
		EventSearchDto eventSearchDto = GsonConverter.fromJson ( request.body (), EventSearchDto.class );
		List< Event > eventList =  service.getEventsByLocation ( new Point ( (int)eventSearchDto .getLatitude (), (int)eventSearchDto.getLongitude () ), eventSearchDto.getRadius () );
		return GsonConverter.toJson ( eventList );
	};
	@Getter
	private static Route getEventByLocationAndDatetime = (request, response ) -> {
		User user = userDaoService.getUserByToken ( request.headers ( HttpHeader.AUTHORIZATION.asString () ) );
		EventSearchDto eventSearchDto = GsonConverter.fromJson ( request.body (), EventSearchDto.class );
		List< Event > eventList =  service.getEventsByLocationAndTime ( new Point ( (int)eventSearchDto .getLatitude (), (int)eventSearchDto.getLongitude () ), eventSearchDto.getRadius (), eventSearchDto.getFrom (), eventSearchDto.getTo () );
		return GsonConverter.toJson ( eventList );
	};

}
