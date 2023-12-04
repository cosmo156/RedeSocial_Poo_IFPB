package br.edu.ifpb.poo.repository;

import br.edu.ifpb.poo.adpter.DataService;
import br.edu.ifpb.poo.domain.Comentario;
import br.edu.ifpb.poo.domain.Postagem;
import br.edu.ifpb.poo.domain.Usuario;
import java.util.ArrayList;
import java.util.List;

public class InMemoryDataService implements DataService {
    protected List<Usuario> usuarios = new ArrayList<>();

    @Override
    public void add(Usuario user) {
        this.usuarios.add(user);
    }

    @Override
    public List<Usuario> getAllUser() {
        return this.usuarios;
    }


    @Override
    public Usuario searchUser(String nome) {
        for (Usuario usuarioSearch: this.usuarios){
            if (usuarioSearch.getNome().equals(nome)){
                return usuarioSearch;
            }
        }
        return null;
    }

    @Override
    public boolean userExists(String nome) {
        return this.usuarios.stream().anyMatch(user -> user.getNome().contains(nome));
    }

    @Override
    public Usuario logarUsuario(String nome, String senha){
        for (Usuario user: this.usuarios){
            if (user.getNome().equals(nome) && user.getSenha().equals(senha)){
                return user;
            }
        }
        return null;
    }

    @Override
    public void fazerPostagem(Usuario user, Postagem postagem) {
            user.fazerPostagem(postagem);
    }

    @Override
    public void fazerComentario(Usuario user, Postagem postagem, Comentario comentario) {
        int index = user.getPostagens().indexOf(postagem);
        user.getPostagens().get(index).adicionarComentario(comentario);
    }

    @Override
    public void curtir(Usuario user, Postagem postagem) {
        int index = user.getPostagens().indexOf(postagem);
        user.getPostagens().get(index).curtir();
    }

    @Override
    public void removerCurtida(Usuario user, Postagem postagem) {
        int index = user.getPostagens().indexOf(postagem);
        user.getPostagens().get(index).removerCurtida();
    }

    @Override
    public List<Postagem> getAllPost() {
        List<Postagem> allpost = new ArrayList<>();
        for (Usuario user: getAllUser()){
            allpost.addAll(user.getPostagens());
        }
        return allpost;
    }

    @Override
    public List<Postagem> getPostagens(Usuario user) {
        return user.getPostagens();
    }

    @Override
    public List<Comentario> getComentarios(Postagem postagem) {
        return postagem.getComentarios();
    }

    @Override
    public int getCurtidas(Postagem postagem) {
        return postagem.getCurtidas();
    }
}
