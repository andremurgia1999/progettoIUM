package com.example.progettoium;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ViaggiActivity extends AppCompatActivity {

    ImageView slide1, slide2, slide3, slide4, slide5, slide6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viaggi);

        slide1 = findViewById(R.id.slide1);
        slide2 = findViewById(R.id.slide2);
        slide3 = findViewById(R.id.slide3);
        slide4 = findViewById(R.id.slide4);
        slide5 = findViewById(R.id.slide5);
        slide6 = findViewById(R.id.slide6);


        ViewPager mViewPager = (ViewPager) findViewById(R.id.viewPageAndroid);
        AndroidImageAdapter adapterView = new AndroidImageAdapter(this);
        mViewPager.setAdapter(adapterView);

        adapterView.getCurrentImageResource(mViewPager.getCurrentItem());


        if(adapterView.getCurrentImageResource(mViewPager.getCurrentItem()) ==  R.drawable.roma1)
            slide1.setVisibility(View.VISIBLE);
        if(adapterView.getCurrentImageResource(mViewPager.getCurrentItem()) ==  R.drawable.roma2){
            slide1.setVisibility(View.GONE);
            slide2.setVisibility(View.VISIBLE);
        }


    }
}