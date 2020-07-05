package com.example.todoapp;

import androidx.appcompat.app.AppCompatActivity;

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

    EditText inputTask;
    Button saveButton;
    ListView listOfTask;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputTask = findViewById(R.id.input_task);
        saveButton = findViewById(R.id.btn_save);
        listOfTask = findViewById(R.id.lv_task);

        saveButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String temp = inputTask.getText().toString();
                        Log.d(null, temp);
                        if (!temp.isEmpty()) {
                            adapter.add(temp);
                            //adapter.notifyDataSetChanged();
                        } else {
                            Toast.makeText(MainActivity.this,
                                    "Please type something!",
                                    Toast.LENGTH_LONG).show();
                        }
                    }
                }
        );
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
}