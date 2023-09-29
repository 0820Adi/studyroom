package com.example.studyroom.communication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import com.example.studyroom.communication.DiscussionPost;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.studyroom.Adapters.DiscussionBoardAdapter;
import com.example.studyroom.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import java.util.ArrayList;

public class DiscussionBoardActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private DiscussionBoardAdapter discussionAdapter;
    private ArrayList<DiscussionPost> discussionList;
    private FloatingActionButton fabCreatePost;
    private TextInputLayout textInputLayout;
    private TextInputEditText editTextPost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discussion_board);

        // Initialize views
        recyclerView = findViewById(R.id.recycler_view_discussion);
        fabCreatePost = findViewById(R.id.fab_create_post);
        textInputLayout = findViewById(R.id.text_input_layout);
        editTextPost = findViewById(R.id.edit_text_post);

        // Initialize the list of discussion posts (You can populate it as needed)
        discussionList = new ArrayList<>();
        discussionList.add(new DiscussionPost("User 1", "Lorem ipsum dolor sit amet, consectetur adipiscing elit."));
        discussionList.add(new DiscussionPost("User 2", "Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."));
        // Add more discussion posts as needed...

        // Initialize the discussion adapter
        discussionAdapter = new DiscussionBoardAdapter(this, discussionList);

        // Set up the RecyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(discussionAdapter);

        // Set an onClickListener for the floating action button to create new posts
        fabCreatePost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newPost = editTextPost.getText().toString().trim();

                if (!newPost.isEmpty()) {
                    // Add the new post to the list and notify the adapter
                    discussionList.add(new DiscussionPost("User X", newPost));
                    discussionAdapter.notifyItemInserted(discussionList.size() - 1);

                    // Clear the text input field
                    editTextPost.setText("");
                }
            }
        });
    }
}
