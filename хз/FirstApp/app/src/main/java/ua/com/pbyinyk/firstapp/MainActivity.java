package ua.com.pbyinyk.firstapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.BundleCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by 1 on 30.03.2016.
 */
public class MainActivity extends AppCompatActivity {

    private static final String TAG = "QuizActivity";
    private static final String KEY_INDEX="index";
    private Button mTrueButton;
    private Button mFalseButton;
    private ImageButton mNextButton;
    private ImageButton mPreviusButton;
    private Button mCheatButton;
    private TextView mQuestionTextView;


    private TrueFalse [] mQuestionBank=new TrueFalse[]{
            new TrueFalse(false,R.string.question_Italy),
            new TrueFalse(false,R.string.question_Japan),
            new TrueFalse(true,R.string.question_Poland),
            new TrueFalse(true,R.string.question_USA),
    };

    private int mCurrentIndex=0;


    private void updateQuestion(){
        int question=mQuestionBank[mCurrentIndex].getmQuestion();
        mQuestionTextView.setText(question);
    }

    private void cackAnswer(boolean userPressTrue){
        boolean answerIsTrue=mQuestionBank[mCurrentIndex].ismTrueQuestion();

        int massageResId=0;

        if(userPressTrue==answerIsTrue){

            massageResId=R.string.correct_toast;

        }else{
            massageResId=R.string.incorrect_toast;
        }

        Toast.makeText(this,massageResId,Toast.LENGTH_SHORT).show();
    }


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mQuestionTextView=(TextView)findViewById(R.id.question_text_view);
        mQuestionTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
                updateQuestion();
            }
        });
        mCheatButton=(Button)findViewById(R.id.cheatButton);
        mCheatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,CheatsActivity.class);
                boolean answerIsTrue = mQuestionBank[mCurrentIndex].ismTrueQuestion();
                intent.putExtra(CheatsActivity.EXTRA_ANSWER_IS_TRUE, answerIsTrue);
                startActivityForResult(intent,0);
            }
        });

        mPreviusButton=(ImageButton)findViewById(R.id.previus_button);


            mPreviusButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    mCurrentIndex = (mCurrentIndex + 3) % mQuestionBank.length;


                    updateQuestion();
                }

                 });



        mNextButton=(ImageButton)findViewById(R.id.next_button);
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
                updateQuestion();
            }
        });
        if (savedInstanceState != null) {
            mCurrentIndex = savedInstanceState.getInt(KEY_INDEX, 0);
        }
        updateQuestion();



        mTrueButton=(Button)findViewById(R.id.true_button);
        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cackAnswer(true);

            }
        });

        mFalseButton=(Button)findViewById(R.id.false_button);
        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               cackAnswer(false);
            }
        });


    }
        public void onSaveInstanceState(Bundle savedInstanceState) {
            super.onSaveInstanceState(savedInstanceState);
            Log.i(TAG, "onSaveInstanceState");
            savedInstanceState.putInt(KEY_INDEX, mCurrentIndex);
        }

    }





