package dezbyte.engine.helpers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

abstract public class FileResourceLoader {

    protected File resource;

    public FileResourceLoader(File file)
    {
        this.resource = file;
    }

    public FileResourceLoader(String filepath) throws FileNotFoundException
    {
        this.resource = new File(filepath);
    }

    public FileReader fileReader() throws FileNotFoundException
    {
        return new FileReader(this.resource);
    }

}
