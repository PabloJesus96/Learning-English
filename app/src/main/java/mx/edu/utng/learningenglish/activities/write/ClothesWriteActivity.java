package mx.edu.utng.learningenglish.activities.write;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import mx.edu.utng.learningenglish.R;

public class ClothesWriteActivity extends AppCompatActivity  implements View.OnClickListener {

    private TextView tv1;
    private TextView tv2;
    private TextView tv3;
    private TextView tv4;
    private TextView tv5;
    private TextView tv6;
    private TextView tv7;
    private TextView tv8;
    private EditText etCap;
    private EditText etTShirt;
    private EditText etShoes;
    private EditText etSweater;
    private EditText etBikini;
    private EditText etShorts;
    private EditText etJacket;
    private EditText etSocks;
    private Button btCap;
    private Button btTShirt;
    private Button btShoes;
    private Button btSweater;
    private Button btBikini;
    private Button btShorts;
    private Button btJacket;
    private Button btSocks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clothes_write);
        this.setTitle("Family Writing");

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        tv1 = (TextView) findViewById(R.id.tv_1);
        tv2 = (TextView) findViewById(R.id.tv_2);
        tv3 = (TextView) findViewById(R.id.tv_3);
        tv4  = (TextView) findViewById(R.id.tv_4);
        tv5  = (TextView) findViewById(R.id.tv_5);
        tv6  = (TextView) findViewById(R.id.tv_6);
        tv7  = (TextView) findViewById(R.id.tv_7);
        tv8 = (TextView) findViewById(R.id.tv_8);

        etCap = (EditText) findViewById(R.id.et_cap);
        etTShirt = (EditText) findViewById(R.id.et_t_shirt);
        etShoes = (EditText) findViewById(R.id.et_shoes);
        etSweater = (EditText) findViewById(R.id.et_sweater);
        etBikini = (EditText) findViewById(R.id.et_bikini);
        etShorts = (EditText) findViewById(R.id.et_shorts);
        etJacket = (EditText) findViewById(R.id.et_jacket);
        etSocks = (EditText) findViewById(R.id.et_socks);

        btCap = (Button) findViewById(R.id.bt_cap);
        btTShirt = (Button) findViewById(R.id.bt_t_shirt);
        btShoes = (Button) findViewById(R.id.bt_shoes);
        btSweater = (Button) findViewById(R.id.bt_sweater);
        btBikini = (Button) findViewById(R.id.bt_bikini);
        btShorts = (Button) findViewById(R.id.bt_shorts);
        btJacket = (Button) findViewById(R.id.bt_jacket);
        btSocks = (Button) findViewById(R.id.bt_socks);

        btCap.setOnClickListener(this);
        btTShirt.setOnClickListener(this);
        btShoes.setOnClickListener(this);
        btSweater.setOnClickListener(this);
        btBikini.setOnClickListener(this);
        btShorts.setOnClickListener(this);
        btJacket.setOnClickListener(this);
        btSocks.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String cap = etCap.getText().toString();
        String tShirt = etTShirt.getText().toString();
        String shorts = etShorts.getText().toString();
        String sweater = etSweater.getText().toString();
        String shoes = etShoes.getText().toString();
        String bikini = etBikini.getText().toString();
        String socks = etSocks.getText().toString();
        String jacket = etJacket.getText().toString();

        switch (v.getId()){
            case R.id.bt_cap:
                if(cap.equalsIgnoreCase("cap")){
                    //tv1 = (TextView) findViewById(R.id.tv_father);
                    tv1.setText("CAP");
                    Toast.makeText(this, "Is Correct!", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(this, "Is Error!", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.bt_t_shirt:
                if(tShirt.equalsIgnoreCase("t-shirt")){
                    //tvFather = (TextView) findViewById(R.id.tv_father);
                    tv2.setText("T-SHIRT");
                    Toast.makeText(this, "Is Correct!", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(this, "Is Error!", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.bt_shoes:
                if(shoes.equalsIgnoreCase("shoes")){
                    //tvFather = (TextView) findViewById(R.id.tv_father);
                    tv3.setText("SHOES");
                    Toast.makeText(this, "Is Correct!", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(this, "Is Error!", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.bt_sweater:
                if(sweater.equalsIgnoreCase("sweater")){
                    //tvFather = (TextView) findViewById(R.id.tv_father);
                    tv4.setText("SWEATER");
                    Toast.makeText(this, "Is Correct!", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(this, "Is Error!", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.bt_bikini:
                if(bikini.equalsIgnoreCase("bikini")){
                    //tvFather = (TextView) findViewById(R.id.tv_father);
                    tv5.setText("BIKINI");
                    Toast.makeText(this, "Is Correct!", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(this, "Is Error!", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.bt_shorts:
                if(shorts.equalsIgnoreCase("shorts")){
                    //tvFather = (TextView) findViewById(R.id.tv_father);
                    tv6.setText("SHORTS");
                    Toast.makeText(this, "Is Correct!", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(this, "Is Error!", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.bt_jacket:
                if(jacket.equalsIgnoreCase("jacket")){
                    //tvFather = (TextView) findViewById(R.id.tv_father);
                    tv7.setText("JACKET");
                    Toast.makeText(this, "Is Correct!", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(this, "Is Error!", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.bt_socks:
                if(socks.equalsIgnoreCase("socks")){
                    //tvFather = (TextView) findViewById(R.id.tv_father);
                    tv8.setText("SOCKS");
                    Toast.makeText(this, "Is Correct!", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(this, "Is Error!", Toast.LENGTH_LONG).show();
                }
                break;
            default:
                break;
        }
    }
}
