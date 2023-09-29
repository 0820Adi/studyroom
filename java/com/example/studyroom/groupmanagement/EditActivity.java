package com.example.studyroom.groupmanagement;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.studyroom.R;

public class EditActivity extends AppCompatActivity {

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
    private Button saveChangesButton;
    private Button deleteGroupButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        // Initialize views
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
        saveChangesButton = findViewById(R.id.btn_save_changes);
        deleteGroupButton = findViewById(R.id.btn_delete_group);

        // Set a default location (you should populate the spinner with actual locations)
        String[] locations = {"Location 1", "Location 2", "Location 3"};
        ArrayAdapter<String> locationAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, locations);
        locationAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        locationSpinner.setAdapter(locationAdapter);

        // Handle Upload Profile Picture button click
        uploadProfilePictureButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Implement logic to allow users to upload a profile picture
                Toast.makeText(EditActivity.this, "Upload Profile Picture Clicked", Toast.LENGTH_SHORT).show();
            }
        });

        // Handle Add Members button click
        addMembersButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Implement logic to add members to the group
                Toast.makeText(EditActivity.this, "Add Members Clicked", Toast.LENGTH_SHORT).show();
            }
        });

        // Handle Save Changes button click
        saveChangesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Implement logic to save changes made to the group
                String groupName = groupNameEditText.getText().toString();
                String groupDescription = groupDescriptionEditText.getText().toString();
                String selectedLocation = locationSpinner.getSelectedItem().toString();
                String privacyOption = getSelectedPrivacyOption();
                String groupRules = groupRulesEditText.getText().toString();
                String groupTags = groupTagsEditText.getText().toString();

                // You can use this data to update the group information in your database

                Toast.makeText(EditActivity.this, "Changes Saved", Toast.LENGTH_SHORT).show();
            }
        });

        // Handle Delete Group button click
        deleteGroupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Implement logic to delete the group
                Toast.makeText(EditActivity.this, "Group Deleted", Toast.LENGTH_SHORT).show();
            }
        });

        // Add more logic as needed for other views and buttons
    }

    // Helper method to get the selected privacy option
    private String getSelectedPrivacyOption() {
        int selectedRadioButtonId = privacyRadioGroup.getCheckedRadioButtonId();
        if (selectedRadioButtonId == publicRadioButton.getId()) {
            return "Public";
        } else if (selectedRadioButtonId == inviteOnlyRadioButton.getId()) {
            return "Invite-Only";
        } else if (selectedRadioButtonId == passwordProtectedRadioButton.getId()) {
            return "Password-Protected";
        } else {
            return "Unknown";
        }
    }
}
