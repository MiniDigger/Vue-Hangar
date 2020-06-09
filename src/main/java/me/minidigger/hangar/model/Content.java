package me.minidigger.hangar.model;

import com.google.common.base.Objects;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import java.util.StringJoiner;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Content {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Type(type = "uuid-char")
    private UUID id;

    private String format = "markdown";
    private String content;

    protected Content() {
        // JPA
    }

    public Content(String content) {
        this.content = content;
    }

    public UUID getId() {
        return id;
    }

    public String getFormat() {
        return format;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Content content1 = (Content) o;
        return Objects.equal(id, content1.id) &&
               Objects.equal(format, content1.format) &&
               Objects.equal(content, content1.content);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, format, content);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Content.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("format='" + format + "'")
                .add("content='" + content + "'")
                .toString();
    }
}
