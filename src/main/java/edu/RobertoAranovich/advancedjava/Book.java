package edu.RobertoAranovich.advancedjava;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

/**
 * A simple Book Class to store entries in a book catalog
 *
 * @author Roberto Aranovich
 */

public class Book {
    private String title;
    private Author author;
    private String publisher;
    private Date dateOfPublication;
    private String placeOfPublication;

    /**
     * Creates a new Book instance.
     *
     * @param title              he title of the book.
     * @param author             author's info (name, date of birth and death (if applicable), nationality.
     * @param publisher          book's publisher or publishing house.
     * @param dateOfPublication  book's date of publication.
     * @param placeOfPublication book's place of publication.
     */

    public Book(String title, Author author, String publisher, Date dateOfPublication, String placeOfPublication) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.dateOfPublication = dateOfPublication;
        this.placeOfPublication = placeOfPublication;
    }

    /**
     * @return the book's title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @return the book's author
     */
    public Author getAuthor() {
        return author;
    }

    /**
     * @return the book's publisher
     */
    public String getPublisher() {
        return publisher;
    }

    /**
     * @return the book's date of publication
     */
    public Date getDateOfPublication() {
        return dateOfPublication;
    }

    /**
     * @return the book's place of publication
     */
    public String getPlaceOfPublication() {
        return placeOfPublication;
    }

    /**
     * Method to determine if the book belongs to the public domain.
     * A public-domain book is a book with no copyright,
     * a book that was created without a license, or a book where its copyrights expired or have been forfeited.
     * In most countries the term of protection of copyright lasts until January first,
     * 70 years after the death of the latest living author (from Wikipedia.com).
     * I will assume that all the books are copyrighted and licensed,
     * so the criterion will be whether or not the author is alive and when did she died.
     * The method doesn't support books with multiple authors.
     *
     * @return a boolean indicating if the book belongs to the public domain
     */
    public boolean isInThePublicDomain() throws ParseException {
        if (author.isAlive()) {
            return false;
        } else {
            Calendar cal = Calendar.getInstance();
            int currentYear = cal.get(Calendar.YEAR);
            cal.setTime(author.getDateOfDeath());
            int yearOfDeath = cal.get(Calendar.YEAR);
            int copyrightExpiration = 70;
            if ((currentYear - yearOfDeath) > copyrightExpiration) {
                return true;
            }
        }
        return false;
    }
}