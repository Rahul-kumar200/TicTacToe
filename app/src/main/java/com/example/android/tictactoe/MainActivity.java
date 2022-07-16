package com.example.android.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    boolean gameActive=true;
    // Player representation
    // 0 - X
    // 1 - 0

    // activePlayer changes at each turn
    int activePlayer=0;
    int [] gameState={ 2, 2, 2, 2, 2, 2, 2, 2, 2};

    // 0 - X
    // 1 - 0
    // 2 - NULL(Blank)

    // these all the the fixed 8 winning positions
    int [][] winPositions={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};

    public void playerTap(View view){

        if(gameActive==false)
        {
            gameReset(view);
        }

        ImageView img= (ImageView) view;

        int tappedImage = Integer.parseInt(img.getTag().toString());

        // if empty then fill the image

        if(gameState[tappedImage] == 2){

            gameState[tappedImage]=activePlayer;

            if(activePlayer==0){
                img.setImageResource(R.drawable.x);
                activePlayer=1;
                TextView status= findViewById(R.id.status);
                status.setText("O's Turn - Tap to Play");
            }

            else if(activePlayer==1){
                img.setImageResource(R.drawable.o );
                activePlayer=0;
                TextView status= findViewById(R.id.status);
                status.setText("X's Turn - Tap to Play");

            }
        }

        // checking wheather any player won or not
        for(int[] winPosition : winPositions)
        {
            if(gameState[winPosition[0]]!=2 &&gameState[winPosition[0]]==gameState[winPosition[1]] && gameState[winPosition[1]]==gameState[winPosition[2]]){

                // somebody won the game
                String winnerStr;
                if(gameState[winPosition[0]]==0){
                    winnerStr="X win the Game";
                }

                else {
                  winnerStr="O win the Game";
                }

                // Update the status text
                TextView status=findViewById(R.id.status);
                status.setText(winnerStr);

                // making the gameActive boolean variable false
                gameActive=false;
            }
        }


    }

    public void gameReset(View view)
    {
        gameActive=true;
        activePlayer=0;
        for(int i=0;i<gameState.length;i++)
        {
            gameState[i]=2;
        }
        ((ImageView)findViewById(R.id.imageView0)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}