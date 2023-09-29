package com.example.studyroom.sessionmanagement;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.studyroom.R;

public class DetailsActivity extends AppCompatActivity {

    private TextView eventNameTextView;
    private TextView eventDateTimeTextView;
    private TextView eventLocationTextView;
    private TextView eventCategoryTextView;
    private TextView eventDescriptionTextView;
    private TextView eventOrganizerTextView;
    private Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        // Initialize views
        eventNameTextView = findViewById(R.id.text_view_event_name);
        eventDateTimeTextView = findViewById(R.id.text_view_event_datetime);
        eventLocationTextView = findViewById(R.id.text_view_event_location);
        eventCategoryTextView = findViewById(R.id.text_view_event_category);
        eventDescriptionTextView = findViewById(R.id.text_view_event_description);
        eventOrganizerTextView = findViewById(R.id.text_view_event_organizer);
        backButton = findViewById(R.id.btn_back);

        // Retrieve event details from intent
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String eventName = extras.getString("eventName", "");
            String eventDateTime = extras.getString("eventDateTime", "");
            String eventLocation = extras.getString("eventLocation", "");
            String eventCategory = extras.getString("eventCategory", "");
            String eventDescription = extras.getString("eventDescription", "");
            String eventOrganizer = extras.getString("eventOrganizer", "");

            // Set event details in TextViews
            eventNameTextView.setText(eventName);
            eventDateTimeTextView.setText("Date and Time: " + eventDateTime);
            eventLocationTextView.setText("Location: " + eventLocation);
            eventCategoryTextView.setText("Category: " + eventCategory);
            eventDescriptionTextView.setText(eventDescription);
            eventOrganizerTextView.setText("Organizer: " + eventOrganizer);
        }

        // Set click listener for the back button
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle back button click (e.g., return to the previous activity)
                finish();
            }
        });
    }
}
