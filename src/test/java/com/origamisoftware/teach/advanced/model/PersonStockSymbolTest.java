package com.origamisoftware.teach.advanced.model;

import org.junit.Test;

import java.sql.Timestamp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Unit test for PersonStockSymbol class
 */
public class PersonStockSymbolTest {

    /**
     * Testing helper method for generating PersonStockSymbol test data
     *
     * @return a PersonStockSymbol object that uses Person and Hobby
     * return from their respective create method.
     */
    public static PersonStockSymbol createPersonStockSymbol() {
        Person person = PersonTest.createPerson();
        String symbol = "GOOG";
        return new PersonStockSymbol( person, symbol );

    }

    @Test
    public void testPersonStockSymbolGetterAndSetters() {
        String symbol = "GOOG";
        Person person = PersonTest.createPerson();
        PersonStockSymbol personStockSymbol = new PersonStockSymbol();
        int id = 8;
        personStockSymbol.setId( id );
        personStockSymbol.setPerson( person );
        personStockSymbol.setSymbol( symbol );
        System.out.println( personStockSymbol.toString() );
        assertEquals( "person matches", person, personStockSymbol.getPerson() );
        assertEquals( "symbol matches", symbol, personStockSymbol.getSymbol() );
        assertEquals( "id matches", id, personStockSymbol.getId() );
    }

    @Test
    public void testEqualsNegativeDifferentPerson() {
        PersonStockSymbol personStockSymbol = createPersonStockSymbol();
        personStockSymbol.setId( 8 );
        String symbol = "AMZN";
        Person person = new Person();
        Timestamp birthDate = new Timestamp( PersonTest.birthDayCalendar.getTimeInMillis() + 10000 );
        person.setBirthDate( birthDate );
        person.setFirstName( PersonTest.firstName );
        person.setLastName( PersonTest.lastName );
        PersonStockSymbol personStockSymbol2 = new PersonStockSymbol( person, symbol );
        assertFalse( "Different person", personStockSymbol.equals( personStockSymbol2 ) );
    }

    @Test
    public void testEquals() {
        PersonStockSymbol personStockSymbol = createPersonStockSymbol();
        assertTrue( "Same objects are equal", personStockSymbol.equals( createPersonStockSymbol() ) );
    }

    @Test
    public void testToString() {
        PersonStockSymbol personStockSymbol = createPersonStockSymbol();
        assertTrue( "toString has lastName", personStockSymbol.toString().contains( PersonTest.lastName ) );
        assertTrue( "toString has person", personStockSymbol.toString().contains( PersonTest.firstName ) );
        assertTrue( "toString has symbol", personStockSymbol.toString().contains( "GOOG" ) );
    }

}