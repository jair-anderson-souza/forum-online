/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.forum.core.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import org.bson.Document;

/**
 * @author Anderson Souza <jair_anderson_bs@hotmail.com>
 * @since Apr 8, 2018 10:32:34 PM
 */
public class Topic implements Serializable {

    private Long id;
    private String category;
    private String title;
    private String content;
    private Date date;

    public Topic() {
    }

    public Topic(String category, String title, String content, Date date) {
        this.category = category;
        this.title = title;
        this.content = content;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Document toDocument() {
        Document doc = new Document().
                append("category", this.getCategory()).
                append("title", this.getTitle()).
                append("content", this.getContent()).
                append("date", this.getDate());
        return doc;
    }

    public Topic toTopic(Document doc) {
        String category = doc.getString("category");
        String title = doc.getString("title");
        String content = doc.getString("content");
        Date date = (Date) doc.get("date");
        return new Topic(category, title, content, date);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Topic other = (Topic) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Topic{" + "id=" + id + ", category=" + category + ", title=" + title + ", content=" + content + ", data=" + date + '}';
    }

}
