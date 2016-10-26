package com.example.suncica.todo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    public Button addNewTask;
    public static ListAdapter adapter;
    public static ListView list;
    static public TaskDataBase dataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addNewTask = (Button) findViewById(R.id.button);
        addNewTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this,
                        AddTaskActivity.class);
                startActivity(myIntent);
            }
        });

        list = (ListView) findViewById(R.id.list);
        adapter = new ListAdapter(this);
        dataBase = new TaskDataBase(this);

        list.setOnItemClickListener(this);

        Element[] elements = dataBase.readAllTasks();
        adapter.update(elements);
        list.setAdapter(adapter);

    }

    @Override
    protected void onResume() {
        super.onResume();
        Element[] elements = dataBase.readAllTasks();
        if(elements != null) {
            for (int i = 0; i < elements.length; i++) {
                Log.i("TAG:", elements[i].getToDoTask());
                Log.i("TAG:", elements[i].getTaskDescription());
                Log.i("TAG:", String.valueOf(elements[i].getTaskDone()));
                Log.i("TAG:", elements[i].getColor());
            }
        }
        adapter.update(elements);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Element element = (Element) adapter.getItem(position);
        String taskNameStr = element.getToDoTask();
        String taskDescrStr = element.getTaskDescription();
        String color = element.getColor();
        Intent myIntent = new Intent(MainActivity.this,
                TaskDetails.class);
        Bundle extras = new Bundle();
        extras.putString("task name",taskNameStr);
        extras.putString("task description",taskDescrStr);
        Element element1 = dataBase.readElement(taskNameStr);
        Boolean isDone = element1.getTaskDone();
        extras.putBoolean("is done",isDone);
        extras.putString("color",color);
        myIntent.putExtras(extras);
        startActivity(myIntent);
    }
}
