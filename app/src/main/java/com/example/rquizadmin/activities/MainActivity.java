package com.example.rquizadmin.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rquizadmin.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
 private EditText edit_question,edit_option1,edit_option2,edit_option3,edit_option4;
 private CheckBox checkBox1,checkBox2,checkBox3,checkBox4;
 private FloatingActionButton floatingActionButton_add_quiz;
 private TextView textView_question_count,textView_see_questions;
 private ScrollView scrollView_question_card;
 private int question_count =0;
 private Button create_quiz_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit_question=findViewById(R.id.edit_question);
        edit_option1=findViewById(R.id.edit_option1);
        edit_option2=findViewById(R.id.edit_option2);
        edit_option3=findViewById(R.id.edit_option3);
        edit_option4=findViewById(R.id.edit_option4);
        checkBox1=findViewById(R.id.checkBox1);
        checkBox2=findViewById(R.id.checkBox2);
        checkBox3=findViewById(R.id.checkBox3);
        checkBox4=findViewById(R.id.checkBox4);
        floatingActionButton_add_quiz=findViewById(R.id.floatingActionButton_add_quiz);
        textView_question_count=findViewById(R.id.textView_question_count);
        textView_see_questions=findViewById(R.id.textView_see_questions);
        scrollView_question_card=findViewById(R.id.scrollView_question_card);
        floatingActionButton_add_quiz.setOnClickListener(this);
        create_quiz_button=findViewById(R.id.create_quiz_button);

    }

    @Override
    public void onClick(View view) {

        if(view==floatingActionButton_add_quiz){

//            if (checkIfEdittextsAreEmpty()) {
//                Toast.makeText(getApplicationContext(), "field(s) cannot be empty!", Toast.LENGTH_SHORT).show();
//                return;
//            }
//            if (checkIfCheckboxesAreEmpty()) {
//                Toast.makeText(getApplicationContext(), "choose an answer first!", Toast.LENGTH_SHORT).show();
//                return;
//            }
            animateQuestionCard();

        }


    }

    private void animateQuestionCard() {
        scrollView_question_card.setLayerType(View.LAYER_TYPE_HARDWARE, null);
        textView_question_count.setVisibility(View.VISIBLE);
        textView_see_questions.setVisibility(View.VISIBLE);
        textView_question_count.setText(String.valueOf( question_count)) ;
        create_quiz_button.setEnabled(true);
        scrollView_question_card.animate().translationX(-getScreenWidth() / 2f + textView_see_questions.getMeasuredWidth() / 2f).translationY(getScreenHeight()).scaleX(0).scaleY(0).alpha(0)
                .setDuration(601).setInterpolator(new AccelerateInterpolator()).setListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                scrollView_question_card.setLayerType(View.LAYER_TYPE_NONE, null);
                scrollView_question_card.setTranslationX(0);
                scrollView_question_card.setTranslationY(0);
                scrollView_question_card.setScaleX(1);
                scrollView_question_card.setScaleY(1);
                scrollView_question_card.setAlpha(1);
            }
        });
    }

    private static int getScreenHeight() {
        return Resources.getSystem().getDisplayMetrics().heightPixels;
    }

    private static int getScreenWidth() {
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }

    private boolean checkIfCheckboxesAreEmpty() {
        if ((!checkBox1.isChecked())
                && !(checkBox2.isChecked())
                && !(checkBox3.isChecked())
                && !(checkBox4.isChecked())) {
            return true;
        }
        return false;
    }

    private boolean checkIfEdittextsAreEmpty() {
        if ((edit_question.getText().toString().trim().isEmpty())
                || (edit_option1.getText().toString().trim().isEmpty())
                || (edit_option2.getText().toString().trim().isEmpty())
                || (edit_option3.getText().toString().trim().isEmpty())
                || (edit_option4.getText().toString().trim().isEmpty())) {
            return true;
        }
        return false;
    }
}