package com.example.progettoium;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class CompaniesActivity extends AppCompatActivity {

    CardView volotea, ryanair, easyjet, meridiana, emirates, etihad, airitaly, airfrance;

    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_companies);

        volotea = findViewById(R.id.volotea);
        ryanair = findViewById(R.id.ryanair);
        easyjet = findViewById(R.id.easyjet);
        meridiana = findViewById(R.id.meridiana);
        emirates = findViewById(R.id.emirates);
        etihad = findViewById(R.id.etihad);
        airitaly = findViewById(R.id.airitaly);
        airfrance = findViewById(R.id.airfrance);

        drawerLayout = findViewById(R.id.drawer_layout);

        volotea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://volotea.com";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        ryanair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://ryanair.com";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        easyjet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://easyjet.com";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        meridiana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://ita-airways.com";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        emirates.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://emirates.com";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        etihad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://etihad.com";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        airitaly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://airitaly.com";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        airfrance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://airfrance.com";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
    }

    private void openDrawer(DrawerLayout drawerLayout) {
        drawerLayout.openDrawer(GravityCompat.START);
    }

    private void closeDrawer(DrawerLayout drawerLayout){
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }

    public void ClickMenu(View view){
        openDrawer(drawerLayout);
    }

    public void ClickLogo(View view){
        closeDrawer(drawerLayout);
    }

    public void ClickHome(View view){
        closeDrawer(drawerLayout);
        redirectActivity(this, MainActivity.class);
    }

    public void ClickReviews(View view){
        closeDrawer(drawerLayout);
        redirectActivity(this, ReviewsActivity.class);
    }

    public void ClickCompanies(View view){
        closeDrawer(drawerLayout);
    }

    public void ClickChiSiamo(View view){
        closeDrawer(drawerLayout);
        redirectActivity(this, NoiActivity.class);
    }

    public void ClickContatti(View view){
        closeDrawer(drawerLayout);
        redirectActivity(this, ContattiActivity.class);
    }

    private void redirectActivity(Activity old_activity, Class new_activity) {
        Intent intent = new Intent(old_activity, new_activity);
        old_activity.startActivity(intent);
    }
}