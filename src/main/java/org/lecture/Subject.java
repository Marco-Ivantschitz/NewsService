package org.lecture;

/**
 * In this interface the subjects for the observer are declared
 */

public interface Subject {
        void registerObserver(Observer observer);
        void removeObserver(Observer observer);
        void notifyObservers();

}
