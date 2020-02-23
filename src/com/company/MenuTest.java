package com.company;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;
/**
 * Test class for Menu
 */
public class MenuTest {

    Menu menu = new Menu(); // create menu object
    InputStream in;  // for generating fake stream of possible user data

    @org.junit.jupiter.api.Test
    void getMenuChoice() {
        String  badInput = "garbage input",  // for testing horrible user input
                upperC = "C",   // for testing if valid uppercase cmds are converted to lowercase
                lowerB = "b";   // for testing valid lowercase cmds

        // convert fake input to data for dummy input stream
        in = new ByteArrayInputStream(badInput.getBytes());
        // add fake input String into System.in stream
        System.setIn(in);
        // check that the bad input generated from String badInput returns 'x' as expected
        assertEquals('x', menu.getMenuChoice() );

        // now try with uppercase valid input and verify output is lowercase input

        // convert fake input to data for dummy input stream
        in = new ByteArrayInputStream(upperC.getBytes());
        // add fake input String into System.in stream
        System.setIn(in);
        // check that the input generated from String upperC returns 'c' as expected
        assertEquals( 'c', menu.getMenuChoice() );

        // now try with generic lowercase valid input and verify output is same as input

        // convert fake input to data for dummy input stream
        in = new ByteArrayInputStream(lowerB.getBytes());
        // add fake input String into System.in stream
        System.setIn(in);
        // check that the input generated from String upperC returns 'c' as expected
        assertEquals( 'b', menu.getMenuChoice() );
    }

    @org.junit.jupiter.api.Test
    void prompt_FirstName() {
        String jenny = "Jenny"; // for testing if input is properly returned on prompt

        // convert fake input to data for dummy input stream
        in = new ByteArrayInputStream(jenny.getBytes());
        // add fake input String into System.in stream
        System.setIn(in);
        // check that the input generated from String "Jenny" returns "Jenny" as expected
        assertEquals( "Jenny", menu.prompt_FirstName() );

        // convert fake input to data for dummy input stream
        in = new ByteArrayInputStream(jenny.getBytes());
        // add fake input String into System.in stream
        System.setIn(in);
        // check that the input generated from String "Jenny" does not match "Xavier"
        assertFalse( "Xavier" == menu.prompt_FirstName() );
    }

    @org.junit.jupiter.api.Test
    void prompt_LastName() {
        String patterson = "Patterson"; // for testing if input is properly returned on prompt

        // convert fake input to data for dummy input stream
        in = new ByteArrayInputStream(patterson.getBytes());
        // add fake input String into System.in stream
        System.setIn(in);
        // check that the input generated from String "Patterson" returns "Patterson" as expected
        assertEquals( "Patterson", menu.prompt_LastName() );

        // convert fake input to data for dummy input stream
        in = new ByteArrayInputStream(patterson.getBytes());
        // add fake input String into System.in stream
        System.setIn(in);
        // check that the input generated from String "Patterson" does not match "Xavier"
        assertFalse( "Xavier" == menu.prompt_LastName() );
    }

    @org.junit.jupiter.api.Test
    void prompt_Street() {
        String street = "321 Penny Lane"; // for testing if input is properly returned on prompt

        // convert fake input to data for dummy input stream
        in = new ByteArrayInputStream(street.getBytes());
        // add fake input String into System.in stream
        System.setIn(in);
        // check that the input generated from String "321 Penny Lane" returns "321 Penny Lane" as expected
        assertEquals( "321 Penny Lane", menu.prompt_Street() );

        // convert fake input to data for dummy input stream
        in = new ByteArrayInputStream(street.getBytes());
        // add fake input String into System.in stream
        System.setIn(in);
        // check that the input generated from String "321 Penny Lane" does not match "123 Penny Lane"
        assertFalse( "123 Penny Lane" == menu.prompt_Street() );
    }

    @org.junit.jupiter.api.Test
    void prompt_City() {
        String city = "Chicago"; // for testing if input is properly returned on prompt

        // convert fake input to data for dummy input stream
        in = new ByteArrayInputStream(city.getBytes());
        // add fake input String into System.in stream
        System.setIn(in);
        // check that the input generated from String "Chicago" returns "Chicago" as expected
        assertEquals( "Chicago", menu.prompt_State() );

        // convert fake input to data for dummy input stream
        in = new ByteArrayInputStream(city.getBytes());
        // add fake input String into System.in stream
        System.setIn(in);
        // check that the input generated from String "Chicago" does not match "Danville"
        assertFalse( "Danville" == menu.prompt_State() );
    }

    @org.junit.jupiter.api.Test
    void prompt_State() {
        String state = "Illinois"; // for testing if input is properly returned on prompt

        // convert fake input to data for dummy input stream
        in = new ByteArrayInputStream(state.getBytes());
        // add fake input String into System.in stream
        System.setIn(in);
        // check that the input generated from String "Illinois" returns "Illinois" as expected
        assertEquals( "Illinois", menu.prompt_State() );

        // convert fake input to data for dummy input stream
        in = new ByteArrayInputStream(state.getBytes());
        // add fake input String into System.in stream
        System.setIn(in);
        // check that the input generated from String "Illinois" does not match "California"
        assertFalse( "California" == menu.prompt_State() );
    }

    @org.junit.jupiter.api.Test
    void prompt_Zip() {
        String zip = "94577"; // for testing if input is properly returned on prompt

        // convert fake input to data for dummy input stream
        in = new ByteArrayInputStream(zip.getBytes());
        // add fake input String into System.in stream
        System.setIn(in);
        // check that the input generated from String "94577" returns 94577 as expected
        assertEquals( 94577, menu.prompt_Zip() );

        // convert fake input to data for dummy input stream
        in = new ByteArrayInputStream(zip.getBytes());
        // add fake input String into System.in stream
        System.setIn(in);
        // check that the input generated from String "94577" does not match 0
        assertFalse( 0 == menu.prompt_Zip() );
    }

    @org.junit.jupiter.api.Test
    void prompt_Phone() {
        String phone = "510-566-9569"; // for testing if input is properly returned on prompt

        // convert fake input to data for dummy input stream
        in = new ByteArrayInputStream(phone.getBytes());
        // add fake input String into System.in stream
        System.setIn(in);
        // check that the input generated from String "510-566-9569" returns "510-566-9569" as expected
        assertEquals( "510-566-9569", menu.prompt_Phone() );

        // convert fake input to data for dummy input stream
        in = new ByteArrayInputStream(phone.getBytes());
        // add fake input String into System.in stream
        System.setIn(in);
        // check that the input generated from String "510-566-9569" does not match "0"
        assertFalse( "0" == menu.prompt_Phone() );
    }

    @org.junit.jupiter.api.Test
    void prompt_Email() {
        String email = "jenny@yahoo.com"; // for testing if input is properly returned on prompt

        // convert fake input to data for dummy input stream
        in = new ByteArrayInputStream(email.getBytes());
        // add fake input String into System.in stream
        System.setIn(in);
        // check that the input generated from String "jenny@yahoo.com" returns "jenny@yahoo.com" as expected
        assertEquals( "jenny@yahoo.com", menu.prompt_Email() );

        // convert fake input to data for dummy input stream
        in = new ByteArrayInputStream(email.getBytes());
        // add fake input String into System.in stream
        System.setIn(in);
        // check that the input generated from String "jenny@yahoo.com" does not match "henry@yahoo.com"
        assertFalse( "henry@yahoo.com" == menu.prompt_Email() );
    }
}
