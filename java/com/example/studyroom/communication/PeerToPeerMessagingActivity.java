package com.example.studyroom.communication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.studyroom.Adapters.PeerToPeerAdapter;
import com.example.studyroom.Models.Message;
import com.example.studyroom.R;
import java.util.ArrayList;
import java.util.List;

public class PeerToPeerMessagingActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private PeerToPeerAdapter peerToPeerAdapter;
    private List<Message> messageList;
    private EditText editTextMessage;
    private Button buttonSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peer_messaging);

        // Initialize views
        recyclerView = findViewById(R.id.recycler_view_chat);
        editTextMessage = findViewById(R.id.edit_text_message);
        buttonSend = findViewById(R.id.button_send);

        // Initialize the list of messages (You can populate it as needed)
        messageList = new ArrayList<>();
        messageList.add(new Message("User 1", "Hello, how are you?"));
        messageList.add(new Message("User 2", "I'm good, thanks!"));
        // Add more messages as needed...

        // Initialize the peer-to-peer adapter
        peerToPeerAdapter = new PeerToPeerAdapter(this, messageList);

        // Set up the RecyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(peerToPeerAdapter);

        // Set an onClickListener for the send button
        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newMessage = editTextMessage.getText().toString().trim();

                if (!newMessage.isEmpty()) {
                    // Add the new message to the list and notify the adapter
                    messageList.add(new Message("User 1", newMessage));
                    peerToPeerAdapter.notifyItemInserted(messageList.size() - 1);

                    // Clear the message input field
                    editTextMessage.setText("");
                }
            }
        });
    }
}
