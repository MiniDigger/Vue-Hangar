package me.minidigger.hangar.util.db;

import com.github.zafarkhaja.semver.Version;

import javax.persistence.AttributeConverter;

public class VersionConverter implements AttributeConverter<Version, String> {
    @Override
    public String convertToDatabaseColumn(Version version) {
        if (version == null) return null;
        return version.toString();
    }

    @Override
    public Version convertToEntityAttribute(String version) {
        if (version == null) return null;
        return Version.valueOf(version);
    }
}
