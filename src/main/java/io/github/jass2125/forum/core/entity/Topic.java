/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.forum.core.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * @author Anderson Souza <jair_anderson_bs@hotmail.com>
 * @since Apr 8, 2018 10:32:34 PM
 */
public class Topic implements Serializable {

    private Long id;
    private String category;
    private String title;
    private String content;
    private LocalDate date;

    public Topic() {
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
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
