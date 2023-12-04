package br.edu.ifpb.poo.commads.cli;

import br.edu.ifpb.poo.adpter.Commad;
import br.edu.ifpb.poo.repository.AdmUsuarioRepository;
import br.edu.ifpb.poo.service.AdmUsuarioService;
import br.edu.ifpb.poo.validators.ContentValidator;
import br.edu.ifpb.poo.validators.ValidationContext;


public class RegisterUserCommad implements Commad {
    @Override
    public void execute() {
        AdmUsuarioService admUsuarioService = new AdmUsuarioService(AdmUsuarioRepository.getInstance());

        System.out.println("\n=================================");
        System.out.println("Cadastrar Usuário");
        System.out.println("=================================");

        ValidationContext<String> strValidationContext = new ValidationContext<>(new ContentValidator());
        String nome = strValidationContext.getValidValue("Nome: ", "Nome não pode ser vazio e deve ser maior do que 2 caracteres!", String.class);
        String senha = strValidationContext.getValidValue("Senha: ", "A senha não pode ser vazio e deve ser maior do que 2 caracteres!", String.class);

        admUsuarioService.criarUser(nome, senha);

    }
}
