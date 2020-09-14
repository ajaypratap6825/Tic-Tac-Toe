package com.example.projects.tic_tac_toe;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity  extends AppCompatActivity implements View.OnClickListener {
    Button[][] b = new Button[3][3];
    boolean p1 = true;
    int rCount;
    int p1P, p2P;
    TextView tp1;
    TextView tp2;
    int i,j;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        tp1 = findViewById(R.id.tp1);
        tp2 = findViewById(R.id.tp2);

        for(i=0; i<3; i++) {
            for(j=0; j<3; j++){
              String bid= "b_" +i+j;
              int resId= getResources().getIdentifier(bid, "id", getPackageName());
                      b[i][j]= findViewById(resId);
                      b[i][j].setOnClickListener((View.OnClickListener) this);
            }
        }
        Button br= findViewById(R.id.br);
        br.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reset();
                MediaPlayer m= MediaPlayer.create(SecondActivity.this, R.raw.click);
                m.start();
            }
        });
    }
    @Override
    public void onClick(View v){
      if(!((Button) v).getText().toString().equals("")){
        return;
      }
      if (p1){
          ((Button) v).setText("X");
          MediaPlayer m= MediaPlayer.create(SecondActivity.this, R.raw.click);
          m.start();
      }
      else{
          ((Button)v).setText("O");
          MediaPlayer m= MediaPlayer.create(SecondActivity.this, R.raw.click);
          m.start();
      }
      rCount++;
      if (checkForWin()) {
          if (p1) {
              p1Wins();
          } else {
              p2Wins();
          }
      }else if(rCount==9){
              draw();
          }else {
              p1= !p1;
          }
      }

    public boolean checkForWin(){
        String[][] s= new String[3][3];
        for(i=0; i<3; i++){
            for(j=0; j<3; j++){
                s[i][j]= b[i][j].getText().toString();
            }
        }
        for(i=0; i<3; i++){
            if(s[i][0].equals(s[i][1]) && s[i][0].equals(s[i][2]) && !s[i][0].equals("")){
                return true;
            }
        }
        for(i=0; i<3; i++){
            if(s[0][i].equals(s[1][i]) && s[0][i].equals(s[2][i]) && !s[0][i].equals("")){
                return true;
            }
        }
        if(s[0][0].equals(s[1][1]) && s[0][0].equals(s[2][2]) && !s[0][0].equals("")){
            return true;
        }
        if(s[0][2].equals(s[1][1]) && s[0][2].equals(s[2][0]) && !s[0][2].equals("")){
            return true;
        }
        return false;
    }
    public void p1Wins(){
        p1P++;
        Toast.makeText(this,"Player 1 wins!!",Toast.LENGTH_SHORT).show();
        updatePoints();
        resetBoard();
    }
    public void p2Wins(){
        p2P++;
        Toast.makeText(this,"Player 2 wins!!",Toast.LENGTH_SHORT).show();
        updatePoints();
        resetBoard();
    }
    public void draw(){
        Toast.makeText(this,"Draw",Toast.LENGTH_SHORT).show();
        resetBoard();
    }
    public void updatePoints(){
        tp1.setText("Player 1:" + p1P);
        tp2.setText("Player 2:" + p2P);
    }
    public void resetBoard(){
        for(i=0; i<3; i++) {
            for (j = 0; j < 3; j++){
                b[i][j].setText("");
            }
        }
        rCount=0;
        p1=true;
    }
    public void reset(){
        p1P=0;
        p2P=0;
        updatePoints();
        resetBoard();
    }
}
