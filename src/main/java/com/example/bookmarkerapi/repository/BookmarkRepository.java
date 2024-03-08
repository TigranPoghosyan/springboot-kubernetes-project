package com.example.bookmarkerapi.repository;

import com.example.bookmarkerapi.entity.Bookmark;
import com.example.bookmarkerapi.entity.BookmarkDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BookmarkRepository extends JpaRepository<Bookmark, Long> {

    @Query("select new com.example.bookmarkerapi.entity.BookmarkDTO(b.id,b.title,b.url,b.createdAt) from Bookmark b")
    Page<BookmarkDTO> findBookmarks(Pageable pageable);
}
