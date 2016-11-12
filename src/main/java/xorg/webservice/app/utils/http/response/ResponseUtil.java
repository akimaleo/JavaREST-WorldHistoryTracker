package xorg.webservice.app.utils.http.response;


import spark.Response;


/**
 * Created by lonely on 16.08.16.
 * @author : Alexander Balyshyn
 * @version : v1
 */
public class ResponseUtil {
    public static void addDefaultHeaderLocale( Response response ) {
        response.header( "UserLocale", "en" );
    }
}
