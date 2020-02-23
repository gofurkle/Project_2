package com.company;

import static org.junit.jupiter.api.Assertions.*;
/**
 * Test class for AddressEntry
 */
public class AddressEntryTest {

    @org.junit.jupiter.api.Test
    void testToString() {

        AddressEntry entry1 = new AddressEntry( "Jenny", "Patterson", "2452 Bermuda Ave",
                "San Leandro", "CA", 94577, "510-566-9569", "jenny@gmail.com");

        AddressEntry entry2 = new AddressEntry( "Carl", "Patterson", "2452 Bermuda Ave",
                "San Leandro", "CA", 94577, "510-833-6270", "carl@gmail.com");

        // test AddressEntry 1
        assertEquals( '\t' + "Patterson" + ", " + "Jenny" + "\n\t" + "2452 Bermuda Ave" + "\n\t"
                + "San Leandro" + ", " + "CA" + ' '+ 94577
                + "\n\t" + "510-566-9569" + "\n\t" + "jenny@gmail.com", entry1.toString() );

        // test AddressEntry 2
        assertEquals( '\t' + "Patterson" + ", " + "Carl" + "\n\t" + "2452 Bermuda Ave" + "\n\t"
                + "San Leandro" + ", " + "CA" + ' '+ 94577
                + "\n\t" + "510-833-6270" + "\n\t" + "carl@gmail.com", entry2.toString() );
    }

    @org.junit.jupiter.api.Test
    void setFirstName() {
        AddressEntry entry = new AddressEntry();

        // first assert that default first name is "Allison"
        assertEquals( "Allison", entry.getFirstName() );

        // next change the first name of the entry and assert that the new name is correct
        entry.setFirstName( "Alyssa" );
        assertEquals( "Alyssa", entry.getFirstName() );
    }

    @org.junit.jupiter.api.Test
    void setLastName() {
        AddressEntry entry = new AddressEntry();

        // first assert that default last name is "Jennings"
        assertEquals( "Jennings", entry.getLastName() );

        // next change the last name of the entry and assert that the new name is correct
        entry.setLastName( "Ochoa" );
        assertEquals( "Ochoa", entry.getLastName() );
    }

    @org.junit.jupiter.api.Test
    void setStreet() {
        AddressEntry entry = new AddressEntry();

        // first assert that default street name is "123 Monrovia Ave"
        assertEquals( "123 Monrovia Ave", entry.getStreet() );

        // next change the street name of the entry and assert that the new name is correct
        entry.setStreet( "321 Tulip Ln" );
        assertEquals( "321 Tulip Ln", entry.getStreet() );
    }

    @org.junit.jupiter.api.Test
    void setCity() {
        AddressEntry entry = new AddressEntry();

        // first assert that default city name is "Cincinnati"
        assertEquals( "Cincinnati", entry.getCity() );

        // next change the city name of the entry and assert that the new name is correct
        entry.setCity( "Carlstown" );
        assertEquals( "Carlstown", entry.getCity() );
    }

    @org.junit.jupiter.api.Test
    void setState() {
        AddressEntry entry = new AddressEntry();

        // first assert that default state name is "Washington"
        assertEquals( "Washington", entry.getState() );

        // next change the state name of the entry and assert that the new name is correct
        entry.setState( "Oregon" );
        assertEquals( "Oregon", entry.getState() );
    }

    @org.junit.jupiter.api.Test
    void setZip() {
        AddressEntry entry = new AddressEntry();

        // first assert that default zip code is 97202
        assertEquals( 97202, entry.getZip() );

        // next change the zip code of the entry and assert that the new name is correct
        entry.setZip( 94577 );
        assertEquals( 94577, entry.getZip() );
    }

    @org.junit.jupiter.api.Test
    void setPhone() {
        AddressEntry entry = new AddressEntry();

        // first assert that default phone number is "555-321-9876"
        assertEquals( "555-321-9876", entry.getPhone() );

        // next change the phone number of the entry and assert that the new name is correct
        entry.setPhone( "510-566-9569" );
        assertEquals( "510-566-9569", entry.getPhone() );
    }

    @org.junit.jupiter.api.Test
    void setEmail() {
        AddressEntry entry = new AddressEntry();

        // first assert that default email is "a.jennings.1994@gmail.com"
        assertEquals( "a.jennings.1994@gmail.com", entry.getEmail() );

        // next change the first name of the entry and assert that the new name is correct
        entry.setEmail( "b.jennings@gmail.com" );
        assertEquals( "b.jennings@gmail.com", entry.getEmail() );
    }

    @org.junit.jupiter.api.Test
    void getFirstName() {
        AddressEntry entry = new AddressEntry();

        // first assert that default first name is "Allison"
        assertEquals( "Allison", entry.getFirstName() );

        // next change the first name of the entry and assert that the new name is correct
        entry.setFirstName( "Alyssa" );
        assertEquals( "Alyssa", entry.getFirstName() );
    }

    @org.junit.jupiter.api.Test
    void getLastName() {
        AddressEntry entry = new AddressEntry();

        // first assert that default last name is "Jennings"
        assertEquals( "Jennings", entry.getLastName() );

        // next change the last name of the entry and assert that the new name is correct
        entry.setLastName( "Ochoa" );
        assertEquals( "Ochoa", entry.getLastName() );
    }

    @org.junit.jupiter.api.Test
    void getStreet() {
        AddressEntry entry = new AddressEntry();

        // first assert that default street name is "123 Monrovia Ave"
        assertEquals( "123 Monrovia Ave", entry.getStreet() );

        // next change the street name of the entry and assert that the new name is correct
        entry.setStreet( "321 Tulip Ln" );
        assertEquals( "321 Tulip Ln", entry.getStreet() );
    }

    @org.junit.jupiter.api.Test
    void getCity() {
        AddressEntry entry = new AddressEntry();

        // first assert that default city name is "Cincinnati"
        assertEquals( "Cincinnati", entry.getCity() );

        // next change the city name of the entry and assert that the new name is correct
        entry.setCity( "Carlstown" );
        assertEquals( "Carlstown", entry.getCity() );
    }

    @org.junit.jupiter.api.Test
    void getState() {
        AddressEntry entry = new AddressEntry();

        // first assert that default state name is "Washington"
        assertEquals( "Washington", entry.getState() );

        // next change the state name of the entry and assert that the new name is correct
        entry.setState( "Oregon" );
        assertEquals( "Oregon", entry.getState() );
    }

    @org.junit.jupiter.api.Test
    void getZip() {
        AddressEntry entry = new AddressEntry();

        // first assert that default zip code is 97202
        assertEquals( 97202, entry.getZip() );

        // next change the zip code of the entry and assert that the new name is correct
        entry.setZip( 94577 );
        assertEquals( 94577, entry.getZip() );
    }

    @org.junit.jupiter.api.Test
    void getPhone() {
        AddressEntry entry = new AddressEntry();

        // first assert that default phone number is "555-321-9876"
        assertEquals( "555-321-9876", entry.getPhone() );

        // next change the phone number of the entry and assert that the new name is correct
        entry.setPhone( "510-566-9569" );
        assertEquals( "510-566-9569", entry.getPhone() );
    }

    @org.junit.jupiter.api.Test
    void getEmail() {
        AddressEntry entry = new AddressEntry();

        // first assert that default email is "a.jennings.1994@gmail.com"
        assertEquals( "a.jennings.1994@gmail.com", entry.getEmail() );

        // next change the first name of the entry and assert that the new name is correct
        entry.setEmail( "b.jennings@gmail.com" );
        assertEquals( "b.jennings@gmail.com", entry.getEmail() );
    }
}
