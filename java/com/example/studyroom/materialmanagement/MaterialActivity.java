package com.example.studyroom.materialmanagement;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.studyroom.R;
import com.google.android.material.textfield.TextInputLayout;

public class MaterialActivity extends AppCompatActivity {

    private TextView materialTitle;
    private Button materialButton;
    private TextView materialDescription;
    private TextInputLayout materialInputLayout;
    private EditText materialEditText;
    private Button materialSubmitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material);

        // Initialize UI elements
        materialTitle = findViewById(R.id.material_title);
        materialButton = findViewById(R.id.material_button);
        materialDescription = findViewById(R.id.material_description);
        materialInputLayout = findViewById(R.id.material_input_layout);
        materialEditText = findViewById(R.id.material_edit_text);
        materialSubmitButton = findViewById(R.id.material_submit_button);

        // Button click listener
        materialButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle button click here
                materialDescription.setText("Button Clicked!");
            }
        });

        // Submit button click listener
        materialSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle submit button click here
                String userInput = materialEditText.getText().toString().trim();
                if (!userInput.isEmpty()) {
                    materialDescription.setText("User Input: " + userInput);
                } else {
                    materialInputLayout.setError("Please enter something");
                }
            }
        });
    }
}
