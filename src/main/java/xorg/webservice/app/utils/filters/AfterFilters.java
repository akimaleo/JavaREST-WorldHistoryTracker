package xorg.webservice.app.utils.filters;

import spark.Filter;
import spark.Request;
import spark.Response;

/**
 * Created by lonely on 16.08.16.
 *
 * @author : Alexander Balyshyn
 * @version : v1
 */
public final class AfterFilters {

	/** Add Gzip content encoding */
	public static Filter addGzipHeader = ( Request request, Response response ) -> {
		response.header( "Content-Encoding", "gzip" );
	};

}
