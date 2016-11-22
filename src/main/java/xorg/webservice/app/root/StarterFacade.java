package xorg.webservice.app.root;


import xorg.webservice.app.utils.conf.server.SparkServerConfig;
import xorg.webservice.app.utils.routing.Router;

import static spark.debug.DebugScreen.enableDebugScreen;


public class StarterFacade {


    public static void start( ) {

        initServerConfiguration( );
        initRoutingService( );

    }

    private static void initRoutingService( ) {
       
        Router.init();
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
