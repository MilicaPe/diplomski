package com.ftn.sbnz.service.service.helper;

import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

@Service
public class FileService {
    public File createFile(String folder, String fileName) {
        try {
            URL res = getClass().getClassLoader().getResource(folder);
            File f = Paths.get(res.toURI()).toFile();
            String path = f.getAbsolutePath() + "/" + fileName;

            File file = new File(path);

            if (file.createNewFile())
                return file;
            else
                throw new RuntimeException();
        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
