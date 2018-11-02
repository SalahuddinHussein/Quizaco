package com.smiledwatermelon.quizaco;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button mFalseButton,mTrueButton;
    TextView mQuizText,mScoreText;
    int mQuizIndex=0;
    int mScore=0;
    ProgressBar mProgressBar;


    private TrueFalse[] mQuizBank= new TrueFalse[]{
            new TrueFalse(R.string.question_1,true),
            new TrueFalse(R.string.question_2,true),
            new TrueFalse(R.string.question_3,true),
            new TrueFalse(R.string.question_4,true),
            new TrueFalse(R.string.question_5,true),
            new TrueFalse(R.string.question_6,false),
            new TrueFalse(R.string.question_7,true),
            new TrueFalse(R.string.question_8,false),
            new TrueFalse(R.string.question_9,true),
            new TrueFalse(R.string.question_10,true),
            new TrueFalse(R.string.question_11,false),
            new TrueFalse(R.string.question_12,false),
            new TrueFalse(R.string.question_13,true),

    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState!=null){
            mScore=savedInstanceState.getInt("ScoreKey");
            mQuizIndex=savedInstanceState.getInt("IndexKey");
        }
        else{
            mScore=0;
            mQuizIndex=0;

        }

        mFalseButton = findViewById(R.id.false_button);
        mTrueButton=findViewById(R.id.true_button);
        mQuizText=findViewById(R.id.question_text_view);
        mScoreText=findViewById(R.id.score);

        mQuizText.setText(mQuizBank[mQuizIndex].getQuistionResourceID());
        mProgressBar=findViewById(R.id.progress_bar);
        mProgressBar.setMax(mQuizBank.length);
        mQuizText.setText(mQuizBank[mQuizIndex].getQuistionResourceID());
        mScoreText.setText("Score "+mScore+"/"+mQuizBank.length);
        // Set buttons listeners
        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                CheckAnswer(true);
                UpdateQuizes();
            }
        });

        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                CheckAnswer(false);
                 UpdateQuizes();

            }
        });

    }

    private  void UpdateQuizes(){
        mQuizIndex++;
        mProgressBar.setProgress(mQuizIndex);
        if(mQuizIndex==mQuizBank.length){
            mProgressBar.setProgress(mQuizBank.length);
            AlertDialog.Builder alert=new AlertDialog.Builder(this);
            alert.setTitle("Game Over");
            alert.setCancelable(false);
            alert.setMessage("Your Score is "+mScore+" Point's!");
            alert.setPositiveButton("Close App", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            }).show();
            mQuizIndex=mQuizBank.length-1;
            }
        mQuizText.setText(mQuizBank[mQuizIndex].getQuistionResourceID());
        mScoreText.setText("Score "+mScore+"/"+mQuizBank.length);

    }

    private void CheckAnswer(boolean mMyAnswer){

        if(mQuizBank[mQuizIndex].isAnswer()==mMyAnswer){
            mScore++;
            Toast.makeText(getApplicationContext(),R.string.correct_toast,Toast.LENGTH_SHORT).show();
        }else
            Toast.makeText(getApplicationContext(),R.string.incorrect_toast,Toast.LENGTH_SHORT).show();

    }
@Override
    public void onSaveInstanceState(Bundle outState ) {

    super.onSaveInstanceState(outState);
    outState.putInt("ScoreKey",mScore);
    outState.putInt("IndexKey",mQuizIndex);
}
}
