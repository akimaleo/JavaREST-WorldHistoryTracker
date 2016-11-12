package xorg.webservice.app.utils.routing;


import xorg.webservice.app.controllers.users.UserCtrl;

import static spark.Spark.*;


/**
 * Created by lonely on 31.08.16.
 *
 * @author : Alexander Balyshyn
 * @version : v1
 */
public class Router implements Routing{


    @Override
    public void init( ) {

        get( "/index", UserCtrl.getGenRandToken () );
    }
}