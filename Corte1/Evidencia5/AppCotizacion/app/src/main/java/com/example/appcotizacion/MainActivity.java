package com.example.appcotizacion;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText numeroCotOb ,descriOb, precioOb,porcentajeOb,plazoOb;
    private TextView numeroCotL, descriL, precioL, porcentajeL,plazoL,pagoIl,totalA,pagoMen;
    private Button btnMostrar, btnLimpiar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Cotizacion bol = new Cotizacion();
        numeroCotOb= (EditText) findViewById(R.id.numeroCotOb);
        descriOb= (EditText) findViewById(R.id.descriOb);
        precioOb= (EditText) findViewById(R.id.precioOb);
        porcentajeOb= (EditText) findViewById(R.id.porcentajeOb);
        plazoOb= (EditText) findViewById(R.id.plazoOb);
        btnMostrar= (Button) findViewById(R.id.btnMostrar);
        btnLimpiar= (Button) findViewById(R.id.btnLimpiar);
        numeroCotL = (TextView) findViewById(R.id.numeroCotL);
        descriL = (TextView) findViewById(R.id.descriL);
        precioL = (TextView) findViewById(R.id.precioL);
        porcentajeL = (TextView) findViewById(R.id.porcentajeL);
        plazoL = (TextView) findViewById(R.id.plazoL);
        pagoIl = (TextView) findViewById(R.id.pagoIl);
        totalA = (TextView) findViewById(R.id.totalA);
        pagoMen = (TextView) findViewById(R.id.pagoMen);
        btnLimpiar.setVisibility(View.INVISIBLE);
        pagoIl.setVisibility(View.INVISIBLE);
        totalA.setVisibility(View.INVISIBLE);
        pagoMen.setVisibility(View.INVISIBLE);
        btnMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(numeroCotOb.getText().toString().matches("") || descriOb.getText().toString().matches("") || precioOb.getText().toString().matches("") ||
                        porcentajeOb.getText().toString().matches("") || plazoOb.getText().toString().matches("")){
                    Toast.makeText(MainActivity.this,"Favor de rellenar todos los espacios",Toast.LENGTH_SHORT).show();
                }else{

                    bol.setDescripcion(descriOb.getText().toString());
                    bol.setPorcentajeP(Integer.parseInt(porcentajeOb.getText().toString()));
                    bol.setPlazo(Integer.parseInt(plazoOb.getText().toString()));
                    bol.setId(Integer.parseInt(numeroCotOb.getText().toString()));
                    bol.setPrecio(Float.parseFloat(precioOb.getText().toString()));

                    descriL.setTranslationY(-140);
                    precioL.setTranslationY(-275);
                    porcentajeL.setTranslationY(-415);
                    plazoL.setTranslationY(-555);
                    pagoIl.setTranslationY(-690);
                    totalA.setTranslationY(-690);
                    pagoMen.setTranslationY(-690);

                    descriOb.setVisibility(View.INVISIBLE);
                    porcentajeOb.setVisibility(View.INVISIBLE);
                    plazoOb.setVisibility(View.INVISIBLE);
                    numeroCotOb.setVisibility(View.INVISIBLE);
                    precioOb.setVisibility(View.INVISIBLE);
                    btnLimpiar.setVisibility(View.VISIBLE);
                    pagoIl.setVisibility(View.VISIBLE);
                    totalA.setVisibility(View.VISIBLE);
                    pagoMen.setVisibility(View.VISIBLE);
                    btnMostrar.setVisibility(View.INVISIBLE);
                    numeroCotOb.setText("");
                    descriOb.setText("");
                    precioOb.setText("");
                    porcentajeOb.setText("");
                    plazoOb.setText("");

                    numeroCotL.setText("Numero de cotizacion: "+bol.getId());
                    descriL.setText("Descripcion: "+ bol.getDescripcion());
                    precioL.setText("Precio: "+bol.getPrecio());
                    porcentajeL.setText("Porcentaje: "+bol.getPorcentajeP()+"%");
                    plazoL.setText("Plazo: "+bol.getPlazo());
                    pagoIl.setText("Pago inicial: "+bol.calcularPagoInicial());
                    totalA.setText("Total a fin: "+bol.calcularTotal());
                    pagoMen.setText("Pago mensual: "+bol.calcularMensualidad());
                }
            }
        });

        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                descriOb.setVisibility(View.VISIBLE);
                porcentajeOb.setVisibility(View.VISIBLE);
                plazoOb.setVisibility(View.VISIBLE);
                numeroCotOb.setVisibility(View.VISIBLE);
                precioOb.setVisibility(View.VISIBLE);
                btnMostrar.setVisibility(View.VISIBLE);
                btnLimpiar.setVisibility(View.INVISIBLE);
                pagoIl.setVisibility(View.INVISIBLE);
                totalA.setVisibility(View.INVISIBLE);
                pagoMen.setVisibility(View.INVISIBLE);
                descriL.setTranslationY(0);
                precioL.setTranslationY(0);
                porcentajeL.setTranslationY(0);
                plazoL.setTranslationY(0);
                pagoIl.setTranslationY(0);
                totalA.setTranslationY(0);
                pagoMen.setTranslationY(0);

                numeroCotL.setText("Numero de cotizacion: ");
                descriL.setText("Descripcion: ");
                precioL.setText("Precio: ");
                porcentajeL.setText("Porcentaje: ");
                plazoL.setText("Plazo: ");
                pagoIl.setText("");
                totalA.setText("");
                pagoMen.setText("");

            }
        });
    }
}