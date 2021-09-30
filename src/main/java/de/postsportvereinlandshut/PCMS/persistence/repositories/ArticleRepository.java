package de.postsportvereinlandshut.PCMS.persistence.repositories;

import java.sql.Timestamp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import de.postsportvereinlandshut.PCMS.persistence.entities.Article;
import de.postsportvereinlandshut.PCMS.persistence.entities.User;

@Repository
public interface ArticleRepository extends JpaRepository <Article, Long>{
    //findAll() -> CRUD Repository
    //findOne(User) -> CRUD Repository
    //count(User)   -> CRUD Repository
    //insert user   -> CRUD Repository(save)

    @Transactional
    @Modifying
    @Query(value = "update Article a set a.title = :title where a.id = :#{#article.id}")
    public void setTitle(@Param("article") Article article, @Param("title") String title);

    @Transactional
    @Modifying
    @Query(value = "update Article a set a.author = :author where a.id = :#{#article.id}")
    public void setAuthor(@Param("article") Article article, @Param("author") User author);

    @Transactional
    @Modifying
    @Query(value = "update Article a set a.isPublished = :isPublished where a.id = :#{#article.id}")
    public void setPublished(@Param("article") Article article, @Param("isPublished") boolean isPublished);

    @Transactional
    @Modifying
    @Query(value = "update Article a set a.content = :content where a.id = :#{#article.id}")
    public void setContent(@Param("article") Article article, @Param("content") String content);

    @Transactional
    @Modifying
    @Query(value = "update Article a set a.department = :department where a.id = :#{#article.id}")
    public void setDepartment(@Param("article") Article article, @Param("content") String content);

    @Transactional
    @Modifying
    @Query(value = "update Article a set a.publicationDate = :pubDate where a.id = :#{#article.id}")
    public void setPublicationDate(@Param("article") Article article, @Param("pubDate") Timestamp publicationDate);

}

