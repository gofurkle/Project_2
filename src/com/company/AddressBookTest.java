package com.company;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
/**
 * Test class for AddressBook
 */
public class AddressBookTest {

    AddressBook ab = new AddressBook(); // generic address book for testing
    InputStream in;  // for generating fake stream of possible user data
    ByteArrayOutputStream generatedOutput = new ByteArrayOutputStream();    // for capturing console output

    @org.junit.jupiter.api.BeforeEach
    public void init(){
        // generate and add 2 dummy entries
        AddressEntry entry1 = new AddressEntry( "Jenny", "Patterson", "2452 Bermuda Ave",
                "San Leandro", "CA", 94577, "510-566-9569", "jenny@gmail.com");

        AddressEntry entry2 = new AddressEntry( "Carl", "Patterson", "2452 Bermuda Ave",
                "San Leandro", "CA", 94577, "510-833-6270", "carl@gmail.com");
        ab.add( entry1 );
        ab.add( entry2 );
        // double check that size is 2
        assertEquals( 2, ab.addressEntryList.size() );
    }

    @org.junit.jupiter.api.Test
    void list() {
        // create new address book for this test (something smaller)
        AddressBook listTest = new AddressBook();
        // add an entry to it
        AddressEntry entry1 = new AddressEntry( "Jenny", "Patterson", "2452 Bermuda Ave",
                "San Leandro", "CA", 94577, "510-566-9569", "jenny@gmail.com");
        listTest.add( entry1 );
        // prepare buffer to capture output stream
        System.setOut(new PrintStream(generatedOutput));

        // list data
        listTest.list();
        // compare captured output
        assertEquals( '\t' + "Patterson" + ", " + "Jenny" + "\n\t" + "2452 Bermuda Ave" + "\n\t"
                + "San Leandro" + ", " + "CA" + ' '+ 94577
                + "\n\t" + "510-566-9569" + "\n\t" + "jenny@gmail.com\n", generatedOutput.toString() );
    }

    @org.junit.jupiter.api.Test
    void find() {
        // check that two entries are returned for perfect match
        assertEquals( 2, ab.find( "Patterson" ).size() );
        // check that two entries are returned for first three letters
        assertEquals( 2, ab.find( "Pat" ).size() );
        // check that zero entries are returned for non-match
        assertEquals( 0, ab.find( "Zap" ).size() );
        // generate and new entry
        AddressEntry entry3 = new AddressEntry( "Frank", "Zappa", "303 Howard Ln",
                "San Leandro", "CA", 94577, "510-566-9569", "jenny@gmail.com");
        ab.add( entry3 );
        // check that one entry is found for query
        assertEquals( 1, ab.find( "Z" ).size() );
    }

    @org.junit.jupiter.api.Test
    void readFromFile() {
        // check that initial size is 2
        assertEquals( 2, ab.addressEntryList.size() );
        // read 2 new entries from a file
        ab.readFromFile( "AddressInputDataFile.txt" );
        // check that new size is 4
        assertEquals( 4, ab.addressEntryList.size() );
        // read 2 more entries from file
        ab.readFromFile( "AddressFamilyData.txt" );
        // check that new size is 6
        assertEquals( 6, ab.addressEntryList.size() );
    }

    @org.junit.jupiter.api.Test
    void remove() {
        // check that initial size is 2
        assertEquals( 2, ab.addressEntryList.size() );

        // generate fake user input as String for remove prompt which will first chose '2' to remove Jenny Patterson
        // then select 'y' to confirm removal
        String choices = "2\ny";
        // convert fake input to data for dummy input stream
        in = new ByteArrayInputStream(choices.getBytes());
        // add fake input String into System.in stream
        System.setIn(in);
        // attempt to remove Jenny Patterson entry, reading fake input as generated
        ab.remove( "Patterson" );
        // check that new size is 1
        assertEquals( 1, ab.addressEntryList.size() );

        // now generate choice to remove the remaining entry, Carl Patterson, from the address book
        String second = "y";
        // convert fake input to data for dummy input stream
        in = new ByteArrayInputStream(second.getBytes());
        // add fake input String into System.in stream
        System.setIn(in);
        // now attempt to remove the remaining entry
        ab.remove( "Patterson" );
        // check that new size is 0
        assertEquals( 0, ab.addressEntryList.size() );
    }

    @org.junit.jupiter.api.Test
    void add() {
        // check that initial size is 2
        assertEquals( 2, ab.addressEntryList.size() );
        // generate 2 new entries
        AddressEntry entry3 = new AddressEntry( "Frank", "Zappa", "303 Howard Ln",
                "San Leandro", "CA", 94577, "510-566-9569", "jenny@gmail.com");

        AddressEntry entry4 = new AddressEntry( "John", "Lennon", "123 Abbey Rd",
                "Liverpool", "UK", 101, "510-432-4567", "jlennon@gmail.com");
        // add 1 new entry
        ab.add( entry3 );
        // check that new size is 3
        assertEquals( 3, ab.addressEntryList.size() );
        // add 1 new entry
        ab.add( entry4 );
        // check that new size is 4
        assertEquals( 4, ab.addressEntryList.size() );
    }
}
