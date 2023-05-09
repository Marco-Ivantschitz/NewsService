package org.lecture;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

/**
 * In the Main class of the program starts.
 * There is the console input, searchReader, checkCategory and readNews
 */

public class Main {
    public static void main(String[] args) {

        ArrayList<Readers> readers = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        Menu menu = new Menu();

        NewsObserver nO = new NewsObserver();

        ArrayList<News> newsList = readNews();

        while (true) {
            menu.menu();
            int eingabe = menu.consoleInput();

            if (eingabe == 1) {
                System.out.println("\nRegistered users:\n");
                for (Readers reader : readers) {
                    System.out.println(reader.getName());
                    for (ReaderCategory rc :reader.getCategory()) {
                        System.out.print("  " + rc.name());
                    }
                    System.out.println("");
                }
            }

            if (eingabe == 2) {
                System.out.println("\nRegistration\n");
                System.out.println("Enter your name: ");
                String name = scanner.nextLine();

                Readers reader = new Readers(name);
                readers.add(reader);
                nO.registerObserver( reader);
            }

            if (eingabe == 3) {
                System.out.println("Enter your name: ");
                String name = scanner.nextLine();

                Readers reader = searchReader(readers, name);
                if (reader != null) {
                    while (true) {
                        System.out.println("\nThe Categories are: Sport, Politik, Top_Story and Boulevard\n");
                        System.out.println("Please enter the categories separated with a comma: (enter without category gets you the exit)");
                        String category = scanner.nextLine().toUpperCase();

                        if (category.isEmpty()) {
                            break;
                        }

                        List<String> categories = checkCategory(category);
                        if (!categories.isEmpty()) {
                            for (String c : categories) {
                                ReaderCategory rc = ReaderCategory.valueOf(c);

                                if (!reader.getCategory().contains(rc)) {
                                    reader.getCategory().add(rc);
                                }

                            }
                        }
                    }

                } else {
                    System.out.println("Reader is not registered");
                }
            }

            if (eingabe == 4) {
                System.out.println("\nDe-Registration\n");
                System.out.println("Enter your name: ");
                String name = scanner.nextLine();

                Readers reader = searchReader(readers, name);
                if (reader != null) {
                    readers.remove(reader);
                    nO.removeObserver(reader);
                } else {
                    System.out.println("Reader is not registered");
                }
            }

            if (eingabe == 5) {
                ArrayList<News> newsS = readNews();
                if (newsS != null) {
                    newsList = newsS;
                }
            }

            if (eingabe == 6) {
                System.out.println("\nSend News\n");

                for(News news : newsList) {
                    nO.setNews(news);
                }
            }

            if (eingabe == 7) {
                for (Readers reader : readers) {
                    System.out.println("News for " + reader.getName());

                    boolean hit = false;
                    for (ReaderCategory rc : reader.getCategory()) {
                        boolean header = false;
                        for (News news : reader.getNews()) {
                            if (rc == news.getCategory()) {
                                if (header == false) {
                                    System.out.println("  News: " + news.getCategory());
                                    header = true;
                                }
                                System.out.println("    " + news.getText());
                                hit = true;
                            }
                        }
                    }

                    if (hit == false) {
                        System.out.println("  No news at the moment.");
                    }
                }
            }

            if (eingabe == 8) {
                SaveReaders sR = new SaveReaders();
                sR.saveReaders(readers,  "src/main/resources/readers.csv");
            }

            if (eingabe == 9) {
                LoadingReaders lR = new LoadingReaders();
                readers = lR.loadReaders(Paths.get("src/main/resources/readers.csv"));
                for (Readers reader:readers) {
                    nO.registerObserver( reader);
                }

            }

            if (eingabe == 10) {
                System.out.println("Program was terminated");
                break;
            }
        }
    }

    private static Readers searchReader(ArrayList<Readers> readers, String name) {
        for (Readers reader : readers) {
            if (name.equalsIgnoreCase(reader.getName())) {
                return reader;
            }
        }
        return null;
    }

    private static List<String> checkCategory(String category) {
        String[] categories = category.split(",");
        List<String> cList = Arrays.asList(categories);
        List<String> categoryList = new ArrayList<>(cList);
        ReaderCategory[] rcs = ReaderCategory.values();

        Iterator<String> i = categoryList.iterator();
        while (i.hasNext()) {

            boolean hit = false;
            String c = i.next();

            for (ReaderCategory rc : rcs) {
                if (rc.name().equalsIgnoreCase(c.trim())) {
                    hit = true;
                }
            }

            if (!hit) {
                i.remove();
            }
        }
        return categoryList;
    }

    private static Date update;
    private static ArrayList<News> readNews() {
        if (update == null || update.getTime() + 10000 < new Date().getTime()) {
            update = new Date();
            FileReader fileReader = new FileReader();
            Path path = Paths.get("src/main/resources/news.csv");
            try {
                return fileReader.readFile(path);
            } catch (Exception e) {
                System.out.println("Error Read " + path);
                return null;
            }
        } else {
            System.out.println("Not even 10 seconds have passed since the last update!");
            return null;
        }
    }
}

