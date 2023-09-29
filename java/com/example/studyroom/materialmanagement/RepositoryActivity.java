package com.example.studyroom.materialmanagement;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.studyroom.R;

public class RepositoryActivity extends AppCompatActivity {

    private TextView repoTitle;
    private TextView repoDescription;
    private Button repoStarButton;
    private Button repoForkButton;
    private TextView repoOwner;
    private TextView repoLanguage;
    private TextView repoStarsCount;
    private TextView repoForksCount;

    private boolean isStarred = false; // Track whether the repository is starred

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reppsitory);

        // Initialize UI elements
        repoTitle = findViewById(R.id.repoTitle);
        repoDescription = findViewById(R.id.repoDescription);
        repoStarButton = findViewById(R.id.repoStarButton);
        repoForkButton = findViewById(R.id.repoForkButton);
        repoOwner = findViewById(R.id.repoOwner);
        repoLanguage = findViewById(R.id.repoLanguage);
        repoStarsCount = findViewById(R.id.repoStarsCount);
        repoForksCount = findViewById(R.id.repoForksCount);

        // Set click listeners for buttons
        repoStarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Toggle the "Star" status and update the button text accordingly
                isStarred = !isStarred;
                if (isStarred) {
                    repoStarButton.setText("Unstar");
                    // Implement logic to star the repository in your backend or API
                } else {
                    repoStarButton.setText("Star");
                    // Implement logic to unstar the repository in your backend or API
                }
            }
        });

        repoForkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Implement logic to fork the repository in your backend or API
                Toast.makeText(RepositoryActivity.this, "Repository Forked", Toast.LENGTH_SHORT).show();
            }
        });

        // Populate the TextViews with data (you can replace with dynamic data)
        repoTitle.setText("Repository Name");
        repoDescription.setText("Description of the repository.");
        repoOwner.setText("Owner:  Aditya");
        repoLanguage.setText("Language: Java");
        repoStarsCount.setText("Stars: 1000");
        repoForksCount.setText("Forks: 500");
    }
}
