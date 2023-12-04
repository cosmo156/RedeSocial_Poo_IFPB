package br.edu.ifpb.poo.commads.gui;

import br.edu.ifpb.poo.adpter.Commad;
import br.edu.ifpb.poo.domain.Usuario;
import br.edu.ifpb.poo.gui.PainelPrincipal;
import br.edu.ifpb.poo.repository.AdmUsuarioRepository;
import br.edu.ifpb.poo.service.AdmUsuarioService;
import br.edu.ifpb.poo.validators.ContentValidator;
import br.edu.ifpb.poo.validators.GuiTextValidator;

import javax.swing.*;

public class LoginUserGuiCommad implements Commad {
    private final JTextField nome;
    private final JPasswordField senha;
    private final JFrame frame;
    private final AdmUsuarioService service = new AdmUsuarioService(AdmUsuarioRepository.getInstance());

    public LoginUserGuiCommad(JFrame frame, JTextField nome, JPasswordField senha){
        this.nome = nome;
        this.frame = frame;
        this.senha = senha;
    }
    @Override
    public void execute() {
        char[] senhaChar = senha.getPassword();
        String nomeStr = nome.getText();
        String senhaStr = new String(senhaChar);

        GuiTextValidator nomeValidator = new GuiTextValidator(new ContentValidator());
        GuiTextValidator senhaValidator = new GuiTextValidator(new ContentValidator());

        boolean nomeIsValid = nomeValidator.validate(nome);
        boolean senhaIsValid = senhaValidator.validate(senha);

            if (nomeIsValid && senhaIsValid) {
                if (service.userExists(nomeStr)){
                    JOptionPane.showMessageDialog(nome.getParent(), "Usuario Logado com sucesso!");
                    Usuario user = service.logarUsuario(nomeStr, senhaStr);
                    new PainelPrincipal(user).setVisible(true);
                    frame.setVisible(false);
                }else {
                    JOptionPane.showMessageDialog(nome.getParent(), "Usuario nao encontrado!");
                }
            }

    }
}
