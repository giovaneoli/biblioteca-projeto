package biblioteca.view;

public class TelaInicial extends javax.swing.JFrame {

    /**
     * Creates new form TelaInicial
     */
    public TelaInicial() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        header2 = new javax.swing.JPanel();
        mgLogo2 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        BotaoGerenciarLivros = new javax.swing.JButton();
        BotaoGerenciarUsuarios = new javax.swing.JButton();
        BotaoGerenciarEmprestimos = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        BotaoSairTelaInicial = new javax.swing.JButton();

        header2.setBackground(new java.awt.Color(255, 255, 255));

        mgLogo2.setBackground(new java.awt.Color(255, 255, 255));
        mgLogo2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/biblioteca/view/testeLivro3.png"))); // NOI18N
        mgLogo2.setToolTipText("MG Total Care");
        mgLogo2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel14.setBackground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("Alterar Senha");

        javax.swing.GroupLayout header2Layout = new javax.swing.GroupLayout(header2);
        header2.setLayout(header2Layout);
        header2Layout.setHorizontalGroup(
            header2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(header2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mgLogo2)
                .addGap(18, 18, 18)
                .addComponent(jLabel14)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        header2Layout.setVerticalGroup(
            header2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(header2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(header2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mgLogo2)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, header2Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(8, 8, 8)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Início");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "O que você deseja fazer?", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        BotaoGerenciarLivros.setText("Gerenciar Livros");
        BotaoGerenciarLivros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoGerenciarLivrosActionPerformed(evt);
            }
        });

        BotaoGerenciarUsuarios.setText("Gerenciar Usuários");
        BotaoGerenciarUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoGerenciarUsuariosActionPerformed(evt);
            }
        });

        BotaoGerenciarEmprestimos.setText("Gerenciar Empréstimos");
        BotaoGerenciarEmprestimos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoGerenciarEmprestimosActionPerformed(evt);
            }
        });

        jButton1.setText("Alterar Senha");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotaoGerenciarUsuarios, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotaoGerenciarLivros, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotaoGerenciarEmprestimos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BotaoGerenciarLivros)
                .addGap(18, 18, 18)
                .addComponent(BotaoGerenciarUsuarios)
                .addGap(18, 18, 18)
                .addComponent(BotaoGerenciarEmprestimos)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(41, 41, 41))
        );

        BotaoSairTelaInicial.setText("Sair");
        BotaoSairTelaInicial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoSairTelaInicialActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(BotaoSairTelaInicial)))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BotaoSairTelaInicial)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    //Fecha a tela atual
    private void BotaoSairTelaInicialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoSairTelaInicialActionPerformed
        dispose();
    }//GEN-LAST:event_BotaoSairTelaInicialActionPerformed

    //Abre a tela alterar senha e fecha a atual
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        TelaAlterarSenha tela = new TelaAlterarSenha(); //cria tela gerenciar usuários
        tela.setVisible(true); //torna visível
        dispose();  //fecha tela atual
    }//GEN-LAST:event_jButton1ActionPerformed

    //Abre a tela Gerenciar Livros e fecha a atual
    private void BotaoGerenciarLivrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoGerenciarLivrosActionPerformed
        TelaLivrosCadastrados tela = new TelaLivrosCadastrados();
        tela.setVisible(true);
        dispose();
    }//GEN-LAST:event_BotaoGerenciarLivrosActionPerformed

    //Abre a tela Gerenciar Usuários e fecha a atual
    private void BotaoGerenciarUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoGerenciarUsuariosActionPerformed
        TelaUsuariosCadastrados tela = new TelaUsuariosCadastrados(); //cria tela gerenciar usuários
        tela.setVisible(true); //torna visível
        dispose();  //fecha tela atual
    }//GEN-LAST:event_BotaoGerenciarUsuariosActionPerformed
    //Abre a tela Gerenciar Empréstimos e fecha a atual
    private void BotaoGerenciarEmprestimosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoGerenciarEmprestimosActionPerformed
        TelaEmprestimos tela = new TelaEmprestimos(); //cria tela gerenciar usuários
        tela.setVisible(true); //torna visível
        dispose();  //fecha tela atual
    }//GEN-LAST:event_BotaoGerenciarEmprestimosActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaInicial().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotaoGerenciarEmprestimos;
    private javax.swing.JButton BotaoGerenciarLivros;
    private javax.swing.JButton BotaoGerenciarUsuarios;
    private javax.swing.JButton BotaoSairTelaInicial;
    private javax.swing.JPanel header2;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel mgLogo2;
    // End of variables declaration//GEN-END:variables
}
