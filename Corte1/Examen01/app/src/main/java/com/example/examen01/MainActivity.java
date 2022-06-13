package com.example.examen01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText txtNombre;
    private EditText txtAltura;
    private EditText txtBase;
    private Button btnLimpiar;
    private Button btnSiguiente;
    private Button btnSalir;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iniciar();
        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtNombre.setText("");
                txtAltura.setText("");
                txtBase.setText("");
            }
        });

        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txtNombre.getText().toString().matches("") || txtBase.getText().toString().matches("") || txtAltura.getText().toString().matches("")){
                    Toast.makeText(MainActivity.this, "No ha llenado todos los campos", Toast.LENGTH_SHORT).show();
                }else{
                    String nombre = txtNombre.getText().toString();
                    String base = txtBase.getText().toString();
                    String altura = txtAltura.getText().toString();

                    Intent intent = new Intent(MainActivity.this,RectanguloActivity.class);
                    intent.putExtra("nombre",nombre);
                    intent.putExtra("base",base);
                    intent.putExtra("altura",altura);
                    startActivity(intent);

                }
            }
        });

    }

    public void iniciar(){
        txtNombre = (EditText) findViewById(R.id.txtNombre);
        txtAltura = (EditText) findViewById(R.id.txtAltura);
        txtBase = (EditText) findViewById(R.id.txtBase);
        btnLimpiar = (Button) findViewById(R.id.btnLimpiar);
        btnSiguiente = (Button) findViewById(R.id.btnSig);
        btnSalir = (Button) findViewById(R.id.btnSalir);
    }
}