package br.edu.ifpb.poo.adpter;
import br.edu.ifpb.poo.domain.Comentario;
import br.edu.ifpb.poo.domain.Postagem;
import br.edu.ifpb.poo.domain.Usuario;

import java.util.List;

public interface DataService {
    void add(Usuario user);
    List<Usuario> getAllUser();
    Usuario searchUser(String nome);
    boolean userExists(String nome);
    Usuario logarUsuario(String nome, String senha);
    void fazerPostagem(Usuario user, Postagem postagem);
    void fazerComentario(Usuario user, Postagem postagem, Comentario comentario);
    void curtir(Usuario user, Postagem postagem);
    void removerCurtida(Usuario user, Postagem postagem);
    List<Postagem> getAllPost();
    List<Postagem> getPostagens(Usuario user);
    List<Comentario> getComentarios(Postagem postagem);
    int getCurtidas(Postagem postagem);

}
