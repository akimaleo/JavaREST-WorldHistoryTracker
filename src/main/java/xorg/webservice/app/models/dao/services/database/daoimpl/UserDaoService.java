package xorg.webservice.app.models.dao.services.database.daoimpl;


import org.sql2o.Connection;
import xorg.webservice.app.models.dao.factory.AbstractDaoFactory;
import xorg.webservice.app.models.dao.respository.UserRepository;
import xorg.webservice.app.models.dao.services.database.AbstractDaoService;
import xorg.webservice.app.models.pojo.entity.User;


/**
 * Created by raccoon on 06.09.16.
 */
public class UserDaoService extends AbstractDaoService implements UserRepository {
	
	public UserDaoService ( AbstractDaoFactory dataBaseDaoDrivers ) {
		
		super ( dataBaseDaoDrivers );
	}
	
	
	@Override
	public User getUserById ( String id ) throws Exception {
		
		try ( Connection connection = daoFactory.getDataSourceController ().open () ) {
			return connection.createQuery ( "SQL", false ).addParameter ( "id", "smt" ).executeAndFetchFirst ( User.class );
		}
	}
}
