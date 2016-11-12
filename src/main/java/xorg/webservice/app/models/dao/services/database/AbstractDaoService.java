package xorg.webservice.app.models.dao.services.database;


import xorg.webservice.app.models.dao.factory.AbstractDaoFactory;

/**
 * Created by raccoon on 06.09.16.
 */
public class AbstractDaoService {
	
	protected AbstractDaoFactory daoFactory;
	
	public AbstractDaoService ( AbstractDaoFactory daoFactory ) {
		this.daoFactory = daoFactory;
	}
}
