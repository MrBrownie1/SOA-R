package com.example.soa_r;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class mein extends AppCompatActivity {
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mein);

        mAuth = FirebaseAuth.getInstance();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.item1:
                startActivity(new Intent(mein.this,registroRopa.class));
                return true;
            case R.id.item2:
                startActivity(new Intent(mein.this,vistaDatos.class));
                return true;
            case R.id.item3:
                startActivity(new Intent(mein.this,mein.class));
                return true;
            case R.id.item4:
                cerrar();
                return true;
            case R.id.item5:
                startActivity(new Intent(mein.this,perfilUsuario.class));
                return true;
            default:

        }
        return super.onOptionsItemSelected(item);
    }
    public void cerrar(){
        mAuth.signOut();
        finish();
        Toast.makeText(this, "Haz cerrado sesión satisfactoriamente", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(mein.this, MainActivity.class));

    }
}