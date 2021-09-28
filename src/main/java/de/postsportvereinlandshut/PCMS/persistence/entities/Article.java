package de.postsportvereinlandshut.PCMS.persistence.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;

@Entity
public class Article {

    /**
     * article id (primary key)
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    /**
     * title/headline of the article
     */
    @Column(nullable = false, unique = true)
    private String title;
    @Column(nullable = false)
    private long author;

    /**
     * Posted on website or not
     */
    @Column(nullable = false)
    private boolean isPublished;

    /**
     * Actual content of article (html string)
     */
    private String content;

    /**
     * Department in which article gets posted
     */
    private Department department;

    @DateTimeFormat
    @Column(nullable = false)
    private Timestamp creationDate = new Timestamp(System.currentTimeMillis());;

    private Timestamp publicationDate;

    private long klicks = 0l;

    public Article(String title, 
                    long author, 
                    boolean isPublished, 
                    String content, 
                    Department department, 
                    Timestamp publicationDate){
                        this.title = title;
                        this.author = author;
                        this.isPublished = isPublished;
                        this.content = content;
                        this.department = department;
                        this.publicationDate = publicationDate;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(long author) {
        this.author = author;
    }

    public long getAuthor() {
        return author;
    }

    public boolean isPublished() {
        return isPublished;
    }

    public void setPublished(boolean isPublished) {
        this.isPublished = isPublished;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Timestamp getCreationDate() {
        return creationDate;
    }

    public Timestamp getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Timestamp publicationDate) {
        this.publicationDate = publicationDate;
    }

    public long getKlicks() {
        return klicks;
    }

    public void setKlicks(long klicks) {
        this.klicks = klicks;
    }

}
