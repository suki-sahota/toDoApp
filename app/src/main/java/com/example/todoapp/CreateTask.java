package com.example.todoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreateTask extends AppCompatActivity {

    EditText inputTask;
    Button btnSaveTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_task);
        inputTask = findViewById(R.id.et_input_task);
        btnSaveTask = findViewById(R.id.btn_save_task);

        btnSaveTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String temp = inputTask.getText().toString();
                if (!temp.isEmpty()) {
                    inputTask.setText(""); // Clear text from input field
                    Intent intentTask = new Intent(); // Create intent
                    intentTask.putExtra("INPUT_DATA", temp); // Pass data to the intent
                    setResult(RESULT_OK, intentTask); // Set result code and intent
                    finish(); // Transfer intentTask back to predefined target class .MainActivity
                } else {
                    Toast.makeText(CreateTask.this,
                            "Type something please!",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}