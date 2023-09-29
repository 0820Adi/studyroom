package com.example.studyroom.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.studyroom.R;
import com.example.studyroom.communication.DiscussionBoardActivity;
import com.example.studyroom.communication.DiscussionPost;

import java.util.ArrayList;
import java.util.List;

public class DiscussionBoardAdapter extends RecyclerView.Adapter<DiscussionBoardAdapter.ViewHolder> {

    private List<String> topicList;
    private Context context;
    private OnItemClickListener clickListener;

    public DiscussionBoardAdapter(DiscussionBoardActivity discussionBoardActivity, ArrayList<DiscussionPost> discussionList) {
    }


    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public DiscussionBoardAdapter(List<String> topicList, Context context, OnItemClickListener clickListener) {
        this.topicList = topicList;
        this.context = context;
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_discussion_topic, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String topic = topicList.get(position);
        holder.topicTitleTextView.setText(topic);
    }

    @Override
    public int getItemCount() {
        return topicList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView topicTitleTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            topicTitleTextView = itemView.findViewById(R.id.text_view_topic_title);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (clickListener != null) {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    clickListener.onItemClick(position);
                }
            }
        }
    }
}
