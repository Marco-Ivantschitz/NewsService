package org.lecture;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * In this class the loadReader purpose is that we can load the saved readers
 */

public class LoadingReaders {

    public ArrayList<Readers> loadReaders(Path p) {
        ArrayList<Readers> readers = new ArrayList<>();
        try {
            var list = (ArrayList<String>) Files.readAllLines(p);
            for (String line : list) {
                String[] split = line.split(",");

                List<ReaderCategory> category = new ArrayList<>();
                for (int i = 1; i < split.length; i++) {
                    category.add(ReaderCategory.valueOf(split[i]));
                }

                Readers reader = new Readers(split[0], category);
                readers.add(reader);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return readers;
    }
}


