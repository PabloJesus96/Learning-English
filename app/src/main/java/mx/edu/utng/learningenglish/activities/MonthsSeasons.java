package mx.edu.utng.learningenglish.activities;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import mx.edu.utng.learningenglish.R;
import mx.edu.utng.learningenglish.activities.listener.Months;
import mx.edu.utng.learningenglish.activities.listener.SeasonsListenerActivity;
import mx.edu.utng.learningenglish.activities.test.TestMonthsSeasonsActivity;
import mx.edu.utng.learningenglish.adapters.ActivitiesAdapter;
import mx.edu.utng.learningenglish.model.Activities;

public class MonthsSeasons extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_item);
        this.setTitle("Months and Seasons");

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        final RecyclerView rvList = (RecyclerView)findViewById(R.id.rv_list);
        rvList.setHasFixedSize(true);
        LinearLayoutManager manager = new GridLayoutManager(MonthsSeasons.this, 2);
        rvList.setLayoutManager(manager);

        List<Activities> activitiesList = new ArrayList<Activities>();
        activitiesList.add(new Activities(R.drawable.months_year, "Months", "Listening",R.color.enable));
        activitiesList.add(new Activities(R.drawable.seasons, "The Seasons", "Listening",R.color.enable));
        activitiesList.add(new Activities(R.drawable.test, "Test", "Final Test Activity",R.color.enable));

        ActivitiesAdapter adapter = new ActivitiesAdapter(activitiesList);
        adapter.setOnclicListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(rvList.getChildPosition(v)){
                    case 0:
                         startActivity(new Intent(getApplicationContext(),Months.class));
                        break;
                    case 1:
                        startActivity(new Intent(getApplicationContext(),SeasonsListenerActivity.class));
                        break;
                    case 2:
                        startActivity(new Intent(getApplicationContext(),TestMonthsSeasonsActivity.class));
                        break;
                }
            }
        });
        rvList.setAdapter(adapter);
    }
}
