package com.arpi.subeditorforweb2.subeditorweb;

import com.arpi.subeditorforweb2.subeditor.fileExporter.FileExporter;
import com.arpi.subeditorforweb2.subeditor.parser.*;
import com.arpi.subeditorforweb2.subeditor.serializer.StringSerializer;
import com.arpi.subeditorforweb2.subeditor.utils.FileUtils;
import java.nio.file.Path;
import java.util.List;
import org.springframework.web.bind.annotation.*;

@RestController
public class SubEditorController {

  @RequestMapping("/subeditor")
  public void runSubEditor(@RequestParam String newFileName, Double adjustByTime, Double delayByTime) {
    Parser parser = new Parser();
    String fileLocation = "subs/mysub.srt";

    // Read file
    List<SubEntry> subEntries = parser.readAndParse(fileLocation);
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