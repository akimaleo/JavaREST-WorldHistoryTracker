package xorg.webservice.app.models.dao.factory.configs;


import com.mysql.cj.jdbc.MysqlConnectionPoolDataSource;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.sql2o.Sql2o;
import xorg.webservice.app.utils.propsreader.DbConfigReader;

import javax.sql.DataSource;


/**
 * Created by lonely on 26.08.16.
 */
public class DataSourceFactory {
	
	static {
		DbConfigReader.load ();
	}
	
	public static Sql2o getDataSourceWrapper ( ) {
		
		HikariConfig config = new HikariConfig ();
		
		config.setJdbcUrl ( DbConfigReader.get ( "db.mysql.jdbcUrl", "develop" ) );
		config.setUsername ( DbConfigReader.get ( "db.mysql.userName", "develop" ) );
		config.setPassword ( DbConfigReader.get ( "db.mysql.password", "develop" ) );
		config.setMaximumPoolSize ( Integer.parseInt ( DbConfigReader.get ( "db.mysql.poolSize", "develop" ) ) );
		
		return getWrapper ( config );
	}
	
	public static Sql2o getDataSourceWrapper ( DataSource configurableDataSource ) {
		
		HikariConfig config = new HikariConfig ();
		
		config.setDataSource ( configurableDataSource );
		
		
		return getWrapper ( config );
	}
	
	public static Sql2o getMySqlDataSource ( ) {
		
		MysqlConnectionPoolDataSource connectionPoolDataSource = new MysqlConnectionPoolDataSource ();
		connectionPoolDataSource.setDatabaseName ( DbConfigReader.get ( "db.mysql.dbName", "develop" ) );
		connectionPoolDataSource.setPort ( 3306 );
		connectionPoolDataSource.setUser ( DbConfigReader.get ( "db.mysql.userName", "develop" ) );
		connectionPoolDataSource.setPassword ( DbConfigReader.get ( "db.mysql.password", "develop" ) );
		connectionPoolDataSource.setURL ( DbConfigReader.get ( "db.mysql.jdbcUrl", "develop" ) );
		connectionPoolDataSource.setServerName ( DbConfigReader.get ( "db.mysql.host", "develop" ) );
		return getWrapper ( connectionPoolDataSource );
	}
	
	public static MysqlConnectionPoolDataSource getPoolingDataSource ( ) {
		
		MysqlConnectionPoolDataSource connectionPoolDataSource = new MysqlConnectionPoolDataSource ();
		connectionPoolDataSource.setDatabaseName ( DbConfigReader.get ( "db.mysql.dbName", "develop" ) );
		connectionPoolDataSource.setPort ( 3306 );
		connectionPoolDataSource.setUser ( DbConfigReader.get ( "db.mysql.userName", "develop" ) );
		connectionPoolDataSource.setPassword ( DbConfigReader.get ( "db.mysql.password", "develop" ) );
		connectionPoolDataSource.setURL ( DbConfigReader.get ( "db.mysql.jdbcUrl", "develop" ) );
		connectionPoolDataSource.setServerName ( DbConfigReader.get ( "db.mysql.host", "develop" ) );
		return connectionPoolDataSource;
	}
	
	
	private static Sql2o getWrapper ( HikariConfig config ) {
		
		return new Sql2o ( new HikariDataSource ( config ) );
	}
	
	private static Sql2o getWrapper ( DataSource src ) {
		return new Sql2o ( src );
	}
}
