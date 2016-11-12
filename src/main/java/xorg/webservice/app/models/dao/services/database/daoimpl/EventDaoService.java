package xorg.webservice.app.models.dao.services.database.daoimpl;

import org.sql2o.Connection;
import xorg.webservice.app.models.dao.factory.AbstractDaoFactory;
import xorg.webservice.app.models.dao.respository.EventRepository;
import xorg.webservice.app.models.dao.respository.UserRepository;
import xorg.webservice.app.models.dao.services.database.AbstractDaoService;
import xorg.webservice.app.models.pojo.entity.Event;
import xorg.webservice.app.models.pojo.entity.User;

import java.awt.*;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;
import java.util.StringJoiner;

/**
 * Created by akimaleo on 12.11.16.
 */
public class EventDaoService extends AbstractDaoService implements EventRepository {

    public EventDaoService(AbstractDaoFactory dataBaseDaoDrivers) {

        super(dataBaseDaoDrivers);
    }

    //TODO:get lists
    @Override
    public List<Event> getUserEvents(String id) {
        try (Connection connection = daoFactory.getDataSourceController().open()) {
            String sql = "SELECT * FROM EVENT WHERE `id` = " + id + ";";
            return connection.createQuery("SQL", false).addParameter("id", id).executeAndFetch(Event.class);
        }
    }

    @Override
    public List<Event> getEventsByLocation(Point position, float radius) {
        try (Connection connection = daoFactory.getDataSourceController().open()) {
            String sql = "SELECT * FROM EVENT" +
                    "WHERE `longitude` BETWEEN " + (position.y - radius) + " AND " + (position.y + radius) +
                    " AND `latitude` BETWEEN" + (position.x - radius) + " AND " + (position.x + radius) + ";";
            return connection.createQuery(sql).executeAndFetch(Event.class);
        }
    }

    @Override
    public List<Event> getEventsByLocationAndTime(Point position, float radius, Timestamp from, Timestamp to) {
        try (Connection connection = daoFactory.getDataSourceController().open()) {
            String sql = "SELECT * FROM EVENT" +
                    "WHERE `longitude` BETWEEN " + (position.y - radius) + " AND " + (position.y + radius) +
                    " AND `latitude` BETWEEN " + (position.x - radius) + " AND " + (position.x + radius) +
                    " AND `dateTimr` BETWEEN " + from.toString() + " AND " + to.toString() + ";";
            return connection.createQuery(sql).executeAndFetch(Event.class);
        }
    }
}
