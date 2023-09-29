package com.example.studyroom.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.studyroom.R;

import java.util.List;

public class GroupAdapter extends ArrayAdapter<String> {

    private List<String> groupList;

    public GroupAdapter(Context context, List<String> groupList) {
        super(context, 0, groupList);
        this.groupList = groupList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        String currentGroup = groupList.get(position);

        TextView groupNameTextView = listItemView.findViewById(R.id.text_view_group_name);
        groupNameTextView.setText(currentGroup);

        return listItemView;
    }
}
