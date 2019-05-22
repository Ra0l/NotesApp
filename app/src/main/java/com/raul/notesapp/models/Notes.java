package com.raul.notesapp.models;

import com.orm.dsl.Table;

@Table
public class Notes {
    private Long id;
    private String title;
    private String container;
    private String date;

    public Notes() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContainer() {
        return container;
    }

    public void setContainer(String container) {
        this.container = container;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Notes{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", container='" + container + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
