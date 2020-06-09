package me.minidigger.hangar.model;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import java.util.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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
    @OneToMany
    private Map<User, ResourceRole> authors;
    @OneToMany
    private List<Tag> tags;
    @OneToMany
    private List<ResourceVersion> versions;
    @OneToMany
    private List<User> stars;
    @OneToMany
    private Map<ResourcePageSlot, Content> content;

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

    public Map<User, ResourceRole> getAuthors() {
        return authors;
    }

    public void setAuthors(Map<User, ResourceRole> authors) {
        this.authors = authors;
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

    public List<User> getStars() {
        return stars;
    }

    public void setStars(List<User> stars) {
        this.stars = stars;
    }

    public Map<ResourcePageSlot, Content> getContent() {
        return content;
    }

    public void setContent(Map<ResourcePageSlot, Content> content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Resource resource = (Resource) o;
        return java.util.Objects.equals(id, resource.id) &&
                java.util.Objects.equals(name, resource.name) &&
                java.util.Objects.equals(title, resource.title) &&
                java.util.Objects.equals(description, resource.description) &&
                java.util.Objects.equals(authors, resource.authors) &&
                java.util.Objects.equals(tags, resource.tags) &&
                java.util.Objects.equals(versions, resource.versions) &&
                java.util.Objects.equals(stars, resource.stars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, title, description, authors, tags, versions, stars);
    }

    @Override
    public String toString() {
        return "Resource{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", authors=" + authors +
                ", tags=" + tags +
                ", versions=" + versions +
                ", stars=" + stars +
                '}';
    }
}
