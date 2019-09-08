package edu.RobertoAranovich.advancedjava;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Unit test for Author class.
 *
 * @author Roberto Aranovich
 */
public class AuthorTest extends TestCase {
    SimpleDateFormat dateFormat = new SimpleDateFormat("mm-dd-yyyy");

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AuthorTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(AuthorTest.class);
    }

    public void testIsAlivePositive() throws ParseException {
        Author author = new Author("Herman Melville", dateFormat.parse("08-01-1819"), dateFormat.parse("09-28-1891"), "New York City, New York, USA");
        assertTrue(!author.isAlive());
    }

    public void testIsAliveNegative() throws ParseException {
        Author author = new Author("Paul Auster", dateFormat.parse("02-03-1947"), dateFormat.parse("00-00-0000"), "New York City, New York, USA");
        assertFalse(!author.isAlive());
    }

    public void testGetNamePositive() throws ParseException {
        Author author = new Author("Dashiell Hammett", dateFormat.parse("05-27-1894"), dateFormat.parse("01-10-1961"), "St. Mary's County, Maryland, USA");
        assertTrue(author.getName().equals("Dashiell Hammett"));
    }

    public void testGetNameNegative() throws ParseException {
        Author author = new Author("Dashiell Hammett", dateFormat.parse("05-27-1894"), dateFormat.parse("01-10-1961"), "St. Mary's County, Maryland, USA");
        assertTrue(!(author.getName() == null));
    }

    public void testGetDateOfBirthPositive() throws ParseException {
        Author author = new Author("Dashiell Hammett", dateFormat.parse("05-27-1894"), dateFormat.parse("01-10-1961"), "St. Mary's County, Maryland, USA");
        Date testDate = (dateFormat.parse("05-27-1894"));
        assertTrue(author.getDateOfBirth().equals(testDate));
    }

    public void testGetDateOfBirthNegative() throws ParseException {
        Author author = new Author("Dashiell Hammett", dateFormat.parse("05-27-1894"), dateFormat.parse("01-10-1961"), "St. Mary's County, Maryland, USA");
        assertFalse(author.getDateOfBirth() == null);
    }

    public void testDateOfDeathPositive() throws ParseException {
        Author author = new Author("Herman Melville", dateFormat.parse("08-01-1819"), dateFormat.parse("09-28-1891"), "New York City, New York, USA");
        Date testDate = (dateFormat.parse("09-28-1891"));
        assertTrue(author.getDateOfDeath().equals(testDate));
    }

    public void testGetDateOfDeathNegative() throws ParseException {
        Author author = new Author("Herman Melville", dateFormat.parse("08-01-1819"), dateFormat.parse("09-28-1891"), "New York City, New York, USA");
        assertFalse(author.getDateOfDeath() == null);
    }

    public void testGetPlaceOfBirthPositive() throws ParseException {
        Author author = new Author("Paul Auster", dateFormat.parse("02-03-1947"), dateFormat.parse("00-00-0000"), "New York City, New York, USA");
        assertTrue(author.getPlaceOfBirth().equals("New York City, New York, USA"));
    }

    public void testGetPlaceOfBirthNegative() throws ParseException {
        Author author = new Author("Paul Auster", dateFormat.parse("02-03-1947"), dateFormat.parse("00-00-0000"), "New York City, New York, USA");
        assertTrue(!(author.getPlaceOfBirth() == null));
    }

}