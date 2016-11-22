package xorg.webservice.app.utils.security.hashing;


import org.mindrot.jbcrypt.BCrypt;
import xorg.webservice.app.models.pojo.dto.AccessUser;
import xorg.webservice.app.models.pojo.entity.User;

import java.io.Serializable;


/**
 * Created by lonely on 18.08.16.
 *
 * @author : Alexander Balyshyn
 * @version : v1
 */
public class WebServiceSecurity {
	
	private enum HasherPrivateData implements Serializable {
		INSTANCE;
		
		private static String salt = BCrypt.gensalt ( 4 );
		
		HasherPrivateData ( ) {
			
		}
		
		public String getSalt ( ) {
			
			return salt;
		}
	}
	
	public static User getAccessToken ( AccessUser accessUser, User user ) {
		if ( BCrypt.checkpw ( accessUser.getPassword (), user.getHashPassword () ) ) {
			user.setAccessToken ( BCrypt.hashpw ( user.getUserName ().concat ( String.valueOf ( user.getUserId () ) ), BCrypt.gensalt (8) ) );
			return user;
		} else {
			user.setAccessToken ( "" );
			return user;
		}
	}
	
	public static User logOut ( User user ) {
		user.setAccessToken ( "" );
		return user;
	}
	
	public static User registration(AccessUser accessUser){
		String salt = BCrypt.gensalt (8);
		return new User (
				accessUser.getUserName (),
				BCrypt.hashpw ( accessUser.getPassword (), salt ),
				salt
		);
	}
	
	
}
