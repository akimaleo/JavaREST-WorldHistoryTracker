package xorg.webservice.app.utils.security.verificaton;


import org.jetbrains.annotations.Contract;
import xorg.webservice.app.models.pojo.dto.AccessUser;

/**
 * Created by lonely on 19.08.16.
 * @author : Alexander Balyshyn
 * @version : v1
 */
public final class Checker {
	public static final class AUTH {

		/// to be continue...
		@Contract (value = "null, null -> false")
		public static boolean checkpw ( AccessUser authUserDto, AccessUser userFromDb ){
			return false;
		}
	}
}
