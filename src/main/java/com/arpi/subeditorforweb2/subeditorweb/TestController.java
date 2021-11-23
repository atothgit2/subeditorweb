package com.arpi.subeditorforweb2.subeditorweb;

import com.arpi.subeditorforweb2.subeditor.fileExporter.FileExporter;
import com.arpi.subeditorforweb2.subeditor.parser.*;
import com.arpi.subeditorforweb2.subeditor.serializer.StringSerializer;
import com.arpi.subeditorforweb2.subeditor.utils.FileUtils;
import java.nio.file.Path;
import java.util.List;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class TestController {
  @PostMapping(value = "/testjava")
  public void getData(@RequestParam("file") MultipartFile payload) {
    System.out.println(payload);

    Parser parser = new Parser();
    String fileLocation = "subs/mysub.srt";

    // Read file
    List<SubEntry> subEntries = parser.readAndParse(fileLocation);
  }
}