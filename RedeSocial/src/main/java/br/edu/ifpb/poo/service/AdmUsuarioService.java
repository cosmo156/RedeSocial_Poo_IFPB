package br.edu.ifpb.poo.service;

import br.edu.ifpb.poo.domain.Comentario;
import br.edu.ifpb.poo.domain.Postagem;
import br.edu.ifpb.poo.domain.Usuario;
import br.edu.ifpb.poo.repository.AdmUsuarioRepository;

import java.io.Serializable;
import java.util.List;

public class AdmUsuarioService implements Serializable {
    private final transient AdmUsuarioRepository repository;

    public AdmUsuarioService(AdmUsuarioRepository repository){
        this.repository = repository;
    }

    public void criarUser(String nome, String senha){
        repository.add(new Usuario(nome, senha));
    }

    public Usuario search(String nome){
        return repository.searchUser(nome);
    }

    public List<Usuario> getAllUser(){
        return repository.getAllUser();
    }

    public boolean userExists(String nome){
        return repository.userExists(nome);
    }

    public List<Postagem> getAllPost(){
        return repository.getAllPost();
    }

    public Usuario logarUsuario(String nome, String senha){
        return repository.logarUsuario(nome, senha);
    }

    public void fazerPostagem(Usuario user, Postagem postagem){
        this.repository.fazerPostagem(user, postagem);
    }

    public void fazerComentario(Usuario user, Postagem postagem, Comentario comentario){
        this.repository.fazerComentario(user, postagem, comentario);
    }

    public void curtir(Usuario user, Postagem postagem){
        this.repository.curtir(user, postagem);
    }

    public void removerCurtida(Usuario user, Postagem postagem){
        this.repository.removerCurtida(user, postagem);
    }

    public List<Postagem> getPostagens(Usuario user){
        return this.repository.getPostagens(user);
    }

    public List<Comentario> getComentario(Postagem postagem){
        return this.repository.getComentario(postagem);
    }

    public int getCurtidas(Postagem postagem){
        return  this.repository.getCurtidas(postagem);
    }

}
