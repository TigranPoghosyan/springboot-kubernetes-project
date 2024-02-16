package com.example.bookmarkerapi.service;

import com.example.bookmarkerapi.entity.Bookmark;
import com.example.bookmarkerapi.repository.BookmarkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BookmarkService {

    private final BookmarkRepository bookmarkRepository;

    @Transactional(readOnly = true)
    public List<Bookmark> getBookmarks() {
        return bookmarkRepository.findAll();
    }
}
