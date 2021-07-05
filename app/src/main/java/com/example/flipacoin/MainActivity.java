package com.example.flipacoin;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button b;
    ImageView iv;
    Random r;
    int side;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //button
        b = (Button)findViewById(R.id.flip);
        //image
        iv = (ImageView)findViewById(R.id.coin);
        r = new Random();
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.flipsound);
        //function on button to flip a coin
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                side = r.nextInt(2);
                mp.start();
                //for HEADS
                if ( side == 0){
                    iv.setImageResource(R.drawable.head);
                    Toast.makeText(MainActivity.this,"HEADS!",Toast.LENGTH_SHORT).show();
                }
                //for TAILS
                else if (side == 1){
                    iv.setImageResource(R.drawable.tail);
                    Toast.makeText(MainActivity.this,"TAILS!",Toast.LENGTH_SHORT).show();
                }
                //For Rotation
                RotateAnimation rotate = new RotateAnimation(0, 360, RotateAnimation.RELATIVE_TO_SELF, 0.5f,RotateAnimation.RELATIVE_TO_SELF, 0.5f);
                rotate.setDuration(250);
                iv.startAnimation(rotate);
            }
        });
    }
}