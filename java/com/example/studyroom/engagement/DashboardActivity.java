package com.example.studyroom.engagement;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

import com.example.studyroom.R;
import com.example.studyroom.materialmanagement.MaterialActivity;
import com.example.studyroom.sessionmanagement.DetailsActivity;
import com.example.studyroom.usermanagement.ProfileActivity;
import com.example.studyroom.groupmanagement.*;
import com.example.studyroom.communication.*;
import com.example.studyroom.materialmanagement.*;// Replace with the actual package name
public class DashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        // Initialize your CardViews
        androidx.cardview.widget.CardView profileCard = findViewById(R.id.card_profile);
        androidx.cardview.widget.CardView groupManagementCard = findViewById(R.id.card_group_management);
        androidx.cardview.widget.CardView communicationCard = findViewById(R.id.card_communication);
        androidx.cardview.widget.CardView materialCard = findViewById(R.id.card_material);
        androidx.cardview.widget.CardView progressCard = findViewById(R.id.card_progress);
        androidx.cardview.widget.CardView sessionDetailsCard = findViewById(R.id.card_session_details);

        // Set click listeners for each CardView
        profileCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle profile card click
                startActivity(new Intent(DashboardActivity.this, ProfileActivity.class));
            }
        });

        groupManagementCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Start the main activity of the "Group Management" package
                startActivity(new Intent(DashboardActivity.this, CreateActivity.class));
            }
        });

        communicationCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle communication card click
                startActivity(new Intent(DashboardActivity.this, PeerToPeerMessagingActivity.class));
            }
        });

        materialCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle material card click
                startActivity(new Intent(DashboardActivity.this, MaterialActivity.class));
            }
        });

        progressCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle progress card click
                startActivity(new Intent(DashboardActivity.this, NotificationActivity.class));
            }
        });

        sessionDetailsCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle session details card click
                startActivity(new Intent(DashboardActivity.this, DetailsActivity.class));
            }
        });
    }
}
