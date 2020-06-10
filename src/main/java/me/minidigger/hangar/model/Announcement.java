package me.minidigger.hangar.model;

import com.google.common.base.Objects;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import java.util.Date;
import java.util.StringJoiner;
import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Announcement {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Type(type = "uuid-char")
    private UUID id;

    private Date publishedOn;
    private String headline;
    @Column(unique = true)
    private String slug;
    @OneToOne(cascade = CascadeType.ALL)
    private Content content;

    public UUID getId() {
        return id;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    public Date getPublishedOn() {
        return publishedOn;
    }

    public void setPublishedOn(Date publishedOn) {
        this.publishedOn = publishedOn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Announcement that = (Announcement) o;
        return Objects.equal(id, that.id) &&
               Objects.equal(headline, that.headline) &&
               Objects.equal(slug, that.slug) &&
               Objects.equal(content, that.content);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, headline, slug, content);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Announcement.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("headline='" + headline + "'")
                .add("slug='" + slug + "'")
                .add("content='" + content + "'")
                .toString();
    }
}
