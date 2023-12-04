package br.edu.ifpb.poo.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Postagem implements Serializable {
    private String texto;
    private Curtida curtidas;
    private List<Comentario> comentarios;
    private Usuario author;

    public Postagem(Usuario author, String texto) {
        this.texto = texto;
        this.curtidas = new Curtida();
        this.comentarios = new ArrayList<>();
        this.author = author;
    }

    public String getTexto(){
        return this.texto;
    }

    public int getCurtidas() {
        return curtidas.getNumeroCurtidas();
    }

    public Usuario getAuthor() {
        return this.author;
    }

    public void curtir() {
        this.curtidas.curtir();
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void removerCurtida() {
       this.curtidas.descurtir();
    }

    public void adicionarComentario(Comentario comentario) {
        this.comentarios.add(comentario);
    }

    public String toString() {
        return this.texto;
    }
}
