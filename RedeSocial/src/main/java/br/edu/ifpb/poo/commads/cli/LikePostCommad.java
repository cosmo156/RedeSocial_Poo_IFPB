package br.edu.ifpb.poo.commads.cli;

import br.edu.ifpb.poo.adpter.Commad;
import br.edu.ifpb.poo.domain.Postagem;
import br.edu.ifpb.poo.domain.Usuario;
import br.edu.ifpb.poo.repository.AdmUsuarioRepository;
import br.edu.ifpb.poo.service.AdmUsuarioService;

public class LikePostCommad implements Commad {
    private final Usuario user;
    private final Postagem postagem;

    public LikePostCommad(Usuario user, Postagem postagem){
        this.postagem = postagem;
        this.user = user;
    }

    @Override
    public void execute() {
        AdmUsuarioService admUsuarioService = new AdmUsuarioService(AdmUsuarioRepository.getInstance());
        admUsuarioService.curtir(user, this.postagem);
    }
}
