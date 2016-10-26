package com.example.suncica.todo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddTaskActivity extends AppCompatActivity implements View.OnClickListener {

    public Button sumbitButton, yellowButton, redButton, greenButton, blueButton, darkButton, pinkButton;
    public EditText taskTittleEditText, descriptionEditText;
    public boolean color = true;
    public String lastButton = "none";
    public String boxColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);


        taskTittleEditText = (EditText) findViewById(R.id.taskTitleEditText);
        descriptionEditText = (EditText) findViewById(R.id.descriptionEditText);

        sumbitButton = (Button) findViewById(R.id.submitTaskButton);

        sumbitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String taskName = taskTittleEditText.getText().toString();
                String description = descriptionEditText.getText().toString();

                boxColor = lastButton;

                Element element = new Element(taskName, description, false, boxColor);
                MainActivity.dataBase.insert(element);
                Intent myIntent = new Intent(AddTaskActivity.this,
                        MainActivity.class);
                startActivity(myIntent);
            }
        });

        /*color buttons*/
        yellowButton = (Button) findViewById(R.id.yellowButton);
        redButton = (Button) findViewById(R.id.redButton);
        greenButton = (Button) findViewById(R.id.greenButton);
        blueButton = (Button) findViewById(R.id.blueButton);
        darkButton = (Button) findViewById(R.id.darkBlueButton);
        pinkButton = (Button) findViewById(R.id.pinkButton);

        yellowButton.setOnClickListener(this);
        redButton.setOnClickListener(this);
        greenButton.setOnClickListener(this);
        blueButton.setOnClickListener(this);
        darkButton.setOnClickListener(this);
        pinkButton.setOnClickListener(this);
    }

    public void disableAll() {
        yellowButton.setAlpha(1);
        redButton.setAlpha(1);
        greenButton.setAlpha(1);
        blueButton.setAlpha(1);
        darkButton.setAlpha(1);
        pinkButton.setAlpha(1);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.yellowButton:
                if (color) {
                    disableAll();
                    yellowButton.setAlpha(.4f);
                    color = false;
                    lastButton = "yellow";
                } else {
                    if (lastButton == "yellow") {
                        color = true;
                        yellowButton.setAlpha(1);
                        lastButton = "none";
                    } else {
                        disableAll();
                        color = false;
                        yellowButton.setAlpha(.4f);
                        lastButton = "yellow";
                    }
                }
                break;

            case R.id.redButton:
                if (color) {
                    disableAll();
                    redButton.setAlpha(.4f);
                    color = false;
                    lastButton = "red";
                } else {
                    if (lastButton == "red") {
                        color = true;
                        redButton.setAlpha(1);
                        lastButton = "none";
                    } else {
                        disableAll();
                        color = false;
                        redButton.setAlpha(.4f);
                        lastButton = "red";
                    }
                }
                break;

            case R.id.greenButton:
                if (color) {
                    disableAll();
                    greenButton.setAlpha(.4f);
                    color = false;
                    lastButton = "green";
                } else {
                    if (lastButton == "green") {
                        color = true;
                        greenButton.setAlpha(1);
                        lastButton = "none";
                    } else {
                        disableAll();
                        color = false;
                        greenButton.setAlpha(.4f);
                        lastButton = "green";
                    }
                }
                break;
            case R.id.blueButton:
                if (color) {
                    disableAll();
                    blueButton.setAlpha(.4f);
                    color = false;
                    lastButton = "blue";
                } else {
                    if (lastButton == "blue") {
                        color = true;
                        blueButton.setAlpha(1);
                        lastButton = "none";
                    } else {
                        disableAll();
                        color = false;
                        blueButton.setAlpha(.4f);
                        lastButton = "blue";
                    }
                }
                break;

            case R.id.darkBlueButton:
                if (color) {
                    disableAll();
                    darkButton.setAlpha(.4f);
                    color = false;
                    lastButton = "dark";
                } else {
                    if (lastButton == "dark") {
                        color = true;
                        darkButton.setAlpha(1);
                        lastButton = "none";
                    } else {
                        disableAll();
                        color = false;
                        darkButton.setAlpha(.4f);
                        lastButton = "dark";
                    }
                }
                break;

            case R.id.pinkButton:
                if (color) {
                    disableAll();
                    pinkButton.setAlpha(.4f);
                    color = false;
                    lastButton = "pink";
                } else {
                    if (lastButton == "pink") {
                        color = true;
                        pinkButton.setAlpha(1);
                        lastButton = "none";
                    } else {
                        disableAll();
                        color = false;
                        pinkButton.setAlpha(.4f);
                        lastButton = "pink";
                    }
                }
                break;
        }
    }
}
