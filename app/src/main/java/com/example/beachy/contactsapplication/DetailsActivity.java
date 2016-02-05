package com.example.beachy.contactsapplication;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class DetailsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_details);
        ContactsDTO contact;
        DetailsDTO details;
        Bundle data = getIntent().getExtras();
        contact = data.getParcelable("contact");
        details = contact.getDetails();

        ImageView imageView = (ImageView) this.findViewById(R.id.detailsIcon);
        TextView nameView = (TextView) this.findViewById(R.id.contactName);
        TextView compView = (TextView) this.findViewById(R.id.contactCompany);
        TextView worknumView = (TextView) this.findViewById(R.id.detailsWorkNumber);
        TextView homenumView = (TextView) this.findViewById(R.id.detailsHomeNumber);
        TextView mobilenumView = (TextView) this.findViewById(R.id.detailsMobileNumber);
        TextView streetView = (TextView) this.findViewById(R.id.detailsStreet);
        TextView cityView = (TextView) this.findViewById(R.id.detailsCityStateZip);
        TextView birthday = (TextView) this.findViewById(R.id.birthday);
        TextView email = (TextView) this.findViewById(R.id.detailsEmail);



        new downloadImageTask(imageView).execute(details.getLrgImageURL());
        nameView.setText(contact.getName());
        compView.setText(contact.getCompany());
        worknumView.setText(contact.getWorknumber());
        homenumView.setText(contact.getHomenumber());
        mobilenumView.setText(contact.getCellnumber());
        streetView.setText(details.getAddress().getStreet());
        cityView.setText(details.getAddress().getCity() + ", " + details.getAddress().getState() + " " + details.getAddress().getZip());
        birthday.setText(contact.getBirthdate());
        email.setText(details.getEmail());

    }


    private class downloadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;

        public downloadImageTask(ImageView bmImage){
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls){
            String displayurl = urls[0];
            Bitmap icon = null;
            try{
                InputStream in = new URL(displayurl).openStream();
                icon = BitmapFactory.decodeStream(in);
            } catch (MalformedURLException e){
                e.printStackTrace();
            } catch (IOException e){
                e.printStackTrace();
            }
            return icon;
        }

        protected void onPostExecute(Bitmap result){
            bmImage.setImageBitmap(result);
        }
    }
}
