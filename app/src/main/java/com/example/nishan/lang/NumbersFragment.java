package com.example.nishan.lang;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Fragment;
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
public class NumbersFragment extends android.support.v4.app.Fragment {

    public static final String ARG_PAGE = "NUMBER_FRAG";

    private MediaPlayer mediaPlayer;

    MediaPlayer.OnCompletionListener completionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            relaseMediaPlayer();
        }
    };

    private void relaseMediaPlayer() {
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

    public NumbersFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);

        //ArrayList for English Words Form 1-10 3times
        final ArrayList<Word> numbers = new ArrayList<Word>();
        for (int i = 0; i < 3; i++) {
            numbers.add(new Word("one", "ondu", R.drawable.number_one, R.raw.one));
            numbers.add(new Word("two", "yeradu", R.drawable.number_two, R.raw.two));
            numbers.add(new Word("three", "muru", R.drawable.number_three, R.raw.three));
            numbers.add(new Word("four", "nalku", R.drawable.number_four, R.raw.four));
            numbers.add(new Word("five", "Aidu", R.drawable.number_five, R.raw.five));
            numbers.add(new Word("six", "Aru", R.drawable.number_six, R.raw.six));
            numbers.add(new Word("seven", "Aelu", R.drawable.number_seven, R.raw.seven));
            numbers.add(new Word("eight", "entu", R.drawable.number_eight, R.raw.three));
            numbers.add(new Word("nine", "ombathu", R.drawable.number_nine, R.raw.nine));
            numbers.add(new Word("ten", "hathu", R.drawable.number_ten, R.raw.negative));
        }


        //Dynamically creating a textview child element form the AraayList

        WordAdapter wordAdapter = new WordAdapter(getActivity(), numbers, R.color.category_numbers);
        // ArrayAdapter<Word> itemAdapter = new ArrayAdapter<Word>(this,R.layout.list_item, numbers);

        ListView listView = rootView.findViewById(R.id.list);

        listView.setAdapter(wordAdapter);

        //setting listner for list object

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                final Word temp = numbers.get(i);
                relaseMediaPlayer();
                mediaPlayer = MediaPlayer.create(getActivity(), temp.getAudioId());
                mediaPlayer.start();
                //Completion Listners
                mediaPlayer.setOnCompletionListener(completionListener);

            }
        });
        return rootView;
    }

    @Override
    public void onStop() {
        super.onStop();

        // When the activity is stopped, release the media player resources because we won't
        // be playing any more sounds.
        relaseMediaPlayer();
    }

}
