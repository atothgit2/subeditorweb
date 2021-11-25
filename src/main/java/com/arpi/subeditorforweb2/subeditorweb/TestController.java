package com.arpi.subeditorforweb2.subeditorweb;

import com.arpi.subeditorforweb2.subeditor.fileExporter.FileExporter;
import com.arpi.subeditorforweb2.subeditor.parser.*;
import com.arpi.subeditorforweb2.subeditor.serializer.StringSerializer;
import com.arpi.subeditorforweb2.subeditor.utils.FileUtils;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.List;
import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class TestController {
  @PostMapping(value = "/testjava")
  // "newFileName", "adjustByTime", "delayByTime"
  public void getData(
      @RequestParam("file") MultipartFile file, 
      @RequestParam("newFileName") String newFileName,
      @RequestParam("adjustByTime") Double adjustByTime,
      @RequestParam("delayByTime") Double delayByTime)
  {
    String fileContent = "";

    try {
      InputStream inputStream = file.getInputStream();
      fileContent = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
      runSubEditor(newFileName, adjustByTime, delayByTime, fileContent);
      //System.out.println(result);
    } catch (IOException e) {
      e.printStackTrace();
    }
    
  }

  public void runSubEditor(@RequestParam String newFileName, Double adjustByTime, Double delayByTime, String fileContent) {
    Parser parser = new Parser();
    // String fileLocation = "subs/mysub.srt";

    // Read file
    List<SubEntry> subEntries = parser.readAndParse(fileContent);
//        String originalFileName = FileUtils.extractFilanameFromPath(fileLocation);

    // Modify timestamps
    TimingModifierService timingModifierService = new TimingModifierService();
    List<SubEntry> modifiedSubentries = timingModifierService.modifySubentriesTiming(subEntries, adjustByTime);

    // Modify duration
    SubDisplayDurationModifierService subDisplayDurationModifierService = new SubDisplayDurationModifierService();
    List<SubEntry> modifiedSubEntriesDuration = subDisplayDurationModifierService.modifyDisplayDuration(modifiedSubentries, delayByTime);

    // Modified timestamps go to new string
    StringSerializer stringSerializer = new StringSerializer();
    String result = stringSerializer.convertToString(modifiedSubEntriesDuration);

    // String to file
    FileExporter exporter = new FileExporter();
    Path fileLocationNew = FileUtils.fileNominator(newFileName);
    exporter.exportStringToFile(result, fileLocationNew);
  }
}