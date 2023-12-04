package br.edu.ifpb.poo.commads.cli;

import br.edu.ifpb.poo.adpter.Commad;
import br.edu.ifpb.poo.domain.Comentario;
import br.edu.ifpb.poo.domain.Postagem;
import br.edu.ifpb.poo.domain.Usuario;
import br.edu.ifpb.poo.repository.AdmUsuarioRepository;
import br.edu.ifpb.poo.service.AdmUsuarioService;
import br.edu.ifpb.poo.validators.ContentValidator;
import br.edu.ifpb.poo.validators.ValidationContext;

public class CommentPostCommad implements Commad {
    private Postagem postagem;

    public CommentPostCommad(Postagem postagem) {
        this.postagem = postagem;
    }

    @Override
    public void execute() {
        AdmUsuarioService admUsuarioService = new AdmUsuarioService(AdmUsuarioRepository.getInstance());
        ValidationContext<String> strValidationContext = new ValidationContext<>(new ContentValidator());
        String conteudo = strValidationContext.getValidValue("Conteudo do comentário: ", "o comentário não pode ser vazio e deve ser maior do que 2 caracteres!", String.class);

        Usuario userComentario = this.postagem.getAuthor();
        Comentario comentario = new Comentario(conteudo);

        admUsuarioService.fazerComentario(userComentario, this.postagem, comentario);
    }
}
