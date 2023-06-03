package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class ingreso_app extends AppCompatActivity {

    private Spinner mSpinner;
    private String spinnerSelection; // Variable para almacenar la selección del Spinner

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.seleccion_app);

        mSpinner = findViewById(R.id.spinner_parque);

        // Crea un ArrayAdapter con los datos que quieres mostrar en el Spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.parques_array, android.R.layout.simple_spinner_item);

        // Especifica cómo se mostrarán los datos en el Spinner
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Asigna el adaptador al Spinner
        mSpinner.setAdapter(adapter);

        // Obtiene el valor seleccionado del Spinner
        mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spinnerSelection = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Aquí puedes manejar la lógica si no se selecciona nada en el Spinner
            }
        });

        Button btnAvanzar = findViewById(R.id.avanzar_app);
        btnAvanzar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Acción al hacer clic en el botón
                Intent intent = new Intent(ingreso_app.this, form_app.class);
                intent.putExtra("spinner_selection", spinnerSelection); // Pasa el valor seleccionado a la siguiente actividad
                startActivity(intent);
            }
        });
    }
}
