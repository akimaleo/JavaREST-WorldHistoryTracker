package xorg.webservice.app.utils.path;


import lombok.Getter;
import xorg.webservice.app.utils.propsreader.ServerConfReader;


/**
 * Created by raccoon on 05.09.16.
 */
public class Path {

    @Getter
    private static final String resourcePath = "src/main/resources/";

    @Getter
    private static final String dbConfigPropsPath = "props/database/database.props";

    @Getter
    private static final String pathConfig = "props/server/config.props";


    public static final class WebService {

        public final static String INDEX = "";

        public final static String AUTH = ServerConfReader.get( "api.auth" );

        public final static String REGISTRATION = ServerConfReader.get( "api.registration" );

    }

}
