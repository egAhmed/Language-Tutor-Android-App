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
public class PhrasesFragment extends android.support.v4.app.Fragment {

    public static final String ARG_PAGE = "PHRASE_FRAG";

    MediaPlayer mediaPlayer;

    private void relaseMediaPlayer() {
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

    MediaPlayer.OnCompletionListener completionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            relaseMediaPlayer();
        }
    };

    @Override
    public void onStop(){
        super.onStop();
        Log.v("Numberactivity","onStop");
        if(mediaPlayer!=null){
            relaseMediaPlayer();
        }
    }

    public PhrasesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.word_list,container,false);



        //setup a colors
        final ArrayList<Word> familyList = new ArrayList<Word>();
        for (int i = 0; i < 3; i++) {
            familyList.add(new Word("How Are You", "hege idhiri", R.raw.thirty));
            familyList.add(new Word("How Old Are You", "Nimge yestu varsha", R.raw.negative));
            familyList.add(new Word("What is your Name", "Nimma hesaru yenu", R.raw.thousand));
            familyList.add(new Word("Where are you From", "nimma Uru Yavudhu", R.raw.four));
        }

        //setup a word adapter
        WordAdapter wordAdapter = new WordAdapter(getActivity(), familyList, R.color.category_phrases);

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

}
