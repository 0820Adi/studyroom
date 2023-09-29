package com.example.studyroom.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.studyroom.Models.Message;
import com.example.studyroom.R;
import java.util.List;

public class PeerToPeerAdapter extends RecyclerView.Adapter<PeerToPeerAdapter.ViewHolder> {

    private Context context;
    private List<Message> messageList;

    public PeerToPeerAdapter(Context context, List<Message> messageList) {
        this.context = context;
        this.messageList = messageList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_peer_to_peer_message, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Message message = messageList.get(position);

        holder.usernameTextView.setText(message.getUsername());
        holder.messageTextView.setText(message.getMessage());
    }

    @Override
    public int getItemCount() {
        return messageList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView usernameTextView;
        public TextView messageTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            usernameTextView = itemView.findViewById(R.id.text_view_username);
            messageTextView = itemView.findViewById(R.id.text_view_message_content);
        }
    }
}
