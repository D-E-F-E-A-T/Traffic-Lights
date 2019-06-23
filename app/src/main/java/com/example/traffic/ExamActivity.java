package com.example.traffic;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.traffic.Modules.TrafficQuestions;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class ExamActivity extends AppCompatActivity implements View.OnClickListener {

    ArrayList<TrafficQuestions> trafficQuestions;

    ImageView imageView;
ImageView imageanswer;
    Button answer1;
    Button answer2;
    Button answer3;

    TrafficQuestions trafficQuestion;


    int QuestionNumber=0;

    int rightAnswer=10;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam);

        trafficQuestions=new ArrayList<>();

        trafficQuestions=FillArray.getExamp();

        imageView=findViewById(R.id.imageViewimg);
        imageanswer=findViewById(R.id.imageanswer);
        answer1=findViewById(R.id.answer1);
        answer2=findViewById(R.id.answer2);
        answer3=findViewById(R.id.answer3);
        answer1.setOnClickListener(this);
        answer2.setOnClickListener(this);
        answer3.setOnClickListener(this);


        ChangeQuestion();
    }

    public void ChangeQuestion(){
        trafficQuestion=trafficQuestions.get(QuestionNumber);



        int resint = getResources().getIdentifier(trafficQuestion.getImage(),"drawable",getPackageName());


        imageView.setImageResource(resint);







        ArrayList<String> NewInt = new ArrayList<>();


        do {
            int number= getRandomNumberInRange(0,2);

          if (NewInt.size()==0) {
              NewInt.add(String.valueOf(number));
          }

          if(chakeNotexites(NewInt,number))   NewInt.add(String.valueOf(number));


        } while(NewInt.size()< 3);



        ArrayList<String> Answers=new ArrayList<>();

        Answers.add(trafficQuestion.getAnswer1());
        Answers.add(trafficQuestion.getAnswer2());
        Answers.add(trafficQuestion.getAnswer3());

        answer1.setText(Answers.get(Integer.parseInt(NewInt.get(0))));
        answer2.setText(Answers.get(Integer.parseInt(NewInt.get(1))));
        answer3.setText(Answers.get(Integer.parseInt(NewInt.get(2))));

    }


    private static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    public boolean chakeNotexites(ArrayList<String> NewInt,int number){

        boolean isExist = true;
        for (int i= 0; i<NewInt.size(); i++){

            if (NewInt.get((i)).equals(String.valueOf(number))   ){
                isExist = false;
            }

        }

        return isExist;
    }

    @Override
    public void onClick(View v) {

        String your_answer="";


        if (QuestionNumber<9){

            switch (v.getId()) {
                case R.id.answer1:
                    your_answer=answer1.getText().toString();
                    // do something
                    break;
                case R.id.answer2:
                    your_answer=answer2.getText().toString();
                    // do something else
                    break;
                case R.id.answer3:
                    your_answer=answer3.getText().toString();
                    // i'm lazy, do nothing
                    break;
            }
            if (trafficQuestion.getRightAnswer().contains(your_answer) ){
                imageanswer.setImageResource(R.drawable.right);
                int secondsDelayed = 1;
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        imageanswer.setImageResource(android.R.color.transparent);
                    }
                }, secondsDelayed * 1000);
            } else {
                rightAnswer=rightAnswer-1;
                imageanswer.setImageResource(R.drawable.wrong);
                int secondsDelayed = 1;
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        imageanswer.setImageResource(android.R.color.transparent);
                    }
                }, secondsDelayed * 1000);
            }

            QuestionNumber=QuestionNumber+1;
            ChangeQuestion();

        } else{



            new AlertDialog.Builder(this)
                    .setMessage("عدد الاجابات الصحيحة من 10 اسئلة هى "  + String.valueOf(rightAnswer))
                    .setTitle("نتيجة الاختبار")
                    .setCancelable(false)
                    .setPositiveButton("موافق", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    }).show();




           // Toast.makeText(getBaseContext(),  String.valueOf(rightAnswer) ,Toast.LENGTH_LONG).show();
        }





    }
}
