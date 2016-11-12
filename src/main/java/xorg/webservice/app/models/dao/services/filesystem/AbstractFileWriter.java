package xorg.webservice.app.models.dao.services.filesystem;


import java.io.File;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by raccoon on 28.09.16.
 *
 * @version: 1.0beta
 */
public abstract class AbstractFileWriter {

    private String directoryPath;

    private String prefixName;

    protected AbstractFileWriter( String directoryPath, String prefixName ) {

        this.directoryPath = directoryPath;
        this.prefixName = prefixName;
    }

    public String writeFile( File file ) {

        return "RelativePathUrl";
    }

    public String readFile( String fileId ) {
        return "RelativePathUrl";
    }

    public List<String> readFiles( String directoryPath ) {
        return new ArrayList<String>(  );
    }
}
