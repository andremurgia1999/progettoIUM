package com.example.progettoium;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.ZoomControls;

public class PostiActivity extends AppCompatActivity {

    ZoomControls zoomControls;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posti);

        zoomControls = findViewById(R.id.zoom);
        imageView = findViewById(R.id.seatmap);

        zoomControls.setOnZoomInClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        float x=imageView.getScaleX();
                        float y=imageView.getScaleY();

                        // setting the new scale
                        imageView.setScaleX((float)(x+0.5f));
                        imageView.setScaleY((float)(y+0.5f));
                    }
                }
        );

        zoomControls.setOnZoomOutClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        float x=imageView.getScaleX();
                        float y=imageView.getScaleY();
                        if(x==1 && y==1)
                        {
                            // the scale will remain same,since
                            // it is maximum possible zoom out
                            imageView.setScaleX((float)(x));
                            imageView.setScaleY((float)(y));
                        }
                        else
                        {
                            // setting the new scale
                            imageView.setScaleX((float)(x-0.5f));
                            imageView.setScaleY((float)(y-0.5f));
                        }
                    }
                }
        );
    }
}