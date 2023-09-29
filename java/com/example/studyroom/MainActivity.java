package com.example.studyroom;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.studyroom.R;
import com.example.studyroom.usermanagement.RegistrationActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the RelativeLayout where you want to add the button
        @SuppressLint({"WrongViewCast", "MissingInflatedId", "LocalSuppress"}) RelativeLayout relativeLayout = findViewById(R.id.username); // Replace with your layout ID

        // Create a new Button
        Button button = new Button(this);

        // Set button properties (e.g., text and layout params)
        button.setText("Click Me");
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT);
        button.setLayoutParams(layoutParams);

        // Set a click listener to open the other activity
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Start the other activity
                Intent intent = new Intent(MainActivity.this, RegistrationActivity.class); // Replace with the target activity
                startActivity(intent);
            }
        });

        // Add the button to the RelativeLayout
        relativeLayout.addView(button);
    }
}
