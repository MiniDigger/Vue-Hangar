package me.minidigger.hangar;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

import me.minidigger.hangar.model.Tag;
import me.minidigger.hangar.model.TagType;
import me.minidigger.hangar.repository.TagRepository;
import me.minidigger.hangar.repository.TagTypeRepository;

@SpringBootApplication
public class HangarApplication {

    public static void main(String[] args) {
        SpringApplication.run(HangarApplication.class, args);
    }

    @Bean
    public CommandLineRunner loadInitialData(TagRepository tagRepository, TagTypeRepository tagTypeRepository) {
        return (args) -> {
            // tag types
            TagType licence = new TagType("Licence", "📜");
            TagType supportedMCVersion = new TagType("Supported MC Version", "🎮");
            TagType nativeMCVersion = new TagType("Native MC Version", "🎮");
            TagType sourceType = new TagType("Source distribution Type", "ℹ");
            tagTypeRepository.saveAll(List.of(licence, supportedMCVersion, nativeMCVersion, sourceType));

            // licence tags
            Tag mit = new Tag("MIT", licence);
            Tag gpl = new Tag("GPL", licence);
            Tag allRightsReserved = new Tag("All rights reserved", licence);
            Tag custom = new Tag("Custom", licence);
            tagRepository.saveAll(List.of(mit, gpl, allRightsReserved, custom));

            // mc tags
            for (String version : new String[]{"1.12", "1.13", "1.14", "1.15"}) {
                tagRepository.save(new Tag(version, supportedMCVersion));
                tagRepository.save(new Tag(version, nativeMCVersion));
            }

            // source type tags
            Tag obfuscated = new Tag("Obfuscated", sourceType);
            Tag closedSource = new Tag("Closed source", sourceType);
            Tag sharedSource = new Tag("Shared source", sourceType);
            Tag openSource = new Tag("Open source", sourceType);
            tagRepository.saveAll(List.of(obfuscated, closedSource, sharedSource, openSource));
        };
    }
}
