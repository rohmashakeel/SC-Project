package com.example.rohma.secureit;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static com.example.rohma.secureit.R.id.rc_button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button rc_button;
    private Button stats_button;
    private Button map_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rc_button = (Button)findViewById(R.id.rc_button);
        stats_button = (Button) findViewById(R.id.stats_button);
        map_button = (Button) findViewById(R.id.map_button);

        rc_button.setOnClickListener(this);
        stats_button.setOnClickListener(this);
        map_button.setOnClickListener(this);
    }

    @Override
     public void onClick(View v){

        if(v==rc_button){
            openRC();
        }
        if(v==stats_button){
            //try {
                openStats();
            //}
            //catch IllegalStateException
        }
        //if(v==map_button){
          //  openMap();
        //}
    }

    public void openRC()
    {
        Intent intent1 = new Intent(MainActivity.this, ReportCrime.class);
        startActivity(intent1);

    }

    public void openStats()
    {
        Intent intent2 = new Intent(MainActivity.this, Statistics.class);
        startActivity(intent2);

    }

    public void openMap()
    {
        //Intent intent1 = new Intent(MainActivity.this, Map.class);
        //startActivity(intent1);

    }
}
