package xorg.webservice.app.root;


import xorg.webservice.app.utils.conf.server.SparkServerConfig;
import xorg.webservice.app.utils.routing.Router;
import xorg.webservice.app.utils.routing.Routing;

import static spark.debug.DebugScreen.enableDebugScreen;


/**
 * Created by lonely on 31.08.16.
 *
 * @author : Alexander Balyshyn
 * @version : v1
 */
public class StarterFacade {


    public static void start( ) {

        initServerConfiguration( );
        initRoutingService( );

    }

    private static void initRoutingService( ) {
        Routing router = new Router();
        router.init();
    }

    private static void initServerConfiguration( ) {

        SparkServerConfig.init( );
        enableDebugScreen( );

    }

    private void initDaemonMailService( ) {

    }

    private void initWebSocketService( ) {

    }


}
