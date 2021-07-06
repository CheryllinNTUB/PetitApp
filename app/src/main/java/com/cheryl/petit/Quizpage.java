package com.cheryl.petit;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toolbar;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class Quizpage extends AppCompatActivity {

    private TextView q,noInd;
    private LinearLayout optionC;
    private Button next;
    private int count = 0;
    private List<Quizmodel> list;
    private int position = 0;
    private int score = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizpage);

        q = findViewById(R.id.q);
        noInd = findViewById(R.id.noInd);
        optionC = findViewById(R.id.optionC);
        next = findViewById(R.id.next);

        list = new ArrayList<>();
        list.add(new Quizmodel("請問貓咪的特殊穴道-百會穴一共有幾個?","4個","7個","3個","2個","2個"));
        list.add(new Quizmodel("請問貓咪因為基因缺陷，而無法感知下列哪一種味覺？","酸","鹹","苦","甜","甜"));
        list.add(new Quizmodel("狗狗在食物選擇上依賴的是哪一種感官體驗？","味覺","視覺","嗅覺","聽覺","嗅覺"));
        list.add(new Quizmodel("請問一隻成年犬有幾顆牙齒?","42顆","32顆","72顆","28顆","42顆"));
        list.add(new Quizmodel("請問以下哪一種食物對貓狗來說是屬於劇毒?","番茄","水煮蛋","巧克力","芋頭","巧克力"));
        list.add(new Quizmodel("請問在哪一個國家，看到黑貓是代表幸運?","台灣","英國","墨西哥","日本","英國"));
        for (int i = 0; i < 4;i++){
            optionC.getChildAt(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    checkAns((Button)view);
                }
            });
        }


        playAnim(q,0,list.get(position).getQuestion());
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                next.setEnabled(false);
                next.setAlpha(0.7f);
                enableOption(true);
                position++;
                if (position == list.size()){
                    Intent sintent = new Intent(Quizpage.this,Quizscore.class);
                    sintent.putExtra("score",score);
                    sintent.putExtra("total",list.size());
                    startActivity(sintent);
                    finish();
                    return;
                }
                count = 0;
                playAnim(q,0,list.get(position).getQuestion());
            }
        });
    }

    private void playAnim(View view, int value,String data){

        view.animate().alpha(value).scaleX(value).scaleY(value).setDuration(500).setStartDelay(100)
                .setInterpolator(new DecelerateInterpolator()).setListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {
                    if (value == 0 && count < 4){
                        String option = "";
                        if (count == 0){
                            option = list.get(position).getO1();
                        }else if (count == 1){
                            option = list.get(position).getO2();
                        }else if (count == 2){
                            option = list.get(position).getO3();
                        }else if (count == 3){
                            option = list.get(position).getO4();

                        }
                        playAnim(optionC.getChildAt(count),0,option);
                        count++;
                    }
            }

            @Override
            public void onAnimationEnd(Animator animator) {
                if (value == 0 ){
                    try {
                        ((TextView)view).setText(data);
                        noInd.setText(position+1+"/"+list.size());
                    }catch (ClassCastException ex){
                        ((Button)view).setText(data);
                    }
                    view.setTag(data);
                    playAnim(view,1,data);
                }
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
    }

    private void checkAns(Button selectedOption){
        enableOption(false);
        next.setEnabled(true);
        next.setAlpha(1);
        if (selectedOption.getText().toString().equals(list.get(position).getCorrect())){
            score++;
            selectedOption.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#77FFCC")));
        }else {
            selectedOption.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ff0000")));
            Button correctop = (Button) optionC.findViewWithTag(list.get(position).getCorrect());
            correctop.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#77FFCC")));
        }

    }

    private void enableOption(boolean enable){
        for (int i = 0; i < 4;i++){
            optionC.getChildAt(i).setEnabled(enable);
            if (enable){
                optionC.getChildAt(i).setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#989898")));
            }
        }
    }
}
