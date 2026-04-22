package com.ecnu.library;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public class Library {
    private final Map<String, Book> books = new HashMap<>();

    public void addBook(Book book) {
        if (book == null || book.getId() == null) {
            throw new IllegalArgumentException("book 或 id 不能为空");
        }
        if (books.containsKey(book.getId())) {
            throw new IllegalArgumentException("图书 id 已存在: " + book.getId());
        }
        books.put(book.getId(), book);
    }

    public void borrowBook(String id) {
        Book book = getBookOrThrow(id);
        // 借书时若已借出则抛出异常，避免状态被重复修改。
        if (book.isBorrowed()) {
            throw new IllegalStateException("图书已被借出: " + id);
        }
        book.setBorrowed(true);
    }

    public void returnBook(String id) {
        Book book = getBookOrThrow(id);
        // 还书时若本就未借出，说明状态不合法。
        if (!book.isBorrowed()) {
            throw new IllegalStateException("图书当前未借出: " + id);
        }
        book.setBorrowed(false);
    }

    public List<Book> listAvailableBooks() {
        List<Book> result = new ArrayList<>();
        // 仅筛选未借出的图书。
        for (Book book : books.values()) {
            if (!book.isBorrowed()) {
                result.add(book);
            }
        }
        return result;
    }

    private Book getBookOrThrow(String id) {
        Book book = books.get(id);
        if (book == null) {
            throw new NoSuchElementException("图书不存在: " + id);
        }
        return book;
    }
}
