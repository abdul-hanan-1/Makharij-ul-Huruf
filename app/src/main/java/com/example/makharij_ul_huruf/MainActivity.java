package com.example.makharij_ul_huruf;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button button1,button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = findViewById(R.id.repolink);
        button2 = findViewById(R.id.home);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("https://github.com/abdul-hanan-1/Makharij-ul-Huruf.git");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openHome();
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

    public void openHome(){
        Intent intent = new Intent(this, home.class);
        startActivity(intent);
    }

}