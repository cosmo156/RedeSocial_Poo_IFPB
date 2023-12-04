package br.edu.ifpb.poo.validators;

import br.edu.ifpb.poo.adpter.GuiValidator;
import br.edu.ifpb.poo.adpter.Validator;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;

public class GuiTextValidator implements GuiValidator {
    private final Validator<String> validator;

    public GuiTextValidator(Validator<String> validator) {
        this.validator = validator;
    }

    @Override
    public boolean validate(JTextComponent field) {
        boolean textIsValid = getStringValidator().validate(field.getText());

        if (!textIsValid) {
            field.setBackground(new Color(255, 155, 163));
        } else {
            field.setBackground(Color.WHITE);
        }

        return textIsValid;
    }

    @Override
    public boolean senhaIsEquals(JPasswordField field1, JPasswordField field2) {
        char[] senha1 = field1.getPassword();
        char[] senha2 = field2.getPassword();

        String senha1Str = new String(senha1);
        String senha2Str = new String(senha2);

        if (!senha1Str.equals(senha2Str)) {
            field2.setBackground(new Color(255, 155, 163));
        } else {
            field2.setBackground(Color.WHITE);
        }

        return true;
    }

    @Override
    public Validator<String> getStringValidator() {
        return validator;
    }
}
