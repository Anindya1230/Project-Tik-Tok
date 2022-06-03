package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayout;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    boolean isWinner=false;
    int imageClicked=-1;
    int player1=1;  //player1 = cross
    int [][]winningStates={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    int []gameStates={-1,-1,-1,-1,-1,-1,-1,-1,-1};
    public void load(View view) {
            ImageView v = (ImageView) view;
            int tag = Integer.parseInt(v.getTag().toString());
            imageClicked=gameStates[tag];
            if(isWinner==false && imageClicked==-1) {
            if (player1 == 1) {
                v.setImageResource(R.drawable.cross);
                gameStates[tag] = player1;
                Toast.makeText(this, tag + "" + "cross", Toast.LENGTH_SHORT).show();
                player1 = 0;
            } else{
                v.setImageResource(R.drawable.zero);
                gameStates[tag] = player1;
                Toast.makeText(this, tag + "" + "zero", Toast.LENGTH_SHORT).show();
                player1 = 1;
            }
            for (int i = 0; i < winningStates.length; i++) {
                if (gameStates[winningStates[i][0]] == gameStates[winningStates[i][1]] &&
                        gameStates[winningStates[i][1]] == gameStates[winningStates[i][2]] && gameStates[winningStates[i][0]] > -1) {
                    Toast.makeText(this, "Winner is " + (player1 == 0 ? 1 : 0), Toast.LENGTH_SHORT).show();
                    isWinner=true;
                }
            }
        }
    }
    public void reset(View view){
        GridLayout gridLayout=findViewById(R.id.GridLayout);
        int total_image=gridLayout.getChildCount();
        for(int l = 0;l < total_image;l++) {
            ImageView v = (ImageView) gridLayout.getChildAt(l);
            v.setImageDrawable(null);
        }
            isWinner=false;
            imageClicked=-1;
            player1=1;
            for(int j = 0;j<gameStates.length;j++) {
                gameStates[j] = -1;
            }

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}