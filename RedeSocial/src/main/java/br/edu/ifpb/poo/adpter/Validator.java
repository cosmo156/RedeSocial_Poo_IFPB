package br.edu.ifpb.poo.adpter;

public interface Validator<T> {
    boolean validate(T data);
}
