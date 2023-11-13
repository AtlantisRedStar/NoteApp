package com.example.myapplication;
import com.example.myapplication.NoteManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddNoteActivity extends AppCompatActivity {

    private NoteManager noteManager;
    private EditText editTextNoteName;
    private EditText editTextNoteContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        // Initialize NoteManager with the current context
        noteManager = NoteManager.getInstance(this);

        editTextNoteName = findViewById(R.id.editTextNoteName);
        editTextNoteContent = findViewById(R.id.editTextNoteContent);

        Button buttonSave = findViewById(R.id.buttonSave);
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveNote();
            }
        });
    }

    private void saveNote() {
        String noteName = editTextNoteName.getText().toString();
        String noteContent = editTextNoteContent.getText().toString();

        if (noteName.isEmpty() || noteContent.isEmpty()) {
            Toast.makeText(this, R.string.warning_empty_fields, Toast.LENGTH_SHORT).show();
        } else {
            // Save the note using NoteManager
            noteManager.saveNote(noteName, noteContent);

            // Display a success message
            Toast.makeText(this, "Note saved successfully", Toast.LENGTH_SHORT).show();

            // Finish the activity
            finish();
        }
    }
}