package xorg.webservice.app.models.dao.factory;


import org.sql2o.Sql2o;
import xorg.webservice.app.models.dao.factory.configs.DataSourceFactory;
import xorg.webservice.app.models.dao.services.databse.daoimpl.UserDaoService;


/**
 * Created by lonely on 15.08.16.
 */

public class DataBaseDaoFactory
		extends AbstractDaoFactory implements DataBaseDaoDrivers {
	
	private volatile static Sql2o dataSource = null;
	
	
	private DataBaseDaoFactory ( ) {
		
	}
	
	public static final DataBaseDaoFactory getInstance ( ) {
		
		// can use another way for getting instance ( Double Checked Lock & Volatile or Demand Holder)
		// return DemandHolderSingleton.HOLDER_INSTANCE - Demand Holder;
		// return CrunchySingletonHolder.getThreadSafeSingleton () - Double Checked Lock & Volatile;
		return Singleton.INSTANCE.getInstance ();
		
	}
	
	// Double-Checking Locking & Volatile
	@Override
	public Sql2o getDataSourceController ( ) {
		
		Sql2o localDataSource = dataSource;
		if ( localDataSource == null ) {
			synchronized ( DataBaseDaoFactory.class ) {
				localDataSource = dataSource;
				if ( localDataSource == null ) {
					dataSource = localDataSource = DataSourceFactory.getDataSourceWrapper ();
				}
			}
		}
		return localDataSource;
	}
	
	private enum Singleton {
		INSTANCE;
		
		private static DataBaseDaoFactory FACTORY_INSTANCE = new DataBaseDaoFactory ();
		
		Singleton ( ) {
			
		}
		
		public DataBaseDaoFactory getInstance ( ) {
			
			return FACTORY_INSTANCE;
		}
	}
	
	// Double-Checking Locking & Volatile
	private static final class CrunchySingletonHolder {
		
		private static volatile DataBaseDaoFactory INSTANCE;
		
		private static DataBaseDaoFactory getThreadSafeSingleton ( ) {
			DataBaseDaoFactory localInstance = INSTANCE;
			if ( localInstance == null ) {
				synchronized ( CrunchySingletonHolder.class ) {
					localInstance = INSTANCE;
					if ( localInstance == null ) {
						localInstance = INSTANCE = new DataBaseDaoFactory ();
					}
				}
			}
			return localInstance;
		}
	}
	
	private static final class DemandHolderSingleton {
		
		private static final DataBaseDaoFactory HOLDER_INSTANCE = new DataBaseDaoFactory ();
		
	}
	
	public UserDaoService getUserDaoService ( ){
		return new UserDaoService (this);
	}
}
