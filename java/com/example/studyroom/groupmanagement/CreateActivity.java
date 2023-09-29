package com.example.studyroom.groupmanagement;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.studyroom.R;

public class CreateActivity extends AppCompatActivity {

    private EditText groupNameEditText;
    private EditText groupDescriptionEditText;
    private ImageView groupProfileImageView;
    private Button uploadProfilePictureButton;
    private Button addMembersButton;
    private EditText tagsEditText;
    private Spinner locationSpinner;
    private RadioGroup privacyRadioGroup;
    private RadioButton publicRadioButton;
    private RadioButton inviteOnlyRadioButton;
    private RadioButton passwordProtectedRadioButton;
    private EditText groupRulesEditText;
    private EditText groupTagsEditText;
    private Button customThemesButton;
    private Button createGroupButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        groupNameEditText = findViewById(R.id.edit_text_group_name);
        groupDescriptionEditText = findViewById(R.id.edit_text_group_description);
        groupProfileImageView = findViewById(R.id.image_view_group_profile);
        uploadProfilePictureButton = findViewById(R.id.btn_upload_profile_picture);
        addMembersButton = findViewById(R.id.btn_add_members);
        tagsEditText = findViewById(R.id.edit_text_tags);
        locationSpinner = findViewById(R.id.spinner_location);
        privacyRadioGroup = findViewById(R.id.radio_group_privacy);
        publicRadioButton = findViewById(R.id.radio_public);
        inviteOnlyRadioButton = findViewById(R.id.radio_invite_only);
        passwordProtectedRadioButton = findViewById(R.id.radio_password_protected);
        groupRulesEditText = findViewById(R.id.edit_text_group_rules);
        groupTagsEditText = findViewById(R.id.edit_text_group_tags);
        customThemesButton = findViewById(R.id.btn_custom_themes);
        createGroupButton = findViewById(R.id.btn_create_group);

        // Handle upload profile picture button click
        uploadProfilePictureButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Implement logic to upload a group profile picture
                Toast.makeText(CreateActivity.this, "Profile picture uploaded.", Toast.LENGTH_SHORT).show();
            }
        });

        // Handle add members button click
        addMembersButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Implement logic to add members to the group
                Toast.makeText(CreateActivity.this, "Members added to the group.", Toast.LENGTH_SHORT).show();
            }
        });

        // Handle custom themes button click
        customThemesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Implement logic to customize group themes
                Toast.makeText(CreateActivity.this, "Custom themes applied.", Toast.LENGTH_SHORT).show();
            }
        });

        // Handle create group button click
        createGroupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Implement logic to create the group
                String groupName = groupNameEditText.getText().toString();
                String groupDescription = groupDescriptionEditText.getText().toString();
                String selectedLocation = locationSpinner.getSelectedItem().toString();
                int selectedPrivacyId = privacyRadioGroup.getCheckedRadioButtonId();
                String groupPrivacy = "";

                if (selectedPrivacyId == publicRadioButton.getId()) {
                    groupPrivacy = "Public";
                } else if (selectedPrivacyId == inviteOnlyRadioButton.getId()) {
                    groupPrivacy = "Invite-Only";
                } else if (selectedPrivacyId == passwordProtectedRadioButton.getId()) {
                    groupPrivacy = "Password-Protected";
                }

                // You can access other EditText values and handle them as needed

                // Display a toast message with group information
                String message = "Group Name: " + groupName + "\n" +
                        "Group Description: " + groupDescription + "\n" +
                        "Location: " + selectedLocation + "\n" +
                        "Privacy: " + groupPrivacy;

                Toast.makeText(CreateActivity.this, message, Toast.LENGTH_LONG).show();
            }
        });

        // Populate the location spinner with sample data
        ArrayAdapter<CharSequence> locationAdapter = ArrayAdapter.createFromResource(
                this, R.array.locations, android.R.layout.simple_spinner_item);
        locationAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        locationSpinner.setAdapter(locationAdapter);

        // Handle location spinner item selection
        locationSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                String selectedLocation = adapterView.getItemAtPosition(position).toString();
                // You can perform actions based on the selected location
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                // Handle the case when nothing is selected
            }
        });
    }
}
