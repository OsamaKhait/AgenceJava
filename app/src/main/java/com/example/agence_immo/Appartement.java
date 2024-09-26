package com.example.agence_immo;

import java.io.Serializable;
import java.util.ArrayList;

public class Appartement implements Serializable {
    private String rue;
    private String ville;
    private String codePostal;
    private int etage;
    private boolean ascenseur;
    private ArrayList<Piece> pieces; // Liste des pièces

    // Constructeur
    public Appartement(String rue, String ville, String codePostal, int etage, boolean ascenseur) {
        this.rue = rue;
        this.ville = ville;
        this.codePostal = codePostal;
        this.etage = etage;
        this.ascenseur = ascenseur;
        this.pieces = new ArrayList<>();
    }

    // Méthode pour ajouter une pièce
    public void ajouterPiece(Piece piece) {
        pieces.add(piece);
    }

    // Méthode pour obtenir les détails de l'appartement
    public String getDetails() {
        return "Rue: " + rue + "\nVille: " + ville + "\nCode Postal: " + codePostal +
                "\nÉtage: " + etage + "\nAscenseur: " + (ascenseur ? "Oui" : "Non");
    }

    // Getter pour les pièces
    public ArrayList<Piece> getPieces() {
        return pieces; // Assurez-vous que cette méthode est présente
    }
}