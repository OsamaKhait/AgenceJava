package com.example.agence_immo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class DetailAppartementActivity extends AppCompatActivity {

    private TextView textViewDetails;
    private Button buttonAjouterPiece;
    private Appartement appartement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_appartement);

        textViewDetails = findViewById(R.id.textViewDetails);
        buttonAjouterPiece = findViewById(R.id.buttonAjouterPiece);

        // Récupérer les données de l'intent
        Intent intent = getIntent();
        String rue = intent.getStringExtra("rue");
        String ville = intent.getStringExtra("ville");
        String codePostal = intent.getStringExtra("codePostal");
        int etage = intent.getIntExtra("etage", 0);
        boolean ascenseur = intent.getBooleanExtra("ascenseur", false);

        // Créer l'appartement avec les données récupérées
        appartement = new Appartement(rue, ville, codePostal, etage, ascenseur);

        // Afficher les détails de l'appartement
        afficherDetailsAppartement();

        // Gestionnaire de clic pour le bouton Ajouter une pièce
        buttonAjouterPiece.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailAppartementActivity.this, AjouterPieceActivity.class);
                intent.putExtra("appartement", appartement); // Passer l'appartement à la nouvelle activité
                startActivity(intent);
            }
        });
    }

    private void afficherDetailsAppartement() {
        StringBuilder details = new StringBuilder(appartement.getDetails());
        details.append("\n\nPièces :\n");
        for (Piece piece : appartement.getPieces()) {
            details.append("Type: ").append(piece.getTypePiece())
                    .append(", Surface: ").append(piece.getSurface()).append(" m²\n");
        }
        textViewDetails.setText(details.toString());
    }

}

