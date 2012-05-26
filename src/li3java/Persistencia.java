package li3java;


import java.io.File;
import java.util.Random;
import javax.swing.JFileChooser;
import javax.swing.SwingWorker;
import localidade.Localidades;
import utilizador.Utilizadores;

public class Persistencia extends javax.swing.JFrame {
    private Task task;
    private Localidades localidades;
    private Utilizadores utilizadores;
    private File fUsers;
    private File fLocs;
    private File fLigs;
 
    class Task extends SwingWorker<Void, Void> {
        /*
         * Tarefa executada em plano de fundo
         */
        @Override
        public Void doInBackground() {
            Random random = new Random();
            int progress = 0;
            //Initialize progress property.
            setProgress(0);
            while (progress < 100) {
                //Sleep for up to one second.
                try {
                    Thread.sleep(random.nextInt(1000));
                } catch (InterruptedException ignore) {}
                //Make random progress.
                progress += random.nextInt(10);
                setProgress(Math.min(progress, 100));
            }
            return null;
        }
 
        /*
         * Executed in event dispatching thread
         */
        @Override
        public void done() {
            //startButton.setEnabled(true);
            //setCursor(null); //turn off the wait cursor
            //taskOutput.append("Done!\n");
        }
    }
    
    
    public Persistencia() {
	initComponents();
    }
    
    public Persistencia(Localidades locs, Utilizadores users) {
	initComponents();
	this.localidades = locs;
	this.utilizadores = users;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jBusers = new javax.swing.JButton();
        jBlocs = new javax.swing.JButton();
        jBligs = new javax.swing.JButton();
        jTFusers = new javax.swing.JTextField();
        jTFlocs = new javax.swing.JTextField();
        jTFligs = new javax.swing.JTextField();
        jCBusers = new javax.swing.JCheckBox();
        jCBlocs = new javax.swing.JCheckBox();
        jCBligs = new javax.swing.JCheckBox();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jCBcinco = new javax.swing.JCheckBox();
        jCBdez = new javax.swing.JCheckBox();
        jCBquinze = new javax.swing.JCheckBox();
        jCBdezoito = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jRBrw = new javax.swing.JRadioButton();
        jRBr = new javax.swing.JRadioButton();
        jPbar = new javax.swing.JProgressBar();
        jBiniciar = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        jLpatamar = new javax.swing.JLabel();
        jLaction = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        java.awt.GridBagLayout jPanel1Layout = new java.awt.GridBagLayout();
        jPanel1Layout.columnWidths = new int[] {0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0};
        jPanel1Layout.rowHeights = new int[] {0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0};
        jPanel1.setLayout(jPanel1Layout);

        jBusers.setText("Escolher Ficheiro");
        jBusers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBusersActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        jPanel1.add(jBusers, gridBagConstraints);

        jBlocs.setText("Escolher Ficheiro");
        jBlocs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBlocsActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 3;
        jPanel1.add(jBlocs, gridBagConstraints);

        jBligs.setText("Escolher Ficheiro");
        jBligs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBligsActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 3;
        jPanel1.add(jBligs, gridBagConstraints);

        jTFusers.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel1.add(jTFusers, gridBagConstraints);

        jTFlocs.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel1.add(jTFlocs, gridBagConstraints);

        jTFligs.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel1.add(jTFligs, gridBagConstraints);

        jCBusers.setText("Ficheiro de Utilizadores");
        jCBusers.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jCBusersStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel1.add(jCBusers, gridBagConstraints);

        jCBlocs.setText("Ficheiro de Localidades");
        jCBlocs.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jCBlocsStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel1.add(jCBlocs, gridBagConstraints);

        jCBligs.setText("Ficheiro de Ligações");
        jCBligs.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jCBligsStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel1.add(jCBligs, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 13;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel1.add(jSeparator1, gridBagConstraints);

        jLabel1.setFont(new java.awt.Font("DejaVu Sans", 1, 15)); // NOI18N
        jLabel1.setText("Fontes de Dados");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 13;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
        jPanel1.add(jLabel1, gridBagConstraints);

        jCBcinco.setSelected(true);
        jCBcinco.setText("5000");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 12;
        jPanel1.add(jCBcinco, gridBagConstraints);

        jCBdez.setSelected(true);
        jCBdez.setText("10000");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 12;
        jPanel1.add(jCBdez, gridBagConstraints);

        jCBquinze.setSelected(true);
        jCBquinze.setText("15000");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 12;
        jPanel1.add(jCBquinze, gridBagConstraints);

        jCBdezoito.setSelected(true);
        jCBdezoito.setText("18000");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 12;
        jPanel1.add(jCBdezoito, gridBagConstraints);

        jLabel2.setFont(new java.awt.Font("DejaVu Sans", 1, 15)); // NOI18N
        jLabel2.setText("Patamares");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 13;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
        jPanel1.add(jLabel2, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.gridwidth = 13;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel1.add(jSeparator2, gridBagConstraints);

        jLabel3.setFont(new java.awt.Font("DejaVu Sans", 1, 15)); // NOI18N
        jLabel3.setText("Operações Medidas");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 16;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 20, 0, 0);
        jPanel1.add(jLabel3, gridBagConstraints);

        buttonGroup1.add(jRBrw);
        jRBrw.setSelected(true);
        jRBrw.setText("Leitura e Escrita");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 18;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel1.add(jRBrw, gridBagConstraints);

        buttonGroup1.add(jRBr);
        jRBr.setText("Apenas leitura");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 18;
        gridBagConstraints.gridwidth = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel1.add(jRBr, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 24;
        gridBagConstraints.gridwidth = 13;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel1.add(jPbar, gridBagConstraints);

        jBiniciar.setText("Iniciar");
        jBiniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBiniciarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 22;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel1.add(jBiniciar, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 20;
        gridBagConstraints.gridwidth = 13;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel1.add(jSeparator3, gridBagConstraints);

        jLpatamar.setText("Operação");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 28;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        jPanel1.add(jLpatamar, gridBagConstraints);

        jLaction.setText("Patamar");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 26;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        jPanel1.add(jLaction, gridBagConstraints);

        jLabel4.setText("Repetição");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 26;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        jPanel1.add(jLabel4, gridBagConstraints);

        jLabel5.setText("Dados");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 28;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        jPanel1.add(jLabel5, gridBagConstraints);

        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 26;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 10);
        jPanel1.add(jTextField1, gridBagConstraints);

        jTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 28;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 10);
        jPanel1.add(jTextField2, gridBagConstraints);

        jTextField3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 26;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 10);
        jPanel1.add(jTextField3, gridBagConstraints);

        jTextField4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 28;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 10);
        jPanel1.add(jTextField4, gridBagConstraints);

        jLabel6.setText("Repetições");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 22;
        jPanel1.add(jLabel6, gridBagConstraints);

        jTextField5.setColumns(4);
        jTextField5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField5.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 22;
        jPanel1.add(jTextField5, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 527, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBiniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBiniciarActionPerformed
	/*startButton.setEnabled(false);
        setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        //Instances of javax.swing.SwingWorker are not reusuable, so
        //we create new instances as needed.
        task = new Task();
        task.addPropertyChangeListener(this);
        task.execute();*/
    }//GEN-LAST:event_jBiniciarActionPerformed

    private void jBusersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBusersActionPerformed
	selectedFileUsers();
    }//GEN-LAST:event_jBusersActionPerformed

    private void jBlocsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBlocsActionPerformed
	selectedFileLocs();
    }//GEN-LAST:event_jBlocsActionPerformed

    private void jBligsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBligsActionPerformed
	selectedFileLigs();
    }//GEN-LAST:event_jBligsActionPerformed

    private void jCBusersStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jCBusersStateChanged
	if( ((javax.swing.JCheckBox)evt.getSource()).isSelected() && jTFusers.getText().isEmpty())
	    selectedFileUsers();
    }//GEN-LAST:event_jCBusersStateChanged

    private void jCBlocsStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jCBlocsStateChanged
	if( ((javax.swing.JCheckBox)evt.getSource()).isSelected() && jTFlocs.getText().isEmpty())
	    selectedFileLocs();
    }//GEN-LAST:event_jCBlocsStateChanged

    private void jCBligsStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jCBligsStateChanged
	if( ((javax.swing.JCheckBox)evt.getSource()).isSelected() && jTFligs.getText().isEmpty())
	    selectedFileLigs();
    }//GEN-LAST:event_jCBligsStateChanged
    
    private void selectedFileUsers(){
	JFileChooser fc = new JFileChooser();
	fc.setMultiSelectionEnabled(false);
	fc.setDialogTitle("Abrir ficheiro de Utilizadores");
        int returnVal = fc.showOpenDialog(this);
        
        if( returnVal == JFileChooser.APPROVE_OPTION ){
            fUsers = fc.getSelectedFile();
	    jTFusers.setText(fUsers.getAbsolutePath());
	    jTFusers.setCaretPosition( jTFusers.getText().length() );
	    jCBusers.setSelected(true);
	}
    }
    
    private void selectedFileLocs(){
	JFileChooser fc = new JFileChooser();
	fc.setMultiSelectionEnabled(false);
	fc.setDialogTitle("Abrir ficheiro de Localidades");
        int returnVal = fc.showOpenDialog(this);
        
        if( returnVal == JFileChooser.APPROVE_OPTION ){
            fLocs = fc.getSelectedFile();
	    jTFlocs.setText(fLocs.getAbsolutePath());
	    jTFlocs.setCaretPosition( jTFlocs.getText().length() );
	    jCBlocs.setSelected(true);
	}   
    }
    
    private void selectedFileLigs(){
	JFileChooser fc = new JFileChooser();
	fc.setMultiSelectionEnabled(false);
	fc.setDialogTitle("Abrir ficheiro de Ligações");
        int returnVal = fc.showOpenDialog(this);
        
        if( returnVal == JFileChooser.APPROVE_OPTION ){
            fLigs = fc.getSelectedFile();
	    jTFligs.setText(fLigs.getAbsolutePath());
	    jTFligs.setCaretPosition( jTFligs.getText().length() );
	    jCBligs.setSelected(true);
	}   
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
	/*
	 * Set the Nimbus look and feel
	 */
	//<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
	 * If
	 * Nimbus
	 * (introduced
	 * in
	 * Java
	 * SE
	 * 6)
	 * is
	 * not
	 * available,
	 * stay
	 * with
	 * the
	 * default
	 * look
	 * and
	 * feel.
	 * For
	 * details
	 * see
	 * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
	 */
	try {
	    for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
		if ("Nimbus".equals(info.getName())) {
		    javax.swing.UIManager.setLookAndFeel(info.getClassName());
		    break;
		}
	    }
	} catch (ClassNotFoundException ex) {
	    java.util.logging.Logger.getLogger(Persistencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	} catch (InstantiationException ex) {
	    java.util.logging.Logger.getLogger(Persistencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	} catch (IllegalAccessException ex) {
	    java.util.logging.Logger.getLogger(Persistencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	} catch (javax.swing.UnsupportedLookAndFeelException ex) {
	    java.util.logging.Logger.getLogger(Persistencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	}
	//</editor-fold>

	/*
	 * Create and display the form
	 */
	java.awt.EventQueue.invokeLater(new Runnable() {

	    public void run() {
		new Persistencia().setVisible(true);
	    }
	});
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jBiniciar;
    private javax.swing.JButton jBligs;
    private javax.swing.JButton jBlocs;
    private javax.swing.JButton jBusers;
    private javax.swing.JCheckBox jCBcinco;
    private javax.swing.JCheckBox jCBdez;
    private javax.swing.JCheckBox jCBdezoito;
    private javax.swing.JCheckBox jCBligs;
    private javax.swing.JCheckBox jCBlocs;
    private javax.swing.JCheckBox jCBquinze;
    private javax.swing.JCheckBox jCBusers;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLaction;
    private javax.swing.JLabel jLpatamar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar jPbar;
    private javax.swing.JRadioButton jRBr;
    private javax.swing.JRadioButton jRBrw;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextField jTFligs;
    private javax.swing.JTextField jTFlocs;
    private javax.swing.JTextField jTFusers;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    // End of variables declaration//GEN-END:variables
}
