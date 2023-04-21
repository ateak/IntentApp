package ru.study.intentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button submitButton;
    Button browserButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        submitButton = (Button) findViewById(R.id.submit_button);
        browserButton = (Button) findViewById(R.id.browser_button);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText firstName = (EditText) findViewById(R.id.first_name_text);
                EditText lastName = (EditText) findViewById(R.id.last_name_text);

                String firstNameString = firstName.getText().toString();
                String lastNameString = lastName.getText().toString();

                Intent submitIntent = new Intent(MainActivity.this, ShowActivity.class);
                submitIntent.putExtra("firstNameString", firstNameString);
                submitIntent.putExtra("lastNameString", lastNameString);
                startActivity(submitIntent);
            }
        });

        browserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://code.tutsplus.com"));
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                } else {
                    Log.d("Intent", "Не получается обработать намерение!");
                }
            }
        });
    }
}