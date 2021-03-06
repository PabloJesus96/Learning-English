package mx.edu.utng.learningenglish.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import mx.edu.utng.learningenglish.R;
import mx.edu.utng.learningenglish.activities.listener.ClothesListenerActivity;
import mx.edu.utng.learningenglish.activities.listener.FamilyListenerActivity;
import mx.edu.utng.learningenglish.activities.test.TestFamilyClothes;
import mx.edu.utng.learningenglish.activities.write.ClothesWriteActivity;
import mx.edu.utng.learningenglish.activities.write.FamilyWriteActivity;
import mx.edu.utng.learningenglish.adapters.ActivitiesAdapter;
import mx.edu.utng.learningenglish.model.Activities;

/**
 * Created by Husky Siberiano on 04/02/2017.
 */
public class FamilyClothes extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_item);
        this.setTitle("Family and Clothes");

        ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        final RecyclerView rvList = (RecyclerView)findViewById(R.id.rv_list);
        rvList.setHasFixedSize(true);
        LinearLayoutManager manager = new GridLayoutManager(FamilyClothes.this, 2);
        rvList.setLayoutManager(manager);

        List<Activities> activitiesList = new ArrayList<Activities>();
        activitiesList.add(new Activities(R.drawable.ic_family_listening, "Family", "Listening",R.color.enable));
        activitiesList.add(new Activities(R.drawable.ic_clothes_listening, "Clothes", "Listening",R.color.enable));
        activitiesList.add(new Activities(R.drawable.ic_family_writing, "Family", "Writing",R.color.enable));
        activitiesList.add(new Activities(R.drawable.ic_clothes_listening, "Clothes", "Writing",R.color.enable));
        activitiesList.add(new Activities(R.drawable.test, "Test", "Final Test Activity",R.color.enable));

        ActivitiesAdapter adapter = new ActivitiesAdapter(activitiesList);
        adapter.setOnclicListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(rvList.getChildPosition(v)){
                    case 0:
                        startActivity(new Intent(getApplicationContext(),FamilyListenerActivity.class));
                        break;
                    case 1:
                        startActivity(new Intent(getApplicationContext(),ClothesListenerActivity.class));
                        break;
                    case 2:
                        startActivity(new Intent(getApplicationContext(),FamilyWriteActivity.class));
                        break;
                    case 3:
                        startActivity(new Intent(getApplicationContext(),ClothesWriteActivity.class));
                        break;
                    case 4:
                        startActivity(new Intent(getApplicationContext(),TestFamilyClothes.class));
                        break;
                }
            }
        });
        rvList.setAdapter(adapter);
    }
}
