package br.edu.ifpb.poo.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Curtida implements Serializable {
    private final List<Usuario> numeroCurtidas;

    public Curtida(){
        this.numeroCurtidas = new ArrayList<>();
    }

    public int getNumeroCurtidas(){
        return this.numeroCurtidas.size();
    }

    public void curtir(Usuario user){
        if (isUserCurtida(user)){
            return;
        }
        this.numeroCurtidas.add(user);
    }

    public void descurtir(Usuario user){
        if (this.numeroCurtidas.isEmpty()){
            return;
        }
        this.numeroCurtidas.remove(user);
    }

    public boolean isUserCurtida(Usuario user){
        return this.numeroCurtidas.contains(user);
    }
}
