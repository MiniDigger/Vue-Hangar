package me.minidigger.hangar.model;

import com.google.common.base.Objects;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import java.util.StringJoiner;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Tag {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Type(type = "uuid-char")
    private UUID id;

    private String displayName;
    @OneToOne
    private TagType tagType;

    protected Tag() {
        // JPA
    }

    public Tag(String displayName, TagType tagType) {
        this.displayName = displayName;
        this.tagType = tagType;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public TagType getTagType() {
        return tagType;
    }

    public void setTagType(TagType tagType) {
        this.tagType = tagType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tag tag = (Tag) o;
        return Objects.equal(id, tag.id) &&
               Objects.equal(displayName, tag.displayName) &&
               Objects.equal(tagType, tag.tagType);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, displayName, tagType);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Tag.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("displayName='" + displayName + "'")
                .add("tagType=" + tagType)
                .toString();
    }
}
