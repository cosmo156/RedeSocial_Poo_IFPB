package br.edu.ifpb.poo.commads.gui;

import br.edu.ifpb.poo.adpter.Commad;
import br.edu.ifpb.poo.domain.Postagem;
import br.edu.ifpb.poo.domain.Usuario;
import br.edu.ifpb.poo.repository.AdmUsuarioRepository;
import br.edu.ifpb.poo.service.AdmUsuarioService;
import br.edu.ifpb.poo.validators.ContentValidator;
import br.edu.ifpb.poo.validators.GuiTextValidator;

import javax.swing.*;

public class CreatePostGuiCommad implements Commad {
    private Usuario user;
    private JTextArea jTextArea;
    private final AdmUsuarioService service = new AdmUsuarioService(AdmUsuarioRepository.getInstance());

    public CreatePostGuiCommad(Usuario user, JTextArea jTextArea){
        this.user = user;
        this.jTextArea = jTextArea;
    }

    @Override
    public void execute() {
        GuiTextValidator postValidator = new GuiTextValidator(new ContentValidator());
        boolean postIsValid = postValidator.validate(jTextArea);

        if(postIsValid){
            service.fazerPostagem(user, new Postagem(user, jTextArea.getText()));
            JOptionPane.showMessageDialog(jTextArea.getParent(), "Postagem criada com sucesso!");
            jTextArea.setText("");
        }
    }
}
