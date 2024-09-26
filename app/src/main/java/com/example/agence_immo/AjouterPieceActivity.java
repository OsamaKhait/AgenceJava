package com.example.agence_immo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AjouterPieceActivity extends AppCompatActivity {

    private Spinner spinnerTypePiece;
    private EditText editTextNiveau, editTextLongueur, editTextLargeur;
    private Button buttonCreer;
    private Appartement appartement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajouter_piece);

        // Récupérer l'appartement passé par l'activité précédente
        Intent intent = getIntent();
        appartement = (Appartement) intent.getSerializableExtra("appartement");

        // Initialiser le Spinner
        spinnerTypePiece = findViewById(R.id.spinnerTypePiece);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.types_de_piece, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTypePiece.setAdapter(adapter);

        editTextNiveau = findViewById(R.id.editTextNiveau);
        editTextLongueur = findViewById(R.id.editTextLongueur);
        editTextLargeur = findViewById(R.id.editTextLargeur);
        buttonCreer = findViewById(R.id.buttonCreer);

        // Gestionnaire de clic pour le bouton Créer
        buttonCreer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ajouterPiece();
            }
        });
    }

    private void ajouterPiece() {
        // Récupérer les valeurs saisies
        String typePiece = spinnerTypePiece.getSelectedItem().toString();
        String niveauStr = editTextNiveau.getText().toString();
        String longueurStr = editTextLongueur.getText().toString();
        String largeurStr = editTextLargeur.getText().toString();

        if (niveauStr.isEmpty() || longueurStr.isEmpty() || largeurStr.isEmpty()) {
            Toast.makeText(this, "Veuillez remplir tous les champs", Toast.LENGTH_SHORT).show();
            return;
        }

        int niveau = Integer.parseInt(niveauStr);
        double longueur = Double.parseDouble(longueurStr);
        double largeur = Double.parseDouble(largeurStr);
        double surface = longueur * largeur; // Calcul de la surface

        // Créer une nouvelle pièce
        Piece piece = new Piece(typePiece, surface);
        appartement.ajouterPiece(piece); // Ajouter la pièce à l'appartement

        // Créer un Intent pour retourner à l'activité de détail
        Intent intent = new Intent(AjouterPieceActivity.this, DetailAppartementActivity.class);
        intent.putExtra("appartement", appartement); // Passer l'appartement mis à jour
        startActivity(intent);
    }
}
