package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class DeleteNoteActivity extends AppCompatActivity {

    private NoteManager noteManager;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> notes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_note);

        // Initialize NoteManager with the current context
        noteManager = NoteManager.getInstance(this);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_single_choice, notes);

        ListView listView = findViewById(R.id.listViewDelete);
        listView.setAdapter(adapter);
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        // Refresh the list initially
        refreshNoteList();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Handle item click, e.g., delete the selected note
                String selectedNoteName = notes.get(position);
                noteManager.deleteNote(selectedNoteName);

                // Refresh the list
                refreshNoteList();
            }
        });
    }

    // Method to refresh the note list
    private void refreshNoteList() {
        notes.clear();
        notes.addAll(noteManager.getNoteNames());
        adapter.notifyDataSetChanged();
    }
}