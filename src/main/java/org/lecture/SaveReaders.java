package org.lecture;

import java.io.*;
import java.util.ArrayList;

/**
 * In this class we can save the reader and his category/categories
 */

public class SaveReaders {

    public static void saveReaders (ArrayList<Readers> readers, String filename) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename));

            String r = "";
            for(Readers reader : readers) {
                r += reader.getName();
                for (ReaderCategory rc : reader.getCategory()) {
                    r += "," + rc.name();
                }
                r += "\n";
            }

            writer.write(r);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
