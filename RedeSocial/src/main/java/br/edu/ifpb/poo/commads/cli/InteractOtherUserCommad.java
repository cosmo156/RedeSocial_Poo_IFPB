package br.edu.ifpb.poo.commads.cli;

import br.edu.ifpb.poo.adpter.Commad;
import br.edu.ifpb.poo.commads.CommandExecutor;
import br.edu.ifpb.poo.domain.Usuario;
import br.edu.ifpb.poo.repository.AdmUsuarioRepository;
import br.edu.ifpb.poo.service.AdmUsuarioService;
import br.edu.ifpb.poo.validators.ContentValidator;
import br.edu.ifpb.poo.validators.ValidationContext;

import java.util.List;

public class InteractOtherUserCommad implements Commad {
    private final Usuario myUser;
    public InteractOtherUserCommad(Usuario user){
        this.myUser = user;
    }
    @Override
    public void execute() {
        AdmUsuarioService admUsuarioService = new AdmUsuarioService(AdmUsuarioRepository.getInstance());

        if (admUsuarioService.getAllUser().size() > 1){
            List<Usuario> usuarios = admUsuarioService.getAllUser();

            System.out.println("\n================");
            System.out.println("Usuários disponiveis: ");
            System.out.println("================");

            for (Usuario usuario: usuarios){
                if (usuario.getNome().equals(myUser.getNome())){
                    continue;
                }
                System.out.println(usuario.getNome());
            }

            ValidationContext<String> strValidationContext = new ValidationContext<>(new ContentValidator());
            String nome = strValidationContext.getValidValue("Digite o nome do usuário: ", "Nome não pode ser vazio e deve ser maior do que 2 caracteres!", String.class);

            if (admUsuarioService.userExists(nome)){
                Usuario otherUser = admUsuarioService.search(nome);
                new CommandExecutor().executeCommad(new SearchPostCommad(otherUser));
            }else {
                System.out.println("O usuario não existe!");
            }

        }
        System.out.println("Apenas você está cadastrado no sistema!");
    }
}
