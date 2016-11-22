package xorg.webservice.app.utils.routing;


import xorg.webservice.app.controllers.events.EventCtrl;
import xorg.webservice.app.controllers.users.UserCtrl;
import xorg.webservice.app.utils.path.Path;

import static spark.Spark.get;
import static spark.Spark.post;


/**
 * Created by lonely on 31.08.16.
 *
 * @author : Alexander Balyshyn
 * @version : v1
 */
public class Router{
    
    public static void init( ) {
        post ( Path.WebService.AUTH, UserCtrl.getAuth () );
        post ( Path.WebService.REGISTRATION, UserCtrl.getCreateUser () );
        post( Path.WebService.EVENT_ADD, EventCtrl.getCreateEvent());
        post( Path.WebService.EVENTS_WITH_LOCATION, EventCtrl.getGetEventByLocationAndDatetime());
    }
}