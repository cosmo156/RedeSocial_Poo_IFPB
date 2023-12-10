package br.edu.ifpb.poo.commads.cli;

import br.edu.ifpb.poo.adpter.Commad;
import br.edu.ifpb.poo.commads.CommandExecutor;
import br.edu.ifpb.poo.domain.Comentario;
import br.edu.ifpb.poo.domain.Postagem;
import br.edu.ifpb.poo.domain.Usuario;
import br.edu.ifpb.poo.repository.AdmUsuarioRepository;
import br.edu.ifpb.poo.service.AdmUsuarioService;

import java.util.List;
import java.util.Scanner;

public class StatisticsUserCommad implements Commad {
    private Usuario user;

    public StatisticsUserCommad(Usuario user){
        this.user = user;
    }

    @Override
    public void execute() {
        if (!user.getPostagens().isEmpty()){
            Scanner sc = new Scanner(System.in);
            System.out.println("==============");
            System.out.println("Escolha a postagem que deseja interagir: ");
            for (Postagem postagem: user.getPostagens()){
                System.out.println("========================");
                System.out.println("Indice: " + user.getPostagens().indexOf(postagem));
                System.out.println("Conteudo: "+ postagem.getTexto());
                System.out.println("Curtidas: "+ postagem.getCurtidas());
                System.out.println("Comentarios:" );
                for (Comentario comentario: postagem.getComentarios()){
                    System.out.println(comentario.getTexto());
                }
                System.out.println("========================");
            }
            System.out.print("Digite o index da postagem: ");
            int index = sc.nextInt();
            if (index > user.getPostagens().size()){
                System.out.println("Index invalido!");
            }else {
                Postagem postagem = user.getPostagens().get(index);
                new CommandExecutor().executeCommad(new MenuInteractUserCommad(this.user, postagem));
            }
        }else {
            System.out.println("O usuário não tem nenhuma postagem cadastrada!");
        }
    }
}
