package xorg.webservice.app.models.dao.services.database.daoimpl;


import org.sql2o.Connection;
import org.sql2o.Sql2oException;
import xorg.webservice.app.models.dao.factory.AbstractDaoFactory;
import xorg.webservice.app.models.dao.respository.UserRepository;
import xorg.webservice.app.models.dao.services.database.AbstractDaoService;
import xorg.webservice.app.models.pojo.dto.AccessUser;
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
		String sql = "SELECT * FROM users WHERE userId = :id";
		try ( Connection connection = daoFactory.getDataSourceController ().open () ) {
			return connection.createQuery ( sql, false ).addParameter ( "id", id ).executeAndFetchFirst ( User.class );
		}
	}
	
	@Override
	public User getUserByToken ( String token ) throws Sql2oException {
		String sql = "SELECT * FROM users WHERE accessToken = :token";
		try ( Connection connection = daoFactory.getDataSourceController ().open () ) {
			return connection.createQuery ( sql, false ).addParameter ( "token", token ).executeAndFetchFirst ( User.class );
		}
	}
	
	@Override
	public User getUser ( AccessUser user ) throws Sql2oException{
		String sql = "SELECT * FROM users WHERE userName = :name";
		try ( Connection connection = daoFactory.getDataSourceController ().open () ) {
			return connection.createQuery ( sql, false )
					.addParameter ("name", user.getUserName ())
					.executeAndFetchFirst ( User.class );
		}
		
	}
}
