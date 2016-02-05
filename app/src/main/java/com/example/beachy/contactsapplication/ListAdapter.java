package com.example.beachy.contactsapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 * Created by Beachy on 2/4/2016.
 */
public class ListAdapter extends ArrayAdapter<ContactsDTO> {
    private final Context context;
    private List<ContactsDTO> contactsDTOList;

    public ListAdapter(Context context, List<ContactsDTO> listView){
        super(context, -1, listView);
        this.context = context;
        this.contactsDTOList = listView;
    }

    @Override
    public int getCount() {
        return contactsDTOList.size();
    }


    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View row_view = inflater.inflate(R.layout.list_row_layout, parent, false);
        ImageView imageView = (ImageView) row_view.findViewById(R.id.contactIcon);
        TextView nameView = (TextView) row_view.findViewById(R.id.PreviewName);
        TextView numView = (TextView) row_view.findViewById(R.id.PreviewNumber);
        new downloadImageTask(imageView).execute(contactsDTOList.get(position).getSmallImageUrl());
        nameView.setText(contactsDTOList.get(position).getName());
        numView.setText(contactsDTOList.get(position).getName());


        return row_view;
    }


    private class downloadImageTask extends AsyncTask<String, Void, Bitmap>{
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
