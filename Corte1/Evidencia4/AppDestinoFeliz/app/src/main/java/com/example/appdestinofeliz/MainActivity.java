package com.example.appdestinofeliz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText txtNombre,txtEdad, txtID, txtPrecio, txtFecha;
    private Spinner spnDestino, spnTipo;
    private TextView lblSubtotal, lblImpuesto, lblDescuento, lblTotal;
    private Button btnMostrar, btnLimpiar, btnSalir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Boleto boleto = new Boleto();
        txtNombre = (EditText) findViewById(R.id.txtNombre);
        txtEdad = (EditText) findViewById(R.id.txtEdad);
        txtID = (EditText) findViewById(R.id.txtID);
        txtPrecio = (EditText) findViewById(R.id.txtPrecio);
        txtFecha = (EditText) findViewById(R.id.txtFecha);
        lblSubtotal = (TextView) findViewById(R.id.lblSubTotal);
        lblImpuesto = (TextView) findViewById(R.id.lblImpuesto);
        lblDescuento = (TextView) findViewById(R.id.lblDescuento);
        lblTotal = (TextView) findViewById(R.id.lblTotal);
        spnDestino = (Spinner) findViewById(R.id.spnDestino);
        spnTipo = (Spinner) findViewById(R.id.spnTipo);
        btnLimpiar = (Button) findViewById(R.id.btnLimpiar);
        btnMostrar = (Button) findViewById(R.id.btnMostrar);
        btnSalir = (Button) findViewById(R.id.btnSalir);

        btnMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txtNombre.getText().toString().matches("") || txtEdad.getText().toString().matches("") || txtID.getText().toString().matches("")
                        || txtFecha.getText().toString().matches("") || txtPrecio.getText().toString().matches("")){
                    Toast.makeText(MainActivity.this, "Faltan campos por llenar", Toast.LENGTH_SHORT).show();
                }else{
                    boleto.setNombre(txtNombre.getText().toString());
                    boleto.setId(Integer.parseInt(txtID.getText().toString()));
                    boleto.setFecha(txtFecha.getText().toString());
                    boleto.setPrecio(Float.parseFloat(txtPrecio.getText().toString()));

                    lblSubtotal.setText("Subtotal: " + boleto.mostrarPrecio() );
                    lblTotal.setText("Total: " + boleto.mostrarTotal(Integer.parseInt(txtID.getText().toString())));
                    lblImpuesto.setText("Impuesto: " + boleto.mostrarIVA());
                    lblDescuento.setText("Descuento: " + boleto.mostrarDescuento(Integer.parseInt(txtID.getText().toString())));
                }
            }
        });

        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtNombre.setText("");
                txtEdad.setText("");
                txtPrecio.setText("");
                txtID.setText("");
                txtFecha.setText("");
            }
        });
        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        ArrayAdapter<String> Adaptador =new
                ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_expandable_list_item_1,
                getResources().getStringArray(R.array.destinosViaje));
        ArrayAdapter<String> Adaptador2 =new
                ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_expandable_list_item_1,
                getResources().getStringArray(R.array.tipo));
        spnDestino.setAdapter(Adaptador);
        spnTipo.setAdapter(Adaptador2);
        spnDestino.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this,"Selecciono viaje a " + adapterView.getItemAtPosition(i).toString(),Toast.LENGTH_SHORT).show();
                boleto.setDestino(adapterView.getItemAtPosition(i).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }


        });
        spnTipo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this,"Selecciono " + adapterView.getItemAtPosition(i).toString(),Toast.LENGTH_SHORT).show();
                boleto.setTipoViaje(Integer.parseInt(adapterView.getItemAtPosition(i).toString()));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}