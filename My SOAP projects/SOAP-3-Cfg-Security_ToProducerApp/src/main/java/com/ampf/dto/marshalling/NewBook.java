package com.ampf.dto.marshalling;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;


@JacksonXmlRootElement(localName = "book")
public class NewBook {
    String edition;

    @JacksonXmlProperty(isAttribute = true)
    String title;

    @JacksonXmlElementWrapper(localName = "authors")
    @JacksonXmlProperty(localName = "author")
    List<String> authors;

    @JacksonXmlProperty(localName = "publisher")
    String publisherName;

    String paperback;
    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public String getPaperback() {
        return paperback;
    }

    public void setPaperback(String paperback) {
        this.paperback = paperback;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    @JsonIgnore
    public boolean getCapsPublisherName(){
        return null!=publisherName;
    }
}
