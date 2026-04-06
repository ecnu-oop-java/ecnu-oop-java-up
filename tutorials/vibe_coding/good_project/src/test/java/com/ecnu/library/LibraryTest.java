package com.ecnu.library;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LibraryTest {

    private Library library;

    @BeforeEach
    void setUp() {
        library = new Library();
        library.addBook(new Book("B001", "Java Core", "Author A", false));
        library.addBook(new Book("B002", "Effective Java", "Author B", false));
        library.addBook(new Book("B003", "Refactoring", "Author C", false));
    }

    @Test
    void addBookShouldSucceedWhenIdIsUnique() {
        library.addBook(new Book("B010", "Domain-Driven Design", "Eric Evans", false));

        List<Book> available = library.listAvailableBooks();
        assertEquals(4, available.size());
    }

    @Test
    void addBookShouldThrowWhenBookIsNull() {
        assertThrows(IllegalArgumentException.class, () -> library.addBook(null));
    }

    @Test
    void addBookShouldThrowWhenIdIsNull() {
        assertThrows(IllegalArgumentException.class,
                () -> library.addBook(new Book(null, "No Id", "Nobody", false)));
    }

    @Test
    void addBookShouldThrowWhenIdAlreadyExists() {
        assertThrows(IllegalArgumentException.class,
                () -> library.addBook(new Book("B001", "Duplicate", "Someone", false)));
    }

    @Test
    void borrowBookShouldUpdateStateWhenBookExistsAndAvailable() {
        library.borrowBook("B001");

        List<Book> available = library.listAvailableBooks();
        assertEquals(2, available.size());
        assertFalse(available.stream().anyMatch(book -> "B001".equals(book.getId())));
    }

    @Test
    void borrowBookShouldThrowWhenBookNotFound() {
        assertThrows(NoSuchElementException.class, () -> library.borrowBook("B999"));
    }

    @Test
    void borrowBookShouldThrowWhenBookAlreadyBorrowed() {
        library.borrowBook("B002");

        assertThrows(IllegalStateException.class, () -> library.borrowBook("B002"));
    }

    @Test
    void returnBookShouldUpdateStateWhenBookIsBorrowed() {
        library.borrowBook("B003");
        library.returnBook("B003");

        List<Book> available = library.listAvailableBooks();
        assertEquals(3, available.size());
        assertTrue(available.stream().anyMatch(book -> "B003".equals(book.getId())));
    }

    @Test
    void returnBookShouldThrowWhenBookNotFound() {
        assertThrows(NoSuchElementException.class, () -> library.returnBook("B999"));
    }

    @Test
    void returnBookShouldThrowWhenBookIsNotBorrowed() {
        assertThrows(IllegalStateException.class, () -> library.returnBook("B001"));
    }

    @Test
    void listAvailableBooksShouldOnlyReturnUnborrowedBooks() {
        library.borrowBook("B001");
        library.borrowBook("B003");

        List<Book> available = library.listAvailableBooks();
        assertEquals(1, available.size());
        assertEquals("B002", available.get(0).getId());
    }
}
