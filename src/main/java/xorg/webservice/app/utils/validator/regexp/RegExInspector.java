package xorg.webservice.app.utils.validator.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by lonely on 29.08.16.
 */
public class RegExInspector {
	private static class REG_PATTERN {
		private static final String USERNAME_PATTERN = "^[a-zA-Z](.[a-zA-Z0-9_-]*){3,32}$";
		private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=_-])(?=\\S+$).{8,}$";
		private static final String USERMAIL_PATTERN = "^[a-zA-Z](.[a-zA-Z0-9_-]*){3,32}$";
		private static final String ACCESSTOKEN_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=_-])(?=\\S+$).{8,}$";
	}

	public static class UserInspector {
		public static boolean checkUserName( String userName ){
			Pattern pattern = Pattern.compile( REG_PATTERN.USERNAME_PATTERN );
			Matcher matcher = pattern.matcher( userName );
			return matcher.matches();
		}
		public static boolean checkPassword( String password ){
			Pattern pattern = Pattern.compile( REG_PATTERN.PASSWORD_PATTERN );
			Matcher matcher = pattern.matcher( password );
			return matcher.matches();
		}
	}

	public static class OrganisatonInspector {

	}


}
