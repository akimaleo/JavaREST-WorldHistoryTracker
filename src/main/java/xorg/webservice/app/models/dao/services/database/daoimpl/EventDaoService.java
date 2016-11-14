package xorg.webservice.app.models.dao.services.database.daoimpl;

import org.sql2o.Connection;
import org.sql2o.Sql2oException;
import xorg.webservice.app.models.dao.factory.AbstractDaoFactory;
import xorg.webservice.app.models.dao.respository.EventRepository;
import xorg.webservice.app.models.dao.services.database.AbstractDaoService;
import xorg.webservice.app.models.pojo.entity.Event;

import java.awt.geom.Point2D;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by akimaleo on 12.11.16.
 */
public class EventDaoService extends AbstractDaoService implements EventRepository {
	
	public EventDaoService ( AbstractDaoFactory dataBaseDaoDrivers ) {
		
		super ( dataBaseDaoDrivers );
	}
	
	@Override
	public List< Event > getUserEvents ( String id ) throws Sql2oException {
		try ( Connection connection = daoFactory.getDataSourceController ().open () ) {
			String sql = "SELECT * FROM EVENT WHERE userId = :id";
			return connection.createQuery ( sql, false ).addParameter ( "id", id ).executeAndFetch ( Event.class );
		}
	}
	
	@Override
	public List< Event > getEventsByLocation ( Point2D position, float radius ) {
		String sql = "SELECT * FROM userEvents WHERE longitude BETWEEN :topBorder AND :bottomBorder AND latitude BETWEEN :leftBorder AND :rightBorder";
		try ( Connection connection = daoFactory.getDataSourceController ().open () ) {
			connection.createQuery ( sql, false )
					.addParameter ( "topBorder", position.getY ()+radius )
					.addParameter ( "bottomBorder", position.getY ()-radius )
					.addParameter ( "leftBorder", position.getX ()-radius )
					.addParameter ( "rightBorder", position.getX ()+radius )
					.executeAndFetch ( Event.class );
					
		}
		return null;
	}
	
	
	@Override
	public List< Event > getEventsByLocationAndTime ( java.awt.geom.Point2D position, float radius, Timestamp from, Timestamp to ) {
		try ( Connection connection = daoFactory.getDataSourceController ().open () ) {
			String sql = "SELECT * FROM EVENT" +
					"WHERE `longitude` BETWEEN " + ( position.getY () - radius ) + " AND " + ( position.getY () + radius ) +
					" AND `latitude` BETWEEN " + ( position.getX () - radius ) + " AND " + ( position.getX () + radius ) +
					" AND `dateTime` BETWEEN " + from.toString () + " AND " + to.toString () + ";";
			return connection.createQuery ( sql ).executeAndFetch ( Event.class );
		}
	}
	
	;
}
