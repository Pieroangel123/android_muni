package com.example.myapplication;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class formato_app extends AppCompatActivity {
    private Button btnTerminar;
    private Button mBtnTomarFoto;

    private static final int REQUEST_IMAGE_CAPTURE = 1;

    private class InsertDataAsyncTask extends AsyncTask<Void, Void, Void> {
        private String text1, text2, text3, text4, text5, text6, text7, text8, text9, text10, text11, text12, text13, text14;

        public InsertDataAsyncTask(String text1, String text2, String text3, String text4, String text5, String text6, String text7, String text8, String text9, String text10, String text11, String text12, String text13, String text14) {
            this.text1 = text1;
            this.text2 = text2;
            this.text3 = text3;
            this.text4 = text4;
            this.text5 = text5;
            this.text6 = text6;
            this.text7 = text7;
            this.text8 = text8;
            this.text9 = text9;
            this.text10 = text10;
            this.text11 = text11;
            this.text12 = text12;
            this.text13 = text13;
            this.text14 = text14;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            conection connection = new conection(getApplicationContext());
            connection.insertDataIntoPenalidadTable(text1, text2, text3, text4, text5, text6, text7, text8, text9, text10, text11, text12, text13, text14);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            // Luego, realiza la acción para enviar a otra vista
            Intent intent = new Intent(formato_app.this, ingreso_app.class);
            // Aquí puedes agregar datos adicionales a través de `intent.putExtra()`
            startActivity(intent);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.formato_app);

        btnTerminar = findViewById(R.id.terminar_app);
        btnTerminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean allFieldsFilled = true;

                EditText editText1 = findViewById(R.id.edit_text1);
                String text1 = editText1.getText().toString().trim();
                if (text1.isEmpty()) {
                    allFieldsFilled = false;
                    editText1.setError("Este campo es obligatorio");
                }

                EditText editText2 = findViewById(R.id.edit_text2);
                String text2 = editText2.getText().toString().trim();
                if (text2.isEmpty()) {
                    allFieldsFilled = false;
                    editText2.setError("Este campo es obligatorio");
                }

                EditText editText3 = findViewById(R.id.edit_text3);
                String text3 = editText3.getText().toString().trim();
                if (text3.isEmpty()) {
                    allFieldsFilled = false;
                    editText2.setError("Este campo es obligatorio");
                }

                EditText editText4 = findViewById(R.id.edit_text4);
                String text4 = editText4.getText().toString().trim();
                if (text4.isEmpty()) {
                    allFieldsFilled = false;
                    editText2.setError("Este campo es obligatorio");
                }

                EditText editText5 = findViewById(R.id.edit_text5);
                String text5 = editText5.getText().toString().trim();
                if (text5.isEmpty()) {
                    allFieldsFilled = false;
                    editText2.setError("Este campo es obligatorio");
                }

                EditText editText6 = findViewById(R.id.edit_text6);
                String text6 = editText6.getText().toString().trim();
                if (text6.isEmpty()) {
                    allFieldsFilled = false;
                    editText2.setError("Este campo es obligatorio");
                }

                EditText editText7 = findViewById(R.id.edit_text7);
                String text7 = editText7.getText().toString().trim();
                if (text7.isEmpty()) {
                    allFieldsFilled = false;
                    editText2.setError("Este campo es obligatorio");
                }

                EditText editText8 = findViewById(R.id.edit_text8);
                String text8 = editText8.getText().toString().trim();
                if (text8.isEmpty()) {
                    allFieldsFilled = false;
                    editText2.setError("Este campo es obligatorio");
                }

                EditText editText9 = findViewById(R.id.edit_text9);
                String text9 = editText9.getText().toString().trim();
                if (text9.isEmpty()) {
                    allFieldsFilled = false;
                    editText2.setError("Este campo es obligatorio");
                }

                EditText editText10 = findViewById(R.id.edit_text10);
                String text10 = editText10.getText().toString().trim();
                if (text10.isEmpty()) {
                    allFieldsFilled = false;
                    editText2.setError("Este campo es obligatorio");
                }

                EditText editText11 = findViewById(R.id.edit_text11);
                String text11 = editText11.getText().toString().trim();
                if (text11.isEmpty()) {
                    allFieldsFilled = false;
                    editText2.setError("Este campo es obligatorio");
                }

                EditText editText12 = findViewById(R.id.edit_text12);
                String text12 = editText12.getText().toString().trim();
                if (text12.isEmpty()) {
                    allFieldsFilled = false;
                    editText2.setError("Este campo es obligatorio");
                }

                EditText editText13 = findViewById(R.id.edit_text13);
                String text13 = editText13.getText().toString().trim();
                if (text13.isEmpty()) {
                    allFieldsFilled = false;
                    editText2.setError("Este campo es obligatorio");
                }

                EditText editText14 = findViewById(R.id.edit_text14);
                String text14 = editText14.getText().toString().trim();
                if (text14.isEmpty()) {
                    allFieldsFilled = false;
                    editText2.setError("Este campo es obligatorio");
                }

                // Si todos los campos están llenos
                if (allFieldsFilled) {
                    // Ejecutar la inserción en un AsyncTask
                    InsertDataAsyncTask task = new InsertDataAsyncTask(text1, text2, text3, text4, text5, text6, text7, text8, text9, text10, text11, text12, text13, text14);
                    task.execute();
                } else {
                    Toast.makeText(formato_app.this, "Por favor, completa todos los campos.", Toast.LENGTH_SHORT).show();
                }
            }

        });
        mBtnTomarFoto = findViewById(R.id.tomar_foto);
        mBtnTomarFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Crea un Intent para abrir la cámara
                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
                    startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
                }
            }
        });
    }
}
