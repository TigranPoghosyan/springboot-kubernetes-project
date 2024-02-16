package com.example.bookmarkerapi;

import com.example.bookmarkerapi.entity.Bookmark;
import com.example.bookmarkerapi.repository.BookmarkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final BookmarkRepository bookmarkRepository;

    @Override
    public void run(String... args) throws Exception {
        bookmarkRepository.save(new Bookmark(null, "SpringBlog", "https://spring.io/blog", Instant.now()));
        bookmarkRepository.save(new Bookmark(null, "Quarkus", "https://quarkus.io/", Instant.now()));
        bookmarkRepository.save(new Bookmark(null, "Micronaut", "https://micronaut.io/", Instant.now()));
        bookmarkRepository.save(new Bookmark(null, "JOOQ", "https://jooq.io/", Instant.now()));
        bookmarkRepository.save(new Bookmark(null, "VladMihalcea", "https://vladMihalcea.com", Instant.now()));
        bookmarkRepository.save(new Bookmark(null, "Thoughts On Java", "https://thorben-janssen.com/", Instant.now()));
        bookmarkRepository.save(new Bookmark(null, "DZone", "https://dzone.com/", Instant.now()));
        bookmarkRepository.save(new Bookmark(null, "DevOpsBookmarks", "https://devopsbookmarks.com/", Instant.now()));
        bookmarkRepository.save(new Bookmark(null, "Kubernetes docs", "https://kubernetes.io/odcs/home/", Instant.now()));
        bookmarkRepository.save(new Bookmark(null, "Expressjs", "https://expressjs.com/", Instant.now()));
        bookmarkRepository.save(new Bookmark(null, "Marcobehler", "https://marcoboehler.com", Instant.now()));
        bookmarkRepository.save(new Bookmark(null, "baeldung", "https://baeldung.com", Instant.now()));
        bookmarkRepository.save(new Bookmark(null, "devglan", "https://devglan/", Instant.now()));
        bookmarkRepository.save(new Bookmark(null, "linuxize", "https://linuxize.com", Instant.now()));
        bookmarkRepository.save(new Bookmark(null, "amazon", "https://amazon.com", Instant.now()));
        bookmarkRepository.save(new Bookmark(null, "microsoft", "https://microsoft.com", Instant.now()));
        bookmarkRepository.save(new Bookmark(null, "apple", "https://apple.com", Instant.now()));
        bookmarkRepository.save(new Bookmark(null, "samsung", "https://samsung.com", Instant.now()));
        bookmarkRepository.save(new Bookmark(null, "postgresql", "https://postgresql.com", Instant.now()));
        bookmarkRepository.save(new Bookmark(null, "mongodb", "https://mongodb.com", Instant.now()));
    }
}
