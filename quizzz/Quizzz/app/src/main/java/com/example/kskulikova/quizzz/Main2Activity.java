package com.example.kskulikova.quizzz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import static android.provider.Settings.Global.getString;

public class Main2Activity extends AppCompatActivity {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    int score = 0;

    public int onRadioButtonClick(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.q1_radio_1:
                if (checked)
                    score +=1;
                    break;
            case R.id.q1_radio_2:
                if (checked)
                    break;
            case R.id.q1_radio_3:
                if (checked)
                break;
            case R.id.q2_radio_1:
                if (checked)
                break;
            case R.id.q2_radio_2:
                if (checked)
                    score +=1;
                break;
            case R.id.q2_radio_3:
                if (checked)
                break;
            case R.id.q3_radio_1:
                if (checked)
                break;
            case R.id.q3_radio_2:
                if (checked)
                break;
            case R.id.q3_radio_3:
                if (checked)
                    score +=1;
                break;
            case R.id.q4_radio_1:
                if (checked)
                break;
            case R.id.q4_radio_2:
                if (checked)
                break;
            case R.id.q4_radio_3:
                if (checked)
                break;
            case R.id.q4_radio_4:
                if (checked)
                    score +=1;
                break;
        }
        return score;
    }

    private int getScoreForRadioGroup(RadioGroup r) {
        int selectedButtonId = r.getCheckedRadioButtonId();
        if (selectedButtonId > 0)
            return Integer.parseInt((String) findViewById(selectedButtonId).getTag());
        return 0;
    }

    public void get_score(View view) {
        int total=0;

        int question_1 = getScoreForRadioGroup((RadioGroup) findViewById(R.id.q1));
        int question_2 = getScoreForRadioGroup((RadioGroup) findViewById(R.id.q2));
        int question_3 = getScoreForRadioGroup((RadioGroup) findViewById(R.id.q3));
        int question_4 = getScoreForRadioGroup((RadioGroup) findViewById(R.id.q4));
        EditText countryName = (EditText) findViewById(R.id.input_country);
        String country = countryName.getText().toString(); //gets you the contents of edit text
        CheckBox tinsCheckbox = (CheckBox) findViewById(R.id.tins_checkbox);
        boolean tinsFact = tinsCheckbox.isChecked();
        CheckBox mountRumpke = (CheckBox) findViewById(R.id.MountRumpke_checkbox);
        boolean mountFact = mountRumpke.isChecked();
        CheckBox glass = (CheckBox) findViewById(R.id.glass_checkbox);
        boolean glassFact = glass.isChecked();
        total = calculateScore(country, tinsFact, mountFact, glassFact) + question_1 + question_2 + question_3 + question_4;
        String scoreMessage = createScoreMessage(total);
        Toast.makeText(this, scoreMessage, Toast.LENGTH_SHORT).show();

    }

    private int calculateScore(String country, boolean tinsFact, boolean mountFact, boolean glassFact) {
        score=0;
        if (!tinsFact && mountFact && glassFact) {
            score += 1;
        }

        if (country.equals("Germany")) {
            score += 1;
        }



        return score;
    }

    private String createScoreMessage (int total) {
        String scoreMessage = "Your score is "+ total + "/6!";
        return scoreMessage;
    }

}