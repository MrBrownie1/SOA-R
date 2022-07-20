package com.example.soa_r;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class registroRopa extends AppCompatActivity implements View.OnClickListener {

    EditText txttalla, txtgenero, txtestado, txttipo;

    Button btnRegistrar;

    RequestQueue requestQueue;

    private static final String URL1 = "http://192.168.0.174/soa_bd/insertar.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_ropa);


        requestQueue = Volley.newRequestQueue(this);

        //UI
        initUI();


        btnRegistrar.setOnClickListener(this);

    }

    private void initUI() {

        txttalla = findViewById(R.id.Talla);
        txtgenero = findViewById(R.id.Genero);
        txtestado = findViewById(R.id.Estado);
        txttipo =  findViewById(R.id.Tipo);
        btnRegistrar =  findViewById(R.id.btnRegistrar);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        if (id == R.id.btnRegistrar) {
            String talla = txttalla.getText().toString().trim();
            String genero = txtgenero.getText().toString().trim();
            String estado = txtestado.getText().toString().trim();
            String tipo = txttipo.getText().toString().trim();

            createUser(talla, genero, estado, tipo);

        }
    }

    private void createUser(final String talla, final String genero, final String estado, final String tipo) {

        StringRequest stringRequest = new StringRequest(
                Request.Method.POST,
                URL1,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(registroRopa.this, "Operacion Exitosa", Toast.LENGTH_SHORT).show();

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(registroRopa.this, "Operacion fallida", Toast.LENGTH_SHORT).show();
                    }
                }
        ) {
            @Override

            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("talla", talla);
                params.put("genero", genero);
                params.put("estado", estado);
                params.put("tipo", tipo);
                return params;
            }

        };

        requestQueue.add(stringRequest);
    }
}
