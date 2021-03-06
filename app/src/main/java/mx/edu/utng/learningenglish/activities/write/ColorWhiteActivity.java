package mx.edu.utng.learningenglish.activities.write;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import mx.edu.utng.learningenglish.R;
import mx.edu.utng.learningenglish.activities.AudioService;
import mx.edu.utng.learningenglish.adapters.WritingAdapter;
import mx.edu.utng.learningenglish.model.ActivityWriting;

/**
 * Created by Husky Siberiano on 26/02/2017.
 */

public class ColorWhiteActivity extends AppCompatActivity {
    private EditText etColorWriting;
    private TextView tvColor;
    private WritingAdapter adapter;
    private List<ActivityWriting> writings = new ArrayList<ActivityWriting>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_item);
        this.setTitle("What color is?");
        ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        this.setVolumeControlStream(AudioManager.STREAM_MUSIC);

        initComponents();
    }

    public void initComponents(){

        final RecyclerView rvList = (RecyclerView)findViewById(R.id.rv_list);
        rvList.setHasFixedSize(true);
        LinearLayoutManager manager = new LinearLayoutManager(ColorWhiteActivity.this);
        rvList.setLayoutManager(manager);


        writings.add(new ActivityWriting(R.drawable.white_writing, "escribe el color indicado:", " _ H I _ E  ", "",R.color.enable));
        adapter = new WritingAdapter(writings);

        adapter.setListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.bt_completed:
                        etColorWriting = (EditText)findViewById(R.id.et_writing_complete);
                        tvColor  = (TextView)findViewById(R.id.et_writing_color);
                        etColorWriting.getText().toString();
                        String colorcito = etColorWriting.getText().toString();

                        if(colorcito.equalsIgnoreCase("white")){
                            tvColor.setText("W H I T E  ");
                            tvColor.setTextColor(getResources().getColor(R.color.white));

                            int secondsDelayed = 1000;
                            new Handler().postDelayed(new Runnable() {
                                public void run() {
                                    AlertDialog.Builder builder = new AlertDialog.Builder(ColorWhiteActivity.this);
                                    builder.setMessage("\nEL SIGUIENTE COLOR ES:")
                                            .setTitle(Html.fromHtml("<font color='#FF0000'><b>¡ C O R R E C T O ! </b></font>"))
                                            .setIcon(getResources().getDrawable(R.drawable.winner_acv))
                                            .setPositiveButton("ACEPTAR", new DialogInterface.OnClickListener() {
                                                public void onClick(DialogInterface dialog, int id) {
                                                    startActivity(new Intent(ColorWhiteActivity.this,ColorBlueActivity.class));
                                                }
                                            });
                                    builder.show();
                                    //finish();
                                }
                            }, secondsDelayed);

                        }else {
                            Toast toast = Toast.makeText(getApplicationContext(),"has escrito un color incorrecto: " + etColorWriting.getText().toString(), Toast.LENGTH_LONG);
                            toast.setGravity(Gravity.CENTER|Gravity.CENTER,0,0);
                            toast.show();
                            break;
                        }
                }
            }
        });
        rvList.setAdapter(adapter);
    }

    @Override
    public void onResume() {
        super.onResume();
        Intent i = new Intent(this, AudioService.class);
        i.putExtra("action", AudioService.START);
        startService(i);
    }

    @Override
    public void onPause() {
        super.onPause();
        Intent i = new Intent(this, AudioService.class);
        i.putExtra("action", AudioService.PAUSE);
        startService(i);
    }

}