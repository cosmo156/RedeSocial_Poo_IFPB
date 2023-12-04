package br.edu.ifpb.poo.repository;

import br.edu.ifpb.poo.domain.Comentario;
import br.edu.ifpb.poo.domain.Postagem;
import br.edu.ifpb.poo.domain.Usuario;

import java.io.*;
import java.util.List;

public class FileDataService extends InMemoryDataService {
    private String myField = "data.bin";
    public FileDataService() {
        File data = new File(myField);
        if (data.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(myField))) {
                usuarios = (List<Usuario>) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void add(Usuario user){
        super.add(user);
        write();
    }

    @Override
    public void fazerPostagem(Usuario user, Postagem postagem) {
        super.fazerPostagem(user, postagem);
        write();
    }

    @Override
    public void curtir(Usuario user, Postagem postagem) {
        super.curtir(user, postagem);
        write();
    }

    @Override
    public void removerCurtida(Usuario user, Postagem postagem) {
        super.removerCurtida(user, postagem);
        write();
    }

    @Override
    public void fazerComentario(Usuario user, Postagem postagem, Comentario comentario) {
        super.fazerComentario(user, postagem, comentario);
        write();
    }

    private void write(){
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("data.bin"))) {
            oos.writeObject(getAllUser());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

