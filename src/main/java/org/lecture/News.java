package org.lecture;

import java.util.Date;

/**
 * The News Constructor is declared here
 * Also the Equals function is here declared so we can not get the same news
 */

public class News {

    private ReaderCategory category;
    private String text;
    private Date dateTime;

    public News(ReaderCategory category, String text, Date dateTime) {
        this.category = category;
        this.text = text;
        this.dateTime = dateTime;
    }

    public ReaderCategory getCategory() {
        return category;
    }

    public void setCategory(ReaderCategory category) {
        this.category = category;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public boolean equals(Object o) {

        // If the object is compared with itself then return true
        if (o == this) {
            return true;
        }

        if (!(o instanceof News)) {
            return false;
        }

        // typecast o to Complex so that we can compare data members
        News n = (News) o;

        // Compare the data members and return accordingly
        if(this.category == null && n.category != null || this.category != null && n.category == null) {
            return false;
        }

        if(this.category != null && !this.category.equals(n.category)) {
            return false;
        }

        if(this.text == null && n.text != null || this.text != null && n.text == null) {
            return false;
        }

        if(this.text != null && !this.text.equals(n.text)) {
            return false;
        }

        if(this.dateTime == null && n.dateTime != null || this.dateTime != null && n.dateTime == null) {
            return false;
        }

        if(this.dateTime != null && !this.dateTime.equals(n.dateTime)) {
            return false;
        }

        return true;
    }
}
