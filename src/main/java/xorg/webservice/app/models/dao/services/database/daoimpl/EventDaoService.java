package xorg.webservice.app.models.dao.services.database.daoimpl;

import org.sql2o.Connection;
import org.sql2o.Sql2oException;
import xorg.webservice.app.models.dao.factory.AbstractDaoFactory;
import xorg.webservice.app.models.dao.respository.EventRepository;
import xorg.webservice.app.models.dao.services.database.AbstractDaoService;
import xorg.webservice.app.models.pojo.entity.Event;

import java.awt.*;
import java.awt.geom.Point2D;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by akimaleo on 12.11.16.
 */
public class EventDaoService extends AbstractDaoService implements EventRepository {

    public EventDaoService(AbstractDaoFactory dataBaseDaoDrivers) {

        super(dataBaseDaoDrivers);
    }

    @Override
    public List<Event> getUserEvents(String id) throws Sql2oException {
        try (Connection connection = daoFactory.getDataSourceController().open()) {
            String sql = "SELECT * FROM EVENT WHERE userId = :id";
            return connection.createQuery(sql, false).addParameter("id", id).executeAndFetch(Event.class);
        }
    }
    @Override
    public List<Event> getUserEventsByToken(String token) throws Sql2oException {
        try (Connection connection = daoFactory.getDataSourceController().open()) {
            String sql = "SELECT eventId, eventName,createDate,latitude,longitude FROM historyTracker.userEvents INNER JOIN users ON users.userId = userEvents.userId WHERE `accessToken` = :token;";
            return connection.createQuery(sql, false).addParameter("token", token).executeAndFetch(Event.class);
        }
    }
    @Override
    public List<Event> getEventsByLocation(Point position, float radius) {
        String sql = "SELECT * FROM userEvents WHERE ( SQRT(POW(:posX * latitude) + POW(:posY * longitude)) <= :radius )";
        try (Connection connection = daoFactory.getDataSourceController().open()) {
            return connection.createQuery(sql, false)
                    .addParameter("posX", position.getX())
                    .addParameter("posY", position.getY())
                    .addParameter("radius", radius)
                    .executeAndFetch(Event.class);

        }
    }


    @Override
    public List<Event> getEventsByLocationAndTime(Point2D.Double position, double radius, Timestamp from, Timestamp to) {
        //TODO: uncomment
//        radius /= 111;
        String sql = "SELECT * FROM userEvents WHERE ( SQRT(POW(:posX - latitude,2) + POW(:posY - longitude,2)) <= :radius ) AND createDate BETWEEN :from AND :to";
        try (Connection connection = daoFactory.getDataSourceController().open()) {
            return connection.createQuery(sql, false)
                    .addParameter("posX", position.getX())
                    .addParameter("posY", position.getY())
                    .addParameter("radius", radius)
                    .addParameter("from", from)
                    .addParameter("to", to)
                    .executeAndFetch(Event.class);

        }
    }

    @Override
    public void createEvent(Event event) {
        String sql = "INSERT INTO userEvents(eventName, longitude, latitude, userId) VALUE(:name, :long, :lat, :userid)";
        try (Connection connection = daoFactory.getDataSourceController().open()) {
            connection.createQuery(sql, false)
                    .addParameter("name", event.getEventName())
                    .addParameter("lat", event.getLatitude())
                    .addParameter("long", event.getLongitude())
                    .addParameter("userid", event.getUserId())
                    .executeUpdate();
        } catch (Sql2oException e) {
            e.printStackTrace();
        }
        System.out.println("\n\nCreate event user: " + event.toString());

    }
}
