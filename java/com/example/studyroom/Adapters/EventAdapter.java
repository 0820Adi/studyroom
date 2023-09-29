package com.example.studyroom.Adapters;




import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.studyroom.R;
import com.example.studyroom.Models.Event;
import java.util.List;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.EventViewHolder> {

    private List<Event> events;

    public EventAdapter(List<Event> events) {
        this.events = events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public EventViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_event, parent, false);
        return new EventViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EventViewHolder holder, int position) {
        Event event = events.get(position);

        holder.eventNameTextView.setText(event.getName());
        holder.eventTimeTextView.setText(event.getTime());
        holder.eventLocationTextView.setText(event.getLocation());
        holder.eventCategoryTextView.setText(event.getCategory());
    }

    @Override
    public int getItemCount() {
        return events.size();
    }

    public static class EventViewHolder extends RecyclerView.ViewHolder {
        public TextView eventNameTextView;
        public TextView eventTimeTextView;
        public TextView eventLocationTextView;
        public TextView eventCategoryTextView;

        public EventViewHolder(@NonNull View itemView) {
            super(itemView);
            eventNameTextView = itemView.findViewById(R.id.text_view_event_name);
            eventTimeTextView = itemView.findViewById(R.id.text_view_event_time);
            eventLocationTextView = itemView.findViewById(R.id.text_view_event_location);
            eventCategoryTextView = itemView.findViewById(R.id.text_view_event_category);
        }
    }
}
