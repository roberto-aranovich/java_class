package edu.RobertoAranovich.advancedjava;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * A simple Author Class to store a book's author info
 *
 * @author Roberto Aranovich
 */

public class Author {

    private String name;
    private Date dateOfBirth;
    private Date dateOfDeath;
    private String placeOfBirth;

    /**
     * Creates a new Author instance.
     *
     * @param name         author's first and last name (and middle initial if any).
     * @param dateOfBirth  author's date of birth.
     * @param dateOfDeath  author's date of death ('00-00-0000' if alive).
     * @param placeOfBirth author's place of birth
     */
    public Author(String name, Date dateOfBirth, Date dateOfDeath, String placeOfBirth) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = dateOfDeath;
        this.placeOfBirth = placeOfBirth;
    }

    /**
     * @return the author's name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the author's date of birth
     */
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * @return the author's date of death ('00-00-0000' if alive).
     */
    public Date getDateOfDeath() {
        return dateOfDeath;
    }

    /**
     * @return the author's place of birth
     */
    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    /**
     * @return a boolean indicating whether the author is alive or not
     */
    public boolean isAlive() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("mm-dd-yyyy");
        Date nullDate = dateFormat.parse("00-00-0000");
        if (dateOfDeath.equals(nullDate)) {
            return true;
        }
        return false;
    }
}
