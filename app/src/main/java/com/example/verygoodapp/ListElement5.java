package com.example.verygoodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.google.android.youtube.player.YouTubeThumbnailView;

public class ListElement5 extends YouTubeBaseActivity {

    private static final String TAG = "ListElement5";

    YouTubePlayerView mYouTubePlayerView;
    Button btnPlay;
    YouTubePlayer.OnInitializedListener mOnInitializedListener;
    Button btnList;
    Button btnMain;
    Button btnQuiz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_element5);
        Log.d(TAG, "onCreate: Starting.");
        btnPlay = (Button) findViewById(R.id.btnPlay);
        mYouTubePlayerView = (YouTubePlayerView) findViewById(R.id.youtubePlay);

        btnList = (Button) findViewById(R.id.btnList);
        btnMain = (Button) findViewById(R.id.btnMain);
        btnQuiz = (Button) findViewById(R.id.btnQuiz);

        mOnInitializedListener = new YouTubePlayer.OnInitializedListener(){
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b){
                Log.d(TAG, "onClick: Done initializing.");

                youTubePlayer.loadVideo("gDYr1p_fMbU");
            }
            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult){
                Log.d(TAG, "onClick: Failed to initialize.");
            }
        };

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(ListElement5.this, R.anim.fadeout);
                btnPlay.startAnimation(animation);
                Log.d(TAG, "onClick: initializing Youtube Payer.");
                mYouTubePlayerView.initialize(YouTubeConfig.getApiKey(), mOnInitializedListener);

            }
        });

        btnList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(ListElement5.this, R.anim.bounce);
                btnList.startAnimation(animation);
                startActivity(new Intent(ListElement5.this, MainActivity.class));
            }
        });

        btnMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(ListElement5.this, R.anim.bounce);
                btnMain.startAnimation(animation);
            }
        });

        btnQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(ListElement5.this, R.anim.bounce);
                btnQuiz.startAnimation(animation);
                startActivity(new Intent(ListElement5.this, ListElement0Quiz.class));
            }
        });


    }
}