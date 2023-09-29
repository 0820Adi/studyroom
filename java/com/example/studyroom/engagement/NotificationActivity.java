package com.example.studyroom.engagement;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.studyroom.R;

public class NotificationActivity extends Activity {

    private TextView notificationTitleTextView;
    private TextView notificationMessageTextView;
    private Button closeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        // Initialize views
        notificationTitleTextView = findViewById(R.id.text_view_notification_title);
        notificationMessageTextView = findViewById(R.id.text_view_notification_message);
        closeButton = findViewById(R.id.btn_close_notification);

        // Get notification data from intent or other source and set it to the views
        String notificationTitle = getIntent().getStringExtra("notificationTitle");
        String notificationMessage = getIntent().getStringExtra("notificationMessage");

        notificationTitleTextView.setText(notificationTitle);
        notificationMessageTextView.setText(notificationMessage);

        // Set click listener for the close button
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Close the notification activity
                finish();
            }
        });
    }
}
