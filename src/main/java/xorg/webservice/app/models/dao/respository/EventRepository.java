package xorg.webservice.app.models.dao.respository;


import xorg.webservice.app.models.pojo.entity.Event;

import java.awt.*;
import java.util.List;


public interface EventRepository {

    List<Event> getUserEvents(String id);
    List<Event> getEventsByLocation(Point position,float radius);

}
