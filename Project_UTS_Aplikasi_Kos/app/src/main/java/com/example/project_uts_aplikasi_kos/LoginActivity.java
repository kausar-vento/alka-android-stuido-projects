package com.example.project_uts_aplikasi_kos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    DataHelper dh;
    Session session;
    EditText inputUsername, inputPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        dh = new DataHelper(this);
        session = new Session(this);
        inputUsername = (EditText) findViewById(R.id.iptUsername);
        inputPassword = (EditText) findViewById(R.id.iptPassword);
        if (session.loggedin()) {
            startActivity(new Intent(LoginActivity.this,MainActivity.class));
            finish();
        }
    }

    public void btnR(View view) {
        Intent inte = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(inte);
    }

    public void btnL(View view) {
        String username = inputUsername.getText().toString();
        String password = inputPassword.getText().toString();

        if (dh.getUser(username, password)) {
            session.setLoggedin(true);
            startActivity(new Intent(LoginActivity.this, MainActivity.class));
            finish();
        } else {
            displayToast("Username atau Password Anda Kosong");
        }
    }
    private void displayToast(String message){
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
}