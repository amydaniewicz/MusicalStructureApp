package com.example.android.musicalstructure;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class SongListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.song_list_layout);

        // Create a list of songs
        final ArrayList<Song> songs = new ArrayList<Song>();
        songs.add(new Song(R.drawable.tina_turner, "River Deep - Mountain High","Tina Turner"));
        songs.add(new Song(R.drawable.theophilus_london_solange , "Flying Overseas", "Theophilus London, Solange, Devonte Hynes"));
        songs.add(new Song(R.drawable.justin_timberlake , "Sauce", "Justin Timberlake"));
        songs.add(new Song(R.drawable.nilufer_yanya, "Baby Luv", "Nilufer Yanya"));
        songs.add(new Song(R.drawable.the_ting_tings, "That's Not My Name", "The Ting Tings"));
        songs.add(new Song(R.drawable.gary_clark_jr, "Honest I Do", "Gary Clark Jr."));
        songs.add(new Song(R.drawable.dolly_parton, "Do I Ever Cross Your Mind", "Dolly Parton, Chet Atkins"));
        songs.add(new Song(R.drawable.fatboy_slim, "Wonderful Night", "Fatboy Slim"));
        songs.add(new Song(R.drawable.regina_spektor, "Us", "Regina Spektor"));
        songs.add(new Song(R.drawable.borns, "Faded Heart", "BORNS"));

        // Create a {@link SongAdapter}, whose data source is a list of {@link Song}s.
        // The adapter knows how to create list items for each item in the list.
        SongAdapter adapter = new SongAdapter(this, songs);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // activity_list layout file.
        ListView listView = (ListView) findViewById(R.id.list);

        // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list.
        listView.setAdapter(adapter);

    }
}

