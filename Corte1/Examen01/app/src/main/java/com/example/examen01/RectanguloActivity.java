package com.example.examen01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class RectanguloActivity extends AppCompatActivity {

    private TextView lblNombre;
    private TextView lblBase;
    private TextView lblAltura;
    private RadioButton rdbArea;
    private RadioButton rdbPerimetro;
    private TextView lblResultado;
    private Button btnCalcular;
    private Button btnRegresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rectangulo);
        iniciar();


        Intent intent = new Intent();

        lblNombre.setText("Nombre: " + intent.getStringExtra("name"));
        lblBase.setText("Base: " + intent.getStringExtra("base"));
        lblAltura.setText("Altura: " + intent.getStringExtra("altura"));

        float numBase = Float.parseFloat(intent.getStringExtra("base"));
        float numAltura = Float.parseFloat(intent.getStringExtra("altura"));
        Rectangulo rectangulo = new Rectangulo(numBase,numAltura);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rdbArea.isChecked()){
                    lblResultado.setText("El resultado es: "+ rectangulo.calculoArea());
                }else if (rdbPerimetro.isChecked()){
                    lblResultado.setText("El resultado es: "+ rectangulo.calculoPerimetro());
                }else{
                    Toast.makeText(RectanguloActivity.this, "Seleccione una opción", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    public void iniciar(){
        lblNombre = (TextView) findViewById(R.id.lblNombre);
        lblBase = (TextView) findViewById(R.id.lblBase);
        lblAltura = (TextView) findViewById(R.id.lblAltura);
        rdbArea = (RadioButton) findViewById(R.id.rdbArea);
        rdbPerimetro = (RadioButton) findViewById(R.id.rdbPerimetro);
        lblResultado = (TextView) findViewById(R.id.lblResultado);
        btnCalcular = (Button) findViewById(R.id.btnCalcular);
        btnRegresar = (Button) findViewById(R.id.btnRegresar);
        RadioButton radioArea = (RadioButton) findViewById(R.id.rdbArea);
        RadioButton radioPerimetro = (RadioButton) findViewById(R.id.rdbPerimetro);
    }
}