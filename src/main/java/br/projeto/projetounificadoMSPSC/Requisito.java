/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.projeto.projetounificadoMSPSC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author allan
 */
public class Requisito {
    private int id;
    private int identificador;
    private String nome;
    private String modulo;
    private String funcionalidades;
    private Date dataCricao;
    private Date dataUltimaAlteracao;
    private int prioridade;
    private String versao;
    private int complexidade;
    private int esforcoHoras;
    private int estado;
    private int fase;
    private String descricao;
    private String projeto;
    private String autor;
    private String autorUltimaAlteracao;
    
    public Vector recuperarRelatorioRequisitos() {
        Vector listaRequisitos = new Vector();
        
        String sql = "SELECT R.ID, R.Identificador, R.Nome, R.Modulo, R.Funcionalidades, R.Prioridade, R.Descricao, "
                + "U.ID, U.NomeUsuario AS Autor FROM Requisitos R LEFT JOIN Projetos P ON (P.ID = R.Projeto) "
                + "LEFT JOIN Usuarios U ON (U.ID = R.Autor) WHERE P.ID = " + FormProjetoLista.projetoForm.getId();
        
        try {
            ConnectionFactory conexaoBD = new ConnectionFactory();
            Connection conn = conexaoBD.getConnection();
        
            Statement stm = conn.createStatement();
            
            ResultSet dados;
            dados = stm.executeQuery(sql);
            while(dados.next()) {
                int idResult = dados.getInt("R.ID");
                String identificadorResult = dados.getString("R.Identificador");
                String nomeResult = dados.getString("R.Nome");
                String moduloResult = dados.getString("R.Modulo");
                String funcionalidadesResult = dados.getString("R.Funcionalidades");
                String prioridadesResult = dados.getString("R.Prioridade");
                String descricaoResult = dados.getString("R.Descricao");
                String autorResult = dados.getString("Autor");
                
                Vector temp = new Vector();
                
                temp.add(idResult);
                temp.add(identificadorResult);
                temp.add(nomeResult);
                temp.add(moduloResult);
                temp.add(funcionalidadesResult);
                temp.add(prioridadesResult);
                temp.add(descricaoResult);
                temp.add(autorResult);
                
                listaRequisitos.addElement(temp);
            }
            
            conexaoBD.closeConnection();
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível recuperar a lista de requisitos!");
        }
        return listaRequisitos;
    }
    
    public Vector recuperarListaRequisitos() {
        Vector listaRequisitos = new Vector();
        
        String sql = "SELECT R.ID, R.Identificador, R.Nome, R.Modulo, R.Funcionalidades, R.DataCriacao, R.Prioridade, R.Descricao, "
                + "P.ID, P.Nome AS Projeto, U.ID, U.NomeUsuario AS Autor FROM Requisitos R LEFT JOIN Projetos P ON (P.ID = R.Projeto) "
                + "LEFT JOIN Usuarios U ON (U.ID = R.Autor) WHERE P.ID = " + FormProjetoLista.projetoForm.getId();
        
        try {
            ConnectionFactory conexaoBD = new ConnectionFactory();
            Connection conn = conexaoBD.getConnection();
        
            Statement stm = conn.createStatement();
            
            ResultSet dados;
            dados = stm.executeQuery(sql);
            while(dados.next()) {
                int idResult = dados.getInt("R.ID");
                String identificadorResult = dados.getString("R.Identificador");
                String nomeResult = dados.getString("R.Nome");
                String moduloResult = dados.getString("R.Modulo");
                String funcionalidadesResult = dados.getString("R.Funcionalidades");
                Date datacriacaoResult = dados.getDate("R.DataCriacao");
                String prioridadesResult = dados.getString("R.Prioridade");
                String descricaoResult = dados.getString("R.Descricao");
                String projetoResult = dados.getString("Projeto");
                String autorResult = dados.getString("Autor");
                
                Vector temp = new Vector();
                
                temp.add(idResult);
                temp.add(identificadorResult);
                temp.add(nomeResult);
                temp.add(moduloResult);
                temp.add(funcionalidadesResult);
                temp.add(datacriacaoResult);
                temp.add(prioridadesResult);
                temp.add(descricaoResult);
                temp.add(projetoResult);
                temp.add(autorResult);
                
                listaRequisitos.addElement(temp);
            }
            
            conexaoBD.closeConnection();
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível recuperar a lista de requisitos!");
        }
        return listaRequisitos;
    }
    
    public boolean autenticarRequisito(String nome) {
        String exists = "";
        
        String sql = "SELECT Nome FROM Requisitos WHERE Nome = \"" + nome + "\" AND Projeto = " + FormProjetoLista.projetoForm.getId();
       
        try {
            ConnectionFactory conexaoBD = new ConnectionFactory();  
            Connection conn = conexaoBD.getConnection();
            
            Statement stm = conn.createStatement();
            
            ResultSet resultado; 
            resultado = stm.executeQuery(sql);
            
            while(resultado.next()){
                exists = resultado.getString("Nome");
            }
            
            conexaoBD.closeConnection();

        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível consultar!");
        }
        
        if (exists == null || exists.equals("")) {
            return true;
        } else {
            return false;
        }
    }
    
    public void salvarRequisito(int identificador, String nome, String modulo, String funcionalidades, int prioridade, int complexidade,
                                int esforcoEstimadoH, String descricao) {
        String sql = "INSERT INTO Requisitos (Identificador, Nome, Modulo, Funcionalidades, DataCriacao, Prioridade, Versao, Complexidade, "
                + "EsforcoHoras, Estado, Fase, Descricao, Projeto, Autor) "
                + "VALUES "
                + "(" + identificador + ", \"" + nome + "\", \"" + modulo + "\", \"" + funcionalidades + "\", NOW(), " + prioridade + ", "
                + "\"0\", " + complexidade + ", " + esforcoEstimadoH + ", 1, 1, \"" + descricao + "\", "
                + FormProjetoLista.projetoForm.getId() + ", " + FormLogin.userLogin.getId() + ")";
        
        try {
            ConnectionFactory conexaoBD = new ConnectionFactory();
            Connection conn = conexaoBD.getConnection();
        
            Statement stm = conn.createStatement();
            stm.executeUpdate(sql);
            
            conexaoBD.closeConnection();
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Não conseguiu gravar!");
        }
    }
    
    public void consultarRequisito(int id) {
        String sql = "SELECT R.ID, R.Identificador + 0 AS Identificador, R.Nome, R.Modulo, R.Funcionalidades, R.DataCriacao, "
                + "R.DataUltimaAlteracao, R.Prioridade + 0 AS Prioridade, R.Versao, R.Complexidade + 0 AS Complexidade, "
                + "R.EsforcoHoras, R.Estado + 0 AS Estado, R.Fase + 0 AS Fase, R.Descricao, U.ID, U.NomeUsuario, P.ID, "
                + "P.Nome "
                + "FROM Requisitos R "
                + "LEFT JOIN Usuarios U ON (U.ID = R.Autor) "
                + "LEFT JOIN Projetos P ON (P.ID = R.Projeto) "
                + "WHERE R.ID = " + id + "";
        
        try {
            ConnectionFactory conexaoBD = new ConnectionFactory();  
            Connection conn = conexaoBD.getConnection();
            
            Statement stm = conn.createStatement();
            
            ResultSet resultado; 
            resultado = stm.executeQuery(sql);
            
            while (resultado.next()) {
                this.id = resultado.getInt("R.ID");
                this.identificador = resultado.getInt("Identificador");
                this.nome = resultado.getString("R.Nome");
                this.modulo = resultado.getString("R.Modulo");
                this.funcionalidades = resultado.getString("R.Funcionalidades");
                this.dataCricao = resultado.getDate("R.DataCriacao");
                this.dataUltimaAlteracao = resultado.getDate("R.DataUltimaAlteracao");
                this.prioridade = resultado.getInt("Prioridade");
                this.versao = resultado.getString("R.Versao");
                this.complexidade = resultado.getInt("Complexidade");
                this.esforcoHoras = resultado.getInt("R.EsforcoHoras");
                this.estado = resultado.getInt("Estado");
                this.fase = resultado.getInt("Fase");
                this.descricao = resultado.getString("R.Descricao");
                this.projeto = resultado.getString("P.Nome");
                this.autor = resultado.getString("U.NomeUsuario");
                this.autorUltimaAlteracao = resultado.getString("U.NomeUsuario");
            }
            
            conexaoBD.closeConnection();
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível resgatar os dados desse requisito!");
        }
    }
    
    public void deletarRequisito() {
        String sql = "DELETE FROM Requisitos WHERE ID = " + id;
        
        try {
            ConnectionFactory conexaoBD = new ConnectionFactory();  
            Connection conn = conexaoBD.getConnection();
            
            Statement stm = conn.createStatement();
            
            stm.executeUpdate(sql);
            
            conexaoBD.closeConnection();
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível excluir esse requisito!");
        }
    }
    
    public void alterarRequisito(int identificador, String nome, String modulo, String funcionalidades, int prioridade, String versao, 
                                 int complexidade, int esforcoHoras, int estado, int fase, String descricao) {
        String sql = "UPDATE Requisitos " +
                     "SET Identificador = " + identificador + ", " +
                         "Prioridade = " + prioridade + ", " +
	                 "Estado = " + estado + ", " +
	                 "Fase = " + fase + ", " +
	                 "Complexidade = " + complexidade + ", " +
	                 "Nome = \"" + nome + "\", " +
	                 "Modulo = \"" + modulo + "\", " +
	                 "Versao = \"" + versao + "\", " +
	                 "EsforcoHoras = " + esforcoHoras + ", " +
                         "Funcionalidades = \"" + funcionalidades + "\", " +
                         "Descricao = \"" + descricao + "\", " +
                         "AutorUltimaAlteracao = \"" + FormLogin.userLogin.getId() + "\", " +
                         "DataUltimaAlteracao = NOW() " +
                     "WHERE ID = " + id;
        
        String sqlDataHoraUltimaAlteracao = "SELECT DataUltimaAlteracao FROM Requisitos WHERE ID = " + id;
        
        try {
            ConnectionFactory conexaoBD = new ConnectionFactory();
            Connection conn = conexaoBD.getConnection();
        
            Statement stm = conn.createStatement();
            stm.executeUpdate(sql);
            
            ResultSet result = stm.executeQuery(sqlDataHoraUltimaAlteracao);
            
            while(result.next()) {
                this.dataUltimaAlteracao = result.getDate("DataUltimaAlteracao");
            }
            
            conexaoBD.closeConnection();
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível alterar esse requisito!");
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getModulo() {
        return modulo;
    }

    public void setModulo(String modulo) {
        this.modulo = modulo;
    }

    public String getFuncionalidades() {
        return funcionalidades;
    }

    public void setFuncionalidades(String funcionalidades) {
        this.funcionalidades = funcionalidades;
    }

    public Date getDataCricao() {
        return dataCricao;
    }

    public void setDataCricao(Date dataCricao) {
        this.dataCricao = dataCricao;
    }

    public Date getDataUltimaAlteracao() {
        return dataUltimaAlteracao;
    }

    public void setDataUltimaAlteracao(Date dataUltimaAlteracao) {
        this.dataUltimaAlteracao = dataUltimaAlteracao;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    public String getVersao() {
        return versao;
    }

    public void setVersao(String versao) {
        this.versao = versao;
    }

    public int getComplexidade() {
        return complexidade;
    }

    public void setComplexidade(int complexidade) {
        this.complexidade = complexidade;
    }

    public int getEsforcoHoras() {
        return esforcoHoras;
    }

    public void setEsforcoHoras(int esforcoHoras) {
        this.esforcoHoras = esforcoHoras;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getFase() {
        return fase;
    }

    public void setFase(int fase) {
        this.fase = fase;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getProjeto() {
        return projeto;
    }

    public void setProjeto(String projeto) {
        this.projeto = projeto;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getAutorUltimaAlteracao() {
        return autorUltimaAlteracao;
    }

    public void setAutorUltimaAlteracao(String autorUltimaAlteracao) {
        this.autorUltimaAlteracao = autorUltimaAlteracao;
    }
}
