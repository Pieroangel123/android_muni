package com.example.myapplication;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class form_app extends AppCompatActivity {

    private Button btnRetroceder;
    private Button btnAvanzar;
    private EditText editText1;
    private EditText editText2;
    // Agrega aquí los demás EditText necesarios
    private CheckBox checkBox1;
    private CheckBox checkBox2;
    private CheckBox checkBox3;
    private CheckBox checkBox4;
    private CheckBox checkBox5;
    private CheckBox checkBox6;
    private CheckBox checkBox7;
    private CheckBox checkBox8;
    private CheckBox checkBox9;
    // Agrega aquí los demás CheckBox necesarios

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form_fc);

        btnRetroceder = findViewById(R.id.retroceder);
        btnAvanzar = findViewById(R.id.terminar);
        editText1 = findViewById(R.id.edit_text); // Reemplaza "editText1" con el ID correcto del EditText
        editText2 = findViewById(R.id.edit_text2); // Reemplaza "editText2" con el ID correcto del EditText
        // Asigna los demás EditText necesarios
        checkBox1 = findViewById(R.id.check1); // Reemplaza "checkBox1" con el ID correcto del CheckBox
        checkBox2 = findViewById(R.id.check2);
        checkBox3 = findViewById(R.id.check3);
        checkBox4 = findViewById(R.id.check4);
        checkBox5 = findViewById(R.id.check5);
        checkBox6 = findViewById(R.id.check6);
        checkBox7 = findViewById(R.id.check7);
        checkBox8 = findViewById(R.id.check8);
        checkBox9 = findViewById(R.id.check9);// Reemplaza "checkBox2" con el ID correcto del CheckBox
        // Asigna los demás CheckBox necesarios

        btnRetroceder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Acción al hacer clic en el botón de retroceso
                Intent intent = new Intent(form_app.this, ingreso_app.class);
                startActivity(intent);
            }
        });

        btnAvanzar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Acción al hacer clic en el botón de avanzar

                // Validar que todos los campos de texto estén llenos
                if (camposTextoLlenos()) {
                    // Obtener el valor de los CheckBox
                    String valorCheckBox1 = checkBox1.isChecked() ? "SI" : "NO";
                    String valorCheckBox2 = checkBox2.isChecked() ? "SI" : "NO";
                    String valorCheckBox3 = checkBox3.isChecked() ? "SI" : "NO";
                    String valorCheckBox4 = checkBox4.isChecked() ? "SI" : "NO";
                    String valorCheckBox5 = checkBox5.isChecked() ? "SI" : "NO";
                    String valorCheckBox6 = checkBox6.isChecked() ? "SI" : "NO";
                    String valorCheckBox7 = checkBox7.isChecked() ? "SI" : "NO";
                    String valorCheckBox8 = checkBox8.isChecked() ? "SI" : "NO";
                    String valorCheckBox9 = checkBox9.isChecked() ? "SI" : "NO";

                    // Insertar datos en la tabla
                    new InsertPenalidadTask().execute(valorCheckBox1, valorCheckBox2, valorCheckBox3, valorCheckBox4, valorCheckBox5, valorCheckBox6, valorCheckBox7, valorCheckBox8, valorCheckBox9);
                } else {
                    Toast.makeText(form_app.this, "Por favor, complete todos los campos de texto", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean camposTextoLlenos() {
        String texto1 = editText1.getText().toString().trim();
        String texto2 = editText2.getText().toString().trim();
        // Obtén los valores de los demás EditText y realiza la validación

        return !TextUtils.isEmpty(texto1) && !TextUtils.isEmpty(texto2);
        // Agrega la validación para los demás campos de texto
    }

    private class InsertPenalidadTask extends AsyncTask<String, Void, Void> {
        @Override
        protected Void doInBackground(String... valoresCheckBox) {
            // Insertar los valores en la tabla (utiliza los valoresCheckBox según corresponda)
            conection.insertPenalidad(valoresCheckBox[0], valoresCheckBox[1], valoresCheckBox[2], valoresCheckBox[3], valoresCheckBox[4], valoresCheckBox[5], valoresCheckBox[6], valoresCheckBox[7], valoresCheckBox[8]);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            // Aquí puedes realizar cualquier actualización de la interfaz de usuario después de la inserción

            // Verificar si algún CheckBox tiene el valor "NO" y redirigir a la vista correspondiente
            if (checkBox1.isChecked() && checkBox2.isChecked() && checkBox3.isChecked() && checkBox4.isChecked() && checkBox5.isChecked() && checkBox6.isChecked() && checkBox7.isChecked() && checkBox8.isChecked() && checkBox9.isChecked()) {
                // Todos los CheckBox tienen el valor "SI", redirigir a la vista anterior
                Intent intent = new Intent(form_app.this, ingreso_app.class);
                startActivity(intent);
            } else {
                // Al menos un CheckBox tiene el valor "NO", redirigir a otra vista
                Intent intent = new Intent(form_app.this, formato_app.class);
                startActivity(intent);
            }
        }
    }
}
