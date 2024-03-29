/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.SystemControl;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author guilh
 */
public class CriarDB extends javax.swing.JFrame {

    UsarDB usarDB;
    private SystemControl systemControl = new SystemControl();

    /**
     * Creates new form TelaInicial
     */
    public CriarDB() {
        usarDB = new UsarDB();
        usarDB.setTelaInicial(this);
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

        tfNomeBanco = new javax.swing.JTextField();
        btCriar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btSelBanco = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mnCriarBd = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        mnUsarBd = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        mnSair = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Novo banco de dados");
        setBackground(new java.awt.Color(245, 245, 245));
        setResizable(false);

        tfNomeBanco.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        tfNomeBanco.setToolTipText("Nome do banco de dados a ser criado");
        tfNomeBanco.setName("tfNomeBanco"); // NOI18N

        btCriar.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btCriar.setText("Criar");
        btCriar.setName("btCriar"); // NOI18N
        btCriar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCriarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Criar novo banco de dados");
        jLabel1.setFocusable(false);

        btSelBanco.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btSelBanco.setText("Selecionar banco");
        btSelBanco.setName("btSelBanco"); // NOI18N
        btSelBanco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSelBancoActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setText("Nome do banco: ");
        jLabel2.setFocusable(false);

        jMenu1.setText("Banco de dados");

        mnCriarBd.setText("Criar banco de dados");
        mnCriarBd.setName("mnCriarBd"); // NOI18N
        mnCriarBd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnCriarBdActionPerformed(evt);
            }
        });
        jMenu1.add(mnCriarBd);
        jMenu1.add(jSeparator1);

        mnUsarBd.setText("Usar banco de dados");
        mnUsarBd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnUsarBdActionPerformed(evt);
            }
        });
        jMenu1.add(mnUsarBd);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Ajuda");

        mnSair.setText("Sair");
        mnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnSairActionPerformed(evt);
            }
        });
        jMenu2.add(mnSair);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(270, 270, 270)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addComponent(jLabel2)
                        .addGap(40, 40, 40)
                        .addComponent(tfNomeBanco, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(224, 224, 224)
                        .addComponent(btSelBanco)
                        .addGap(157, 157, 157)
                        .addComponent(btCriar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(179, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(88, 88, 88)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfNomeBanco, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 115, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btSelBanco, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btCriar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(120, 120, 120))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnSairActionPerformed
        // TODO add your handling code here:
        int resposta = JOptionPane.showConfirmDialog(null, "Deseja mesmo sair do sistema?");
        if (resposta == 0) {
            System.exit(0);
        }
    }//GEN-LAST:event_mnSairActionPerformed

    private void mnUsarBdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnUsarBdActionPerformed
        // TODO add your handling code here:List<String> bancos = new ArrayList();
        String nomeBd = dialogSelecionarBd();
        if (!nomeBd.equals("")) {
            usarDB.setTitle("Prompt de Comando - " + nomeBd);
            usarDB.setLbTituloBanco("Prompt de Comando - " + nomeBd);
            usarDB.setDatabase(nomeBd);
            usarDB.setVisible(true);
            setVisible(false);
        }
    }//GEN-LAST:event_mnUsarBdActionPerformed

    private void mnCriarBdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnCriarBdActionPerformed
        tfNomeBanco.setText("");
    }//GEN-LAST:event_mnCriarBdActionPerformed

    private void btSelBancoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSelBancoActionPerformed
        String nomeBd = dialogSelecionarBd();
        if (!nomeBd.equals("")) {
            usarDB.setTitle("Prompt de Comando - " + nomeBd);
            usarDB.setLbTituloBanco("Prompt de Comando - " + nomeBd);
            usarDB.setDatabase(nomeBd);
            usarDB.setVisible(true);
            setVisible(false);
        }
    }//GEN-LAST:event_btSelBancoActionPerformed

    private void btCriarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCriarActionPerformed
        // TODO add your handling code here:
        if (!systemControl.validaNome(tfNomeBanco.getText())) {
            JOptionPane.showMessageDialog(null, "O nome de banco informado é inválido. Tente novamente!");
        } else {
            int resposta = JOptionPane.showConfirmDialog(null, "Deseja criar o banco de dados \"" + tfNomeBanco.getText() + "\"?");
            if (resposta == 0) {
                String retorno = systemControl.createDatabase(tfNomeBanco.getText());
                JOptionPane.showMessageDialog(null, retorno);
            }
        }
        tfNomeBanco.setText("");
    }//GEN-LAST:event_btCriarActionPerformed

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
            java.util.logging.Logger.getLogger(CriarDB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CriarDB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CriarDB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CriarDB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CriarDB().setVisible(true);
            }
        });
    }

    public String dialogSelecionarBd() {
        File file = new File(systemControl.buscaCaminho());
        String[] directories = file.list((File current, String name) -> new File(current, name).isDirectory());
        String[] comboStrings = new String[directories.length + 1];
        comboStrings[0] = "";
        System.arraycopy(directories, 0, comboStrings, 1, directories.length);

        JComboBox cbBancos = new JComboBox(comboStrings);
        cbBancos.setEditable(true);
        JOptionPane.showMessageDialog(null, cbBancos, "Selecione o banco que deseja utilizar", JOptionPane.INFORMATION_MESSAGE);
        if (Arrays.asList(comboStrings).contains(cbBancos.getSelectedItem().toString())) {
            return cbBancos.getSelectedItem().toString();
        } else {
            JOptionPane.showMessageDialog(null, "O banco de dados informado é inválido. Tente novamente!");
            return "";
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCriar;
    private javax.swing.JButton btSelBanco;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JMenuItem mnCriarBd;
    private javax.swing.JMenuItem mnSair;
    private javax.swing.JMenuItem mnUsarBd;
    private javax.swing.JTextField tfNomeBanco;
    // End of variables declaration//GEN-END:variables
}
