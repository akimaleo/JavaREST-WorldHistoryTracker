package xorg.webservice.app.models.dao.factory;


/**
 * Created by raccoon on 28.09.16.
 *
 * @version: 1.0beta
 */
public class FileSystemDaoFactory {
	
	private static FileSystemDaoFactory fileSystemDaoFactory;
	
	private FileSystemDaoFactory ( ) {
		
	}
	
	public static FileSystemDaoFactory getFileSystemDaoFactory ( ) {
		FileSystemDaoFactory localInstance = fileSystemDaoFactory;
		if( localInstance == null) {
			synchronized ( FileSystemDaoFactory.class ) {
				localInstance = fileSystemDaoFactory;
				if ( localInstance == null ) {
					localInstance = fileSystemDaoFactory = new FileSystemDaoFactory ();
				}
			}
		}
		return localInstance;
	}
	
	
}
