package mx.edu.utng.learningenglish.menu;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import android.view.LayoutInflater;
import android.widget.ImageView;

import mx.edu.utng.learningenglish.activities.AboutActivity;
import mx.edu.utng.learningenglish.activities.MonthsSeasons;
import mx.edu.utng.learningenglish.activities.ResourceLearnSongs;
import mx.edu.utng.learningenglish.activities.TableroLogros;
import mx.edu.utng.learningenglish.login.PrefManager;
import mx.edu.utng.learningenglish.R;
import mx.edu.utng.learningenglish.activities.test.Test;
import mx.edu.utng.learningenglish.activities.AlphabetNumbers;
import mx.edu.utng.learningenglish.activities.AnimalsColors;
import mx.edu.utng.learningenglish.activities.FamilyClothes;
import mx.edu.utng.learningenglish.activities.GeoFigSports;
import mx.edu.utng.learningenglish.sqlite.DbHelper;
import mx.edu.utng.learningenglish.login.LoginActivity;
import mx.edu.utng.learningenglish.login.Session;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private ImageButton ibActivity1;
    private ImageButton ibActivity2;
    private ImageButton ibActivity3;
    private ImageButton ibActivity4;
    private ImageButton ibActivity6;
    private ImageView ivTest;
    private TextView tvAbNu;
    private TextView tvAnCo;
    private TextView tvFaRo;
    private TextView tvFgDe;
    private TextView tvMonSea;
    private Session session;
    DbHelper helper;
    private String idUser;
    private final static String SETTING_USER = "setting_user";
    private String user;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        LayoutInflater inflater = getLayoutInflater();
        inflater.inflate(R.layout.activity_main, null);

        ibActivity1 = (ImageButton)findViewById(R.id.ib_activity_1);
        ibActivity2 = (ImageButton)findViewById(R.id.ib_activity_2);
        ibActivity3 = (ImageButton)findViewById(R.id.ib_activity_3);
        ibActivity4 = (ImageButton)findViewById(R.id.ib_activity_4);
        ibActivity6 = (ImageButton)findViewById(R.id.ib_activity_6);
        ivTest =(ImageView)findViewById(R.id.iv_certificate);
        tvAbNu = (TextView)findViewById(R.id.tv_al_nu);
        tvAnCo = (TextView)findViewById(R.id.tv_an_co);
        tvFaRo = (TextView)findViewById(R.id.tv_fa_ro);
        tvFgDe = (TextView)findViewById(R.id.tv_fg_de);
        tvMonSea = (TextView)findViewById(R.id.tv_mon_sea);
        tvAbNu.setText("Alphabet\nNumbers");
        tvAnCo.setText("Animal\nColors");
        tvFaRo.setText("Family\nClothes");
        tvFgDe.setText("Geometric Figures\nSports");
        tvMonSea.setText("Mounth\nSeasons");

        helper = new DbHelper(this);
        sharedPreferences = getApplicationContext().getSharedPreferences("recuperardatos", Context.MODE_PRIVATE);
        user = sharedPreferences.getString(SETTING_USER,"");
        idUser = helper.getIdUser(user);
        String calif1 = helper.getScore(idUser, 1);
        String calif2 = helper.getScore(idUser, 2);
        String calif3 = helper.getScore(idUser, 3);
        String calif4 = helper.getScore(idUser, 4);
        String calif5 = helper.getScore(idUser, 5);
        //String calif6 = helper.getScore(idUser, 6);
        //String calif7 = helper.getScore(idUser, 7);
        //String calif8 = helper.getScore(idUser, 8);

        if(calif1==null || Double.valueOf(calif1) < 8){
            ibActivity2.setBackgroundResource(R.drawable.button_unactivated);
        }else if(Double.valueOf(calif1) >= 8){
            ibActivity2.setBackgroundResource(R.drawable.button_circle);
        }
        if(calif2==null || Double.valueOf(calif2) < 8){
            ibActivity3.setBackgroundResource(R.drawable.button_unactivated);
        }else if(Double.valueOf(calif2) >= 8){
            ibActivity3.setBackgroundResource(R.drawable.button_circle);
        }
        if(calif3==null || Double.valueOf(calif3) < 8){
            ibActivity4.setBackgroundResource(R.drawable.button_unactivated);
        }else if(Double.valueOf(calif3) >= 8){
            ibActivity4.setBackgroundResource(R.drawable.button_circle);
        }
        if(calif4==null || Double.valueOf(calif4) < 8){
            ibActivity6.setBackgroundResource(R.drawable.button_unactivated);
        }else if(Double.valueOf(calif4) >= 8){
            ibActivity6.setBackgroundResource(R.drawable.button_circle);
        }
        if(calif5==null || Double.valueOf(calif5) < 8){
            ivTest.setBackgroundResource(R.drawable.button_unactivated);
        }else if(Double.valueOf(calif5) >= 8){
            ivTest.setBackgroundResource(R.drawable.button_circle);
        }

        ibActivity1.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),AlphabetNumbers.class));
            }
        });

        ibActivity2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String calif = helper.getScore(idUser, 1);
               if (calif==null || Double.valueOf(calif) < 8) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setMessage("Complete previous activities into unlock this one.")
                            .setTitle("Blocked Activity 2").setIcon(R.drawable.logo)
                            .setNegativeButton("to accept", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            });
                    builder.show();
                }else if(Double.valueOf(calif) >= 8){
                    startActivity(new Intent(getApplicationContext(),AnimalsColors.class));
                }
            }
        });

        ibActivity3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String calif = helper.getScore(idUser,2);
                if (calif==null || Double.valueOf(calif) < 8) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setMessage("Complete previous activities into unlock this one.")
                            .setTitle("Blocked Activity 3").setIcon(R.drawable.logo)
                            .setNegativeButton("to accept", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            });
                    builder.show();
                }else if(Double.valueOf(calif) >= 8){
                    startActivity(new Intent(getApplicationContext(),FamilyClothes.class));
                }
            }
        });

        ibActivity4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String calif = helper.getScore(idUser,3);
                if (calif==null || Double.valueOf(calif) < 8) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setMessage("Complete previous activities into unlock this one.")
                            .setTitle("Blocked Activity 4").setIcon(R.drawable.logo)
                            .setNegativeButton("to accept", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            });
                    builder.show();
                }else if(Double.valueOf(calif) >= 8){
                    startActivity(new Intent(getApplicationContext(),GeoFigSports.class));
                }
            }
        });

        ibActivity6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String calif = helper.getScore(idUser,4);
                if (calif==null || Double.valueOf(calif) < 8) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setMessage("Complete previous activities into unlock this one.")
                            .setTitle("Blocked Activity 5").setIcon(R.drawable.logo)
                            .setNegativeButton("to accept", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            });
                    builder.show();
                }else if(Double.valueOf(calif) >= 8){
                    startActivity(new Intent(getApplicationContext(),MonthsSeasons.class));
                }
            }
        });

        ivTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String calif = helper.getScore(idUser,5);
                if (calif==null || Double.valueOf(calif) < 8) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setMessage("Perform the previous activities first, to perform the final test")
                            .setTitle("Final test blocked").setIcon(R.drawable.logo)
                            .setNegativeButton("to accept", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            });
                    builder.show();
                }else if(Double.valueOf(calif) >= 8){
                    startActivity(new Intent(getApplicationContext(),Test.class));
                }
            }
        });

        session = new Session(this);

        if(!session.loggedin()){
            logout();
        }

        DrawerLayout drawer = (DrawerLayout)findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle= new ActionBarDrawerToggle(this, drawer, toolbar,(R.string.open_drawer),(R.string.close_drawer));
        NavigationView navigationView = (NavigationView)findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }
    private void logout(){
        session.setLoggedin(false);
        finish();
        startActivity(new Intent(MainActivity.this,LoginActivity.class));
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawerLayout =(DrawerLayout)findViewById(R.id.drawer_layout);
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);

        }else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        boolean fragmentTransaction=false;
        Fragment fragment = null;
        if(id==R.id.nav_slideshow){
            Log.i("Navegation Drawer","Entering in option slideshow");
            startActivity(new Intent(getApplicationContext(),ResourceLearnSongs.class));

        } else if(id==R.id.nav_manage){
            Log.i("Navegation Drawer","Entering in option manage");
            getSupportActionBar().setTitle(session.getClass().getClass().getName());
//jeje aqui cambiarle
        }else if(id==R.id.nav_view){
            Log.i("Navegation View","Entering in option view");
            getSupportActionBar().setTitle("View");

        }else if(id==R.id.nav_share){
            SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
            Log.i("Navegation Drawer","Option 1: "+preferences.getBoolean("option1", false));
            Log.i("Navegation Drawer","Option 2: "+preferences.getString("option2", ""));
            Log.i("Navegation Drawer","Option 3: "+preferences.getString("option3", ""));

        } else if(id==R.id.nav_send){
            startActivity(new Intent(this, Preferences.class));
            Log.i("Navigation Dreawer", "Enterinf in option Preferences");

        }else if (id==R.id.nav_instructions){
            PrefManager prefManager = new PrefManager(getApplicationContext());
            prefManager.setFirstTimeLaunch(true);
            startActivity(new Intent(this, WelcomeActivity.class));
            finish();


        }else if (id==R.id.nav_logro){
            PrefManager prefManager = new PrefManager(getApplicationContext());
            prefManager.setFirstTimeLaunch(true);
            session.setLoggedin(true);
            //finish();
            startActivity(new Intent(MainActivity.this,TableroLogros.class));

        }else if (id==R.id.nav_exit){
            PrefManager prefManager = new PrefManager(getApplicationContext());
            prefManager.setFirstTimeLaunch(true);
            session.setLoggedin(false);
            finish();
            startActivity(new Intent(MainActivity.this,LoginActivity.class));

        }else if(id==R.id.nav_about){
            PrefManager prefManager = new PrefManager(getApplicationContext());
            prefManager.setFirstTimeLaunch(true);
            session.setLoggedin(true);
            //finish();
            startActivity(new Intent(MainActivity.this,AboutActivity.class));
        }
        if (fragmentTransaction){
            getSupportFragmentManager().beginTransaction().replace(R.id.content_main, fragment).commit();
            item.setChecked(true);
            getSupportActionBar().setTitle(item.getTitle());

        }
        DrawerLayout drawerLayout=(DrawerLayout)findViewById(R.id.drawer_layout);
        drawerLayout.closeDrawer(GravityCompat.START);

        return true;
    }

}
