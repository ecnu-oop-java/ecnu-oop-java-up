package com.ecnu.library;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BookTest {

    @Test
    void gettersAndSettersShouldWorkAsExpected() {
        Book book = new Book("B100", "Clean Code", "Robert C. Martin", false);

        assertEquals("B100", book.getId());
        assertEquals("Clean Code", book.getTitle());
        assertEquals("Robert C. Martin", book.getAuthor());
        assertFalse(book.isBorrowed());

        book.setId("B101");
        book.setTitle("Clean Architecture");
        book.setAuthor("Uncle Bob");
        book.setBorrowed(true);

        assertEquals("B101", book.getId());
        assertEquals("Clean Architecture", book.getTitle());
        assertEquals("Uncle Bob", book.getAuthor());
        assertTrue(book.isBorrowed());
    }

    @Test
    void toStringShouldContainAllFields() {
        Book book = new Book("B200", "Algorithms", "Sedgewick", true);

        String text = book.toString();
        assertTrue(text.contains("B200"));
        assertTrue(text.contains("Algorithms"));
        assertTrue(text.contains("Sedgewick"));
        assertTrue(text.contains("isBorrowed=true"));
    }
}
