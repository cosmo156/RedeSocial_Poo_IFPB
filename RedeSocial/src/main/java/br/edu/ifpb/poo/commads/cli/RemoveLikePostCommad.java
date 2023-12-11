package br.edu.ifpb.poo.commads.cli;

import br.edu.ifpb.poo.adpter.Commad;
import br.edu.ifpb.poo.domain.Postagem;
import br.edu.ifpb.poo.domain.Usuario;
import br.edu.ifpb.poo.repository.AdmUsuarioRepository;
import br.edu.ifpb.poo.service.AdmUsuarioService;

public class RemoveLikePostCommad implements Commad {
    private final Usuario user;
    private final Postagem postagem;

    public RemoveLikePostCommad(Usuario user, Postagem postagem){
        this.postagem = postagem;
        this.user = user;
    }

    @Override
    public void execute() {
        AdmUsuarioService admUsuarioService = new AdmUsuarioService(AdmUsuarioRepository.getInstance());
        admUsuarioService.removerCurtida(this.user, this.postagem);
    }
}
