package br.edu.ifpb.poo.domain;

import java.io.Serializable;

public class Curtida implements Serializable {
    private int numeroCurtidas;

    public Curtida(){
        this.numeroCurtidas = 0;
    }

    public int getNumeroCurtidas(){
        return this.numeroCurtidas;
    }

    public void curtir(){
        this.numeroCurtidas++;
    }

    public void descurtir(){
        if (this.numeroCurtidas == 0){
            return;
        }
        this.numeroCurtidas--;
    }
}
