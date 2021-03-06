package com.example.ljr.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ljr.myapplication.DB.DBHelper;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private Button login, register;
    private EditText etEmail, etPass;
    private DBHelper db;
    private Session session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        db = new DBHelper(this);
        session = new Session(this);
        login = (Button)findViewById(R.id.btnLogin);
        register =(Button)findViewById(R.id.btnReg);
        etEmail = (EditText)findViewById(R.id.etEmail);
        etPass = (EditText)findViewById(R.id.etPass);
        login.setOnClickListener(this);
        register.setOnClickListener(this);

        if(session.loggedin()){
            startActivity(new Intent(LoginActivity.this, MainActivity.class));
            finish();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnLogin:
                    login();
                break;
            case R.id.btnReg:
                    startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
                break;
            default:
        }
    }

    private void login(){
        String email = etEmail.getText().toString();
        String pass = etPass.getText().toString();

        if(db.getUser(email,pass) != -1){
            session.setLoggedin(db.getUser(email, pass));
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            intent.putExtra("frag", "logToHome");
            startActivity(intent);
            //startActivity(new Intent(LoginActivity.this, MainActivity.class));
            finish();
        }else{
            Toast.makeText(getApplicationContext(), "Wrong email/password",Toast.LENGTH_SHORT).show();
        }
    }
}
