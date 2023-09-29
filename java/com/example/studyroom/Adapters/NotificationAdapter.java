package com.example.studyroom.Adapters;

import com.example.studyroom.engagement.NotificationActivity;

import android.app.Notification;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.studyroom.R;

import java.util.List;

public class NotificationAdapter extends BaseAdapter {
    private Context context;
    private List<Notification> notificationList;

    public NotificationAdapter(Context context, List<Notification> notificationList) {
        this.context = context;
        this.notificationList = notificationList;
    }

    @Override
    public int getCount() {
        return notificationList.size();
    }

    @Override
    public Object getItem(int position) {
        return notificationList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item_notification, parent, false);
        }

        TextView titleTextView = convertView.findViewById(R.id.text_view_notification_title);
        TextView messageTextView = convertView.findViewById(R.id.text_view_notification_message);

        Notification notification = notificationList.get(position);

        titleTextView.setText(notification.getGroup());
        messageTextView.setText(notification.getGroup());

        return convertView;
    }
}
