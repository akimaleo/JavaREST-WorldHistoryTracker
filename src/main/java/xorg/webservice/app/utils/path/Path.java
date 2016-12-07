package xorg.webservice.app.utils.path;


import lombok.Getter;
import xorg.webservice.app.utils.propsreader.ServerConfReader;


public class Path {

    @Getter
    private static final String resourcePath = "src/main/resources/";

    @Getter
    private static final String dbConfigPropsPath = "props/database/database.props";

    @Getter
    private static final String pathConfig = "props/server/config.props";


    public static final class WebService {

        public final static String INDEX = "";

        public final static String AUTH = ServerConfReader.get("api.auth");

        public final static String CHECK_TOKEN = ServerConfReader.get("api.checkToken");

        public final static String REGISTRATION = ServerConfReader.get("api.registration");
        public final static String EVENT_ADD = ServerConfReader.get("api.createEvent");
        public final static String EVENTS_BY_USER_TOKEN = ServerConfReader.get("api.eventsByToken");
        public final static String EVENTS = ServerConfReader.get("api.events");
        public final static String EVENTS_WITH_LOCATION = ServerConfReader.get("api.eventsByLocation");

    }

}
