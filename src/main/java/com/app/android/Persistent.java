package com.app.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class Persistent extends AppCompatActivity {
    int theAmount, index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_persistent);

        final EditText amount = (EditText)findViewById(R.id.txtAmount);

        Button btCalc = (Button)findViewById(R.id.btnCalc);
        final TextView theResult = (TextView)findViewById(R.id.txtResult);

        final SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);

        btCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    theAmount = Integer.parseInt(amount.getText().toString());

                    Spinner spSpice = (Spinner) findViewById(R.id.spnSpice);
                    index = spSpice.getSelectedItemPosition();

                    SharedPreferences.Editor editor = sharedPref.edit();

                    editor.putInt("index", index);
                    editor.putInt("amount", theAmount);

                    editor.commit();

                    startActivity(new Intent(Persistent.this, PersistentResults.class));

                } catch (Exception e) {
                    theResult.setText("Error: " + e);
                }
            }
        });
    }
}
