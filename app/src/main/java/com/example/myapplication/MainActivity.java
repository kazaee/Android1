package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    String strUName ="admin";
    String strPass = "12345678";
    EditText txtusername,txtpassword;

    Button btnlogin,btnsignup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setLanguageForApp("ar");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtusername = (EditText) findViewById(R.id.txtusername);
        txtpassword = (EditText) findViewById(R.id.txtpassword);

        btnlogin = (Button) findViewById(R.id.btnlogin);
        btnsignup = (Button) findViewById(R.id.btnsignup);

   /*     btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validation()) {
                    Intent intent = new Intent(MainActivity.this, actMain.class);
                    startActivity(intent);
                    finish();
                }
                btnsignup.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MainActivity.this, signup.class);
                        startActivity(intent);
                    }
                });

            }
        });*/


    }
    public void btnLoginClick(View v){
        if (validation()) {
            Intent intent = new Intent(MainActivity.this, actMain.class);
            startActivity(intent);
            finish();
        }

    }
    public void btnsignupclick(View v){
        Intent intent = new Intent(MainActivity.this, signup.class);
        startActivity(intent);

    }
    boolean validation(){
        if (txtpassword.length()<6){
            Toast.makeText(this, R.string.invalidlength, Toast.LENGTH_SHORT).show();
            return false;
        }
        if (txtusername.getText().toString().equals(strUName) && txtpassword.getText().toString().equals(strPass))
            return true;
        else
            Toast.makeText(MainActivity.this, R.string.invalidpass, Toast.LENGTH_SHORT).show();
        return false;
    }
    private void setLanguageForApp(String language){
        String LanguageToLoad = language;
        Locale locale;
        if(LanguageToLoad.equals("not-set")){
            locale = Locale.getDefault();
        }
        else {
            locale = new Locale(LanguageToLoad);
        }
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config,getBaseContext().getResources().getDisplayMetrics());
    }
}