package com.example.agence_immo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText editTextRue, editTextVille, editTextCodePostal, editTextEtage;
    private CheckBox checkBoxAscenseur;
    private Button buttonCreer;
    private Appartement nouvelAppartement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialiser les vues
        editTextRue = findViewById(R.id.editTextRue);
        editTextVille = findViewById(R.id.editTextVille);
        editTextCodePostal = findViewById(R.id.editTextCodePostal);
        editTextEtage = findViewById(R.id.editTextEtage);
        checkBoxAscenseur = findViewById(R.id.checkBoxAscenseur);
        buttonCreer = findViewById(R.id.buttonCreer);

        // Gestionnaire de clic pour le bouton Créer
        buttonCreer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                creerAppartement();
            }
        });
    }

    private void creerAppartement() {
        // Récupérer les valeurs des champs de texte
        String rue = editTextRue.getText().toString();
        String ville = editTextVille.getText().toString();
        String codePostal = editTextCodePostal.getText().toString();
        int etage = Integer.parseInt(editTextEtage.getText().toString());
        boolean ascenseur = checkBoxAscenseur.isChecked();

        // Créer un nouvel appartement
        nouvelAppartement = new Appartement(rue, ville, codePostal, etage, ascenseur);

        // Passer les données à DetailAppartementActivity
        Intent intent = new Intent(MainActivity.this, DetailAppartementActivity.class);
        intent.putExtra("rue", rue);
        intent.putExtra("ville", ville);
        intent.putExtra("codePostal", codePostal);
        intent.putExtra("etage", etage);
        intent.putExtra("ascenseur", ascenseur);
        startActivity(intent);
    }


}