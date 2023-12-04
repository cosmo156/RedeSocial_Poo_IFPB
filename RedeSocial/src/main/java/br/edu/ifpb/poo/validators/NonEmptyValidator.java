package br.edu.ifpb.poo.validators;

import br.edu.ifpb.poo.adpter.Validator;

public class NonEmptyValidator implements Validator<String> {
    @Override
    public boolean validate(String data) {
        return !data.equals("");
    }
}
