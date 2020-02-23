/**
 * @author Emmanuel Gallegos
 * @version "%I%, %G%"
 */
package com.company;
/**
 * AddressEntry class, describes contents of a single AddressEntry for use in AddressBook
 */
public class AddressEntry {
    /**
     * This stores the first name of the person at this address
     */
    private String firstName;
    /**
     * This stores the last name of the person at this address
     */
    private String lastName;
    /**
     * This stores the street name of the person at this address
     */
    private String street;
    /**
     * This stores the city name of the person at this address
     */
    private String city;
    /**
     * This stores the state name of the person at this address
     */
    private String state;
    /**
     * This stores the zip code of the person at this address
     */
    private int zip;
    /**
     * This stores the phone number of the person at this address
     */
    private String phone;
    /**
     * This stores the email address of the person at this address
     */
    private String email;
    /**
     * default Constructor defines generic AddressEntry
     */
    public AddressEntry()
    {
        firstName = "Allison";
        lastName = "Jennings";
        street = "123 Monrovia Ave";
        city = "Cincinnati";
        state = "Washington";
        zip = 97202;
        phone = "555-321-9876";
        email = "a.jennings.1994@gmail.com";
    }

    /**
     * Constructor allows for initialization of all AddressEntry fields
     * @param fn    first name
     * @param ln    last name
     * @param str   street name
     * @param ci    city name
     * @param sta   state name
     * @param zc    zip code
     * @param pn    phone number
     * @param em    email address
     */
    public AddressEntry( String fn, String ln, String str, String ci, String sta, int zc, String pn, String em )
    {
        firstName = fn;
        lastName = ln;
        street = str;
        city = ci;
        state = sta;
        zip = zc;
        phone = pn;
        email = em;
    }

    /**
     * @return data from this object as a neatly formatted String
     */
    public String toString()
    {
        return lastName + ", " + firstName + "\n\t" + street + "\n\t" + city + ", " + state + ' '+ zip
                + "\n\t" + phone + "\n\t" + email;
    }

    /**
     * @param str   first name
     */
    public void setFirstName( String str )
    {
        firstName = str;
    }
    /**
     * @param str   last name
     */
    public void setLastName( String str )
    {
        lastName = str;
    }

    /**
     * @param str   street name
     */
    public void setStreet( String str )
    {
        street = str;
    }

    /**
     * @param str   city name
     */
    public void setCity( String str )
    {
        city = str;
    }

    /**
     * @param str   state name
     */
    public void setState( String str )
    {
        state = str;
    }

    /**
     * @param str   zip code
     */
    public void setZip( int str )
    {
        zip = str;
    }

    /**
     * @param str   phone number
     */
    public void setPhone( String str )
    {
        phone = str;
    }

    /**
     * @param str   email address
     */
    public void setEmail( String str )
    {
        email = str;
    }

    /**
     * @return  first name
     */
    public String getFirstName()
    {
        return firstName;
    }

    /**
     * @return last name
     */
    public String getLastName()
    {
        return lastName;
    }

    /**
     * @return  street name
     */
    public String getStreet()
    {
        return street;
    }

    /**
     * @return  city name
     */
    public String getCity()
    {
        return city;
    }

    /**
     * @return  state name
     */
    public String getState()
    {
        return state;
    }

    /**
     * @return  zip code
     */
    public int getZip()
    {
        return zip;
    }

    /**
     * @return  phone number
     */
    public String getPhone()
    {
        return phone;
    }

    /**
     * @return  email address
     */
    public String getEmail()
    {
        return email;
    }
}
