package xorg.webservice.app.utils.propsreader;


import jodd.props.Props;
import xorg.webservice.app.utils.path.Path;

import java.io.File;
import java.io.IOException;


/**
 * Created by lonely on 15.08.16.
 *
 * @author : Alexander Balyshyn
 * @version : v1
 */
public final class DbConfigReader {

    private static final Props PROPS_READER = new Props( );


    public static void load() {

        try {
            PROPS_READER.load( new File( Path.getResourcePath( ) + Path.getDbConfigPropsPath() ) );
        } catch ( IOException e ) {
            e.printStackTrace( );
        }
    }

    public static String get(String key, String... profiles){
        return PROPS_READER.getValue( key, profiles );
    }

}
