package com.example.android.musicalstructure;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class SongAdapter extends ArrayAdapter<Song> {

    /**
     * This is our own custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists.
     *
     * @param context   The current context. Used to inflate the layout file.
     * @param songs     A List of Song objects to display in a list
     */
    public SongAdapter(Activity context, ArrayList<Song> songs) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // The second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, songs);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link Song} object located at this position in the list
        final Song currentSong = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID title_text_view
        TextView titleTextView = (TextView) listItemView.findViewById(R.id.title_text_view);
        // Get the title from the current Song object and
        // set this text on the titleTextView
        titleTextView.setText(currentSong.getSongTitle());

        // Find the TextView in the list_item.xml layout with the ID artist_text_view
        TextView artistTextView = (TextView) listItemView.findViewById(R.id.artist_text_view);
        // Get the artist's name from the current Song object and
        // set this text on the artistTextView
        artistTextView.setText(currentSong.getSongArtist());

        // Find the LinearLayout in the list_item.xml layout
        LinearLayout listItemLayout = (LinearLayout) listItemView.findViewById(R.id.list_item_layout);

        // Set an on click listener onto that view group
        listItemLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nowPlayingIntent = new Intent(getContext(), NowPlayingActivity.class);

                // Include the song image, title, and artist name with the intent
                nowPlayingIntent.putExtra("SONG_RESOURCE_ID", currentSong.getSongResourceId());
                nowPlayingIntent.putExtra("SONG_TITLE", currentSong.getSongTitle());
                nowPlayingIntent.putExtra("SONG_ARTIST", currentSong.getSongArtist());

                getContext().startActivity(nowPlayingIntent);
            }
        });

        // Return the whole list item layout (containing 1 ImageView and 2 TextViews)
        // so that it can be shown in the ListView
        return listItemView;
    }
}
