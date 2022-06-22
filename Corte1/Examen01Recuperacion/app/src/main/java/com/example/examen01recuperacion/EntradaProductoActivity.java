package com.example.examen01recuperacion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class EntradaProductoActivity extends AppCompatActivity {

    private TextView lblProducto;
    private TextView lblPrecioC;
    private TextView lblPrecioV;
    private TextView lblGanancia;
    private Button btnCalcular;
    private Button btnRegresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrada_producto);
        iniciar();

        Intent intent = getIntent();


        EntradaProducto entrada = new EntradaProducto();

        int precioC = Integer.parseInt(intent.getStringExtra("PrecioC"));
        int precioV = Integer.parseInt(intent.getStringExtra("PrecioV"));
        int cantidad = Integer.parseInt(intent.getStringExtra("Cantidad"));

        lblProducto.setText("Producto: "+ intent.getStringExtra("Codigo"));

        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lblPrecioC.setText("Total Precio de Compra: "+String.valueOf(entrada.calcularPrecioCompra(precioC, cantidad)));
                lblPrecioV.setText("Total Precio de Venta: "+String.valueOf(entrada.calcularPrecioVenta(precioV,cantidad)));
                lblGanancia.setText("Total Ganacia: "+String.valueOf(entrada.calcularGanancia(precioV,precioC,cantidad)));
            }
        });
    }

    public void iniciar(){
        lblGanancia = (TextView) findViewById(R.id.lblGanancia);
        lblPrecioC = (TextView) findViewById(R.id.lblPrecioC);
        lblPrecioV = (TextView) findViewById(R.id.lblPrecioV);
        lblProducto = (TextView) findViewById(R.id.lblProducto);
        btnRegresar = (Button) findViewById(R.id.btnRegresar);
        btnCalcular = (Button) findViewById(R.id.btnCalcular);

    }
}