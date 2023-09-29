package com.example.studyroom.materialmanagement;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.studyroom.R;

public class UploadActivity extends AppCompatActivity {

    // Constants
    private static final int FILE_PICKER_REQUEST_CODE = 123;

    // UI elements
    private Button selectFileButton;
    private TextView selectedFileTextView;
    private EditText fileDescriptionEditText;
    private ProgressBar uploadProgressBar;
    private TextView uploadStatusTextView;
    private Button uploadButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload);

        // Initialize UI elements
        selectFileButton = findViewById(R.id.btn_select_file);
        selectedFileTextView = findViewById(R.id.text_view_selected_file);
        fileDescriptionEditText = findViewById(R.id.edit_text_description);
        uploadProgressBar = findViewById(R.id.progress_bar_upload);
        uploadStatusTextView = findViewById(R.id.text_view_upload_status);
        uploadButton = findViewById(R.id.btn_upload);

        // Set up click listeners
        selectFileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Open a file picker dialog
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("*/*"); // Allow all file types
                startActivityForResult(intent, FILE_PICKER_REQUEST_CODE);
            }
        });

        uploadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle real file upload logic here
                String fileDescription = fileDescriptionEditText.getText().toString();
                String selectedFilePath = selectedFileTextView.getText().toString();

                // Implement file upload and progress update logic here
                uploadFile(selectedFilePath, fileDescription);
            }
        });
    }

    // Handle the result of the file picker dialog
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == FILE_PICKER_REQUEST_CODE && resultCode == RESULT_OK) {
            if (data != null && data.getData() != null) {
                // Handle the selected file here
                Uri selectedFileUri = data.getData();
                String selectedFilePath = selectedFileUri.getPath();
                selectedFileTextView.setText(selectedFilePath);
            }
        }
    }

    // Handle file upload progress updates (replace this with your actual progress update code)
    private void handleUploadProgress(int progress) {
        uploadProgressBar.setProgress(progress);
        uploadStatusTextView.setText("Uploading: " + progress + "%");
    }

    // Handle file upload success
    private void handleUploadSuccess() {
        uploadProgressBar.setVisibility(View.GONE);
        uploadStatusTextView.setText("Upload completed");

        // Optionally, save upload details to a database
        saveUploadDetailsToDatabase();

        // Display a success toast message
        Toast.makeText(UploadActivity.this, "File uploaded successfully", Toast.LENGTH_SHORT).show();
    }

    // Handle file upload failure
    private void handleUploadFailure(String errorMessage) {
        uploadProgressBar.setVisibility(View.GONE);
        uploadStatusTextView.setText("Upload failed");

        // Display an error toast message
        Toast.makeText(UploadActivity.this, "File upload failed: " + errorMessage, Toast.LENGTH_SHORT).show();
    }

    // Simulate file upload and progress updates (replace with your actual upload logic)
    private void uploadFile(String filePath, String description) {
        // Simulated upload progress
        for (int progress = 0; progress <= 100; progress += 10) {
            final int finalProgress = progress;
            new android.os.Handler().postDelayed(new Runnable() {
                public void run() {
                    handleUploadProgress(finalProgress);
                    if (finalProgress == 100) {
                        handleUploadSuccess();
                    }
                }
            }, progress * 100); // Delay for demonstration
        }
    }

    // Save upload details to a database (replace this with your actual database code)
    private void saveUploadDetailsToDatabase() {
        // Implement database integration here
    }
}
