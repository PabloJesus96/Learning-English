package mx.edu.utng.learningenglish.activities.test;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;

import mx.edu.utng.learningenglish.R;
import mx.edu.utng.learningenglish.activities.MonthsSeasons;
import mx.edu.utng.learningenglish.menu.MainActivity;
import mx.edu.utng.learningenglish.sqlite.DbHelper;

public class TestMonthsSeasonsActivity extends AppCompatActivity implements View.OnClickListener {
    private RadioButton rbJanuary;
    private RadioButton rbDecember;
    private RadioButton rbJune;
    private RadioButton rbAugust;
    private RadioButton rbApril;
    private EditText etSummer;
    private EditText etWinter;
    private EditText etFall;
    private EditText etSpring;
    private EditText etNovember;
    private ImageView ivSendAC;
    private DbHelper db;
    private String idUser;
    private final static String SETTING_USER = "setting_user";
    private String user;
    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_months_seasons);
        this.setTitle("Test Months and Seasons");

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        rbJanuary = (RadioButton)findViewById(R.id.rb_january);
        rbDecember = (RadioButton)findViewById(R.id.rb_december);
        rbJune = (RadioButton)findViewById(R.id.rb_june);
        rbAugust = (RadioButton)findViewById(R.id.rb_august);
        rbApril = (RadioButton)findViewById(R.id.rb_april);
        etSummer =(EditText)findViewById(R.id.et_summer_t);
        etWinter =(EditText)findViewById(R.id.et_winter_t);
        etFall =(EditText)findViewById(R.id.et_fall_t);
        etSpring =(EditText)findViewById(R.id.et_spring_t);
        etNovember =(EditText)findViewById(R.id.et_november);
        ivSendAC =(ImageView) findViewById(R.id.iv_send_ac);

        etSummer.getText().toString();
        etWinter.getText().toString();
        etFall.getText().toString();
        etSpring.getText().toString();
        etNovember.getText().toString();

        rbJanuary.setOnClickListener(this);
        rbDecember.setOnClickListener(this);
        rbJune.setOnClickListener(this);
        rbAugust.setOnClickListener(this);
        rbApril.setOnClickListener(this);
        etSummer.setOnClickListener(this);
        etWinter.setOnClickListener(this);
        etFall.setOnClickListener(this);
        etSpring.setOnClickListener(this);
        etNovember.setOnClickListener(this);
        ivSendAC.setOnClickListener(this);

        db = new DbHelper(this);
    }

    @Override
    public void onClick(View v) {
        int scoreTest = 0;
        String summer = etSummer.getText().toString();
        String winter = etWinter.getText().toString();
        String fall = etFall.getText().toString();
        String spring = etSpring.getText().toString();
        String november =  etNovember.getText().toString();

        if(rbJanuary.isChecked()){
            scoreTest = scoreTest + 1;
        }
        if(rbDecember.isChecked()){
            scoreTest = scoreTest + 1;
        }
        if(rbAugust.isChecked()){
            scoreTest=scoreTest+1;
        }
        if(rbApril.isChecked()){
            scoreTest=scoreTest+1;
        }
        if(rbJune.isChecked()){
            scoreTest = scoreTest + 1;
        }
        if(summer.equalsIgnoreCase("SUMMER")){
            scoreTest = scoreTest + 1;
        }
        if(winter.equalsIgnoreCase("WINTER")){
            scoreTest = scoreTest + 1;
        }
        if(fall.equalsIgnoreCase("FALL")){
            scoreTest=scoreTest+1;
        }
        if(spring.equalsIgnoreCase("SPRING")){
            scoreTest=scoreTest+1;
        }
        if(november.equalsIgnoreCase("NOVEMBER")){
            scoreTest=scoreTest+1;
        }

        int scoreFinal = scoreTest;
        if(ivSendAC.isPressed()){
            sharedPreferences = getApplicationContext().getSharedPreferences("recuperardatos", Context.MODE_PRIVATE);
            user = sharedPreferences.getString(SETTING_USER,"");
            idUser = db.getIdUser(user);
            Log.i("el id del usuario es ", idUser);
            String data = db.getScore(idUser, 5);
            if(data!=null){
                db.updateScore(idUser,5,String.valueOf(scoreTest));
            }else{
                db.addScore(String.valueOf(scoreTest),idUser,5);
            }
            if (scoreTest>=8) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(TestMonthsSeasonsActivity.this);
                builder.setTitle(Html.fromHtml("<font color='#FF0000'><b>¡ F E L I C I D A D E S ! </b></font>"))
                        .setIcon(getResources().getDrawable(R.drawable.winner_acv))
                        .setMessage("HAS CONCLUIDO LA ACTIVIDAD MONTHS AND SEASONS," +
                                " AHORA PUEDES SEGUIR CON LA SIGUIENTE ACTIVIDAD:" +
                                Html.fromHtml("<b>TEST FINAL.</b>"))
                        .setPositiveButton("ACEPTAR", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                            }
                        });
                builder.show();
            }else{
                final AlertDialog.Builder builderFather = new AlertDialog.Builder(TestMonthsSeasonsActivity.this);
                builderFather.setTitle(Html.fromHtml("<font color='#FF0000'><b>¡ I N C O R R E C T O ! </b></font>"))
                        .setIcon(getResources().getDrawable(R.drawable.winner_acv))
                        .setMessage("LO SENTIMOS, PARA PODER PASAR ESTE TEST TIENES QUE " +
                                "OBTENER UNA CALIFICACION MAYOR Ó IGUAL A 8, TU CALIFICACIÓN " +
                                "ACTUAL ES: " + scoreFinal)
                        .setPositiveButton("ACEPTAR", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                startActivity(new Intent(getApplicationContext(), MonthsSeasons.class));
                            }
                        });
                builderFather.show();
            }
        }

    }
}
