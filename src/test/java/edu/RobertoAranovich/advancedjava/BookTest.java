package edu.RobertoAranovich.advancedjava;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * JUnit test for Book class.
 *
 * @author Roberto Aranovich
 */
public class BookTest {
    SimpleDateFormat dateFormat = new SimpleDateFormat("mm-dd-yyyy");

    @Test
    public void testIsInThePublicDomainPositive() throws ParseException {
        Author author = new Author("Herman Melville", dateFormat.parse("08-01-1819"), dateFormat.parse("09-28-1891"), "New York City, New York, USA");
        Book book = new Book("Moby-Dick", author, "Harper and Brothers", dateFormat.parse("00-00-1951"), "New York City, New York, USA");
        assertTrue(book.isInThePublicDomain());
    }

    @Test
    public void testIsInThePublicDomainNegative() throws ParseException {
        Author author = new Author("Paul Auster", dateFormat.parse("02-03-1947"), dateFormat.parse("00-00-0000"), "New York City, New York, USA");
        Book book = new Book("In the Country of Last Things", author, "Viking Press", dateFormat.parse("00-00-1987"), "New York City, New York, USA");
        assertFalse(book.isInThePublicDomain());
    }

    @Test
    public void testGetTitlePositive() throws ParseException {
        Author author = new Author("Dashiell Hammett", dateFormat.parse("05-27-1894"), dateFormat.parse("01-10-1961"), "St. Mary's County, Maryland, USA");
        Book book = new Book("The Maltese Falcon", author, "Alfred A. Knopf, Inc.", dateFormat.parse("00-00-1930"), "New York City, New York, USA");
        assertTrue(book.getTitle().equals("The Maltese Falcon"));
    }

    @Test
    public void testGetTitleNegative() throws ParseException {
        Author author = new Author("Dashiell Hammett", dateFormat.parse("05-27-1894"), dateFormat.parse("01-10-1961"), "St. Mary's County, Maryland, USA");
        Book book = new Book("The Maltese Falcon", author, "Alfred A. Knopf, Inc.", dateFormat.parse("00-00-1930"), "New York City, New York, USA");
        assertTrue(!(book.getTitle() == null));
    }

    @Test
    public void testGetAuthorPositive() throws ParseException {
        Author author = new Author("Dashiell Hammett", dateFormat.parse("05-27-1894"), dateFormat.parse("01-10-1961"), "St. Mary's County, Maryland, USA");
        Book book = new Book("The Maltese Falcon", author, "Alfred A. Knopf, Inc.", dateFormat.parse("00-00-1930"), "New York City, New York, USA");
        assertTrue(book.getAuthor().equals(author));
    }

    @Test
    public void testGetAuthorNegative() throws ParseException {
        Author author = new Author("Dashiell Hammett", dateFormat.parse("05-27-1894"), dateFormat.parse("01-10-1961"), "St. Mary's County, Maryland, USA");
        Book book = new Book("The Maltese Falcon", author, "Alfred A. Knopf, Inc.", dateFormat.parse("00-00-1930"), "New York City, New York, USA");
        assertTrue(!(book.getAuthor() == null));
    }

    @Test
    public void testGetPublisherPositive() throws ParseException {
        Author author = new Author("Dashiell Hammett", dateFormat.parse("05-27-1894"), dateFormat.parse("01-10-1961"), "St. Mary's County, Maryland, USA");
        Book book = new Book("The Maltese Falcon", author, "Alfred A. Knopf, Inc.", dateFormat.parse("00-00-1930"), "New York City, New York, USA");
        assertTrue(book.getPublisher().equals("Alfred A. Knopf, Inc."));
    }

    @Test
    public void testGetPublisherNegative() throws ParseException {
        Author author = new Author("Dashiell Hammett", dateFormat.parse("05-27-1894"), dateFormat.parse("01-10-1961"), "St. Mary's County, Maryland, USA");
        Book book = new Book("The Maltese Falcon", author, "Alfred A. Knopf, Inc.", dateFormat.parse("00-00-1930"), "New York City, New York, USA");
        assertTrue(!(book.getTitle() == null));
    }

    @Test
    public void testGetDateOfPublicationPositive() throws ParseException {
        Author author = new Author("Dashiell Hammett", dateFormat.parse("05-27-1894"), dateFormat.parse("01-10-1961"), "St. Mary's County, Maryland, USA");
        Book book = new Book("The Maltese Falcon", author, "Alfred A. Knopf, Inc.", dateFormat.parse("00-00-1930"), "New York City, New York, USA");
        assertTrue(book.getDateOfPublication().equals(dateFormat.parse("00-00-1930")));
    }

    @Test
    public void testGetDateOfPublicationNegative() throws ParseException {
        Author author = new Author("Dashiell Hammett", dateFormat.parse("05-27-1894"), dateFormat.parse("01-10-1961"), "St. Mary's County, Maryland, USA");
        Book book = new Book("The Maltese Falcon", author, "Alfred A. Knopf, Inc.", dateFormat.parse("00-00-1930"), "New York City, New York, USA");
        assertTrue(!(book.getDateOfPublication() == null));
    }

    @Test
    public void testGetPlaceOfPublicationPositive() throws ParseException {
        Author author = new Author("Dashiell Hammett", dateFormat.parse("05-27-1894"), dateFormat.parse("01-10-1961"), "St. Mary's County, Maryland, USA");
        Book book = new Book("The Maltese Falcon", author, "Alfred A. Knopf, Inc.", dateFormat.parse("00-00-1930"), "New York City, New York, USA");
        assertTrue(book.getPlaceOfPublication().equals("New York City, New York, USA"));
    }

    @Test
    public void testGetPlaceOfPublicationNegative() throws ParseException {
        Author author = new Author("Dashiell Hammett", dateFormat.parse("05-27-1894"), dateFormat.parse("01-10-1961"), "St. Mary's County, Maryland, USA");
        Book book = new Book("The Maltese Falcon", author, "Alfred A. Knopf, Inc.", dateFormat.parse("00-00-1930"), "New York City, New York, USA");
        assertTrue(!(book.getPlaceOfPublication() == null));
    }
}