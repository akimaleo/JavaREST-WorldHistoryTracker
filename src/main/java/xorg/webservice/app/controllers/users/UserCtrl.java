package xorg.webservice.app.controllers.users;


import lombok.Getter;
import org.eclipse.jetty.http.HttpHeader;
import org.slf4j.*;
import spark.Route;
import xorg.webservice.app.models.dao.factory.AbstractDaoFactory;
import xorg.webservice.app.models.dao.services.database.daoimpl.UserDaoService;
import xorg.webservice.app.models.pojo.dto.AccessUser;
import xorg.webservice.app.models.pojo.entity.User;
import xorg.webservice.app.utils.json.gson.GsonConverter;
import xorg.webservice.app.utils.security.hashing.WebServiceSecurity;


public class UserCtrl {
	private static ILoggerFactory loggerFactory = LoggerFactory.getILoggerFactory ();
	
	private final static Logger logger = loggerFactory.getLogger ( "UserService" );
	private final static Marker marker = MarkerFactory.getMarker ( " CLIENT REQUEST = ? = ? + ====" );
	
	private static UserDaoService service = AbstractDaoFactory.getDataBaseDaoFactory ().getUserDaoService ();
	
	@Getter
	private static Route createUser = ( request, response ) -> {
		AccessUser accessUser = GsonConverter.fromJson ( request.body (), AccessUser.class );
		User userToStorage = WebServiceSecurity.registration ( accessUser );
		service.createUser ( userToStorage );
		User user = service.getUser ( accessUser.getUserName () );
		User verifiedUser = WebServiceSecurity.getAccessToken ( accessUser, user );
		service.updateUser ( verifiedUser );
		response.header ( HttpHeader.AUTHORIZATION.asString (), verifiedUser.getAccessToken () );
		return "";
		
	};
	
	@Getter
	private static Route auth = ( request, response ) -> {
		try{
			AccessUser accessUser = GsonConverter.fromJson ( request.body (), AccessUser.class );
			logger.info ( accessUser.toString () );
			User user = service.getUser ( accessUser.getUserName () );
			User verifiedUser = WebServiceSecurity.getAccessToken ( accessUser, user );
			service.updateUser ( verifiedUser );
			response.header ( HttpHeader.AUTHORIZATION.asString (), verifiedUser.getAccessToken () );
			return null;
		}
		catch ( Exception e ) {
			response.header (
					HttpHeader.AUTHORIZATION.asString (),
					"NULL");
			return "";
		}
		
	};
}
