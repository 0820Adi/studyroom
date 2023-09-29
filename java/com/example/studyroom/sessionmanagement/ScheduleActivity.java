package com.example.studyroom.sessionmanagement;

import com.example.studyroom.Models.Event;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.studyroom.Adapters.EventAdapter;
import com.example.studyroom.Adapters.TimeSlotAdapter;
import com.example.studyroom.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class ScheduleActivity extends AppCompatActivity {

    private DatePicker datePicker;
    private RecyclerView recyclerViewTimeSlots;
    private RecyclerView recyclerViewEvents;
    private Button btnCreateEvent;
    private EditText editTextSearch;
    private Spinner spinnerEventFilter;
    private TextView textViewEventDetails;

    private List<String> timeSlots = new ArrayList<>();
    private List<Event> events = new ArrayList<>();
    private EventAdapter eventAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);

        datePicker = findViewById(R.id.datePicker);
        recyclerViewTimeSlots = findViewById(R.id.recycler_view_time_slots);
        recyclerViewEvents = findViewById(R.id.recycler_view_events);
        btnCreateEvent = findViewById(R.id.btn_create_event);
        editTextSearch = findViewById(R.id.edit_text_search);
        spinnerEventFilter = findViewById(R.id.spinner_event_filter);
        textViewEventDetails = findViewById(R.id.text_view_event_details);

        initializeTimeSlots();
        initializeEvents();

        LinearLayoutManager layoutManagerTimeSlots = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewTimeSlots.setLayoutManager(layoutManagerTimeSlots);
        TimeSlotAdapter timeSlotAdapter = new TimeSlotAdapter(timeSlots);
        recyclerViewTimeSlots.setAdapter(timeSlotAdapter);

        LinearLayoutManager layoutManagerEvents = new LinearLayoutManager(this);
        recyclerViewEvents.setLayoutManager(layoutManagerEvents);
        eventAdapter = new EventAdapter(events);
        recyclerViewEvents.setAdapter(eventAdapter);

        btnCreateEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle event creation, e.g., navigate to a create event activity
            }
        });

        editTextSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // Handle search logic
                filterEvents(charSequence.toString());
            }



            @Override
            public void afterTextChanged(Editable editable) {}
        });

        ArrayAdapter<CharSequence> filterAdapter = ArrayAdapter.createFromResource(
                this, R.array.event_filters, android.R.layout.simple_spinner_item);
        filterAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerEventFilter.setAdapter(filterAdapter);

        spinnerEventFilter.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                // Handle filtering logic
                filterEventsByCategory(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });

        // Initialize the date picker with the current date
        Calendar calendar = Calendar.getInstance();
        datePicker.init(
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH),
                new DatePicker.OnDateChangedListener() {
                    @Override
                    public void onDateChanged(DatePicker datePicker, int year, int month, int day) {
                        // Handle date selection logic
                        updateEventsForSelectedDate(year, month, day);
                    }
                });
    }

    private void initializeTimeSlots() {
        // Populate time slots (replace with your own data source or logic)
        timeSlots.add("8:00 AM - 9:00 AM");
        timeSlots.add("9:00 AM - 10:00 AM");
        timeSlots.add("10:00 AM - 11:00 AM");
        // Add more time slots as needed
    }

    private void initializeEvents() {
        // Populate events (replace with your own data source or logic)
        events.add(new Event("Meeting 1", "8:00 AM - 9:00 AM", "Location A", "Category A"));
        events.add(new Event("Workshop 1", "9:00 AM - 10:00 AM", "Location B", "Category B"));
        events.add(new Event("Seminar 1", "10:00 AM - 11:00 AM", "Location C", "Category A"));
        // Add more events as needed
    }

    private void filterEvents(String query) {
        // Filter events based on the search query (replace with your own logic)
        List<Event> filteredEvents = new ArrayList<>();
        for (Event event : events) {
            if (event.getName().toLowerCase(Locale.getDefault()).contains(query.toLowerCase(Locale.getDefault()))) {
                filteredEvents.add(event);
            }
        }
        eventAdapter.setEvents(filteredEvents);
    }

    private void filterEventsByCategory(int position) {
        // Filter events by category based on the selected spinner item (replace with your own logic)
        if (position == 0) {
            eventAdapter.setEvents(events); // Show all events
        } else {
            String selectedCategory = getResources().getStringArray(R.array.event_filters)[position];
            List<Event> filteredEvents = new ArrayList<>();
            for (Event event : events) {
                if (event.getCategory().equalsIgnoreCase(selectedCategory)) {
                    filteredEvents.add(event);
                }
            }
            eventAdapter.setEvents(filteredEvents);
        }
    }

    private void updateEventsForSelectedDate(int year, int month, int day) {
        // Update events based on the selected date
        Calendar selectedDate = Calendar.getInstance();
        selectedDate.set(year, month, day);
        Date selectedDateObj = selectedDate.getTime();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        String selectedDateString = dateFormat.format(selectedDateObj);

        List<Event> filteredEvents = new ArrayList<>();
        for (Event event : events) {
            String eventDateString = dateFormat.format(event.getDate());
            if (eventDateString.equals(selectedDateString)) {
                filteredEvents.add(event);
            }
        }
        eventAdapter.setEvents(filteredEvents);
    }

}
