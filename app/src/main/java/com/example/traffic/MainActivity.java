package com.example.traffic;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.traffic.Adapter.trafficAdapter;
import com.example.traffic.Modules.Traffic;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;

    RecyclerView recyclerView;

trafficAdapter trafficAdapter;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:

                    FillArray.getExamp();
                    trafficAdapter.changeData(FillArray.fillPreventionSigns());
                    return true;

                case R.id.navigation_dashboard:

                    trafficAdapter.changeData(FillArray.fillLandSigns());
                    return true;

                case R.id.navigation_notifications:

                    trafficAdapter.changeData(FillArray.fillReportSigns());
                    return true;

                case R.id.navigation_exam:

                    Intent intent = new Intent(getApplication().getBaseContext(),ExamActivity.class);
                    startActivity(intent);
                    return true;

            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        recyclerView=findViewById(R.id.rec);

        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));


        //recyclerView.setLayoutManager(new GridLayoutManager(this,3,LinearLayoutManager.VERTICAL,false));


        ArrayList<Traffic> trafficlist = new ArrayList<>();

        trafficlist = FillArray.fillPreventionSigns();
        trafficAdapter=new trafficAdapter(trafficlist);
        recyclerView.setAdapter(trafficAdapter);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
