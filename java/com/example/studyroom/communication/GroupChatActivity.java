package com.example.studyroom.communication;



import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import com.example.studyroom.Adapters.GroupChatAdapter;
import com.example.studyroom.Adapters.GroupChatAdapter;
import com.example.studyroom.Models.Message;
import com.example.studyroom.R;
import java.util.ArrayList;
import java.util.List;

public class GroupChatActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private GroupChatAdapter groupChatAdapter;
    private List<Message> messageList;
    private EditText editTextMessage;
    private ImageButton sendButton;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        // Initialize views
        recyclerView = findViewById(R.id.recycler_view_chat);
        editTextMessage = findViewById(R.id.edit_text_message);
        sendButton = findViewById(R.id.button_send);

        // Initialize the list of messages (You can populate it as needed)
        messageList = new ArrayList<>();
        messageList.add(new Message("User 1", "Hello, everyone!"));
        messageList.add(new Message("User 2", "Hi there!"));
        // Add more messages as needed...

        // Initialize the group chat adapter
        groupChatAdapter = new GroupChatAdapter(this, messageList);

        // Set up the RecyclerView
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setStackFromEnd(true); // Scrolls to the bottom for new messages
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(groupChatAdapter);

        // Set an onClickListener for the send button to send new messages
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newMessageText = editTextMessage.getText().toString().trim();

                if (!newMessageText.isEmpty()) {
                    // Add the new message to the list and notify the adapter
                    messageList.add(new Message("User X", newMessageText));
                    groupChatAdapter.notifyItemInserted(messageList.size() - 1);

                    // Clear the message input field
                    editTextMessage.setText("");

                    // Optionally, you can scroll to the new message
                    recyclerView.smoothScrollToPosition(messageList.size() - 1);
                }
            }
        });
    }
}
