package com.binodroxx.mydiceapp;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int mybox = 10;

        final ImageView diceImage1=findViewById(R.id.imgDice1);
        final ImageView diceImage2=findViewById(R.id.imgDice2);
        final int []diceImages={R.drawable.dice1,R.drawable.dice2,R.drawable.dice3,R.drawable.dice4,R.drawable.dice5,R.drawable.dice6};
       final MediaPlayer mp=MediaPlayer.create(this,R.raw.dice_sound);

        Button btnRoll = findViewById(R.id.btnRollTheDice);
        btnRoll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){


                Log.i("MyDiceApp","btnRoll is tapped now!");

                Random rndObject = new Random();
                int MyRandomNumber=rndObject.nextInt(6);
                Log.i("MyDiceApp",MyRandomNumber+"");

                diceImage1.setImageResource(diceImages[MyRandomNumber]);
                MyRandomNumber=rndObject.nextInt(6);
                diceImage2.setImageResource(diceImages[MyRandomNumber]);

                YoYo.with(Techniques.Swing)
                        .duration(500)
                        .repeat(0)
                        .playOn(diceImage1);
                YoYo.with(Techniques.Shake)
                        .duration(500)
                        .repeat(0)
                        .playOn(diceImage2);
                mp.start();
            }
        });
    }
}
