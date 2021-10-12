package com.arpi.subeditorforweb2.subeditor.fileExporter;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;

import static java.nio.file.Files.writeString;

public class FileExporter {
    public void exportStringToFile (String contentToWrite, Path newFilename) {
        try {
            writeString(newFilename, contentToWrite, StandardCharsets.UTF_8);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
