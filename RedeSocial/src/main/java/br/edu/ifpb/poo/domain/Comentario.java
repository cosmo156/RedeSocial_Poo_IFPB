package br.edu.ifpb.poo.domain;

import java.io.Serializable;

public class Comentario implements Serializable {
    private String texto;

    public Comentario(String texto) {
        this.texto = texto;
    }

    public String getTexto() {
        return texto;
    }

    public String toString() {
        return this.texto;
    }
}
