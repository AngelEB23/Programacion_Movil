package com.example.examen01recuperacion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText txtCodigo;
    private EditText txtDescripcion;
    private EditText txtUnidad;
    private EditText txtPrecioV;
    private EditText txtPrecioC;
    private EditText txtCantidad;
    private Button btnSalir;
    private Button btnEnviar;
    private Button btnLimpiar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iniciar();

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txtPrecioV.getText().toString().matches("") || txtPrecioC.getText().toString().matches("") ||
                        txtCodigo.getText().toString().matches("") || txtDescripcion.getText().toString().matches("") ||
                        txtUnidad.getText().toString().matches("") || txtCantidad.getText().toString().matches("")) {
                    Toast.makeText(MainActivity.this, "No ha llenado todos los campos", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(MainActivity.this, EntradaProductoActivity.class);
                    intent.putExtra("Codigo", txtCodigo.getText().toString());
                    intent.putExtra("PrecioC", txtPrecioC.getText().toString());
                    intent.putExtra("PrecioV", txtPrecioV.getText().toString());
                    intent.putExtra("Cantidad", txtCantidad.getText().toString());
                    startActivity(intent);
                }
            }
        });

        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtCantidad.setText("");
                txtCodigo.setText("");
                txtDescripcion.setText("");
                txtUnidad.setText("");
                txtPrecioC.setText("");
                txtPrecioV.setText("");
            }
        });

        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    public void iniciar() {
        txtCodigo = (EditText) findViewById(R.id.txtCodigo);
        txtDescripcion = (EditText) findViewById(R.id.txtDescripcion);
        txtUnidad = (EditText) findViewById(R.id.txtUnidad);
        txtPrecioV = (EditText) findViewById(R.id.txtPrecioV);
        txtPrecioC = (EditText) findViewById(R.id.txtPrecioC);
        txtCantidad = (EditText) findViewById(R.id.txtCantidad);
        btnEnviar = (Button) findViewById(R.id.btnEnviar);
        btnLimpiar = (Button) findViewById(R.id.btnLimpiar);
        btnSalir = (Button) findViewById(R.id.btnSalir);
    }
}