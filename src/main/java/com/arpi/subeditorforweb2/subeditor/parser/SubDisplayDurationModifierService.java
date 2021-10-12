package com.arpi.subeditorforweb2.subeditor.parser;

import com.arpi.subeditorforweb2.subeditor.model.Pair;
import com.arpi.subeditorforweb2.subeditor.utils.FileUtils;

import java.util.List;

public class SubDisplayDurationModifierService {
    public List<SubEntry> modifyDisplayDuration(List<SubEntry> subEntriesFromParser, double modifierInSecs) {

        for (SubEntry entry : subEntriesFromParser) {
            String timingLine = entry.getTiming();
            Pair<String> timestamps = FileUtils.getTimestampsAsStrings(timingLine);
            String adjustedTimestamp1 = timestamps.getFirst();
            String adjustedTimestamp2 = FileUtils.adjustTime(timestamps.getSecond(), modifierInSecs);

            entry.setTiming(adjustedTimestamp1 + " --> " + adjustedTimestamp2);
        }
        return subEntriesFromParser;
    }
}