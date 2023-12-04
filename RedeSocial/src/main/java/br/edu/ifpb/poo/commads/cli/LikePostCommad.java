package br.edu.ifpb.poo.commads.cli;

import br.edu.ifpb.poo.adpter.Commad;
import br.edu.ifpb.poo.domain.Postagem;
import br.edu.ifpb.poo.domain.Usuario;
import br.edu.ifpb.poo.repository.AdmUsuarioRepository;
import br.edu.ifpb.poo.service.AdmUsuarioService;

public class LikePostCommad implements Commad {
    private Usuario user;
    private Postagem postagem;

    public LikePostCommad(Usuario user, Postagem postagem){
        this.postagem = postagem;
        this.user = user;
    }

    @Override
    public void execute() {
        AdmUsuarioService admUsuarioService = new AdmUsuarioService(AdmUsuarioRepository.getInstance());
        Usuario userCurtir = this.postagem.getAuthor();
        admUsuarioService.curtir(userCurtir, this.postagem);
    }
}
