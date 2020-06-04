package me.minidigger.hangar.model;

import com.google.common.base.Objects;

import com.github.zafarkhaja.semver.Version;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import java.util.StringJoiner;
import java.util.UUID;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import me.minidigger.hangar.util.db.VersionConverter;

@Entity
public class ResourceVersion {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Type(type = "uuid-char")
    private UUID id;

    private String name;
    @Convert(converter = VersionConverter.class)
    private Version version;
    private String description;
    private String url;

    protected ResourceVersion() {
        // JPA
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Version getVersion() {
        return version;
    }

    public void setVersion(Version version) {
        this.version = version;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResourceVersion that = (ResourceVersion) o;
        return Objects.equal(id, that.id) &&
               Objects.equal(name, that.name) &&
               Objects.equal(version, that.version) &&
               Objects.equal(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, name, version, description);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", ResourceVersion.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("name='" + name + "'")
                .add("version=" + version)
                .add("description='" + description + "'")
                .toString();
    }
}
