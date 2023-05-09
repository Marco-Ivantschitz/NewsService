package org.lecture;

import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * In the FileReader the File gets all the information.
 * We have also the ParsedDateTime and it will be correct splitted.
 * In the getParsedDateTime the ParsedDateTime is declared.
 */

public class FileReader {
    public ArrayList<News> readFile(Path p) throws Exception {
        ArrayList<News> result = new ArrayList<>();
        if (!Files.exists(p)) {
            throw new Exception();
        } else {
            var list = (ArrayList<String>) Files.readAllLines(p);
            list.remove(0);
            for (String line : list) {
                String[] split = line.split(",");

                ReaderCategory category = ReaderCategory.valueOf(split[0]);
                String text = split[1];
                Date dateTime = getParsedDateTime(split[2]);

                News news = new News(category, text , dateTime);

                result.add(news);
            }
        }
        return result;
    }
    public Date getParsedDateTime(String date) {
        try {
            return new SimpleDateFormat("dd.MM.yyyy hh:mm").parse(date);
        } catch (Exception e) {
            return null;
        }
    }
}
