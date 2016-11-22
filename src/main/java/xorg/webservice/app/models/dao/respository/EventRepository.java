package xorg.webservice.app.models.dao.respository;


import xorg.webservice.app.models.pojo.entity.Event;

import java.awt.*;
import java.sql.Timestamp;
import java.util.List;


public interface EventRepository {
	
	List< Event > getUserEvents ( String id );
	
	List< Event > getEventsByLocation ( Point position, float radius );
	
	List< Event > getEventsByLocationAndTime ( Point position, float radius, Timestamp from, Timestamp to );
	
	void createEvent ( Event event );
}
