package com.example.agence_immo;

import java.io.Serializable;

public class Piece implements Serializable {
    private String typePiece;
    private double surface; // en m²

    public Piece(String typePiece, double surface) {
        this.typePiece = typePiece;
        this.surface = surface;
    }

    public String getTypePiece() {
        return typePiece;
    }

    public double getSurface() {
        return surface;
    }
}


