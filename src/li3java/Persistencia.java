package li3java;


import java.awt.Cursor;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.GregorianCalendar;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import localidade.Localidades;
import localidade.LocalidadesHashMap;
import utilizador.Utilizadores;
import utilizador.UtilizadoresHashMap;

public class Persistencia extends javax.swing.JFrame {
    private Task task;
    private Localidades localidades;
    private Utilizadores utilizadores;
    private File fUsers;
    private File fLocs;
    private File fLigs;
    private int[] patamares;
    private int readOnly;
    private int repeticoes;
    private long temposSDO[][][];
    private long temposEF[][][];
 
    class Task extends SwingWorker<Void, Void> {
        /*
         * Tarefa executada em plano de fundo
         */
        @Override
        public Void doInBackground() {
	    temposSDO = new long[repeticoes][patamares.length][readOnly];
	    temposEF = new long[repeticoes][patamares.length][readOnly];
	    
	    GregorianCalendar inicio;
	    
	    Localidades[] locs = new LocalidadesHashMap[patamares.length];
	    Utilizadores[] users = new UtilizadoresHashMap[patamares.length];
	    for( int i=0; i<patamares.length; i++ ){
		locs[i] = new LocalidadesHashMap();
		Ficheiro.getLocalidades(locs[i], fLocs, patamares[i]);
		Ficheiro.getLigacoes(locs[i], fLigs);
		users[i] = new UtilizadoresHashMap();
		Ficheiro.getUtilizadores(users[i], fUsers, patamares[i]);
		doProgress();
	    }
	    for(int filetype = 0; filetype<2; filetype++)
		for( int rep=0; rep<repeticoes; rep++ )
		    for( int p = 0; p<patamares.length; p++){
			inicio = new GregorianCalendar();
			if( filetype == 0 ){
			    Ficheiro.escreverSDO("tmp.sdo", locs[p], users[p]);
			    temposSDO[rep][p][0] = (new GregorianCalendar()).getTimeInMillis() - inicio.getTimeInMillis();
			    doProgress();
			    if( readOnly == 2 ){
				inicio = new GregorianCalendar();
				Ficheiro.lerSDO("tmp.sdo", localidades, utilizadores);
				temposSDO[rep][p][1] = (new GregorianCalendar()).getTimeInMillis() - inicio.getTimeInMillis();
				doProgress();
			    }
			}else{
			    Ficheiro.escreverEF("tmp.ef", locs[p], users[p]);
			    temposEF[rep][p][0] = (new GregorianCalendar()).getTimeInMillis() - inicio.getTimeInMillis();
			    doProgress();
			    if( readOnly == 2 ){
				inicio = new GregorianCalendar();
				Ficheiro.lerEF("tmp.ef", localidades, utilizadores);
				temposEF[rep][p][1] = (new GregorianCalendar()).getTimeInMillis() - inicio.getTimeInMillis();
				doProgress();
			    }
			}
			System.gc();
		    }
	    return null;
        }
 
        /*
         * Executed in event dispatching thread
         */
        @Override
        public void done() {
            setCursor(null);
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
        jLabel6 = new javax.swing.JLabel();
        jSreps = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Estatísticas da Camada de Persistência");

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

        jPbar.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jPbarStateChanged(evt);
            }
        });
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

        jLabel6.setText("Repetições");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 22;
        jPanel1.add(jLabel6, gridBagConstraints);

        jSreps.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(10), Integer.valueOf(0), null, Integer.valueOf(1)));
        jSreps.setToolTipText("");
        jSreps.setEditor(new javax.swing.JSpinner.NumberEditor(jSreps, ""));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 22;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 10);
        jPanel1.add(jSreps, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 506, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBiniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBiniciarActionPerformed
	jTFusers.setEnabled(false);
	jTFlocs.setEnabled(false);
	jTFligs.setEnabled(false);
	
	jBusers.setEnabled(false);
	jBlocs.setEnabled(false);
	jBligs.setEnabled(false);
	
	jCBusers.setEnabled(false);
	jCBlocs.setEnabled(false);
	jCBligs.setEnabled(false);
	
	jCBcinco.setEnabled(false);
	jCBdez.setEnabled(false);
	jCBquinze.setEnabled(false);
	jCBdezoito.setEnabled(false);
	
	jRBr.setEnabled(false);
	jRBrw.setEnabled(false);
	
	jSreps.setEnabled(false);
	jBiniciar.setEnabled(false);
	
	/*
	 * calcular alguns valores
	 */
	int pActivos = 0;
	if( jCBcinco.isSelected() ) pActivos++;
	if( jCBdez.isSelected() ) pActivos++;
	if( jCBquinze.isSelected() ) pActivos++;
	if( jCBdezoito.isSelected() ) pActivos++;
	
	patamares = new int[pActivos];
	int j = 0;
	if( jCBcinco.isSelected() ){
	    patamares[j] = 5000;
	    j++;
	}
	if( jCBdez.isSelected() ){
	    patamares[j] = 10000;
	    j++;
	}
	if( jCBquinze.isSelected() ){
	    patamares[j] = 15000;
	    j++;
	}
	if( jCBdezoito.isSelected() ){
	    patamares[j] = 18000;
	    j++;
	}
	
	if(jRBr.isSelected()) readOnly = 1;
	else readOnly = 2;
	
	repeticoes = Integer.parseInt(jSreps.getValue().toString());
	
	/*
	 * preparar a barra de progresso
	 */
	int qtyDados = 0;
	if( jCBusers.isSelected() ) qtyDados++;
	if( jCBlocs.isSelected() ) qtyDados++;
	//if( jCBligs.isSelected() ) qtyDados++;
	
	jPbar.setMinimum(0);
	/*
	 * Ler dados para os vários patamares
	 * Para SDO e EF
	 *     Fazer <repeticoes> vezes
	 *             Fazer para cada patamar
	 *	           Escrever
	 *                 Ler
	 */
	jPbar.setMaximum( 2 * repeticoes * j * readOnly + j );
	
        setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
	
        task = new Task();
        task.execute();
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

    private void jPbarStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jPbarStateChanged
	javax.swing.JProgressBar bar = (javax.swing.JProgressBar)evt.getSource();
	if(bar.getValue() == bar.getMaximum()){
	    StringBuilder str = new StringBuilder();
	    
	    double medias[][] = new double[patamares.length][readOnly];
	    double desvp[][] = new double[patamares.length][readOnly];
	    
	    int i,j,k;
	    
	    //somatório
	    for( i=0; i<repeticoes; i++ )
		for( j=0; j<patamares.length; j++ )
		    for(k=0; k<readOnly;k++)
			medias[j][k] += temposSDO[i][j][k];
	    
	    //dividir o somatório pelas repeticoes para obter as medias
	    for(i=0; i<patamares.length; i++)
		for(j=0; j<readOnly; j++)
		    medias[i][j] /= repeticoes;
	    
	    //calcular somatório do quadrado da diferença entre um tempo e a média
	    //  ( i1 - med )^2 + ( i2 - med )^2 + ...
	    for(i=0; i<repeticoes; i++)
		for(j=0; j<patamares.length; j++)
		    for(k=0; k<readOnly;k++){
			desvp[j][k] += Math.pow( temposSDO[i][j][k] - medias[j][k], 2);
		    }
	    
	    //por fim, o desvio padrao
	    for(i=0; i<patamares.length; i++)
		for(j=0; j<readOnly; j++)
		    desvp[i][j] = Math.sqrt( desvp[i][j]/repeticoes );
	    
	    //guardar as médias e desvios padrão de tempos de streams de objecto
	    str.append("------[TemposSDO]------\n");
	    for(i=0; i<patamares.length; i++){
		str.append(patamares[i]).append("\n");
		for(j=0; j<readOnly; j++){
		    if( j==0 ) str.append("ESCRITA -> ");
		    else       str.append("LEITURA -> ");
		    str.append("med: ")
			    .append(medias[i][j])
			    .append(" dp: ")
			    .append(desvp[i][j])
			    .append("\n");
		}
	    }
	    str.append("\n\n");
	    
	    // reiniciar os valores e calcular para os tempos de Escrita Formatada
	    medias = new double[patamares.length][readOnly];
	    desvp = new double[patamares.length][readOnly];
	    
	    //somatório
	    for( i=0; i<repeticoes; i++ )
		for( j=0; j<patamares.length; j++ )
		    for(k=0; k<readOnly;k++)
			medias[j][k] += temposEF[i][j][k];
	    
	    //dividir o somatório pelas repeticoes para obter as medias
	    for(i=0; i<patamares.length; i++)
		for(j=0; j<readOnly; j++)
		    medias[i][j] /= repeticoes;
	    
	    //calcular somatório do quadrado da diferença entre um tempo e a média
	    //  ( i1 - med )^2 + ( i2 - med )^2 + ...
	    for(i=0; i<repeticoes; i++)
		for(j=0; j<patamares.length; j++)
		    for(k=0; k<readOnly;k++){
			desvp[j][k] += Math.pow( temposEF[i][j][k] - medias[j][k], 2);
		    }
	    
	    //por fim, o desvio padrao
	    for(i=0; i<patamares.length; i++)
		for(j=0; j<readOnly; j++)
		    desvp[i][j] = Math.sqrt( desvp[i][j]/repeticoes );
	    
	    //guardar as médias e desvios padrão de tempos de escrita formatada
	    str.append("------[TemposEF]------\n");
	    for(i=0; i<patamares.length; i++){
		str.append(patamares[i]).append("\n");
		for(j=0; j<readOnly; j++){
		    if( j==0 ) str.append("ESCRITA -> ");
		    else       str.append("LEITURA -> ");
		    str.append("med: ")
			    .append(medias[i][j])
			    .append(" dp: ")
			    .append(desvp[i][j])
			    .append("\n");
		}
	    }
	    
	    
	    try {
		PrintWriter pw = new PrintWriter("persistencia.txt");
		pw.append(str.toString());
		pw.close();
	    } catch (FileNotFoundException ex) {}
	    
	    JOptionPane.showMessageDialog(this, "Processo concluído. As estatísticas estão no ficheiro\nestatísticas.txt, na mesma directoria da aplicação.\n\nClique OK para fechar a aplicação.", "Processo Concluído", JOptionPane.INFORMATION_MESSAGE);
	    this.dispose();
	}
    }//GEN-LAST:event_jPbarStateChanged
    
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
    
    private void doProgress(){
	jPbar.setValue( jPbar.getValue()+1 );
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
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar jPbar;
    private javax.swing.JRadioButton jRBr;
    private javax.swing.JRadioButton jRBrw;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSpinner jSreps;
    private javax.swing.JTextField jTFligs;
    private javax.swing.JTextField jTFlocs;
    private javax.swing.JTextField jTFusers;
    // End of variables declaration//GEN-END:variables
}
