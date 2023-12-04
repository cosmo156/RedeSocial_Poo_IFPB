package br.edu.ifpb.poo.commads.cli;

import br.edu.ifpb.poo.adpter.Commad;
import br.edu.ifpb.poo.domain.Postagem;
import br.edu.ifpb.poo.domain.Usuario;
import br.edu.ifpb.poo.repository.AdmUsuarioRepository;
import br.edu.ifpb.poo.service.AdmUsuarioService;
import br.edu.ifpb.poo.validators.ContentValidator;
import br.edu.ifpb.poo.validators.ValidationContext;

public class CreatePostCommad implements Commad {
    private Usuario user;
    public CreatePostCommad(Usuario user){
        this.user = user;
    }
    @Override
    public void execute() {
        AdmUsuarioService admUsuarioService = new AdmUsuarioService(AdmUsuarioRepository.getInstance());

        ValidationContext<String> strValidationContext = new ValidationContext<>(new ContentValidator());
        String conteudo = strValidationContext.getValidValue("Digite o conteudo: ", "A postagem não pode ser vazio e deve ser maior do que 2 caracteres!", String.class);

        Postagem postagem = new Postagem(user, conteudo);
        admUsuarioService.fazerPostagem(this.user,postagem);
    }
}
