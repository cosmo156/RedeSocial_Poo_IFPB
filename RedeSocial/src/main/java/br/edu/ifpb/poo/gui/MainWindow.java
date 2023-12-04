package br.edu.ifpb.poo.gui;

import br.edu.ifpb.poo.repository.AdmUsuarioRepository;
import br.edu.ifpb.poo.repository.FileDataService;

public class MainWindow {
    public static void main(String[] args) {
        AdmUsuarioRepository repository = AdmUsuarioRepository.getInstance();
        repository.setRepository(new FileDataService());
        new PainelLogin().setVisible(true);
    }
}



