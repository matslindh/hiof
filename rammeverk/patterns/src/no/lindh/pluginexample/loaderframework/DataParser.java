package no.lindh.pluginexample.loaderframework;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.*;
import java.util.*;

public class DataParser {
    Map<String, List<Loader>> loaders = new HashMap<String, List<Loader>>();

    public void registerLoader(Loader loader) {
        loader.register(this);
    }

    public void registerLoaderForFileExtension(String fileExtension, Loader loader) {
        if (!loaders.containsKey(fileExtension)) {
            loaders.put(fileExtension, new ArrayList<>());
        }

        loaders.get(fileExtension).add(loader);
    }

    public Map<String, String> load(String filename) {
        String ext = filename.substring(filename.lastIndexOf('.') + 1);
        Map<String, String> data = null;

        if (!loaders.containsKey(ext)) {
            return null;
        }

        // read from file / url / DataSource instead in real version
        byte[] bytes = new byte[20];

        for (Loader loader : loaders.get(ext)) {
            data = loader.load(bytes);

            if (data != null) {
                break;
            }
        }

        return data;
    }
}
