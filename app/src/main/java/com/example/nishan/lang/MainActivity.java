package com.example.nishan.lang;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setContentView(R.layout.activity_main);

        // Get the ViewPager and set it's PagerAdapter so that it can display items
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(new SampleFragmentPagerAdapter(getSupportFragmentManager(),
                MainActivity.this));

        // Give the TabLayout the ViewPager
        TabLayout tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);

    }
       /* Log.v("MainActivity","create");


        //adding onclick listener to the numbers textview
        TextView numberTextView = findViewById(R.id.numbers);
        numberTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Numbers", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, NumbersActivity.class);
                startActivity(intent);
            }
        });

        //adding onclick listener for family textview
        TextView familyMembers = findViewById(R.id.family);
        familyMembers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Family", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, FamilyMembersActivity.class);
                startActivity(intent);
            }
        });

        //adding a onclick listener for Colors TextView
        TextView colorTextView = findViewById(R.id.colors);
        colorTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Colors", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, ColorsActivity.class);
                startActivity(intent);
            }
        });

        //adding a onclick listener for Colors TextView
        TextView phrasesTextView = findViewById(R.id.phrases);
        phrasesTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Phrases", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, PhrasesActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onStart(){
        super.onStart();
        Log.v("MainActivity","start");
    }

    @Override
    public void onPause(){
        super.onPause();
        Log.v("MainActivity","Pause");
    }

    @Override
    public void onResume(){
        super.onResume();
        Log.v("MainActivity","resume");
    }

    @Override
    public void onStop(){
        super.onStop();
        Log.v("MainActivity","Stop");
    }

    @Override
    public  void onDestroy(){
        super.onDestroy();
        Log.v("MainActivity","Destoyed");
    }
*/
}


