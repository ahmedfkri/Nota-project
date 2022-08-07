package com.example.nota;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class NotaActivity extends AppCompatActivity {

    EditText edtScore1;
    EditText edtScore2;

    EditText edtTeam1, edtTeam2;

    TextView txtDor1,txtDor2;

    int dor1,dor2 =0;

    Button btnAdd;
    Button btnAnother;

    int totalScore1=0;
    int totalScore2=0;

    TextView txtScore1;
    TextView txtScore2;

    int newScore1=0;
    int newScore2=0;

    ImageView btnBack;
    Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nota);

        txtDor1=findViewById(R.id.txtDor1);
        txtDor2=findViewById(R.id.txtDor2);

        edtTeam1=findViewById(R.id.edtTeam1);
        edtTeam2=findViewById(R.id.edtTeam2);

        AlertDialog.Builder builder = new AlertDialog.Builder(NotaActivity.this);
        builder.setTitle("متأكد؟")
                .setMessage("عايز تنهي العشرة دي وتبدأ عشرة جديد؟")
                .setNegativeButton("لا ارجع", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setPositiveButton("أيوه", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        clearAll();
                    }
                });


        txtScore1 = findViewById(R.id.txtFirstScore);
        edtScore1 = this.findViewById(R.id.edtFirstScore);


        txtScore2 = findViewById(R.id.txtSecondScore);
        edtScore2= findViewById(R.id.edtSecondScore);

        btnAnother=findViewById(R.id.btnAnother);
        btnAnother.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });

        btnBack=(ImageView) findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent= new Intent(NotaActivity.this,MainActivity.class);
                startActivity(intent);

            }
        });



        ///////////////********************************\\\\\\\\\\\\\\\\\\\\\\\\\


        edtScore1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                edtScore1.getText().clear();
                return false;
            }
        });

        edtScore2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                edtScore2.setText("");
                return false;
            }
        });
        ///////////////********************************\\\\\\\\\\\\\\\\\\\\\\\\\

        btnAdd=findViewById(R.id.btnAdd);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String s1= edtScore1.getText().toString();
                String s2 = edtScore2.getText().toString();

                if(!s1.isEmpty() && s2.isEmpty() ) {

                    newScore1 = Integer.parseInt(edtScore1.getText().toString());
                    addScore1(newScore1);
                    edtScore1.setText("");
                    addDor1();
                    checkScore();


                }else if(s1.isEmpty() && !s2.isEmpty()){

                    newScore2=Integer.parseInt(edtScore2.getText().toString());
                    addScore2(newScore2);
                    edtScore2.setText("");
                    addDor2();
                    checkScore();
                }
                else{

                    Toast.makeText(NotaActivity.this, "!  فوق يا مدير", Toast.LENGTH_SHORT).show();
                    edtScore1.setText("");
                    edtScore2.setText("");
                }

                ///////////////********************************\\\\\\\\\\\\\\\\\\\\\\\\\

//                try {
//                    newScore1=Integer.parseInt(edtScore1.getText().toString());
//                    newScore2=Integer.parseInt(edtScore2.getText().toString());
//                }
//
//                catch (Exception e){
//                    Toast.makeText(NotaActivity.this, e.toString(), Toast.LENGTH_SHORT).show();
//                    edtScore1.setText("0");
//                    edtScore2.setText("0");
//                }
//
//                if(newScore1 >0 && newScore2==0){
//                    addScore1(newScore1);
//                    edtScore1.setText("0");
//                }
                ///////////////********************************\\\\\\\\\\\\\\\\\\\\\\\\\
            }
        });
    }

    private void clearAll() {

        txtDor1.setText("");
        txtDor2.setText("");
        edtTeam1.setText("");
        edtTeam2.setText("");
        txtScore1.setText("0");
        txtScore2.setText("0");

        dor2=0;
        dor1=0;
        totalScore2=0;
        totalScore1=0;
        newScore2=0;
        newScore1=0;


        btnAdd.setEnabled(true);

    }

    private void checkScore() {
        if(totalScore1>= 151){
            Toast.makeText(this, edtTeam1.getText().toString()+" خدوها ", Toast.LENGTH_SHORT).show();
            btnAdd.setEnabled(false);
        }else if(totalScore2 >= 151){
            Toast.makeText(this, edtTeam2.getText().toString()+" خدوها ", Toast.LENGTH_SHORT).show();
            btnAdd.setEnabled(false);
        }

    }

    private void addDor1() {
        dor1++;
        txtDor1.setText(" ادوار:  "+dor1);
    }
    private void addDor2() {
        dor2++;
        txtDor2.setText(" ادوار:  "+dor2);
    }

    public void addScore1(int score){
        totalScore1=score+Integer.parseInt(txtScore1.getText().toString()) ;
        txtScore1.setText(totalScore1+"");
    }

    public void addScore2(int score){
        totalScore2=score+Integer.parseInt(txtScore2.getText().toString()) ;
        txtScore2.setText(totalScore2+"");
    }





}