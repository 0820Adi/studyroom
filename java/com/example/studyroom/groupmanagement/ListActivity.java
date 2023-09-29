package com.example.studyroom.groupmanagement;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.studyroom.Adapters.GroupAdapter;
import com.example.studyroom.R;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    private ListView listViewGroups;
    private Button createGroupButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        listViewGroups = findViewById(R.id.list_view_groups);
        createGroupButton = findViewById(R.id.btn_create_group);

        // Simulated list of groups
        List<String> groupList = new ArrayList<>();
        groupList.add("Group 1");
        groupList.add("Group 2");
        groupList.add("Group 3");

        // Create an ArrayAdapter to populate the ListView
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, groupList);
        listViewGroups.setAdapter(adapter);

        // Set an item click listener for the ListView (you can handle group selection here)
        listViewGroups.setOnItemClickListener((parent, view, position, id) -> {
            String selectedGroup = groupList.get(position);
            // TODO: Handle group selection (e.g., navigate to the GroupViewActivity)
        });

        createGroupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle creating a new group here, e.g., navigate to a CreateGroupActivity
                Intent intent = new Intent(ListActivity.this, CreateActivity.class);
                startActivity(intent);
            }
        });
    }
}
