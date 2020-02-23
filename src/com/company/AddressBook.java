/**
 * @author Emmanuel Gallegos
 * @version "%I%, %G%"
 */
package com.company;

import java.util.*; // for list class utility
import java.io.*;   // for file I/O

/**
 Class AddressBook defines a list of AddressEntries as well as methods to
 add new entries, as well as list all current entries
 */
public class AddressBook {
    /**
     * Has an array list of AddressEntries
     */
    ArrayList<AddressEntry> addressEntryList;

    /**
     * instantiates array list of address entries
     */
    AddressBook() {
        addressEntryList = new ArrayList<>();
    }
    /**
     * iterate through addressEntryList and for each item call toString and print
     * OR prints message if list is empty
     */
    public void list()
    {
        if( addressEntryList.size() == 0 )
        {
            System.out.println( "List is empty!" );
            return;
        }
        for( int i = 0; i < addressEntryList.size(); i++ )
        {
            System.out.println( i + 1 + ".\t" + addressEntryList.get(i).toString() + '\n' );
        }
    }

    /**
     * Takes last name (or first letters) and returns list of all entries that match parameter
     * @param startOf_lastName partial or complete last name to find
     * @return ArrayList containing all AddressEntries which match the parameter
     */
    public ArrayList<AddressEntry> find( String startOf_lastName )
    {
        // search until addressBook is exhausted and all matching entries have been found
        ArrayList<AddressEntry> al = new ArrayList<AddressEntry>();
        for( int i = 0; i < addressEntryList.size(); i++ )
        {
            // if match found, add to list
            if( addressEntryList.get(i).getLastName().startsWith( startOf_lastName ) )
            {
                al.add( addressEntryList.get(i) );
            }
        }
        return al;
    }
    /**
     * Reads in entries from file
     * @param filename : name of file to read entries from
     * @return int : number of entries read
     */
    public int readFromFile( String filename )
    {
        // buffers to hold data
        String firstName, lastName, street, city, state, strZip, phone, email;
        int zip = 0;    // for storing integer zip value
        int ct = 0;     // count of entries read
        boolean badData = false;    // for determining eof

        /**
         * Try to open file and generate buffered reader to take input from filename
         * then read in data from file to initialize addressEntryList, catches and handles
         * FileNotFound exception and IOException
         */
        try {
            // create new buffered reader from filename parameter
            BufferedReader br = new BufferedReader(new FileReader( filename ));
            // attempt to read entries from file
            do {
                // attempt to read in data for each field
                firstName = br.readLine();
                lastName = br.readLine();
                street = br.readLine();
                city = br.readLine();
                state = br.readLine();
                strZip = br.readLine();
                zip = strZip == null ? 0 : Integer.parseInt(strZip);
                phone = br.readLine();
                email = br.readLine();
                // detect if any fields have not been properly read (data is bad OR eof encountered)
                badData = firstName == null ||
                        lastName == null ||
                        street == null ||
                        city == null ||
                        state == null ||
                        zip == 0 ||
                        phone == null ||
                        email == null;
                // if ALL fields have been read, use them to create a new AddressEntry and add it to the list
                if( !badData )
                {
                    add( new AddressEntry( firstName, lastName, street, city, state, zip, phone, email ) );
                    ct++;
                }
            } while( !badData );    // continue as long as there may be more data
        } catch( FileNotFoundException fe ) {
            System.out.println( "File not found: " + filename );
        } catch ( IOException e ) {
            System.out.println( "Can't read from file:" + filename );
        }
        return ct;
    }
    /**
     * finds lastName, prompts user which they would like to remove (if necessary)
     * ensures user is sure about choice before committing to removal
     * @param lastName : last name of entry to remove
     */
    public void remove( String lastName )
    {
        int choice = 0;    // stores user choice if there are multiple matches
        char yes_or_no = '\0';  // for storing if user wants to remove
        Scanner in = new Scanner( System.in );  // for reading user input

        // find all matches for last name param
        ArrayList<AddressEntry> al = find( lastName );

        // if there is more than one match ask user which they'd like to remove
        if( al.size() > 1 )
        {
            System.out.println( "The following " + al.size() + " entries were found in the" +
                    " address book, select number of\nentry you wish to remove: " );
            for( int i = 0; i < al.size(); i++ )
            {
                System.out.println( i + 1 + ":" + al.get(i).toString());
            }
            choice = in.nextInt() - 1;
        }

        // ensure user is confident about removal
        System.out.println( "Hit y to remove the following entry or n to return to main menu:\n"
                + al.get(choice).toString());


        // get user confirmation
        yes_or_no = in.next().charAt(0);

        // if user says yes, remove entry from list
        if( yes_or_no == 'y' || yes_or_no == 'Y' )
        {
            addressEntryList.remove( al.get(choice) );
            System.out.println( "You have successfully removed the " + al.get(choice).getFirstName() + ' '
                    + al.get(choice).getLastName() + " contact." );
        }
    }
    /**
     * add entry to list
     * @param entry is added to list in sorted position by last name then first name
     */
    public void add( AddressEntry entry )
    {
        /**
         * index of where entry is to be inserted
         */
        int indexToAdd = 0;
        /*
         * While we haven't fallen off array and our entry's last name is lexicographically greater than our
         * current search index's last name, advance to next index
         */
        while( indexToAdd < addressEntryList.size() &&
                entry.getLastName().compareTo( addressEntryList.get( indexToAdd ).getLastName() ) > 0 ) {
            indexToAdd++;
        }
        /*
        if we haven't hit the end of the list, and the two last names are identical,
        search according to first name as well
        */
        if( indexToAdd != addressEntryList.size() &&
                entry.getLastName().compareTo( addressEntryList.get( indexToAdd ).getLastName() ) == 0 )
        {
            while( indexToAdd < addressEntryList.size() &&
                    entry.getFirstName().compareTo( addressEntryList.get( indexToAdd ).getFirstName() ) > 0 &&
                    entry.getLastName().compareTo( addressEntryList.get( indexToAdd ).getLastName() ) == 0 )
            {
                indexToAdd++;
            }
        }
        // once appropriate position has been found, add entry to addressBook
        addressEntryList.add( indexToAdd, entry );
    }
}
