package com.example.android.musicalstructure;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class NowPlayingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.now_playing_layout);

        Intent nowPlayingIntent = getIntent();

        ImageView artistPhotoImageView = (ImageView) findViewById(R.id.artist_photo_image_view);
        TextView songTitleTextView = (TextView) findViewById(R.id.song_title_text_view);
        TextView songArtistTextView = (TextView) findViewById(R.id.song_artist_text_view);

        artistPhotoImageView.setImageResource(nowPlayingIntent.getIntExtra("SONG_RESOURCE_ID", 0));
        songTitleTextView.setText(nowPlayingIntent.getStringExtra("SONG_TITLE"));
        songArtistTextView.setText(nowPlayingIntent.getStringExtra("SONG_ARTIST"));

        Button homeButton = (Button) findViewById(R.id.home_2_button);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mainActivityIntent = new Intent(NowPlayingActivity.this, MainActivity.class);
                startActivity(mainActivityIntent);
            }
        });
    }
}

