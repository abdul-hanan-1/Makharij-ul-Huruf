package com.example.makharij_ul_huruf;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class learn extends AppCompatActivity {
    private Button b1,b2,b3,b4,b5,halqiyah,lahatiyah;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        b3 = findViewById(R.id.b3);
        b4 = findViewById(R.id.b4);
        b5 = findViewById(R.id.b5);
        halqiyah = findViewById(R.id.halqiyah);
        lahatiyah = findViewById(R.id.lahatiyah);
        halqiyah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openHalqiyah();
            }
        });
        lahatiyah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLahatiyah();
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openHaafiyah();
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openTarfiyah();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openNiteeyah();
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLisaveyah();
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openGhunna();
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
// Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                Toast.makeText(getApplicationContext(),"No Settings Available!", Toast.LENGTH_LONG).show();
                break;
            case R.id.action_learn:
                Intent intent = new Intent(this, learn.class);
                startActivity(intent);
                break;
            case R.id.action_help:
                Toast.makeText(getApplicationContext(),"Ask help from Allah only.", Toast.LENGTH_LONG).show();
                break;
            default:
// If we got here, the user's action was not recognized.
// Invoke the superclass to handle it.

        }
        return super.onOptionsItemSelected(item);
    }

    public void openHalqiyah(){
        Intent intent = new Intent(this, halqiyah.class);
        startActivity(intent);
    }
    public void openHaafiyah(){
        Intent intent = new Intent(this, haafiyah.class);
        startActivity(intent);
    }
    public void openLahatiyah(){
        Intent intent = new Intent(this, lahatiyah.class);
        startActivity(intent);
    }
    public void openTarfiyah(){
        Intent intent = new Intent(this, tarfiyah.class);
        startActivity(intent);
    }
    public void openNiteeyah(){
        Intent intent = new Intent(this, niteeyah.class);
        startActivity(intent);
    }
    public void openLisaveyah(){
        Intent intent = new Intent(this, lisaveyah.class);
        startActivity(intent);
    }
    public void openGhunna(){
        Intent intent = new Intent(this, ghunna.class);
        startActivity(intent);
    }
}