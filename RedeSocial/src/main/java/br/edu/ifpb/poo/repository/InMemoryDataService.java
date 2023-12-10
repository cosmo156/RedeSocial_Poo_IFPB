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
        return this.usuarios.stream()
                .filter(user -> user.getNome().equals(nome))
                .findFirst()
                .orElse(null);
    }

    @Override
    public boolean userExists(String nome) {
        return this.usuarios.stream().anyMatch(user -> user.getNome().contains(nome));
    }

    @Override
    public Usuario logarUsuario(String nome, String senha) {
        return this.usuarios.stream()
                .filter(user -> user.getNome().equals(nome) && user.getSenha().equals(senha))
                .findFirst()
                .orElse(null);
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
        Usuario autorPost = postagem.getAuthor();
        int index = autorPost.getPostagens().indexOf(postagem);
        autorPost.getPostagens().get(index).curtir(user);
    }

    @Override
    public void removerCurtida(Usuario user, Postagem postagem) {
        Usuario autorPost = postagem.getAuthor();
        int index = autorPost.getPostagens().indexOf(postagem);
        autorPost.getPostagens().get(index).removerCurtida(user);
    }

    @Override
    public List<Postagem> getAllPost() {
        List<Postagem> allpost = new ArrayList<>();
        for (Usuario user: getAllUser()){
            allpost.addAll(user.getPostagens());
        }
        return allpost;
    }
}
