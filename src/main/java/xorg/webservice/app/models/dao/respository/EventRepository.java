package xorg.webservice.app.models.dao.respository;


import org.sql2o.Connection;
import org.sql2o.Sql2oException;
import xorg.webservice.app.models.pojo.entity.Event;

import java.awt.*;
import java.awt.geom.Point2D;
import java.sql.Timestamp;
import java.util.List;


public interface EventRepository {

    List<Event> getUserEvents(String id);

    List<Event> getEventsByLocation(Point position, float radius);

    List<Event> getEventsByLocationAndTime(Point2D.Double position, double radius, Timestamp from, Timestamp to);

    List<Event> getUserEventsByToken(String token);

    void createEvent(Event event);
}
