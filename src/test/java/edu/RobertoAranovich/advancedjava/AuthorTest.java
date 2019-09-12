package edu.RobertoAranovich.advancedjava;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * JUnit test for Author class.
 *
 * @author Roberto Aranovich
 */
public class AuthorTest {

    SimpleDateFormat dateFormat = new SimpleDateFormat("mm-dd-yyyy");

    @Test
    public void testIsAlivePositive() throws ParseException {
        Author author = new Author("Herman Melville", dateFormat.parse("08-01-1819"), dateFormat.parse("09-28-1891"), "New York City, New York, USA");
        assertTrue(!author.isAlive());
    }

    @Test
    public void testIsAliveNegative() throws ParseException {
        Author author = new Author("Paul Auster", dateFormat.parse("02-03-1947"), dateFormat.parse("00-00-0000"), "New York City, New York, USA");
        assertFalse(!author.isAlive());
    }

    @Test
    public void testGetNamePositive() throws ParseException {
        Author author = new Author("Dashiell Hammett", dateFormat.parse("05-27-1894"), dateFormat.parse("01-10-1961"), "St. Mary's County, Maryland, USA");
        assertTrue(author.getName().equals("Dashiell Hammett"));
    }

    @Test
    public void testGetNameNegative() throws ParseException {
        Author author = new Author("Dashiell Hammett", dateFormat.parse("05-27-1894"), dateFormat.parse("01-10-1961"), "St. Mary's County, Maryland, USA");
        assertTrue(!(author.getName() == null));
    }

    @Test
    public void testGetDateOfBirthPositive() throws ParseException {
        Author author = new Author("Dashiell Hammett", dateFormat.parse("05-27-1894"), dateFormat.parse("01-10-1961"), "St. Mary's County, Maryland, USA");
        Date testDate = (dateFormat.parse("05-27-1894"));
        assertTrue(author.getDateOfBirth().equals(testDate));
    }

    @Test
    public void testGetDateOfBirthNegative() throws ParseException {
        Author author = new Author("Dashiell Hammett", dateFormat.parse("05-27-1894"), dateFormat.parse("01-10-1961"), "St. Mary's County, Maryland, USA");
        assertFalse(author.getDateOfBirth() == null);
    }

    @Test
    public void testDateOfDeathPositive() throws ParseException {
        Author author = new Author("Herman Melville", dateFormat.parse("08-01-1819"), dateFormat.parse("09-28-1891"), "New York City, New York, USA");
        Date testDate = (dateFormat.parse("09-28-1891"));
        assertTrue(author.getDateOfDeath().equals(testDate));
    }

    @Test
    public void testGetDateOfDeathNegative() throws ParseException {
        Author author = new Author("Herman Melville", dateFormat.parse("08-01-1819"), dateFormat.parse("09-28-1891"), "New York City, New York, USA");
        assertFalse(author.getDateOfDeath() == null);
    }

    @Test
    public void testGetPlaceOfBirthPositive() throws ParseException {
        Author author = new Author("Paul Auster", dateFormat.parse("02-03-1947"), dateFormat.parse("00-00-0000"), "New York City, New York, USA");
        assertTrue(author.getPlaceOfBirth().equals("New York City, New York, USA"));
    }

    @Test
    public void testGetPlaceOfBirthNegative() throws ParseException {
        Author author = new Author("Paul Auster", dateFormat.parse("02-03-1947"), dateFormat.parse("00-00-0000"), "New York City, New York, USA");
        assertTrue(!(author.getPlaceOfBirth() == null));
    }

}