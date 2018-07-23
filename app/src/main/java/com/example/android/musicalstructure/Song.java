package com.example.android.musicalstructure;

import android.media.Image;
import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * {@link Song} represents one of the songs in the app.
 * It contains an image, song title, and artist for the song.
 */

public class Song  {
    /**
     * Resource ID for the song image
     */
    private int mSongResourceId;
    /**
     * Title for the song
     */
    private String mSongTitle;
    /**
     * Artist for the song
     */
    private String mSongArtist;

    /**
     * Constructor
     */
    public Song(int songResourceId, String songTitle, String songArtist) {
        mSongResourceId = songResourceId;
        mSongTitle = songTitle;
        mSongArtist = songArtist;
    }

    /**
     * Get song image
     */
    public int getSongResourceId() {
        return mSongResourceId;
    }

    /**
     * Get song title
     */
    public String getSongTitle() {
        return mSongTitle;
    }

    /**
     * Get song artist
     */
    public String getSongArtist() {
        return mSongArtist;
    }
}

