package xorg.webservice.app.utils.security.hashing;


import org.mindrot.jbcrypt.BCrypt;

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
	
	
}
