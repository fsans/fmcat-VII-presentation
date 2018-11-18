package com.fmcat.demo;

import javax.persistence.*;


@Entity
@Table(name="post")
public class Post {

    private Long id;
    private String content;
    private String title;
    private Long authorId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "author_id")
    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Post post = (Post) o;

        if (Double.compare(post.authorId, authorId) != 0) return false;
        if (!id.equals(post.id)) return false;
        if (!content.equals(post.content)) return false;
        return title.equals(post.title);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id.hashCode();
        result = 31 * result + content.hashCode();
        result = 31 * result + title.hashCode();
        temp = Double.doubleToLongBits(authorId);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
