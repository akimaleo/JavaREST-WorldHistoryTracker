package xorg.webservice.app.controllers.events;

import lombok.Getter;
import spark.Route;
import xorg.webservice.app.models.dao.factory.AbstractDaoFactory;
import xorg.webservice.app.models.dao.services.database.daoimpl.EventDaoService;
import xorg.webservice.app.models.dao.services.database.daoimpl.UserDaoService;
import xorg.webservice.app.utils.json.gson.GsonConverter;

/**
 * Created by akimaleo on 12.11.16.
 */
public class EventCtrl {
    private static EventDaoService service = AbstractDaoFactory.getDataBaseDaoFactory ().getEventDaoService ();

    @Getter
    private static Route genRandToken = (req, res) -> {
        return  GsonConverter.toJson ( "JSON" );
    };
}
