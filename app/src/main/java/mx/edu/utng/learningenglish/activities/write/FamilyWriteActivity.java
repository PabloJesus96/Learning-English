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

public class FamilyWriteActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView tvFather;
    private TextView tvBrother;
    private TextView tvSister;
    private TextView tvMother;
    private TextView tvCousin;
    private TextView tvAunt;
    private TextView tvGrandFather;
    private TextView tvGrandMother;
    private EditText etFather;
    private EditText etBrother;
    private EditText etSister;
    private EditText etMother;
    private EditText etCousin;
    private EditText etAunt;
    private EditText etGrandMother;
    private EditText etGrandFather;
    private Button btFather;
    private Button btBrother;
    private Button btSister;
    private Button btMother;
    private Button btCousin;
    private Button btAunt;
    private Button btGrandMother;
    private Button btGrandFather;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family_write);
        this.setTitle("Family Writing");

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        tvBrother = (TextView) findViewById(R.id.tv_question_brother);
        tvSister = (TextView) findViewById(R.id.tv_question_sister);
        tvMother = (TextView) findViewById(R.id.tv_question_mother);
        tvCousin  = (TextView) findViewById(R.id.tv_question_cousin);
        tvAunt  = (TextView) findViewById(R.id.tv_question_aunt);
        tvGrandFather  = (TextView) findViewById(R.id.tv_question_grandFather);
        tvGrandMother  = (TextView) findViewById(R.id.tv_question_grandMother);
        tvFather  = (TextView) findViewById(R.id.tv_question_father);
        etFather = (EditText) findViewById(R.id.et_father);
        etBrother = (EditText) findViewById(R.id.et_brother);
        etSister = (EditText) findViewById(R.id.et_sister);
        etMother = (EditText) findViewById(R.id.et_mother);
        etCousin = (EditText) findViewById(R.id.et_cousin);
        etAunt = (EditText) findViewById(R.id.et_aunt);
        etGrandMother = (EditText) findViewById(R.id.et_grandMother);
        etGrandFather  = (EditText) findViewById(R.id.et_grandFather);
        btFather = (Button) findViewById(R.id.bt_father);
        btBrother = (Button) findViewById(R.id.bt_brother);
        btSister = (Button) findViewById(R.id.bt_sister);
        btMother = (Button) findViewById(R.id.bt_mother);
        btCousin = (Button) findViewById(R.id.bt_cousin);
        btAunt = (Button) findViewById(R.id.bt_aunt);
        btGrandMother = (Button) findViewById(R.id.bt_grandmother);
        btGrandFather = (Button) findViewById(R.id.bt_grandfather);
        btFather.setOnClickListener(this);
        btBrother.setOnClickListener(this);
        btSister.setOnClickListener(this);
        btMother.setOnClickListener(this);
        btCousin.setOnClickListener(this);
        btAunt.setOnClickListener(this);
        btGrandMother.setOnClickListener(this);
        btGrandFather.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String father = etFather.getText().toString();
        String brother = etBrother.getText().toString();
        String aunt = etAunt.getText().toString();
        String mother = etMother.getText().toString();
        String sister = etSister.getText().toString();
        String cousin = etCousin.getText().toString();
        String grandFather = etGrandFather.getText().toString();
        String grandMother = etGrandMother.getText().toString();

        switch (v.getId()){
            case R.id.bt_father:
                if(father.equalsIgnoreCase("father")){
                    //tvFather = (TextView) findViewById(R.id.tv_father);
                    tvFather.setText("FATHER");
                    Toast.makeText(this, "Is Correct!", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(this, "Is Error!", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.bt_brother:
                if(brother.equalsIgnoreCase("brother")){
                    //tvFather = (TextView) findViewById(R.id.tv_father);
                    tvBrother.setText("BROTHER");
                    Toast.makeText(this, "Is Correct!", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(this, "Is Error!", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.bt_aunt:
                if(aunt.equalsIgnoreCase("aunt")){
                    //tvFather = (TextView) findViewById(R.id.tv_father);
                    tvAunt.setText("AUNT");
                    Toast.makeText(this, "Is Correct!", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(this, "Is Error!", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.bt_mother:
                if(mother.equalsIgnoreCase("mother")){
                    //tvFather = (TextView) findViewById(R.id.tv_father);
                    tvMother.setText("MOTHER");
                    Toast.makeText(this, "Is Correct!", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(this, "Is Error!", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.bt_sister:
                if(sister.equalsIgnoreCase("sister")){
                    //tvFather = (TextView) findViewById(R.id.tv_father);
                    tvSister.setText("SISTER");
                    Toast.makeText(this, "Is Correct!", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(this, "Is Error!", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.bt_cousin:
                if(cousin.equalsIgnoreCase("cousin")){
                    //tvFather = (TextView) findViewById(R.id.tv_father);
                    tvCousin.setText("COUSIN");
                    Toast.makeText(this, "Is Correct!", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(this, "Is Error!", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.bt_grandfather:
                if(grandFather.equalsIgnoreCase("grandfather")){
                    //tvFather = (TextView) findViewById(R.id.tv_father);
                    tvGrandFather.setText("GRANDFATHER");
                    Toast.makeText(this, "Is Correct!", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(this, "Is Error!", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.bt_grandmother:
                if(grandMother.equalsIgnoreCase("grandmother")){
                    //tvFather = (TextView) findViewById(R.id.tv_father);
                    tvGrandMother.setText("GRANDMOTHER");
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
