/**
 * @author Emmanuel Gallegos
 * @version "%I%, %G%"
 */
package com.company;
import java.util.*;

/**
 * Outlines main class, containing address book application. As of now, main method
 * merely creates a new instance of address book, and calls an init method to test
 * the address book by creating two dummy entries and adding them to the book
 */
public class AddressBookApplication {
    private static AddressBook addressBook = new AddressBook(); // main object

    /**
     * creates instance of addressBook and uses Menu class methods to display menu
     * and read user input to manipulate Address Book Application until 'f' or 'F'
     * command is read from user input.
     * @param args  array of command line String arguments
     */
    public static void main(String[] args) {
        AddressEntry entry; // for holding dummy entry for addition command
        Scanner in = new Scanner(System.in);    // for reading user input
        ArrayList<AddressEntry> entries;        // for holding find command results
        String str;     // for holding user strings in commands: a, b, c, d
        int tmp;        // for holding zip code in addition command and result from load from file
        char c = 'x';   // holds user command choice

        while ( c != 'f' && c!= 'F' )
        {
            c = Menu.getMenuChoice();
            switch (c) {
                case 'a': // process load from file command
                    System.out.println( "Please enter the name of the file you would like to open" );
                    str = in.nextLine();
                    tmp = addressBook.readFromFile( str );
                    System.out.println( "Added " + tmp + " entries to address book" );
                    break;
                case 'b': // process addition command
                    // allocate new entry to add
                    entry = new AddressEntry();
                    // get first name
                    str = Menu.prompt_FirstName();
                    entry.setFirstName(str);
                    // get last name
                    str = Menu.prompt_LastName();
                    entry.setLastName(str);
                    // get street name
                    str = Menu.prompt_Street();
                    entry.setStreet(str);
                    // get city name
                    str = Menu.prompt_City();
                    entry.setCity(str);
                    // get zip code
                    tmp = Menu.prompt_Zip();
                    entry.setZip(tmp);
                    // get state name
                    str = Menu.prompt_State();
                    entry.setState(str);
                    // get phone number
                    str = Menu.prompt_Phone();
                    entry.setPhone(str);
                    // get email
                    str = Menu.prompt_Email();
                    entry.setEmail(str);
                    // add entry to list
                    addressBook.add(entry);
                    // audit to console
                    System.out.println( "\nAdded entry:\n" + entry.toString() + " to address book" );
                    break;
                case 'c': // process removal command
                    System.out.println( "Enter the last name of the entry you would like to remove: " );
                    str = in.nextLine();
                    addressBook.remove(str);
                    break;
                case 'd': // process find command
                    System.out.println( "Enter the last name (or first part of last name) of the entries "
                            + "you would like to find: " );
                    str = in.nextLine();
                    entries = addressBook.find(str);
                    System.out.println( "Found the following " + entries.size() + " entries that match " + str );
                    for ( AddressEntry addressEntry : entries ) {
                        System.out.print( addressEntry.toString() + '\n');
                    }
                    break;
                case 'e': // process listing command
                    addressBook.list();
                    break;
                case 'f': // process exit command
                    System.out.println( "Thank you, goodbye." );
                    break;
                case 'x': // process invalid command
                    System.out.println( "Command invalid. Please choose a valid command\n");
                    break;
            }
        }
    }
}
