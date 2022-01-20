/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.projeto.projetounificadoMSPSC;

import static br.projeto.projetounificadoMSPSC.FormProjetoLista.projetoForm;
import java.time.LocalDate;
import java.util.Date;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author allan
 */
public class FormRequisitosLista extends javax.swing.JFrame {
    public static Requisito requisitoForm;
    
    /**
     * Creates new form FormRequisitosLista
     */
    
    public void recuperarListaRequisitos() {
        Vector listaRequisitos = requisitoForm.recuperarListaRequisitos();
        
        Vector nomesColunas = new Vector(); 
        nomesColunas.add("ID");
        nomesColunas.add("Identificador");
        nomesColunas.add("Nome");
        nomesColunas.add("Módulo");
        nomesColunas.add("Funcionalidades");
        nomesColunas.add("Data de Criação");
        nomesColunas.add("Prioridade");
        nomesColunas.add("Descrição");
        nomesColunas.add("Projeto");
        nomesColunas.add("Autor");
        
        DefaultTableModel dataModel = new DefaultTableModel();
        
        dataModel.setDataVector(listaRequisitos, nomesColunas);
                
        tblRequisitos.setModel(dataModel);
    }
    
    public FormRequisitosLista() {
        initComponents();
        
        requisitoForm = new Requisito();
        
        recuperarListaRequisitos();
        
        btnCancelar.setVisible(false);
        btnSalvar.setVisible(false);
    }
    
    public void getSelectedRequirement() {
        try {
            if (tblRequisitos.getSelectedRow() != -1) {
                int idProjeto = tblRequisitos.getValueAt(tblRequisitos.getSelectedRow(), 0).hashCode();

                requisitoForm.consultarRequisito(idProjeto);
            }
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível resgatar o valor do ID!");
        }
    }
    
    public String atualizarVersao() {
        int versao = Integer.parseInt(requisitoForm.getVersao());
        versao++;
        
        String versaoAtualizada = String.valueOf(versao);
        
        return versaoAtualizada;
    }
    
    public void atualizar() {
        int identificador = cbIdentificador.getSelectedIndex();
        int prioridade = cbPrioridade.getSelectedIndex();
        int estado = cbEstado.getSelectedIndex();
        int fase = cbFase.getSelectedIndex();
        int complexidade = cbComplexidade.getSelectedIndex();
        
        String nome = txtNome.getText();
        String modulo = txtModulo.getText();
        int esforcoHoras = Integer.parseInt(txtEstimaHoras.getText());
        String descricao = txtDescricao.getText();
        String funcionalidades = txtFuncionalidades.getText();
        
        requisitoForm.alterarRequisito(identificador, nome, modulo, funcionalidades, prioridade, atualizarVersao(), complexidade, 
                esforcoHoras, estado, fase, descricao);
        
        recuperarListaRequisitos();
        
        JOptionPane.showMessageDialog(null, "Requisito alterado com sucesso!");
        
        cbIdentificador.setEnabled(false);
        cbEstado.setEnabled(false);
        cbFase.setEnabled(false);
        cbPrioridade.setEnabled(false);
        cbComplexidade.setEnabled(false);
        
        txtNome.setEnabled(false);
        txtModulo.setEnabled(false);
        txtEstimaHoras.setEnabled(false);
        txtDescricao.setEnabled(false);
        txtFuncionalidades.setEnabled(false);
        
        tblRequisitos.setEnabled(true);
        btnVoltar.setEnabled(true);
        btnConsultarRequisito.setEnabled(true);
        btnCancelar.setVisible(false);
        btnSalvar.setVisible(false);
        btnCriarRequisito.setEnabled(true);
        btnDeletarRequisito.setEnabled(true);
        
        txtVersao.setText(atualizarVersao());
        txtAutorUltimaAlteracao.setText(FormLogin.userLogin.getUsuario());
        
        String dataAtual = String.valueOf(LocalDate.now());
        
        txtUltimaAlteracao.setText(dataAtual);
        
        requisitoForm.setIdentificador(identificador);
        requisitoForm.setNome(nome);
        requisitoForm.setModulo(modulo);
        requisitoForm.setFuncionalidades(funcionalidades);
        requisitoForm.setPrioridade(prioridade);
        requisitoForm.setVersao(atualizarVersao());
        requisitoForm.setComplexidade(complexidade);
        requisitoForm.setEsforcoHoras(esforcoHoras);
        requisitoForm.setEstado(estado);
        requisitoForm.setFase(fase);
        requisitoForm.setAutorUltimaAlteracao(FormLogin.userLogin.getUsuario());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblRequisitos = new javax.swing.JTable();
        btnVoltar = new javax.swing.JButton();
        btnCriarRequisito = new javax.swing.JButton();
        btnConsultarRequisito = new javax.swing.JButton();
        btnAlterarRequisito = new javax.swing.JButton();
        btnDeletarRequisito = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lblIdentificador = new javax.swing.JLabel();
        cbIdentificador = new javax.swing.JComboBox<>();
        lblEstado = new javax.swing.JLabel();
        cbEstado = new javax.swing.JComboBox<>();
        lblFase = new javax.swing.JLabel();
        cbFase = new javax.swing.JComboBox<>();
        lblPrioridade = new javax.swing.JLabel();
        cbPrioridade = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        cbComplexidade = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        lblModulo = new javax.swing.JLabel();
        txtModulo = new javax.swing.JTextField();
        lblProjeto = new javax.swing.JLabel();
        txtProjeto = new javax.swing.JTextField();
        lblAutor = new javax.swing.JLabel();
        txtAutor = new javax.swing.JTextField();
        lblDataCriacao = new javax.swing.JLabel();
        txtDataCriacao = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtVersao = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtEstimaHoras = new javax.swing.JFormattedTextField();
        lblUltimaAlteracao = new javax.swing.JLabel();
        txtUltimaAlteracao = new javax.swing.JTextField();
        lblAutorUltimaAlteracao = new javax.swing.JLabel();
        txtAutorUltimaAlteracao = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        lblFuncionalidades = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtFuncionalidades = new javax.swing.JTextArea();
        lblDescricao = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescricao = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        btnRelatorioRequisitos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblRequisitos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Identificador", "Nome", "Módulo", "Funcionalidades", "Data de Criação", "Prioridade", "Descrição", "Projeto", "Autor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblRequisitos);

        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        btnCriarRequisito.setText("Criar Requisito");
        btnCriarRequisito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCriarRequisitoActionPerformed(evt);
            }
        });

        btnConsultarRequisito.setText("Consultar Requisito");
        btnConsultarRequisito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarRequisitoActionPerformed(evt);
            }
        });

        btnAlterarRequisito.setText("Alterar Requisito");
        btnAlterarRequisito.setEnabled(false);
        btnAlterarRequisito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarRequisitoActionPerformed(evt);
            }
        });

        btnDeletarRequisito.setText("Deletar Requisito");
        btnDeletarRequisito.setEnabled(false);
        btnDeletarRequisito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletarRequisitoActionPerformed(evt);
            }
        });

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        lblIdentificador.setForeground(new java.awt.Color(255, 255, 255));
        lblIdentificador.setText("Identificador:");

        cbIdentificador.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Requisitos Funcional", "Requisitos Não Funcional" }));
        cbIdentificador.setEnabled(false);

        lblEstado.setForeground(new java.awt.Color(255, 255, 255));
        lblEstado.setText("Estado:");

        cbEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Pendente", "Em Andamento", "Finalizado" }));
        cbEstado.setEnabled(false);

        lblFase.setForeground(new java.awt.Color(255, 255, 255));
        lblFase.setText("Fase:");

        cbFase.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Iniciação", "Planejamento", "Execução", "Monitoramento", "Controle", "Encerramento" }));
        cbFase.setEnabled(false);

        lblPrioridade.setForeground(new java.awt.Color(255, 255, 255));
        lblPrioridade.setText("Prioridade:");

        cbPrioridade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Baixa", "Média", "Alta" }));
        cbPrioridade.setEnabled(false);

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Complexidade:");

        cbComplexidade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Baixa", "Média", "Alta" }));
        cbComplexidade.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbPrioridade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPrioridade)
                    .addComponent(lblEstado)
                    .addComponent(cbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbFase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFase, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbIdentificador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblIdentificador, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(cbComplexidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(lblIdentificador)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbIdentificador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPrioridade)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbPrioridade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblEstado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblFase)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbFase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbComplexidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel4.setText("Selecione:");

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));

        lblNome.setForeground(new java.awt.Color(255, 255, 255));
        lblNome.setText("Nome:");

        txtNome.setEnabled(false);
        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeActionPerformed(evt);
            }
        });

        lblModulo.setForeground(new java.awt.Color(255, 255, 255));
        lblModulo.setText("Módulo:");

        txtModulo.setEnabled(false);

        lblProjeto.setForeground(new java.awt.Color(255, 255, 255));
        lblProjeto.setText("Projeto:");

        txtProjeto.setEnabled(false);

        lblAutor.setForeground(new java.awt.Color(255, 255, 255));
        lblAutor.setText("Autor:");

        txtAutor.setEnabled(false);

        lblDataCriacao.setForeground(new java.awt.Color(255, 255, 255));
        lblDataCriacao.setText("Data de Criação:");

        txtDataCriacao.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNome)
                    .addComponent(txtModulo)
                    .addComponent(txtProjeto)
                    .addComponent(txtAutor)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNome, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblModulo)
                            .addComponent(lblProjeto)
                            .addComponent(lblAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDataCriacao))
                        .addGap(0, 142, Short.MAX_VALUE))
                    .addComponent(txtDataCriacao))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblModulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtModulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblProjeto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtProjeto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblAutor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDataCriacao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDataCriacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel5.setText("Dados:");

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Versão:");

        txtVersao.setEnabled(false);

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Esforço Estimado Em Horas:");

        txtEstimaHoras.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        txtEstimaHoras.setEnabled(false);

        lblUltimaAlteracao.setForeground(new java.awt.Color(255, 255, 255));
        lblUltimaAlteracao.setText("Data de Última Alteração");

        txtUltimaAlteracao.setEnabled(false);

        lblAutorUltimaAlteracao.setForeground(new java.awt.Color(255, 255, 255));
        lblAutorUltimaAlteracao.setText("Autor da Última Alteração:");

        txtAutorUltimaAlteracao.setEnabled(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtVersao)
                    .addComponent(txtEstimaHoras)
                    .addComponent(txtUltimaAlteracao)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(lblUltimaAlteracao)
                            .addComponent(lblAutorUltimaAlteracao))
                        .addGap(0, 160, Short.MAX_VALUE))
                    .addComponent(txtAutorUltimaAlteracao))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtVersao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtEstimaHoras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(28, 28, 28)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblUltimaAlteracao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUltimaAlteracao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblAutorUltimaAlteracao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtAutorUltimaAlteracao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel6.setText("Mais dados:");

        jPanel4.setBackground(new java.awt.Color(51, 51, 51));

        lblFuncionalidades.setForeground(new java.awt.Color(255, 255, 255));
        lblFuncionalidades.setText("Funcionalidades:");

        txtFuncionalidades.setColumns(20);
        txtFuncionalidades.setRows(5);
        txtFuncionalidades.setEnabled(false);
        jScrollPane3.setViewportView(txtFuncionalidades);

        lblDescricao.setForeground(new java.awt.Color(255, 255, 255));
        lblDescricao.setText("Descrição:");

        txtDescricao.setColumns(20);
        txtDescricao.setRows(5);
        txtDescricao.setEnabled(false);
        jScrollPane2.setViewportView(txtDescricao);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblFuncionalidades)
                            .addComponent(lblDescricao))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblFuncionalidades)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblDescricao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel7.setText("Dados Estatisticos:");

        btnRelatorioRequisitos.setText("Gerar Relatório de Requisitos");
        btnRelatorioRequisitos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRelatorioRequisitosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1096, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnCriarRequisito)
                                .addGap(18, 18, 18)
                                .addComponent(btnConsultarRequisito)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnSalvar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnAlterarRequisito, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(btnDeletarRequisito)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnVoltar))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnRelatorioRequisitos)))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCriarRequisito)
                    .addComponent(btnConsultarRequisito)
                    .addComponent(btnAlterarRequisito)
                    .addComponent(btnDeletarRequisito)
                    .addComponent(btnVoltar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar)
                    .addComponent(btnRelatorioRequisitos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(59, 59, 59))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        // TODO add your handling code here:
        FormProjetoLista projetosForm = new FormProjetoLista();
        projetosForm.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void btnCriarRequisitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCriarRequisitoActionPerformed
        // TODO add your handling code here:
        FormCadastroRequisito cadRequisitoForm = new FormCadastroRequisito();
        cadRequisitoForm.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnCriarRequisitoActionPerformed

    private void btnConsultarRequisitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarRequisitoActionPerformed
        // TODO add your handling code here:
            if (tblRequisitos.getSelectedRow() != -1) {
            getSelectedRequirement();
        
            cbIdentificador.setSelectedIndex(requisitoForm.getIdentificador());
            cbPrioridade.setSelectedIndex(requisitoForm.getPrioridade());
            cbEstado.setSelectedIndex(requisitoForm.getEstado());
            cbFase.setSelectedIndex(requisitoForm.getFase());
            cbComplexidade.setSelectedIndex(requisitoForm.getComplexidade());
        
            txtNome.setText(requisitoForm.getNome());
            txtModulo.setText(requisitoForm.getModulo());
            txtFuncionalidades.setText(requisitoForm.getFuncionalidades());
        
            String dataCriacao = String.valueOf(requisitoForm.getDataCricao());
        
            txtDataCriacao.setText(dataCriacao);
            txtDescricao.setText(requisitoForm.getDescricao());
            txtProjeto.setText(requisitoForm.getProjeto());
            txtAutor.setText(requisitoForm.getAutor());
        
            String dataUltimaAlteracao = String.valueOf(requisitoForm.getDataUltimaAlteracao());
        
            txtUltimaAlteracao.setText(dataUltimaAlteracao);
            txtVersao.setText(requisitoForm.getVersao());
        
            String esforcoHoras = String.valueOf(requisitoForm.getEsforcoHoras());
        
            txtEstimaHoras.setText(esforcoHoras);
            txtAutorUltimaAlteracao.setText(requisitoForm.getAutorUltimaAlteracao());
        
            btnAlterarRequisito.setEnabled(true);
            btnDeletarRequisito.setEnabled(true);
        }
    }//GEN-LAST:event_btnConsultarRequisitoActionPerformed

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeActionPerformed

    private void btnAlterarRequisitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarRequisitoActionPerformed
        // TODO add your handling code here:
        cbIdentificador.setEnabled(true);
        cbEstado.setEnabled(true);
        cbFase.setEnabled(true);
        cbPrioridade.setEnabled(true);
        cbComplexidade.setEnabled(true);
        
        txtNome.setEnabled(true);
        txtModulo.setEnabled(true);
        txtEstimaHoras.setEnabled(true);
        txtDescricao.setEnabled(true);
        txtFuncionalidades.setEnabled(true);
        
        tblRequisitos.setEnabled(false);
        btnVoltar.setEnabled(false);
        btnConsultarRequisito.setEnabled(false);
        btnCancelar.setVisible(true);
        btnSalvar.setVisible(true);
        btnCriarRequisito.setEnabled(false);
        btnDeletarRequisito.setEnabled(false);
        btnRelatorioRequisitos.setEnabled(false);
    }//GEN-LAST:event_btnAlterarRequisitoActionPerformed

    private void btnDeletarRequisitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletarRequisitoActionPerformed
        // TODO add your handling code here:
        String alerta = "Tem certeza que deseja excluir esse requisito?";
        
        int confirm = JOptionPane.showConfirmDialog(null, alerta);
        
        if (confirm == JOptionPane.YES_OPTION) {
            btnAlterarRequisito.setEnabled(false);
            btnDeletarRequisito.setEnabled(false);
            
            cbIdentificador.setSelectedIndex(0);
            cbPrioridade.setSelectedIndex(0);
            cbEstado.setSelectedIndex(0);
            cbFase.setSelectedIndex(0);
            cbComplexidade.setSelectedIndex(0);
        
            txtNome.setText("");
            txtModulo.setText("");
            txtFuncionalidades.setText("");
            txtDataCriacao.setText("");
            txtDescricao.setText("");
            txtProjeto.setText("");
            txtAutor.setText("");
            txtUltimaAlteracao.setText("");
            txtVersao.setText("");            
            txtEstimaHoras.setText("");
            txtAutorUltimaAlteracao.setText("");
            
            requisitoForm.setIdentificador(0);
            requisitoForm.setNome("");
            requisitoForm.setModulo("");
            requisitoForm.setFuncionalidades("");
            requisitoForm.setDataCricao(null);
            requisitoForm.setDataUltimaAlteracao(null);
            requisitoForm.setPrioridade(0);
            requisitoForm.setVersao("");
            requisitoForm.setComplexidade(0);
            requisitoForm.setEsforcoHoras(0);
            requisitoForm.setEstado(0);
            requisitoForm.setFase(0);
            requisitoForm.setDescricao("");
            requisitoForm.setProjeto("");
            requisitoForm.setAutor("");
            requisitoForm.setAutorUltimaAlteracao("");
            
            requisitoForm.deletarRequisito();
            
            JOptionPane.showMessageDialog(null, "Requisito excluído com sucesso!");
            
            requisitoForm.setId(0);
            
            recuperarListaRequisitos();
        }
        else if (confirm == JOptionPane.NO_OPTION) {}
    }//GEN-LAST:event_btnDeletarRequisitoActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        // TODO add your handling code here:
        int identificador = cbIdentificador.getSelectedIndex();
        int prioridade = cbPrioridade.getSelectedIndex();
        int estado = cbEstado.getSelectedIndex();
        int fase = cbFase.getSelectedIndex();
        int complexidade = cbComplexidade.getSelectedIndex();
        
        String nome = txtNome.getText();
        String modulo = txtModulo.getText();
        int esforcoHoras = Integer.parseInt(txtEstimaHoras.getText());
        String descricao = txtDescricao.getText();
        String funcionalidades = txtFuncionalidades.getText();
        
        boolean validado = requisitoForm.autenticarRequisito(nome);
        
        if (cbIdentificador.getSelectedIndex() == 0 || cbPrioridade.getSelectedIndex() == 0 || cbEstado.getSelectedIndex() == 0 || 
                cbFase.getSelectedIndex() == 0 || cbComplexidade.getSelectedIndex() == 0 || txtNome.getText().isEmpty() || 
                txtModulo.getText().isEmpty() || txtDescricao.getText().isEmpty() || txtFuncionalidades.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Todos os campos precisam estar preenchidos para que o requisito possa ser alterado!");
        }
        else {
            boolean mesmoNome = (requisitoForm.getNome() == nome) ? true : false;
            
            if(mesmoNome) {
                atualizar();
                btnRelatorioRequisitos.setEnabled(true);
            }
            else if(validado) {
                atualizar();
                btnRelatorioRequisitos.setEnabled(true);
            }
            else {
                JOptionPane.showMessageDialog(null, "Já existe um requisito com esse nome. Insira outro por favor!");
            }
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        cbIdentificador.setEnabled(false);
        cbEstado.setEnabled(false);
        cbFase.setEnabled(false);
        cbPrioridade.setEnabled(false);
        cbComplexidade.setEnabled(false);
        
        txtNome.setEnabled(false);
        txtModulo.setEnabled(false);
        txtEstimaHoras.setEnabled(false);
        txtDescricao.setEnabled(false);
        txtFuncionalidades.setEnabled(false);
        
        tblRequisitos.setEnabled(true);
        btnVoltar.setEnabled(true);
        btnConsultarRequisito.setEnabled(true);
        btnCancelar.setVisible(false);
        btnSalvar.setVisible(false);
        btnCriarRequisito.setEnabled(true);
        btnDeletarRequisito.setEnabled(true);
        
        cbIdentificador.setSelectedIndex(requisitoForm.getIdentificador());
        cbPrioridade.setSelectedIndex(requisitoForm.getPrioridade());
        cbEstado.setSelectedIndex(requisitoForm.getEstado());
        cbFase.setSelectedIndex(requisitoForm.getFase());
        cbComplexidade.setSelectedIndex(requisitoForm.getComplexidade());
        
        txtNome.setText(requisitoForm.getNome());
        txtModulo.setText(requisitoForm.getModulo());
        txtFuncionalidades.setText(requisitoForm.getFuncionalidades());
        
        String dataCriacao = String.valueOf(requisitoForm.getDataCricao());
        
        txtDataCriacao.setText(dataCriacao);
        txtDescricao.setText(requisitoForm.getDescricao());
        txtProjeto.setText(requisitoForm.getProjeto());
        txtAutor.setText(requisitoForm.getAutor());
        
        String dataUltimaAlteracao = String.valueOf(requisitoForm.getDataUltimaAlteracao());
        
        txtUltimaAlteracao.setText(dataUltimaAlteracao);
        txtVersao.setText(requisitoForm.getVersao());
        
        String esforcoHoras = String.valueOf(requisitoForm.getEsforcoHoras());
        
        txtEstimaHoras.setText(esforcoHoras);
        txtAutorUltimaAlteracao.setText(requisitoForm.getAutorUltimaAlteracao());
        btnRelatorioRequisitos.setEnabled(true);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnRelatorioRequisitosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRelatorioRequisitosActionPerformed
        // TODO add your handling code here:
        FormRelatoriosRequisitos relatorioRequisitosForm = new FormRelatoriosRequisitos();
        relatorioRequisitosForm.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnRelatorioRequisitosActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterarRequisito;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnConsultarRequisito;
    private javax.swing.JButton btnCriarRequisito;
    private javax.swing.JButton btnDeletarRequisito;
    private javax.swing.JButton btnRelatorioRequisitos;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JComboBox<String> cbComplexidade;
    private javax.swing.JComboBox<String> cbEstado;
    private javax.swing.JComboBox<String> cbFase;
    private javax.swing.JComboBox<String> cbIdentificador;
    private javax.swing.JComboBox<String> cbPrioridade;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblAutor;
    private javax.swing.JLabel lblAutorUltimaAlteracao;
    private javax.swing.JLabel lblDataCriacao;
    private javax.swing.JLabel lblDescricao;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblFase;
    private javax.swing.JLabel lblFuncionalidades;
    private javax.swing.JLabel lblIdentificador;
    private javax.swing.JLabel lblModulo;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblPrioridade;
    private javax.swing.JLabel lblProjeto;
    private javax.swing.JLabel lblUltimaAlteracao;
    private javax.swing.JTable tblRequisitos;
    private javax.swing.JTextField txtAutor;
    private javax.swing.JTextField txtAutorUltimaAlteracao;
    private javax.swing.JTextField txtDataCriacao;
    private javax.swing.JTextArea txtDescricao;
    private javax.swing.JFormattedTextField txtEstimaHoras;
    private javax.swing.JTextArea txtFuncionalidades;
    private javax.swing.JTextField txtModulo;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtProjeto;
    private javax.swing.JTextField txtUltimaAlteracao;
    private javax.swing.JTextField txtVersao;
    // End of variables declaration//GEN-END:variables
}
