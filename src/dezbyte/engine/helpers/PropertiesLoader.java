package dezbyte.engine.helpers;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesLoader extends FileResourceLoader {

    public PropertiesLoader(String filepath) throws FileNotFoundException
    {
        super(filepath);
    }

    public Properties load() throws IOException
    {
        Properties properties = new Properties();
        properties.load(this.fileReader());

        return properties;
    }

}
