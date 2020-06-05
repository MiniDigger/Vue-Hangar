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
            TagType licence = new TagType("Licence", "📜", false);
            TagType supportedMCVersion = new TagType("Supported MC Version", "🎮", true);
            TagType nativeMCVersion = new TagType("Native MC Version", "🎮", false);
            TagType sourceType = new TagType("Source distribution Type", "ℹ", false);
            TagType resourceType = new TagType("Resource Type", "", false);
            TagType resourceCategory = new TagType("Resource Category", "", true);
            tagTypeRepository.saveAll(List.of(licence, supportedMCVersion, nativeMCVersion, sourceType, resourceType, resourceCategory));

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

            // general resource type tags
            Tag paper = new Tag("Paper", resourceType);
            Tag waterfall = new Tag("Waterfall", resourceType);
            Tag universal = new Tag("Universal", resourceType);
            Tag standalone = new Tag("Standalone", resourceType);
            Tag web = new Tag("Web", resourceType);
            tagRepository.saveAll(List.of(paper, waterfall, universal, standalone, web));

            // specific resource category tags
            Tag chat = new Tag("Chat", resourceCategory);
            Tag gamemodes = new Tag("Gamemodes", resourceCategory);
            Tag economy = new Tag("Economy", resourceCategory);
            Tag moderation = new Tag("Moderation", resourceCategory);
            Tag mechanics = new Tag("Mechanics", resourceCategory);
            Tag worldManagement = new Tag("World Management", resourceCategory);
            Tag fun = new Tag("Fun", resourceCategory);
            Tag misc = new Tag("Miscellaneous", resourceCategory);
            Tag utilities = new Tag("Utilities", resourceCategory);
            Tag libraries = new Tag("Libraries & APIs", resourceCategory);
            tagRepository.saveAll(List.of(chat, gamemodes, economy, moderation, mechanics, worldManagement, fun, misc, utilities, libraries));
        };
    }
}
