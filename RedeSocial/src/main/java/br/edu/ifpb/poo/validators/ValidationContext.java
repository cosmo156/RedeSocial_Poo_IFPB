package br.edu.ifpb.poo.validators;

import br.edu.ifpb.poo.adpter.Validator;

import java.util.Scanner;

public class ValidationContext<T> {
    private Validator<T> validator;
    public ValidationContext(Validator<T> validator){
        this.validator = validator;
    }

    public boolean validate(T data){
       return this.validator.validate(data);
    }

    public void setValidator(Validator<T> validator){
        this.validator = validator;
    }

    public T getValidValue(String prompt, String errorMsg, Class<T> type){
        T data = null;
        Scanner scan = new Scanner(System.in);

        while (data == null) {
            System.out.print(prompt);
            if (type == String.class) {
                data = (T) scan.nextLine();
            } else if (type == Integer.class) {
                data = (T) Integer.valueOf(scan.nextInt());
                scan.nextLine();
            }

            if (!validator.validate(data)) {
                System.out.println(errorMsg);
                data = null;
            } else {
                break;
            }
        }
        return data;
    }


}
