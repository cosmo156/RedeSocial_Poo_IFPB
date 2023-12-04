package br.edu.ifpb.poo.adpter;

import javax.swing.*;
import javax.swing.text.JTextComponent;

public interface GuiValidator {
    Validator<String> getStringValidator();
    boolean validate(JTextComponent field);
    boolean senhaIsEquals(JPasswordField field1, JPasswordField field2);
}
