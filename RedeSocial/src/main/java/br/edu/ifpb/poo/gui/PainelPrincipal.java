package br.edu.ifpb.poo.gui;

import br.edu.ifpb.poo.commads.CommandExecutor;
import br.edu.ifpb.poo.commads.gui.CreatePostGuiCommad;
import br.edu.ifpb.poo.domain.Postagem;
import br.edu.ifpb.poo.domain.Usuario;
import br.edu.ifpb.poo.repository.AdmUsuarioRepository;
import br.edu.ifpb.poo.service.AdmUsuarioService;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class PainelPrincipal extends javax.swing.JFrame {
    private Usuario userLogado;
    private transient AdmUsuarioService service = new AdmUsuarioService(AdmUsuarioRepository.getInstance());

    public PainelPrincipal(Usuario userLogado) {
        this.userLogado = userLogado;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Painel Principal");
        updatePost();

        jButton1.setText("Criar");
        jButton1.addActionListener((java.awt.event.ActionEvent evt) -> {
            new CommandExecutor().executeCommad(new CreatePostGuiCommad(userLogado, jTextArea1));
            updatePost();
        });

        jList1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JPopupMenu popupMenu = new JPopupMenu();
                JMenuItem jCurtir = new JMenuItem("Curtir");
                JMenuItem jComnetar = new JMenuItem("Comentar");
                JMenuItem jNumCurtidas = new JMenuItem("Curtidas: " + jList1.getSelectedValue().getCurtidas());
                jCurtir.addActionListener(ActionEvent -> {
                    Usuario userCurtir = jList1.getSelectedValue().getAuthor();
                    service.curtir(userCurtir, jList1.getSelectedValue());
                    new SucessMsgGUI("A postagem " + jList1.getSelectedValue().toString() + " curtida com sucesso!");
                });
                jComnetar.addActionListener(ActionEvent -> {
                    Usuario userComentar = jList1.getSelectedValue().getAuthor();
                    new PainelComentar(jList1.getSelectedValue(), userComentar).setVisible(true);
                });
                popupMenu.add(jCurtir);
                popupMenu.add(jComnetar);
                popupMenu.add(jNumCurtidas);
                popupMenu.show(jList1, e.getX(), e.getY());
            }
        });



        jScrollPane2.setViewportView(jList1);

        jLabel1.setText("Todas as postagens registradas:");
        jLabel2.setText("Criar Postagem:");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane2)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(jLabel2)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jButton1)
                                                .addGap(39, 39, 39)))
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jMenu1.setText("Sair");
        jMenuBar1.add(jMenu1);

        jMenu1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new PainelLogin().setVisible(true);
                setVisible(false);
            }
        });

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>

    public void updatePost(){
        jList1.setListData(service.getAllPost().toArray(new Postagem[0]));
    }

    // Variables declaration - do not modify
    private javax.swing.JButton jButton1 = new JButton();
    private javax.swing.JLabel jLabel1 = new JLabel();
    private javax.swing.JLabel jLabel2 = new JLabel();
    private javax.swing.JList<Postagem> jList1 = new JList<>();
    private javax.swing.JMenu jMenu1 = new JMenu();
    private javax.swing.JMenuBar jMenuBar1 = new JMenuBar();
    private javax.swing.JPanel jPanel1 = new JPanel();
    private javax.swing.JScrollPane jScrollPane1 = new JScrollPane();
    private javax.swing.JScrollPane jScrollPane2 = new JScrollPane();
    private javax.swing.JTextArea jTextArea1 = new JTextArea();
    // End of variables declaration
}
