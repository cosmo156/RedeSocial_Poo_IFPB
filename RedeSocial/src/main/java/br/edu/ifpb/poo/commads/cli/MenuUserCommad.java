package br.edu.ifpb.poo.commads.cli;

import br.edu.ifpb.poo.adpter.Commad;
import br.edu.ifpb.poo.commads.CommandExecutor;
import br.edu.ifpb.poo.domain.Usuario;

import java.awt.*;
import java.util.Scanner;

public class MenuUserCommad implements Commad {
    private final Usuario user;
    public MenuUserCommad(Usuario user){
        this.user = user;
    }
    @Override
    public void execute() {
        CommandExecutor executor = new CommandExecutor();
        Scanner sc = new Scanner(System.in);
        int opcao = -1;

        do {
            System.out.println("============================");
            System.out.println("1: Fazer postagem");
            System.out.println("2: Interagir com outros usuários");
            System.out.println("3: Vê estatísticas das minhas postagens");
            System.out.println("4: sair");
            System.out.print("Digite a opção: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao){
                case 1 -> executor.executeCommad(new CreatePostCommad(this.user));
                case 2 -> executor.executeCommad(new InteractOtherUserCommad(this.user));
                case 3 -> executor.executeCommad(new StatisticsUserCommad(this.user));
                case 4 -> System.out.println("Saindo...");
                default -> System.out.println("Opção invalida!");
            }
        }while (opcao != 4);
    }
}
