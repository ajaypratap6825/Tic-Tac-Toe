package com.example.projects.tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button bp, bi, be;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bp= (Button) findViewById (R.id.bp);
        bp.setOnClickListener(new View.OnClickListener(){
            @Override
             public void onClick(View v){
                Intent ip = new Intent(MainActivity.this,SecondActivity.class);
                startActivity(ip);
                MediaPlayer m= MediaPlayer.create(MainActivity.this, R.raw.click);
                m.start();
            }
            });
        bi= (Button) findViewById(R.id.bi);
        bi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ii = new Intent(MainActivity.this,ThirdActivity.class);
                startActivity(ii);
                MediaPlayer m= MediaPlayer.create(MainActivity.this, R.raw.click);
                m.start();
            }
        });
        be= (Button) findViewById(R.id.be);
        be.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ie = new Intent(Intent.ACTION_MAIN);
                ie.addCategory(Intent.CATEGORY_HOME);
                ie.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(ie);
                MediaPlayer m= MediaPlayer.create(MainActivity.this, R.raw.click);
                m.start();
            }
        });
    }
}