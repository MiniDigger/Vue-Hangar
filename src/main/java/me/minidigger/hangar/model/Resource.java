package me.minidigger.hangar.model;

import com.google.common.base.Objects;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import java.util.List;
import java.util.StringJoiner;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Resource {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Type(type = "uuid-char")
    private UUID id;

    private String name;
    private String title;
    private String description;
    @OneToOne
    private User author;
    @OneToMany
    private List<Tag> tags;
    @OneToMany
    private List<ResourceVersion> versions;

    protected Resource() {
        // JPA
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public List<ResourceVersion> getVersions() {
        return versions;
    }

    public void setVersions(List<ResourceVersion> versions) {
        this.versions = versions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Resource resource = (Resource) o;
        return Objects.equal(id, resource.id) &&
               Objects.equal(name, resource.name) &&
               Objects.equal(title, resource.title) &&
               Objects.equal(description, resource.description) &&
               Objects.equal(author, resource.author) &&
               Objects.equal(tags, resource.tags) &&
               Objects.equal(versions, resource.versions);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, name, title, description, author, tags, versions);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Resource.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("name='" + name + "'")
                .add("title='" + title + "'")
                .add("description='" + description + "'")
                .add("author=" + author)
                .add("tags=" + tags)
                .add("versions=" + versions)
                .toString();
    }
}
