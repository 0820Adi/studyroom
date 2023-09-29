package com.example.studyroom.groupmanagement;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.studyroom.R;

public class GroupViewActivity extends AppCompatActivity {

    // Declare UI elements
    private TextView groupNameTextView;
    private TextView groupDescriptionTextView;
    private ImageView groupProfileImageView;
    private TextView groupMembersTextView;
    private ListView groupMembersListView;
    private TextView groupTagsTextView;
    private TextView groupTagsValueTextView;
    private TextView groupLocationTextView;
    private TextView groupLocationValueTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_view);

        // Initialize UI elements
        groupNameTextView = findViewById(R.id.text_view_group_name_value);
        groupDescriptionTextView = findViewById(R.id.text_view_group_description_value);
        groupProfileImageView = findViewById(R.id.image_view_group_profile);
        groupMembersTextView = findViewById(R.id.text_view_group_members);
        groupMembersListView = findViewById(R.id.list_view_group_members);
        groupTagsTextView = findViewById(R.id.text_view_group_tags);
        groupTagsValueTextView = findViewById(R.id.text_view_group_tags_value);
        groupLocationTextView = findViewById(R.id.text_view_group_location);
        groupLocationValueTextView = findViewById(R.id.text_view_group_location_value);

        // Retrieve data or information about the group and populate the UI elements
        // For example:
        String groupName = "Sample Group Name";
        String groupDescription = "Sample Group Description";
        // Load the group profile image, e.g., using a library like Picasso or Glide
        int groupProfileImageResource = R.drawable.baseline_group_24;
        String[] groupMembers = {"Member 1", "Member 2", "Member 3"};
        String groupTags = "Tag1, Tag2, Tag3";
        String groupLocation = "Sample Location";

        // Set data to UI elements
        groupNameTextView.setText(groupName);
        groupDescriptionTextView.setText(groupDescription);
        groupProfileImageView.setImageResource(groupProfileImageResource);
        groupMembersListView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, groupMembers));
        groupTagsValueTextView.setText(groupTags);
        groupLocationValueTextView.setText(groupLocation);
    }
}
