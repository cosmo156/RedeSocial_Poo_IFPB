package br.edu.ifpb.poo.commads.gui;

import br.edu.ifpb.poo.adpter.Commad;
import br.edu.ifpb.poo.domain.Comentario;
import br.edu.ifpb.poo.domain.Postagem;
import br.edu.ifpb.poo.domain.Usuario;
import br.edu.ifpb.poo.repository.AdmUsuarioRepository;
import br.edu.ifpb.poo.service.AdmUsuarioService;
import br.edu.ifpb.poo.validators.ContentValidator;
import br.edu.ifpb.poo.validators.GuiTextValidator;

import javax.swing.*;

public class CreateCommentGuiCommad implements Commad {
    private Postagem post;
    private JTextArea jTextArea;
    private Usuario user;
    private final AdmUsuarioService service = new AdmUsuarioService(AdmUsuarioRepository.getInstance());

    public CreateCommentGuiCommad(Postagem post, JTextArea jTextArea, Usuario user) {
        this.post = post;
        this.jTextArea = jTextArea;
        this.user = user;
    }

    @Override
    public void execute() {
        GuiTextValidator commentValidator = new GuiTextValidator(new ContentValidator());
        boolean commentIsValid = commentValidator.validate(jTextArea);

        if(commentIsValid){
            service.fazerComentario(user, post, new Comentario(jTextArea.getText()));
            JOptionPane.showMessageDialog(jTextArea.getParent(), "O comentario foi adicionado com sucesso!");
            jTextArea.setText("");
        }
    }

}

