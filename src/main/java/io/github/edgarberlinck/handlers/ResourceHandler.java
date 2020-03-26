package io.github.edgarberlinck.handlers;

import java.io.File;
import java.net.URL;

public class ResourceHandler {
     public File readResource(String fileName) {
        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource(fileName);

        if (resource == null) {
            throw new IllegalArgumentException("O arquivo não existe, seu trouxa!");
        }
        return new File(resource.getFile());    
    }
}