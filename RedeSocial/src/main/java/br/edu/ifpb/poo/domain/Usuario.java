package br.edu.ifpb.poo.domain;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Usuario implements Serializable {

    private String nome;
    private String senha;
    private List<Postagem> postagens;

    public Usuario(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
        this.postagens = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Postagem> getPostagens() {
        return this.postagens;
    }

    public void fazerPostagem(Postagem postagem) {
        this.postagens.add(postagem);
    }

    @Override
    public String toString() {
        return this.nome;
    }
}
