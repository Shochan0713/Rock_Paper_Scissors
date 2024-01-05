package com.example.rockpaperscissors;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //グーが押された時のイベント
    public void onClickRock(View view){
        game(0);
    }
    //チョキが押された時のイベント
    public void onClickScissors(View view){
        game(1);
    }
    //パーが押された時のイベント
    public void onClickPaper(View view){
        game(2);
    }

    //コンピューターの手をランダムに決定し、勝敗の判定を行う
    private  void game(int playerHand){
        String[] handTexts = {"グー","チョキ","パー"};
        Random r = new Random();
        int cupHand = r.nextInt(3);

        String judge = null;

        // プレイヤーとコンピュータの手を比較して勝敗を判定する
        if (playerHand == cupHand) {
            judge = "あいこ";
        } else if (playerHand == 0 && cupHand == 2) {
            // 「グー」対「パー」
            judge = "まけ";
        } else if (playerHand == 0 && cupHand == 1) {
            // 「グー」対「チョキ」
            judge = "かち";
        } else if (playerHand == 1 && cupHand == 0) {
            // 「チョキ」対「グー」
            judge = "まけ";
        } else if (playerHand == 1 && cupHand == 2) {
            // 「チョキ」対「パー」
            judge = "かち";
        } else if (playerHand == 2 && cupHand == 0) {
            // 「パー」対「グー」
            judge = "かち";
        } else if (playerHand == 2 && cupHand == 1) {
            // 「パー」対「チョキ」
            judge = "まけ";
        }

        TextView textViewJudge = findViewById(R.id.judge);
        textViewJudge.setText(judge);
        TextView textViewCpu = (TextView)findViewById(R.id.cpu);
        textViewCpu.setText(handTexts[cupHand]);
    }
}