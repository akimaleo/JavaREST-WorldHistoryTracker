package xorg.webservice.app.utils.conf.server;


import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import xorg.webservice.app.utils.propsreader.ServerConfReader;

import static spark.Spark.staticFiles;
import static spark.Spark.threadPool;


/**
 * Created by raccoon on 05.09.16.
 */
public class SparkServerConfig {

    private static ILoggerFactory loggerFactory;

    private final static Logger logger;

    static {

        // load resource props for ServerConf and RoutingConfig
        ServerConfReader.load( );
        loggerFactory = LoggerFactory.getILoggerFactory( );
        logger = loggerFactory.getLogger( "Configuration Logger" );
    }

    public static void init( ) {

        staticFiles.location( ServerConfReader.get( "server.staticFiles" ) );
        threadPool( Integer.parseInt( ServerConfReader.get( "server.threadPoolSize" ) ) );
        logger.info( "ServerConfiguration: THREAD - " + ServerConfReader.get( "server.threadPoolSize" ) );
    }

}
