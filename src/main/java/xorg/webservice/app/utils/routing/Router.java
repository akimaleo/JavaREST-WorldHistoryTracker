package xorg.webservice.app.utils.routing;


import org.eclipse.jetty.server.Server;
import xorg.webservice.app.controllers.events.EventCtrl;
import xorg.webservice.app.controllers.users.UserCtrl;
import xorg.webservice.app.utils.filters.AfterFilters;
import xorg.webservice.app.utils.filters.BeforeFilters;
import xorg.webservice.app.utils.path.Path;

import static spark.Spark.*;

public class Router {

    public static void init() {
        before(BeforeFilters.addTrailingSlashes);
        before(BeforeFilters.requestInfo);
        get("/", (request, response) -> {
//            System.out.print(request.ip());
            return response;
        });
        post(Path.WebService.AUTH, UserCtrl.getAuth());
        post(Path.WebService.REGISTRATION, UserCtrl.getCreateUser());
        post(Path.WebService.EVENT_ADD, EventCtrl.getCreateEvent());
        post(Path.WebService.EVENTS_WITH_LOCATION, EventCtrl.getGetEventByLocationAndDatetime());
        after(AfterFilters.addGzipHeader);

    }
}