package xorg.webservice.app.models.dao.services.database.daoimpl;


import org.sql2o.Connection;
import org.sql2o.Sql2oException;
import xorg.webservice.app.models.dao.factory.AbstractDaoFactory;
import xorg.webservice.app.models.dao.respository.UserRepository;
import xorg.webservice.app.models.dao.services.database.AbstractDaoService;
import xorg.webservice.app.models.pojo.entity.User;


/**
 * Created by raccoon on 06.09.16.
 */
public class UserDaoService extends AbstractDaoService implements UserRepository {

    public UserDaoService(AbstractDaoFactory dataBaseDaoDrivers) {

        super(dataBaseDaoDrivers);
    }


    @Override
    public User getUserById(String id) throws Exception {
        String sql = "SELECT * FROM users WHERE userId = :id";
        try (Connection connection = daoFactory.getDataSourceController().open()) {
            return connection.createQuery(sql, false).addParameter("id", id).executeAndFetchFirst(User.class);
        }
    }

    @Override
    public User getUserByToken(String token) throws Sql2oException {
        String sql = "SELECT * FROM users WHERE accessToken = :token";
        try (Connection connection = daoFactory.getDataSourceController().open()) {
            return connection.createQuery(sql, false).addParameter("token", token).executeAndFetchFirst(User.class);
        }
    }

    @Override
    public User getUser(String username) throws Sql2oException {
        String sql = "SELECT * FROM users WHERE userName = :name";
        try (Connection connection = daoFactory.getDataSourceController().open()) {
            return connection.createQuery(sql, false)
                    .addParameter("name", username)
                    .executeAndFetchFirst(User.class);
        }

    }

    @Override
    public User createUser(User user) {
        String sql = "INSERT INTO users (userName,hashPassword,encryptSalt) VALUES (:userName,:hashPassword,:encryptSalt)";
        try (Connection connection = daoFactory.getDataSourceController().open()) {
            connection.createQuery(sql, false)
                    .addParameter("userName", user.getUserName())
                    .addParameter("hashPassword", user.getHashPassword())
                    .addParameter("encryptSalt", user.getEncryptSalt())
                    .executeUpdate();
            return getUser(user.getUserName());
        }
    }
	
	@Override
	public User updateUser ( User user ) {
		String sql = "UPDATE users SET accessToken = :token WHERE userId = :id";
		try(Connection connection = daoFactory.getDataSourceController ().open ()){
			connection.createQuery ( sql, false)
					.addParameter ( "token", user.getAccessToken () )
					.addParameter ( "id", user.getUserId () )
					.executeUpdate ();
		}
		return getUser ( user.getUserName () );
	}
}
