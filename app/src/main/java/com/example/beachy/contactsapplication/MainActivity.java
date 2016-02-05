package com.example.beachy.contactsapplication;

import android.app.ListActivity;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MainActivity extends ListActivity implements AdapterView.OnItemClickListener {

    private List<ContactsDTO> contactList = new ArrayList<ContactsDTO>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ListView lv = getListView();
        startTask();
        ListAdapter adapter = new ListAdapter(this, contactList);
        lv.setAdapter(adapter);

        lv.setClickable(true);
        lv.setOnItemClickListener(this);

    }

    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
        ContactsDTO contact = contactList.get(position);
        intent.putExtra("contact", contact);
        startActivity(intent);
    }

    public void setContacts(List<ContactsDTO> list){
        this.contactList = list;
    }

    private void startTask(){
        new JSONtsk().execute();
    }


    public class JSONtsk extends AsyncTask<URL, Void, List<ContactsDTO>>{

        @Override
        protected List<ContactsDTO> doInBackground(URL... params) {
            List contacts = null;
            try {
                contacts = NetworkContact.connectContacts();
                Collections.sort(contacts);
            } catch (MalformedURLException e){
                System.err.println("Malformed URL Exception: " + e.getMessage());
            } catch (IOException e){
                System.err.println("Caught IOException: " + e.getMessage());
            }
            return contacts;
        }

        protected void onPostExecute(List<ContactsDTO> list){
            contactList = list;
        }
    }
}



