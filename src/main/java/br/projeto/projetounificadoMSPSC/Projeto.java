/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.projeto.projetounificadoMSPSC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author allan
 */
public class Projeto {
    private int id;
    private String nome;
    private String descricao;
    private String usuarioProprietario;
    private int idUsuarioProprietario;
    
    public void salvarProjeto(String nome, String desc) {
        String sql = "INSERT INTO Projetos(Nome, Descricao, UsuarioProprietario) "
                + "VALUES(\"" + nome + "\", \"" + desc + "\", " + FormLogin.userLogin.getId() + ")";
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
    
    public boolean autenticarProjeto(String nome) {
        String exists = "";
        
        String sql = "SELECT Nome FROM Projetos WHERE Nome = \"" + nome + "\"";
       
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
    
    public Vector recuperarListaProjetos() {
        Vector listaProjetos = new Vector();
        
        String sql = "SELECT P.ID, P.Nome, P.Descricao, U.NomeUsuario AS UsuarioProprietario FROM Projetos P "
                + "LEFT JOIN Usuarios U ON (U.ID = P.UsuarioProprietario);";
        try {
            ConnectionFactory conexaoBD = new ConnectionFactory();
            Connection conn = conexaoBD.getConnection();
        
            Statement stm = conn.createStatement();
            
            ResultSet dados;
            dados = stm.executeQuery(sql);
            while(dados.next()) {
                int idResult = dados.getInt("ID");
                String nomeResult = dados.getString("Nome");
                String descricaoResult = dados.getString("Descricao");
                String usuarioProprietarioResult = dados.getString("UsuarioProprietario");
                
                Vector temp = new Vector();
                
                temp.add(idResult);
                temp.add(nomeResult);
                temp.add(descricaoResult);
                temp.add(usuarioProprietarioResult);
                
                listaProjetos.addElement(temp);
            }
            
            conexaoBD.closeConnection();
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível recuperar a lista de projetos!");
        }
        return listaProjetos;
    }
    
    public void getDataProjects(int id) {             
        String sql = "SELECT P.ID, P.Nome, P.Descricao, U.NomeUsuario AS UsuarioProprietario, U.ID FROM Projetos P "
                + "LEFT JOIN Usuarios U ON (U.ID = P.UsuarioProprietario) WHERE P.ID = " + id + "";
        
        try {
            ConnectionFactory conexaoBD = new ConnectionFactory();  
            Connection conn = conexaoBD.getConnection();
            
            Statement stm = conn.createStatement();
            
            ResultSet resultado; 
            resultado = stm.executeQuery(sql);
            
            while (resultado.next()) {
                this.id = resultado.getInt("P.ID");
                this.nome = resultado.getString("P.Nome");
                this.descricao = resultado.getString("P.Descricao");
                this.usuarioProprietario = resultado.getString("UsuarioProprietario");
                this.idUsuarioProprietario = resultado.getInt("U.ID");
            }
            
            conexaoBD.closeConnection();
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível resgatar os dados desse projeto!");
        }
    }
    
    public boolean verificarUsuarioProprietario() {
        int usuario = 0;
        String sql = "SELECT UsuarioProprietario FROM Projetos WHERE UsuarioProprietario = " + idUsuarioProprietario + " AND ID = " + id + "";
        
        try {
            ConnectionFactory conexaoBD = new ConnectionFactory();  
            Connection conn = conexaoBD.getConnection();
            
            Statement stm = conn.createStatement();
            
            ResultSet resultado; 
            resultado = stm.executeQuery(sql);
            
            while (resultado.next()) {
                usuario = resultado.getInt("UsuarioProprietario");
            }
            
            conexaoBD.closeConnection();
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível resgatar os dados do usuário proprietário do projeto!");
        }
        
        if(usuario == FormLogin.userLogin.getId()) {
            return true;
        } else {
            return false;
        }
    }
    
    public void alterarDadosDoProjeto(String nome, String Descricao) {
        String sql = "UPDATE Projetos SET Nome = \"" + nome + "\", Descricao = \"" + Descricao + "\" WHERE ID = " + id + "";
        
        try {
            ConnectionFactory conexaoBD = new ConnectionFactory();  
            Connection conn = conexaoBD.getConnection();
            
            Statement stm = conn.createStatement();
            stm.executeUpdate(sql);
            
            conexaoBD.closeConnection();
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível resgatar os dados desse usuário!");
        }
    }
    
    public void deletarProjeto() {
        String sql = "DELETE FROM Projetos WHERE ID = " + id;
        String sqlRequisito = "DELETE FROM Requisitos WHERE Projeto = " + id;
        
        try {
            ConnectionFactory conexaoBD = new ConnectionFactory();
            Connection conn = conexaoBD.getConnection();
        
            Statement stm = conn.createStatement();
            stm.executeUpdate(sqlRequisito);
            stm.executeUpdate(sql);
            
            conexaoBD.closeConnection();
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível deletar esse projeto!");
        }
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getUsuarioProprietario() {
        return usuarioProprietario;
    }

    public void setUsuarioProprietario(String usuarioProprietario) {
        this.usuarioProprietario = usuarioProprietario;
    }
}
