package com.example.makharij_ul_huruf;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class ghunna extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ghunna);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
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
}