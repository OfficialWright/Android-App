package com.app.android;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String[] theContent = {"Product Persistent", "Car Animation", "Ukulele Music"};
        setListAdapter(new ArrayAdapter<String>(this, R.layout.activity_main, R.id.lstContent, theContent));
    }

    protected void onListItemClick(ListView l, View v, int position, long id) {
        switch (position) {
            case 0:
                startActivity(new Intent(MainActivity.this, Persistent.class));
                break;
            case 1:
                startActivity(new Intent(MainActivity.this, Animation.class));
                break;
            case 2:
                startActivity(new Intent(MainActivity.this, Music.class));
                break;
        }
    }
}
