package com.example.simplenotes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import java.util.HashSet;

public class NoteEditorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_editor);

        EditText updateEditText = (EditText) findViewById(R.id.updateEditText);

        Intent intent = getIntent();
        final int noteId = intent.getIntExtra( "noteId",-1);

        if (noteId != -1) {
            updateEditText.setText(MainActivity.list.get(noteId));
        }

        updateEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                MainActivity.list.set(noteId, String.valueOf(charSequence));
                MainActivity.arrayAdapter.notifyDataSetChanged();

                //SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("com.example.simplenotes", Context.MODE_PRIVATE);
                //HashSet<String> set = new HashSet(MainActivity.list);
                //sharedPreferences.edit().putStringSet("list", set).apply();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
}
