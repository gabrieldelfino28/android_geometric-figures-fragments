package br.edu.fateczl.geometrycalculator.model;

import androidx.annotation.NonNull;

public class Circulo {
    private float raio;

    public Circulo() {
        super();
    }

    public float getRaio() {
        return raio;
    }

    public void setRaio(float raio) {
        this.raio = raio;
    }

    @NonNull
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Circulo {");
        sb.append("raio=").append(raio);
        sb.append('}');
        return sb.toString();
    }
}
