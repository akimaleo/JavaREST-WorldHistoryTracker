package xorg.webservice.app.root;


import org.slf4j.*;


public class AppInitializer {
	
	private static ILoggerFactory loggerFactory = LoggerFactory.getILoggerFactory ();
	
	private final static Logger logger = loggerFactory.getLogger ( "WebService" );
	private final static Marker marker = MarkerFactory.getMarker ( "Main" );
	
	public static void main ( String[] args ) {
		
		logger.info ( marker, "WebService is started." );
		StarterFacade.start ();
	}
}


