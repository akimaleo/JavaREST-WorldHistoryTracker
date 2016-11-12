package xorg.webservice.app.utils.routing;

import xorg.webservice.app.utils.exception.MyCustomExeption;

import static spark.Spark.exception;

/**
 * Created by lonely on 11/5/16.
 */
public class ExceptionRouter {
	
	public static void initExceptionHandler ( ) {
		
		exception ( MyCustomExeption.class, ( exception, request, response ) -> {
			// Handle the exception here
		} );
		
	}
	
}
