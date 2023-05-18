package com.example.progettoium;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ContattiActivity extends AppCompatActivity {

    ImageView contattaci;

    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contatti);

        drawerLayout = findViewById(R.id.drawer_layout);
        contattaci = findViewById(R.id.contattaci);

        contattaci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phone = "3881745648";
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null));
                startActivity(intent);
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
        redirectActivity(this, CompaniesActivity.class);
    }

    public void ClickChiSiamo(View view){
        closeDrawer(drawerLayout);
        redirectActivity(this, NoiActivity.class);
    }

    public void ClickContatti(View view){
        closeDrawer(drawerLayout);
    }

    private void redirectActivity(Activity old_activity, Class new_activity) {
        Intent intent = new Intent(old_activity, new_activity);
        old_activity.startActivity(intent);
    }
}