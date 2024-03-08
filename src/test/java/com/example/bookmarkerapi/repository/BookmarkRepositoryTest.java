package com.example.bookmarkerapi.repository;

import com.example.bookmarkerapi.entity.Bookmark;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@TestPropertySource(properties = {
        "spring.datasource.url=jdbc:tc:postgresql:14-alpine:///demo"
})
class BookmarkRepositoryTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private BookmarkRepository bookmarkRepository;

    private List<Bookmark> bookmarks;

    @BeforeEach
    void setUp() {
        bookmarkRepository.deleteAll();
        bookmarks = new ArrayList<>();

        bookmarks.add(new Bookmark(null, "SpringBlog", "https://spring.io/blog", Instant.now()));
        bookmarks.add(new Bookmark(null, "DZone", "https://spring.io/dzone", Instant.now()));
        bookmarks.add(new Bookmark(null, "Kubernetes", "https://spring.io/kubernetes", Instant.now()));
        bookmarks.add(new Bookmark(null, "Docker", "https://spring.io/docker", Instant.now()));

        bookmarkRepository.saveAll(bookmarks);
    }

    @ParameterizedTest
    @CsvSource({
            "1,4,1,1,true,true,false,false"
    })
    void shouldGetBookmarks(int pageNo, int totalElements, int totalPages, int currentPage, boolean isFirst, boolean isLast,
                            boolean hasNext, boolean hasPrevious) throws Exception {
        mockMvc.perform(get("/api/bookmarks?page=" + pageNo))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.totalElements", CoreMatchers.equalTo(totalElements)))
                .andExpect(jsonPath("$.totalPages", CoreMatchers.equalTo(totalPages)))
                .andExpect(jsonPath("$.currentPage", CoreMatchers.equalTo(currentPage)))
                .andExpect(jsonPath("$.isFirstPage", CoreMatchers.equalTo(isFirst)))
                .andExpect(jsonPath("$.isLastPage", CoreMatchers.equalTo(isLast)))
                .andExpect(jsonPath("$.hasNext", CoreMatchers.equalTo(hasNext)))
                .andExpect(jsonPath("$.hasPreviousPage", CoreMatchers.equalTo(hasPrevious)));
    }

}