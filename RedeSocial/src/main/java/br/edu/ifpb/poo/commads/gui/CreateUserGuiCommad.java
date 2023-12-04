package br.edu.ifpb.poo.commads.gui;

import br.edu.ifpb.poo.adpter.Commad;
import br.edu.ifpb.poo.gui.PainelLogin;
import br.edu.ifpb.poo.repository.AdmUsuarioRepository;
import br.edu.ifpb.poo.service.AdmUsuarioService;
import br.edu.ifpb.poo.validators.ContentValidator;
import br.edu.ifpb.poo.validators.GuiTextValidator;

import javax.swing.*;


public class CreateUserGuiCommad implements Commad {
    private final JTextField nome;
    private final JPasswordField senha;
    private final JPasswordField senha2;
    private final JFrame frame;
    private final AdmUsuarioService service = new AdmUsuarioService(AdmUsuarioRepository.getInstance());

    public CreateUserGuiCommad(JFrame frame, JTextField nome, JPasswordField senha, JPasswordField senha2) {
        this.nome = nome;
        this.senha = senha;
        this.senha2 = senha2;
        this.frame = frame;
    }
    @Override
    public void execute() {
        char[] senhaChar = senha.getPassword();
        String nomeStr = nome.getText();
        String senhaStr = new String(senhaChar);

        GuiTextValidator nomeValidator = new GuiTextValidator(new ContentValidator());
        GuiTextValidator senhaValidator = new GuiTextValidator(new ContentValidator());
        GuiTextValidator senha2Validator = new GuiTextValidator(new ContentValidator());

        boolean nomeIsValid = nomeValidator.validate(nome);
        boolean senhaIsValid = senhaValidator.validate(senha);
        boolean senha2IsValid = senha2Validator.validate(senha2);
        boolean confirmIsValid = new GuiTextValidator(new ContentValidator()).senhaIsEquals(senha, senha2);

        if (nomeIsValid && senhaIsValid && senha2IsValid && confirmIsValid) {
            JOptionPane.showMessageDialog(nome.getParent(), "Usuario cadastrado com sucesso.");
            service.criarUser(nomeStr, senhaStr);
            new PainelLogin().setVisible(true);
            frame.setVisible(false);
        }
    }
}
