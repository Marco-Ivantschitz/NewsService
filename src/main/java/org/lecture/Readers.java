package org.lecture;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * A class for the readers with the Observer Pattern
 */


public class Readers implements Serializable, Observer {
    private String name;
    private List<ReaderCategory> category = new ArrayList<>();
    private ArrayList<News> news = new ArrayList<>();

    public Readers(String name) {
        this.name = name;
    }

    public Readers(String name, List<ReaderCategory> category) {
        this.name = name;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ReaderCategory> getCategory() {
        return category;
    }

    public void setCategory(List<ReaderCategory> category) {
        this.category = category;
    }

    public ArrayList<News> getNews() {
        return news;
    }

    public void setNews(ArrayList<News> news) {
        this.news = news;
    }

    @Override
    public void update(News news) {
        for (ReaderCategory rc : getCategory()) {
            if (rc == news.getCategory()) {
                boolean hit = false;
                for(News n : getNews()) {
                    if(n.equals(news)) {
                        hit = true;
                        break;
                    }
                }

                if(hit == false) {
                    this.news.add(news);
                }
            }
        }
    }
}
