package br.edu.ifpb.poo.commads.cli;

import br.edu.ifpb.poo.adpter.Commad;
import br.edu.ifpb.poo.commads.CommandExecutor;
import br.edu.ifpb.poo.domain.Postagem;
import br.edu.ifpb.poo.domain.Usuario;
import br.edu.ifpb.poo.repository.AdmUsuarioRepository;
import br.edu.ifpb.poo.service.AdmUsuarioService;

import java.util.Scanner;

public class SearchPostCommad implements Commad {
    private Usuario user;

    public SearchPostCommad(Usuario user) {
        this.user = user;
    }

    @Override
    public void execute() {
        AdmUsuarioService admUsuarioService = new AdmUsuarioService(AdmUsuarioRepository.getInstance());
        if (!admUsuarioService.getPostagens(user).isEmpty()){
            Scanner sc = new Scanner(System.in);
            System.out.println("==============");
            System.out.println("Escolha a postagem que deseja interagir: ");
            for (Postagem postagem: admUsuarioService.getPostagens(user)){
                System.out.println("Indice: " + admUsuarioService.getPostagens(user).indexOf(postagem));
                System.out.println("Conteudo: "+ postagem.getTexto());
            }
            System.out.print("Digite o index da postagem: ");
            int index = sc.nextInt();
            Postagem postagem = admUsuarioService.getPostagens(user).get(index);
            new CommandExecutor().executeCommad(new MenuInteractUserCommad(this.user, postagem));
        }
        System.out.println("O Usuário selecionado não possui nenhuma postagem cadastrada!");
    }
}
