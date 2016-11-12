package xorg.webservice.app.controllers.users;


import lombok.Getter;
import spark.Route;
import xorg.webservice.app.models.dao.factory.AbstractDaoFactory;
import xorg.webservice.app.models.dao.services.database.daoimpl.UserDaoService;
import xorg.webservice.app.utils.json.gson.GsonConverter;

/**
 * Created by raccoon on 19.09.16.
 *
 * @version: 1.0beta
 */
public class UserCtrl {

	private static UserDaoService service = AbstractDaoFactory.getDataBaseDaoFactory ().getUserDaoService ();
	
	@Getter
	private static Route  genRandToken = (req, res) -> {
		return  GsonConverter.toJson ( "JSON" );
	};
}
