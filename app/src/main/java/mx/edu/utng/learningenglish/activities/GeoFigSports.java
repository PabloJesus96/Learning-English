package mx.edu.utng.learningenglish.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import mx.edu.utng.learningenglish.R;
import mx.edu.utng.learningenglish.activities.listener.GeometricFiguresListenerActivity;
import mx.edu.utng.learningenglish.activities.listener.Sport;
import mx.edu.utng.learningenglish.activities.test.TestSportFigure;
import mx.edu.utng.learningenglish.activities.write.GeometricFiguresWriteActivity;
import mx.edu.utng.learningenglish.activities.write.SportWrite;
import mx.edu.utng.learningenglish.adapters.ActivitiesAdapter;
import mx.edu.utng.learningenglish.model.Activities;

/**
 * Created by Husky Siberiano on 10/02/2017.
 */

public class GeoFigSports extends ActionBarActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_item);
        this.setTitle("Geometric Figures and\n Sports");
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        final RecyclerView rvList = (RecyclerView)findViewById(R.id.rv_list);
        rvList.setHasFixedSize(true);
        LinearLayoutManager manager = new GridLayoutManager(GeoFigSports.this, 2);
        rvList.setLayoutManager(manager);

        List<Activities> activitiesList = new ArrayList<Activities>();
        activitiesList.add(new Activities(R.drawable.ic_figures_listening, "Geometric Figures", "Listening",R.color.enable));
        activitiesList.add(new Activities(R.drawable.ic_sports_listening, "Sports", "Listening",R.color.enable));
        activitiesList.add(new Activities(R.drawable.ic_figures_writing, "Geometric Figures", "Writing",R.color.enable));
        activitiesList.add(new Activities(R.drawable.ic_sports_writing, "Sports", "Writing",R.color.enable));
        activitiesList.add(new Activities(R.drawable.test, "Test", "Final Test Activity",R.color.enable));

        ActivitiesAdapter adapter = new ActivitiesAdapter(activitiesList);
        adapter.setOnclicListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(rvList.getChildPosition(v)){
                    case 0:
                       startActivity(new Intent(getApplicationContext(),GeometricFiguresListenerActivity.class));
                        break;
                    case 1:
                        startActivity(new Intent(getApplicationContext(),Sport.class));
                        break;
                    case 2:
                        startActivity(new Intent(getApplicationContext(),GeometricFiguresWriteActivity.class));
                        break;
                    case 3:
                        startActivity(new Intent(getApplicationContext(),SportWrite.class));
                        break;
                    case 4:
                        startActivity(new Intent(getApplicationContext(),TestSportFigure.class));
                        break;
                }
            }
        });
        rvList.setAdapter(adapter);
    }
}
