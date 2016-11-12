package xorg.webservice.app.models.dao.factory;


import xorg.webservice.app.models.dao.services.database.daoimpl.EventDaoService;
import xorg.webservice.app.models.dao.services.database.daoimpl.UserDaoService;

/**
 * Created by lonely on 15.08.16.
 */
public abstract class AbstractDaoFactory implements DataBaseDaoDrivers {
	
	public static AbstractDaoFactory getDataBaseDaoFactory( ) {
		return DataBaseDaoFactory.getInstance();
	}

	public UserDaoService getUserDaoService ( ){
		return new UserDaoService (this);
	}
	public EventDaoService getEventDaoService ( ){
		return new EventDaoService(this);
	}
}
