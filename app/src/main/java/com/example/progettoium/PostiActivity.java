package com.example.progettoium;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.ZoomControls;

public class PostiActivity extends AppCompatActivity {

    ZoomControls zoomControls, zoomControls2, zoomControls3, zoomControls4;
    ImageView imageView, imageView2, imageView3, imageView4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posti);

        zoomControls = findViewById(R.id.zoom);
        zoomControls2 = findViewById(R.id.zoom2);
        zoomControls3 = findViewById(R.id.zoom3);
        zoomControls4 = findViewById(R.id.zoom4);
        imageView = findViewById(R.id.seatmap);
        imageView2 = findViewById(R.id.seatmap2);
        imageView3 = findViewById(R.id.seatmap3);
        imageView4 = findViewById(R.id.seatmap4);

        zoomControls.setVisibility(View.VISIBLE);
        zoomControls2.setVisibility(View.GONE);
        zoomControls3.setVisibility(View.GONE);
        zoomControls4.setVisibility(View.GONE);


        zoomControls.setOnZoomInClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        imageView.setVisibility(View.VISIBLE);
                        imageView2.setVisibility(View.GONE);
                        zoomControls.setVisibility(View.VISIBLE);
                        zoomControls2.setVisibility(View.GONE);
                    }
                }
        );

        zoomControls.setOnZoomOutClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        imageView.setVisibility(View.GONE);
                        imageView2.setVisibility(View.VISIBLE);
                        zoomControls.setVisibility(View.GONE);
                        zoomControls2.setVisibility(View.VISIBLE);
                    }
                }
        );


        zoomControls2.setOnZoomInClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        imageView.setVisibility(View.VISIBLE);
                        imageView2.setVisibility(View.GONE);
                        zoomControls.setVisibility(View.VISIBLE);
                        zoomControls2.setVisibility(View.GONE);
                    }
                }
        );

        zoomControls2.setOnZoomOutClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        imageView2.setVisibility(View.GONE);
                        imageView3.setVisibility(View.VISIBLE);
                        zoomControls2.setVisibility(View.GONE);
                        zoomControls3.setVisibility(View.VISIBLE);
                    }
                }
        );

        zoomControls3.setOnZoomInClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        imageView2.setVisibility(View.VISIBLE);
                        imageView3.setVisibility(View.GONE);
                        zoomControls2.setVisibility(View.VISIBLE);
                        zoomControls3.setVisibility(View.GONE);
                    }
                }
        );

        zoomControls3.setOnZoomOutClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        imageView3.setVisibility(View.GONE);
                        imageView4.setVisibility(View.VISIBLE);
                        zoomControls3.setVisibility(View.GONE);
                        zoomControls4.setVisibility(View.VISIBLE);
                    }
                }
        );

        zoomControls4.setOnZoomInClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        imageView3.setVisibility(View.VISIBLE);
                        imageView4.setVisibility(View.GONE);
                        zoomControls3.setVisibility(View.VISIBLE);
                        zoomControls4.setVisibility(View.GONE);
                    }
                }
        );

        zoomControls4.setOnZoomOutClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                    }
                }
        );
    }

    public void ClickSeleziona(View view){
        finish();
    }
    public void ClickBack(View view){
        finish();
    }
}