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
public class TagType {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Type(type = "uuid-char")
    private UUID id;

    private String displayName;
    private String icon;
    private boolean repeatable;

    protected TagType() {
        // JPA
    }

    public TagType(String displayName, String icon, boolean repeatable) {
        this.displayName = displayName;
        this.icon = icon;
        this.repeatable = repeatable;
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

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public boolean isRepeatable() {
        return repeatable;
    }

    public void setRepeatable(boolean repeatable) {
        this.repeatable = repeatable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TagType tagType = (TagType) o;
        return Objects.equal(id, tagType.id) &&
               Objects.equal(displayName, tagType.displayName) &&
               Objects.equal(icon, tagType.icon);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, displayName, icon);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", TagType.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("displayName='" + displayName + "'")
                .add("icon='" + icon + "'")
                .toString();
    }
}
