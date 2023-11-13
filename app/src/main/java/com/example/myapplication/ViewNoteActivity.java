package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ViewNoteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_note);

        // Retrieve the selected note's name and content from the intent
        Intent intent = getIntent();
        if (intent != null) {
            String noteName = intent.getStringExtra("NOTE_NAME");
            String noteContent = intent.getStringExtra("NOTE_CONTENT");

            // Display the note details in TextViews
            TextView textViewNoteName = findViewById(R.id.textViewNoteName);
            TextView textViewNoteContent = findViewById(R.id.textViewNoteContent);

            textViewNoteName.setText(noteName);
            textViewNoteContent.setText(noteContent);
        }
    }
}