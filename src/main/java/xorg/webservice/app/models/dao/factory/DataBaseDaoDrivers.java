package xorg.webservice.app.models.dao.factory;

import org.sql2o.Sql2o;

/**
 * Created by lonely on 15.08.16.
 */
public interface DataBaseDaoDrivers {
	Sql2o getDataSourceController( );
}
