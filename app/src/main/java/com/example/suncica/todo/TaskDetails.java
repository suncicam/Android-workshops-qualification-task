package com.example.suncica.todo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class TaskDetails extends AppCompatActivity implements View.OnClickListener {

    public Button yellowButton, redButton, greenButton, blueButton, darkButton, pinkButton;
    public EditText taskTittleEditText, descriptionEditText;
    public Button saveButton, deleteButton;
    String titleValue = null;
    String descriptionValue = null;
    Boolean isDoneValue;
    public CheckBox isDoneBox;

    public boolean color = true;
    public String lastButton = "none";
    public String colorName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_details);

        taskTittleEditText = (EditText) findViewById(R.id.editTaskTitleEditText);
        descriptionEditText = (EditText) findViewById(R.id.editDescriptionEditText);
        saveButton = (Button) findViewById(R.id.saveTaskButton);
        deleteButton = (Button) findViewById(R.id.deleteTaskButton);
        isDoneBox = (CheckBox) findViewById(R.id.checkAsDone);

        yellowButton = (Button) findViewById(R.id.editYellowButton);
        redButton = (Button) findViewById(R.id.editRedButton);
        greenButton = (Button) findViewById(R.id.editGreenButton);
        blueButton = (Button) findViewById(R.id.editBlueButton);
        darkButton = (Button) findViewById(R.id.editDarkBlueButton);
        pinkButton = (Button) findViewById(R.id.editPinkButton);

        yellowButton.setOnClickListener(this);
        redButton.setOnClickListener(this);
        greenButton.setOnClickListener(this);
        blueButton.setOnClickListener(this);
        darkButton.setOnClickListener(this);
        pinkButton.setOnClickListener(this);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            titleValue = extras.getString("task name");
            descriptionValue = extras.getString("task description");
            isDoneValue = extras.getBoolean("is done");
            colorName = extras.getString("color");
        }

        switch (colorName) {
            case "yellow":
                yellowButton.performClick();
                break;
            case "red":
                redButton.performClick();
                break;
            case "green":
                greenButton.performClick();
                break;
            case "blue":
                blueButton.performClick();
                break;
            case "dark":
                darkButton.performClick();
                break;
            case "pink":
                pinkButton.performClick();
                break;
            case "none":
                break;

        }

        taskTittleEditText.append(titleValue);
        descriptionEditText.append(descriptionValue);
        isDoneBox.setChecked(isDoneValue);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String taskName = taskTittleEditText.getText().toString();
                String description = descriptionEditText.getText().toString();
                Boolean checkbox = isDoneBox.isChecked();
                MainActivity.dataBase.updatedetails(titleValue, taskName, description, Boolean.toString(checkbox), lastButton);
                Intent myIntent = new Intent(TaskDetails.this,
                        MainActivity.class);
                startActivity(myIntent);
            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.dataBase.deleteElement(titleValue);
                Intent myIntent = new Intent(TaskDetails.this,
                        MainActivity.class);
                startActivity(myIntent);
            }
        });
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
            case R.id.editYellowButton:
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

            case R.id.editRedButton:
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

            case R.id.editGreenButton:
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

            case R.id.editBlueButton:
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

            case R.id.editDarkBlueButton:
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
                    }else {
                        disableAll();
                        color = false;
                        darkButton.setAlpha(.4f);
                        lastButton = "dark";
                    }
                }
                break;

            case R.id.editPinkButton:
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
                    }else {
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

