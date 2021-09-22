package com.example.testemapa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class tela_usuario extends AppCompatActivity {

    private EditText edtlongitude;
    private EditText edtlatitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_usuario);
        edtlongitude = (EditText) findViewById(R.id.edtlongitude);
        edtlatitude = (EditText) findViewById(R.id.edtlatitude);
    }


    public void clickBtnEnviar(View view) {

        Double latitude = Double.parseDouble(edtlatitude.getText().toString());
        Double longitude = Double.parseDouble(edtlongitude.getText().toString());

        Intent intentEnviador = new Intent(getApplicationContext(), MapsActivity.class);

        Bundle parametros = new Bundle();
        parametros.putDouble("chave_latitude", latitude);
        parametros.putDouble("chave_longitude", longitude);

        intentEnviador.putExtras(parametros);

        startActivity(intentEnviador);
    }
}