package br.edu.ifpb.poo.validators;

import br.edu.ifpb.poo.adpter.Validator;

public class ContentValidator implements Validator<String> {
    private static final int MIN_CARACT_NOME = 3;
    @Override
    public boolean validate(String data) {
        new NonEmptyValidator().validate(data);
        return data.length() >= MIN_CARACT_NOME;
    }
}
