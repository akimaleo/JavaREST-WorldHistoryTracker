package xorg.webservice.app.models.dao.respository;


import xorg.webservice.app.models.pojo.entity.User;

/**
 * Created by raccoon on 10/5/16.
 *
 * @version: 1.0beta
 */
public interface UserRepository {
	
	//Declare CRUD-operation
	User getUserById ( String id ) throws Exception;
	User getUserByToken ( String token ) throws Exception;
}
