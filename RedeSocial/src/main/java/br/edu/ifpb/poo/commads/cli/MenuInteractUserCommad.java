package br.edu.ifpb.poo.commads.cli;

import br.edu.ifpb.poo.adpter.Commad;
import br.edu.ifpb.poo.commads.CommandExecutor;
import br.edu.ifpb.poo.domain.Postagem;
import br.edu.ifpb.poo.domain.Usuario;
import br.edu.ifpb.poo.repository.AdmUsuarioRepository;
import br.edu.ifpb.poo.service.AdmUsuarioService;

import java.util.Scanner;

public class MenuInteractUserCommad implements Commad {
    private final Usuario user;
    private final Postagem userPost;

    public MenuInteractUserCommad(Usuario user, Postagem userPost){
        this.user = user;
        this.userPost = userPost;
    }
    @Override
    public void execute() {
        Scanner sc = new Scanner(System.in);
        CommandExecutor executor = new CommandExecutor();

        System.out.println("\n=====================");
        System.out.println("Menu Postagem interação");
        System.out.println("=====================");
        int opcao = -1;
        do {
            System.out.println("============================");
            System.out.println("1: Curtir postagem");
            System.out.println("2: Remover curtida da postagem");
            System.out.println("3: fazer comentário");
            System.out.println("4: sair");
            System.out.println("Digite a opção: ");
            opcao = sc.nextInt();
            sc.nextLine();
            System.out.println("============================");

            switch (opcao){
                case 1 -> executor.executeCommad(new LikePostCommad(this.user, this.userPost));
                case 2 -> executor.executeCommad(new RemoveLikePostCommad(this.user, this.userPost));
                case 3 -> executor.executeCommad(new CommentPostCommad(this.userPost));
                case 4 -> System.out.printf("Saindo...");
                default -> System.out.println("Opção invalida!");
            }
        }while (opcao != 4);
    }
}
