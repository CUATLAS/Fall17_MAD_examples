package com.example.aileen.sport;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void findSport(View view) {
        //toggle button
        ToggleButton toggle = (ToggleButton)findViewById(R.id.toggleButton);
        boolean location = toggle.isChecked();

        //spinner
        Spinner exercise = (Spinner)findViewById(R.id.spinner);
        String exerciseType = String.valueOf(exercise.getSelectedItem());

        //radio buttons
        RadioGroup cost = (RadioGroup)findViewById(R.id.radioGroup);
        int cost_id = cost.getCheckedRadioButtonId();

        //check boxes
        CheckBox winterCheckBox = (CheckBox)findViewById(R.id.checkBox1);
        Boolean winter = winterCheckBox.isChecked();

        CheckBox springCheckBox = (CheckBox)findViewById(R.id.checkBox2);
        Boolean spring = springCheckBox.isChecked();

        CheckBox summerCheckBox = (CheckBox)findViewById(R.id.checkBox3);
        Boolean summer = summerCheckBox.isChecked();

        CheckBox fallCheckBox = (CheckBox)findViewById(R.id.checkBox4);
        Boolean fall = fallCheckBox.isChecked();

        //pick sport
        String perfectSport;
        if(location){ //inside
            if(cost_id == R.id.radioButton1){ //cheapest option
                perfectSport="A home workout";
            } else {
                switch (exerciseType) {
                    case "cardio":
                        perfectSport = "Spin class";
                        break;
                    case "strength":
                        perfectSport = "Weight training";
                        break;
                    case "flexibility":
                        perfectSport = "Yoga";
                        break;
                    default:
                        perfectSport = "Yoga";
                }
            }
        }
        else{ //outside
            if(cost_id == R.id.radioButton3){
                if(winter) {
                    perfectSport = "Skiing";
                } else {
                    perfectSport = "Sky Diving";
                }
            } else {
                switch (exerciseType) {
                    case "cardio":
                        perfectSport = "Running";
                        break;
                    case "strength":
                        perfectSport = "Climbing";
                        break;
                    case "flexibility":
                        perfectSport = "Yoga";
                        break;
                    default:
                        perfectSport = "Yoga";
                }
            }
        }

        //text view
        TextView sportSelection = (TextView)findViewById(R.id.sportTextView);
        sportSelection.setText(perfectSport + " is the sport for you");
    }
}
