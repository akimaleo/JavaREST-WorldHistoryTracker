package xorg.webservice.app.models.dao.respository;


import xorg.webservice.app.models.pojo.entity.Event;

import java.awt.geom.Point2D;
import java.sql.Timestamp;
import java.util.List;


public interface EventRepository {
	
	List< Event > getUserEvents ( String id );
	
	List< Event > getEventsByLocation ( Point2D position, float radius );
	
	List< Event > getEventsByLocationAndTime ( Point2D position, float radius, Timestamp from, Timestamp to );
	
}
