package com.example.todoapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView listOfTask;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listOfTask = findViewById(R.id.lv_task);
        adapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1);
        listOfTask.setAdapter(adapter);

        listOfTask.setOnItemLongClickListener(
            new AdapterView.OnItemLongClickListener() {
                @Override
                public boolean onItemLongClick(AdapterView<?> adapterView,
                                               View view,
                                               int i,
                                               long l) {
                    adapter.remove(adapter.getItem(i));
                    return true;
                }
            }
        );
    }

    public void createNewTask(View view) {
        /* Option 2
        Intent createTask = new Intent(this.CreateT...
         */
        Intent createTask = new Intent();
        // Define destination activity for intent!
        createTask.setClass(this, CreateTask.class);
        startActivityForResult(createTask, 3237);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 3237 &&
                resultCode == RESULT_OK &&
                data != null) { // Kotlin does not require null check
            String temp = data.getStringExtra("INPUT_DATA");
            adapter.add(temp);
        }
    }
}