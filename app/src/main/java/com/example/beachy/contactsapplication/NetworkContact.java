package com.example.beachy.contactsapplication;

import android.util.JsonReader;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Beachy on 2/3/2016.
 */
public class NetworkContact {

    // Execute and return data from given URL

    //Connect to given URL
    public static List connectContacts() throws MalformedURLException, IOException{
        URL url = new URL("http://solstice.applauncher.com/external/contacts.json");
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        urlConnection.connect();
        try {
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            List contacts = readStream(in);
            return contacts;
        } finally {
            urlConnection.disconnect();
        }
    }

    public static DetailsDTO connectDetails(URL url) throws MalformedURLException, IOException{
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        urlConnection.connect();
        try{
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            JsonReader reader = new JsonReader((new InputStreamReader(in, "UTF-8")));
            try {
                return readDetails(reader);
            } finally {
                reader.close();
            }
        } finally {
            urlConnection.disconnect();
        }

    }



    public static List readStream(InputStream in) throws IOException{
        JsonReader reader = new JsonReader(new InputStreamReader(in, "UTF-8"));
        try {
            return readContactsArray(reader);
        } finally {
            reader.close();
        }
    }

    public static List readContactsArray(JsonReader reader) throws IOException{
        List contacts = new ArrayList();

        reader.beginArray();
        while (reader.hasNext()){
            contacts.add(readContacts(reader));
        }
        reader.endArray();
        return contacts;
    }

    public static ContactsDTO readContacts(JsonReader reader) throws IOException {
        String name = null;
        int employeeID = -1;
        String company = null;
        DetailsDTO details = null;
        String smallImageURL = null;
        String birth = null;
        NumberDTO numbers = null;

        reader.beginObject();
        while(reader.hasNext()){
            String tag = reader.nextName();
            if (tag.equals("name")){
                name = reader.nextString();
            } else if (tag.equals("employeeId")){
                employeeID = reader.nextInt();
            } else if (tag.equals("company")){
                company = reader.nextString();
            } else if (tag.equals("detailsURL")){
                URL url =  new URL(reader.nextString());
                details = connectDetails(url);
            } else if (tag.equals("smallImageURL")){
                smallImageURL = reader.nextString();
            } else if (tag.equals("birthdate")){
                birth = reader.nextString();
            } else if (tag.equals("phone")){
                numbers = readNumbers(reader);
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return new ContactsDTO(name, employeeID, company, details, smallImageURL, birth, numbers);
    }

    public static DetailsDTO readDetails(JsonReader reader) throws IOException{
        int empID = -1;
        boolean favorite = false;
        String lrgImageURL = null;
        String email = null;
        String website = null;
        AddressDTO address = null;

        reader.beginObject();
        while (reader.hasNext()){
            String tag = reader.nextName();
            if (tag.equals("employeeId")){
                empID = reader.nextInt();
            } else if (tag.equals("favorite")){
                favorite = reader.nextBoolean();
            } else if (tag.equals("largeImageURL")){
                lrgImageURL = reader.nextString();
            } else if (tag.equals("email")){
                email = reader.nextString();
            } else if (tag.equals("website")){
                website = reader.nextString();
            } else if (tag.equals("address")){
                address = readAddress(reader);
            } else {
                reader.skipValue();
            }

        }
        reader.endObject();
        return new DetailsDTO(empID, favorite, lrgImageURL, email, website, address);
    }

    public static AddressDTO readAddress(JsonReader reader) throws IOException{
        String street = null;
        String city = null;
        String state = null;
        String zip = null;
        long lat = -1;
        long longitude = -1;

        reader.beginObject();
        while (reader.hasNext()){
            String tag = reader.nextName();
            if (tag.equals("street")){
                street = reader.nextString();
            } else if (tag.equals("city")){
                city = reader.nextString();
            } else if (tag.equals("state")){
                state = reader.nextString();
            } else if (tag.equals("zip")){
                zip = reader.nextString();
            } else if (tag.equals("latitude")){
                lat = reader.nextLong();
            } else if (tag.equals("longitude")) {
                longitude = reader.nextLong();
            } else {
                reader.skipValue();
            }

        }
        reader.endObject();
        return new AddressDTO(street, city, state, zip, lat, longitude);
    }

    public static NumberDTO readNumbers(JsonReader reader) throws IOException{
        String work = null;
        String home = null;
        String mobile = null;

        reader.beginObject();
        while (reader.hasNext()){
            String tag = reader.nextName();
            if (tag.equals("work")){
                work = reader.nextString();
            } else if (tag.equals("home")){
                home = reader.nextString();
            } else if (tag.equals("mobile")){
                mobile = reader.nextString();
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return new NumberDTO(work, home, mobile);
    }

}
