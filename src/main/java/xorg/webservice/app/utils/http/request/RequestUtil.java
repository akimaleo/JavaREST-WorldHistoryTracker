package xorg.webservice.app.utils.http.request;


import spark.Request;

import java.util.HashMap;


/**
 * Created by lonely on 16.08.16.
 *
 * @author : Alexander Balyshyn
 * @version : v1
 */
public class RequestUtil {

    public static String getQueryLocale( Request request ) {

        return request.queryParams( "locale" );
    }

    public static String getHeaderLocale( Request request ) {

        return request.headers( "Accept-Language" );
    }

    public final static class UserAgentChecker {

        private static String getUserAgentInfo( Request request ) {

            return request.headers( "User-Agent" );
        }
    }

    public static HashMap< HttpHeaders, String > getHttpRequestHeaders( Request request ) {
        HashMap< HttpHeaders, String > resultHashMap = new HashMap<>( );
        resultHashMap
                .put(
                        HttpHeaders.Accept,
                        request.headers( HttpHeaders.Accept.getType( ) )
                );
        resultHashMap
                .put(
                        HttpHeaders.AcceptCharset,
                        request.headers( HttpHeaders.AcceptCharset.getType( ) )
                );
        resultHashMap
                .put(
                        HttpHeaders.AcceptLanguage,
                        request.headers( HttpHeaders.AcceptLanguage.getType( ) )
                );
        resultHashMap
                .put(
                        HttpHeaders.ContentType,
                        request.headers( HttpHeaders.ContentType.getType( ) )
                );
        resultHashMap
                .put(
                        HttpHeaders.UserAgent,
                        request.headers( HttpHeaders.UserAgent.getType( ) )
                );
        return resultHashMap;
    }
}
