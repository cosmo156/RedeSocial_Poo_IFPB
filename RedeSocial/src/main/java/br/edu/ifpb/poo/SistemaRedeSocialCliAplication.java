package br.edu.ifpb.poo;


import br.edu.ifpb.poo.commads.CommandExecutor;
import br.edu.ifpb.poo.commads.cli.LoginUserCommad;
import br.edu.ifpb.poo.commads.cli.RegisterUserCommad;
import br.edu.ifpb.poo.repository.AdmUsuarioRepository;
import br.edu.ifpb.poo.repository.FileDataService;

import java.util.Scanner;

public class SistemaRedeSocialCliAplication {

    public static void main(String[] args) {
        AdmUsuarioRepository dataService = AdmUsuarioRepository.getInstance();
        dataService.setRepository(new FileDataService());
        CommandExecutor executor = new CommandExecutor();

        Scanner sc = new Scanner(System.in);
        int opcao = -1;

        do {
            System.out.println("\n=================================");
            System.out.println("MENU");
            System.out.println("[1] - Cadastrar Usuário");
            System.out.println("[2] - Logar Usuário");
            System.out.println("[3] - Sair");
            System.out.print("Digite a opção -> ");
            opcao = sc.nextInt();
            sc.nextLine();
            switch (opcao){
                case 1 -> executor.executeCommad(new RegisterUserCommad());
                case 2 -> executor.executeCommad(new LoginUserCommad());
            }
        }while (opcao != 3);
    }
}
