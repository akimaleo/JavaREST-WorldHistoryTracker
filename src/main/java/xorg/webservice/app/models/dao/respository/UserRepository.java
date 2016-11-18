package xorg.webservice.app.models.dao.respository;


import xorg.webservice.app.models.pojo.dto.AccessUser;
import xorg.webservice.app.models.pojo.entity.User;

public interface UserRepository {
	
	//Declare CRUD-operation
	User getUserById ( String id ) throws Exception;
	
	User getUserByToken ( String token ) throws Exception;
	
	User getUser( String userName);
	
	User createUser( User user );
}
