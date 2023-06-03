package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MainActivity extends AppCompatActivity {
    private EditText mUsernameEditText;
    private EditText mPasswordEditText;
    private Connection dbConnection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mUsernameEditText = findViewById(R.id.username_edittext);
        mPasswordEditText = findViewById(R.id.password_edittext);

        Button loginButton = findViewById(R.id.login_button);

        loginButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String username = mUsernameEditText.getText().toString();
                String password = mPasswordEditText.getText().toString();

                if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
                    Toast.makeText(MainActivity.this, "Por favor ingrese usuario y contraseña", Toast.LENGTH_SHORT).show();
                    return;
                }

                ConnectTask connectTask = new ConnectTask();
                connectTask.execute(username, password);
            }
        });

    }

    private class ConnectTask extends AsyncTask<String, Void, ResultSet> {
        @Override
        protected ResultSet doInBackground(String... params) {
            String username = params[0];
            String password = params[1];

            ResultSet resultSet = null;
            try {
                Connection connection = conection.getConnection();
                if (connection != null) {
                    Log.d("DB Connection", "Connected successfully");
                    String query = "SELECT * FROM \"AspNetUsers\" WHERE \"UserName\" = '" + username + "' AND \"Email\" = '" + password + "'";
                    Statement statement = connection.createStatement();
                    resultSet = statement.executeQuery(query);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return resultSet;
        }

        @Override
        protected void onPostExecute(ResultSet resultSet) {
            if (resultSet != null) {
                try {
                    if (resultSet.next()) {
                        Intent intent = new Intent(MainActivity.this, ingreso_app.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(MainActivity.this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } else {
                Toast.makeText(MainActivity.this, "No se pudo conectar a la base de datos", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
