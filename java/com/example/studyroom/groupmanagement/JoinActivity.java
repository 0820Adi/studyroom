package com.example.studyroom.groupmanagement;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

import com.example.studyroom.R;

public class JoinActivity extends AppCompatActivity {

    private EditText groupCodeEditText;
    private Button joinGroupButton;
    private Button createGroupButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);

        groupCodeEditText = findViewById(R.id.edit_text_group_code);
        joinGroupButton = findViewById(R.id.btn_join_group);
        createGroupButton = findViewById(R.id.btn_create_group);

        joinGroupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the group code entered by the user
                String groupCode = groupCodeEditText.getText().toString();

                // TODO: Validate the group code (e.g., make a network request)

                // For demonstration, assume the group code is valid
                boolean isValidCode = true;

                if (isValidCode) {
                    // If the code is valid, navigate to the GroupViewActivity
                    Intent intent = new Intent(JoinActivity.this, GroupViewActivity.class);
                    // Pass any necessary data, such as group information
                    intent.putExtra("groupCode", groupCode);
                    startActivity(intent);
                } else {
                    // Display an error message to the user indicating that the code is invalid
                    groupCodeEditText.setError("Invalid group code");
                }
            }
        });

        createGroupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle creating a new group here, e.g., navigate to a CreateGroupActivity
                Intent intent = new Intent(JoinActivity.this, CreateActivity.class);
                startActivity(intent);
            }
        });
    }
}
