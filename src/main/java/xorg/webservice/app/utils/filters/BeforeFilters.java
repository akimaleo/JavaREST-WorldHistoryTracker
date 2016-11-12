package xorg.webservice.app.utils.filters;

import spark.Filter;
import spark.Request;
import spark.Response;

/**
 * Created by lonely on 16.08.16.
 * @author : Alexander Balyshyn
 * @version : v1
 */
public class BeforeFilters {
	public static Filter addTrailingSlashes = ( Request request, Response response) -> {
		if (!request.pathInfo().endsWith("/")) {
			response.redirect(request.pathInfo() + "/");
		}
	};
}
