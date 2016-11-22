package xorg.webservice.app.utils.filters;

import spark.Filter;
import spark.Request;
import spark.Response;
import xorg.webservice.app.utils.http.request.HttpHeaders;

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

	public static Filter requestInfo = ( Request request, Response response) -> {
		System.out.println(request.ip());
		System.out.println(request.headers(HttpHeaders.Authorization.getType()));
		System.out.println(request.body());
	};
}
