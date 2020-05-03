package com.app.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.Locale;

public class PersistentResults extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_persistent_results);

        TextView ourResult1 = (TextView)findViewById(R.id.txtResult2);
        TextView ourResult2 = (TextView)findViewById(R.id.txtResult3);
        ImageView image = (ImageView)findViewById(R.id.imgChoice);

        SharedPreferences sharedPref2 = PreferenceManager.getDefaultSharedPreferences(this);

        int index = sharedPref2.getInt("index", 0);
        int amount = sharedPref2.getInt("amount", 1);

        String txtChoice = "";
        double result, numChoice = 0;

        if (index == 0) {
            image.setImageResource(R.drawable.mild);
            txtChoice = "Mild";
            numChoice = 29.95;
        } else if (index == 1) {
            image.setImageResource(R.drawable.medium);
            txtChoice = "Medium";
            numChoice = 39.95;
        } else if (index == 2) {
            image.setImageResource(R.drawable.hot);
            txtChoice = "Hot";
            numChoice = 49.95;
        }

        result = amount*numChoice;

        ourResult1.setText("You purchased: " + txtChoice);
        ourResult2.setText("Your cost is: " + NumberFormat.getCurrencyInstance(new Locale("en", "US")).format(result));
    }
}
