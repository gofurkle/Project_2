package com.company;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for AddressBookApplication
 */
public class AddressBookApplicationTest {

    InputStream in;  // for generating fake stream of possible user data
    AddressBookApplication aba = new AddressBookApplication();  // for testing main

    @org.junit.jupiter.api.Test
    void main() {
        // generate a fake null command (a single quit command)
        String cmd = "f\n";
        // convert fake user command to data for dummy input stream
        in = new ByteArrayInputStream(cmd.getBytes());
        // add fake input String into System.in stream
        System.setIn(in);
        // run main process
        aba.main(new String[] {});
        // ensure flow has reached to this point
        assertTrue( true );
    }

    @org.junit.jupiter.api.Test
    void testMain() {
    }
}
