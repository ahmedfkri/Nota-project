package com.example.nota;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button btnNewGame;
    Intent intent;

//    EditText edtFirstName, edtSecondName;
//    Button btnSubmit;
//
//    AlertDialog dialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        btnNewGame=findViewById(R.id.btnNewGame);
        btnNewGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                intent = new Intent(MainActivity.this, NotaActivity.class);
                startActivity(intent);
            }
        });


    }

//    public void openDialog() {
//
//        CustomDialog dialog = new CustomDialog();
//        dialog.show(getSupportFragmentManager(),"dialog");
//
//
//    }


}