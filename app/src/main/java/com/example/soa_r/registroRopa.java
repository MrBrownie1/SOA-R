package com.example.soa_r;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;


import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;




public class registroRopa extends AppCompatActivity {
    EditText txttalla, txtgenero, txtestado, txttipo;
    Button btnRegistrar;


    private FirebaseFirestore mfirestore;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_ropa);

        txttalla = findViewById(R.id.Talla);
        txtgenero = findViewById(R.id.Genero);
        txtestado = findViewById(R.id.Estado);
        txttipo = findViewById(R.id.Tipo);
        btnRegistrar = findViewById(R.id.btnRegistrar);


        mfirestore = FirebaseFirestore.getInstance();
        mAuth = FirebaseAuth.getInstance();


        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String talla1 = txttalla.getText().toString().trim();
                String genero1 = txtgenero.getText().toString().trim();
                String estado1 = txtestado.getText().toString().trim();
                String tipo1 = txttipo.getText().toString().trim();

                if (talla1.isEmpty() && genero1.isEmpty() && estado1.isEmpty() && tipo1.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "ingresa los datos", Toast.LENGTH_SHORT).show();

                } else {
                    postRopa(talla1, genero1, estado1, tipo1);
                }
            }
        });


    }//end onCrate

    private void postRopa(String talla1, String genero1, String estado1, String tipo1) {

        DocumentReference id = mfirestore.collection("ropas").document();

        Map<String, Object> ropas = new HashMap<>();

        ropas.put("id", id.getId());
        ropas.put("Talla", talla1);
        ropas.put("Genero", genero1);
        ropas.put("Estado", estado1);
        ropas.put("Tipo", tipo1);

        mfirestore.collection("ropas").document(id.getId()).set(ropas).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                Toast.makeText(getApplicationContext(), "Creado exitosamente", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(registroRopa.this, MainActivity.class));
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getApplicationContext(), "Error al ingresar", Toast.LENGTH_SHORT).show();
            }
        });

    }

}

