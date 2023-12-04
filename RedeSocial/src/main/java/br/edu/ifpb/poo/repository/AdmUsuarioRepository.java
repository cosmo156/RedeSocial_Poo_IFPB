package br.edu.ifpb.poo.repository;

import br.edu.ifpb.poo.adpter.DataService;
import br.edu.ifpb.poo.domain.Comentario;
import br.edu.ifpb.poo.domain.Postagem;
import br.edu.ifpb.poo.domain.Usuario;

import java.io.Serializable;
import java.util.List;

public class AdmUsuarioRepository implements Serializable {
    private transient DataService dataService;
    private static AdmUsuarioRepository instance;

    private AdmUsuarioRepository(DataService dataService){
        this.dataService = dataService;
    }

    public static AdmUsuarioRepository getInstance() {
        if (instance == null) {
            instance = new AdmUsuarioRepository(new InMemoryDataService());
        }
        return instance;
    }

    public void setRepository(DataService dataService){
        this.dataService = dataService;
    }

    public void add(Usuario user){
        this.dataService.add(user);
    }

    public List<Usuario> getAllUser(){
        return this.dataService.getAllUser();
    }


    public Usuario searchUser(String nome){
        return this.dataService.searchUser(nome);
    }

    public boolean userExists(String nome){
        return this.dataService.userExists(nome);
    }

    public List<Postagem> getAllPost(){
        return this.dataService.getAllPost();
    }

    public Usuario logarUsuario(String nome, String senha){
        return this.dataService.logarUsuario(nome, senha);
    }

    public void fazerPostagem(Usuario user, Postagem postagem){
        this.dataService.fazerPostagem(user, postagem);
    }

    public void fazerComentario(Usuario user, Postagem postagem, Comentario comentario){
        this.dataService.fazerComentario(user, postagem, comentario);
    }

    public void curtir(Usuario user, Postagem postagem){
        this.dataService.curtir(user, postagem);
    }
    public void removerCurtida(Usuario user, Postagem postagem){
        this.dataService.removerCurtida(user, postagem);
    }

    public List<Postagem> getPostagens(Usuario user){
        return  this.dataService.getPostagens(user);
    }

    public List<Comentario> getComentario(Postagem postagem){
        return this.dataService.getComentarios(postagem);
    }

    public int getCurtidas(Postagem postagem){
        return  this.dataService.getCurtidas(postagem);
    }
}
