package org.lecture;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * In this class is the Observer Pattern declared
 */

@Slf4j
public class NewsObserver implements Subject {
    private News news;

    private List<Observer> observerList = new ArrayList<>();

    @Override
    public void registerObserver(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observerList) {
            observer.update(news);
        }
    }

    public void setNews(News news) {
        this.news = news;
        notifyObservers();
    }
}
