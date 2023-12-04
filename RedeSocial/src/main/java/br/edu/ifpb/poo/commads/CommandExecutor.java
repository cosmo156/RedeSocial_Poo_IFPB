package br.edu.ifpb.poo.commads;


import br.edu.ifpb.poo.adpter.Commad;

public class CommandExecutor {
    public void executeCommad(Commad c) {
        c.execute();
    }
}
