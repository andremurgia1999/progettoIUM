package com.example.progettoium;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ViaggiActivity extends AppCompatActivity {

    ImageView slide1, slide2, slide3, slide4, slide5, slide6;
    Button button;

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

        button = findViewById(R.id.ButtonAggiungi);


        ViewPager mViewPager = (ViewPager) findViewById(R.id.viewPageAndroid);
        AndroidImageAdapter adapterView = new AndroidImageAdapter(this);
        mViewPager.setAdapter(adapterView);

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if(position == 0) {
                    slide1.setVisibility(View.VISIBLE);
                    slide2.setVisibility(View.GONE);
                    slide3.setVisibility(View.GONE);
                    slide4.setVisibility(View.GONE);
                    slide5.setVisibility(View.GONE);
                    slide6.setVisibility(View.GONE);
                }
                if(position == 1){
                    slide1.setVisibility(View.GONE);
                    slide2.setVisibility(View.VISIBLE);
                    slide3.setVisibility(View.GONE);
                    slide4.setVisibility(View.GONE);
                    slide5.setVisibility(View.GONE);
                    slide6.setVisibility(View.GONE);
                }
                if(position == 2){
                    slide1.setVisibility(View.GONE);
                    slide2.setVisibility(View.GONE);
                    slide3.setVisibility(View.VISIBLE);
                    slide4.setVisibility(View.GONE);
                    slide5.setVisibility(View.GONE);
                    slide6.setVisibility(View.GONE);
                }
                if(position == 3){
                    slide1.setVisibility(View.GONE);
                    slide2.setVisibility(View.GONE);
                    slide3.setVisibility(View.GONE);
                    slide4.setVisibility(View.VISIBLE);
                    slide5.setVisibility(View.GONE);
                    slide6.setVisibility(View.GONE);
                }
                if(position == 4){
                    slide1.setVisibility(View.GONE);
                    slide2.setVisibility(View.GONE);
                    slide3.setVisibility(View.GONE);
                    slide4.setVisibility(View.GONE);
                    slide5.setVisibility(View.VISIBLE);
                    slide6.setVisibility(View.GONE);
                }
                if(position == 5){
                    slide1.setVisibility(View.GONE);
                    slide2.setVisibility(View.GONE);
                    slide3.setVisibility(View.GONE);
                    slide4.setVisibility(View.GONE);
                    slide5.setVisibility(View.GONE);
                    slide6.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    public void ClickUpload(View view){
        finish();
        redirectActivity(this, UploadActivity.class);
    }

    public void ClickBack(View view){
        finish();
    }

    private void redirectActivity(Activity old_activity, Class new_activity) {
        Intent intent = new Intent(old_activity, new_activity);
        old_activity.startActivity(intent);
    }
}