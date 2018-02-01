package com.example.nishan.lang;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by nishan on 28-01-2018.
 */

public class WordAdapter extends ArrayAdapter<Word> {

    private int colorResid;

    //constructor
    public WordAdapter(Activity Context, ArrayList<Word> item,int colorResid) {
        super(Context, 0, item);
        this.colorResid=colorResid;
    }


    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        View listView = convertView;

        //setiing up reusable layout
        if (listView==null){
            listView= LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
        }

        //finding a current object
        Word currentWord=getItem(position);



        //setting English Text
        TextView english=(TextView)listView.findViewById(R.id.mainText);
        english.setText(currentWord.getEnglishTransLation());

        //Setting Kannada Text
        TextView kannada=listView.findViewById(R.id.subText);
        kannada.setText(currentWord.getKannadaTranslation());

        //setting up image
        ImageView imageView = listView.findViewById(R.id.word_image);
        if(currentWord.hasImage()) {
            imageView.setImageResource(currentWord.getImgId());
            imageView.setVisibility(View.VISIBLE);
        }else {
            imageView.setVisibility(View.GONE);
        }

        //set color for the list
        View textContainer=listView.findViewById(R.id.text_container);

        int color= ContextCompat.getColor(getContext(),colorResid);

        textContainer.setBackgroundColor(color);

        return listView;
    }
}
