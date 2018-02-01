package com.example.nishan.lang;


import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class FamilyFragment extends android.support.v4.app.Fragment {

    public static final String ARG_PAGE = "FAMILY_FRAG";

    /**
     * MediaPlayer Class is to Play Audio for each listItem
     */
    MediaPlayer mediaPlayer;

    /**
     * Clear the mediaPlayer Object for optimal resuorce allocation
     * and clearing the object before object is reinlitialized
     */
    private void relaseMediaPlayer() {
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

    /**
     * This listner will be waiting for the audio to finished playing
     * after it calls relasemedia Player Method
     */
    MediaPlayer.OnCompletionListener completionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            relaseMediaPlayer();
        }
    };


    public FamilyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        /**
         * This is to create View object and Tranfer to the called activity
         * Inflater converts layout to view
         */
        View rootView = inflater.inflate(R.layout.word_list, container, false);


        //setup a colors
        final ArrayList<Word> familyList = new ArrayList<Word>();
        for (int i = 0; i < 3; i++) {
            familyList.add(new Word("Dad", "Appa", R.drawable.family_father, R.raw.seven));
            familyList.add(new Word("Mom", "Amma", R.drawable.family_mother, R.raw.six));
            familyList.add(new Word("Uncle", "Mava", R.drawable.family_older_brother, R.raw.million));
            familyList.add(new Word("Aunty", "aunty", R.drawable.family_grandmother, R.raw.fifty));
        }

        //setup a word adapter
        WordAdapter wordAdapter = new WordAdapter(getActivity(), familyList, R.color.category_family);

        //find out list
        ListView listView = rootView.findViewById(R.id.list);

        //set wordadapter
        listView.setAdapter(wordAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Word temp = familyList.get(i);
                relaseMediaPlayer();
                mediaPlayer = MediaPlayer.create(getActivity(), temp.getAudioId());
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(completionListener);
            }
        });


        return rootView;
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.v("Numberactivity", "onStop");
        if (mediaPlayer != null) {
            relaseMediaPlayer();
        }
    }

}
