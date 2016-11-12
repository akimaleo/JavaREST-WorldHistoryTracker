package xorg.webservice.app.utils.http.request;


import java.io.Serializable;


/**
 * Created by raccoon on 10/13/16.
 *
 * @version: 1.0beta
 */
public enum HttpHeaders implements Serializable {

    Accept( "Accept" ),
    AcceptCharset( "Accept-Charset" ),
    AcceptLanguage( "Accept-Language" ),
    Authorization("Authorization"),
    AcceptDatetime( "Accept-Datetime" ),
    UserAgent("User-Agent"),
    ContentType("Content-Type ");


    private String type;

    private HttpHeaders( String type ) {

        this.type = type;
    }

    public String getType( ) {

        return type;
    }

}
