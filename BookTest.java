package com.CMSC.Library.domain;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
public class BookTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void testBookConstructor() {
        Book book = new Book("Author", true, "1234567890", "Title", 12345L);
        assertEquals("Author", book.getAuthor());
        assertTrue(book.isAudioBook());
        assertEquals("1234567890", book.getIsbn());
        assertEquals("Title", book.getTitle());
        assertEquals(12345L, book.getAccountNumber());
    }

    @Test
    public void testBookEqualsAndHashCode() {
        Book book1 = new Book("Author", true, "1234567890", "Title", 12345L);
        Book book2 = new Book("Author", true, "1234567890", "Title", 12345L);
        assertTrue(book1.equals(book2) && book2.equals(book1));
        assertEquals(book1.hashCode(), book2.hashCode());
    }

    @Test
    public void testBookToString() {
        Book book = new Book("Author", true, "1234567890", "Title", 12345L);
        String expected = "Book(id=null, author=Author, isAudioBook=true, isbn=1234567890, title=Title, accountNumber=12345)";
        assertEquals(expected, book.toString());
    }

    @Test
    public void testSaveBook() {
        Book book = new Book("Author", true, "1234567890", "Title", 12345L);
        bookRepository.save(book);
        List<Book> books = bookRepository.findAll();
        assertEquals(1, books.size());
        assertEquals(book, books.get(0));
    }

   
}
