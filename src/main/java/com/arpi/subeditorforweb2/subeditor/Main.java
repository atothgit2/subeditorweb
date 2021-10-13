//package com.arpi.subeditorforweb2.subeditor;
//
//import com.arpi.subeditorforweb2.subeditor.fileExporter.FileExporter;
//import com.arpi.subeditorforweb2.subeditor.parser.Parser;
//import com.arpi.subeditorforweb2.subeditor.parser.SubDisplayDurationModifierService;
//import com.arpi.subeditorforweb2.subeditor.parser.SubEntry;
//import com.arpi.subeditorforweb2.subeditor.parser.TimingModifierService;
//import com.arpi.subeditorforweb2.subeditor.serializer.StringSerializer;
//import com.arpi.subeditorforweb2.subeditor.utils.FileUtils;
//
//import java.nio.file.Path;
//import java.util.List;
//
//public class Main {
//
//    // HF: olyan feature, ami a sub képernyőn tartását is állítja
//    // hint: paraméterként megadni, hogy melyik funkciót használjuk (sub eltolás, vagy sub időtartam - modify timestamp résznél)
//
//    public static void mymain(String[] arg) {
//        Parser parser = new Parser();
//        String fileLocation = "subs/mysub.srt";
//
//        // Read file
//        List<SubEntry> subEntries = parser.readAndParse(fileLocation);
//        String originalFileName = FileUtils.extractFilanameFromPath(fileLocation);
//
//        // Modify timestamps
//        TimingModifierService timingModifierService = new TimingModifierService();
//        List<SubEntry> modifiedSubentries = timingModifierService.modifySubentriesTiming(subEntries, 3661);
//
//        // Modify duration
//        SubDisplayDurationModifierService subDisplayDurationModifierService = new SubDisplayDurationModifierService();
//        List<SubEntry> modifiedSubEntriesDuration = subDisplayDurationModifierService.modifyDisplayDuration(modifiedSubentries, 61);
//
//        // Modified timestamps go to new string
//        StringSerializer stringSerializer = new StringSerializer();
//        String result = stringSerializer.convertToString(modifiedSubEntriesDuration);
//
//        // String to file
//        FileExporter exporter = new FileExporter();
//        Path fileLocationNew = FileUtils.fileNominator(originalFileName);
//        exporter.exportStringToFile(result, fileLocationNew);
//    }
//}