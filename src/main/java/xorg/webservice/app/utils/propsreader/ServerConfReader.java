package xorg.webservice.app.utils.propsreader;


import jodd.props.Props;
import xorg.webservice.app.utils.path.Path;

import java.io.File;
import java.io.IOException;


/**
 * Created by raccoon on 06.09.16.
 */
public class ServerConfReader {
	
	private static final Props PROPS_READER = new Props ();
	
	
	public static void load ( ) {
		
		try {
			PROPS_READER.load ( new File ( Path.getResourcePath () + Path.getPathConfig () ) );
		} catch ( IOException e ) {
			e.printStackTrace ();
		}
	}
	
	public static String get ( String key, String... profiles ) {
		
		return PROPS_READER.getValue ( key, profiles );
	}
	
}
