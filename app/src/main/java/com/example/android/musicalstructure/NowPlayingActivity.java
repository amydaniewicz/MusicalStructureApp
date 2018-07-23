package com.example.android.musicalstructure;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class NowPlayingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.now_playing_layout);

        // Get the intent data being passed to this activity
        Intent nowPlayingIntent = getIntent();

        // Find the Views that show the artist's photo, song title, and song artist
        ImageView artistPhotoImageView = (ImageView) findViewById(R.id.artist_photo_image_view);
        TextView songTitleTextView = (TextView) findViewById(R.id.song_title_text_view);
        TextView songArtistTextView = (TextView) findViewById(R.id.song_artist_text_view);

        // Set the data retrieved from the intent onto the corresponding views
        artistPhotoImageView.setImageResource(nowPlayingIntent.getIntExtra("SONG_RESOURCE_ID", 0));
        songTitleTextView.setText(nowPlayingIntent.getStringExtra("SONG_TITLE"));
        songArtistTextView.setText(nowPlayingIntent.getStringExtra("SONG_ARTIST"));
    }
}

