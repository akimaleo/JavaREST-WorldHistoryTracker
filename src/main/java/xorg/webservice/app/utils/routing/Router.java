package xorg.webservice.app.utils.routing;


import xorg.webservice.app.controllers.users.UserCtrl;
import xorg.webservice.app.utils.path.Path;

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
        System.out.print ( Path.WebService.REGISTRATION );
        post ( Path.WebService.REGISTRATION, UserCtrl.getCreateUser () );
    }
}