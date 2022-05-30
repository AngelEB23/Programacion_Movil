package com.example.app1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnSaludar;
    private EditText txtNombre;
    private TextView lblSaludo;
    private Button btnSalir;
    private Button btnBorrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSaludar = (Button) findViewById(R.id.btnSaludo);
        txtNombre = (EditText) findViewById(R.id.txtSaludo2);
        lblSaludo =(TextView) findViewById(R.id.lblSaludo);
        btnBorrar =(Button) findViewById(R.id.btnBorrar);
        btnSalir =(Button) findViewById(R.id.btnSalir);

        btnSaludar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(txtNombre.getText().toString().matches("")){
                    Toast.makeText(MainActivity.this,"Favor de ingresar un nombre",Toast.LENGTH_SHORT).show();
                }
                else{
                    String txtSaludar = txtNombre.getText().toString();
                    lblSaludo.setText("Hola " + txtSaludar + " Como Estas? ");
                }
            }
        });



        btnBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lblSaludo.setText("Ingresa tu nombre: ");
                txtNombre.setText("");
            }
        });
        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

}