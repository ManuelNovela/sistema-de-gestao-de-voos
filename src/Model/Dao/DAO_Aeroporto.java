package Model.Dao;

import Controler.Secure;
import Model.Value.Aeronaves;
import Model.Value.Reservas;
import Model.Value.Voo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 * Classe de acesso a dados
 *
 * @author Manuel
 */
public class DAO_Aeroporto {
    private Connection c;
    public static boolean sucesso;
    
    public DAO_Aeroporto(){
        try {
            sucesso = false;
            this.c = BDconexao.getConnection();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(DAO_Aeroporto.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
    public void gravarTrecho(Voo voo){
        try{
        String sql;
        PreparedStatement ps;

        sql = "INSERT INTO `treco`(`NrVoo`, `NrTreco`, `Data`, `NrAssentos`, `CodAeronave`, `CodAeroPartida`, `HorarioPartida`, `CodAeroChegada`, `HorarioChegada`) VALUES (?,?,?,?,?,?,?,?,?)";
        ps = c.prepareStatement(sql);
        ps.setString(1, voo.getNrVoo());
        ps.setString(2, voo.getNrTrecho());
        ps.setString(3, voo.getData());
        ps.setString(4, voo.getAssentosDis());
        ps.setString(5, voo.getCodAeronave());
        ps.setString(6, voo.getAeroPartida());
        ps.setString(7, voo.getPartida());
        ps.setString(8, voo.getAeroChegada());
        ps.setString(9, voo.getChegada());
        ps.execute();
        
        ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Aeroporto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
  
    
    public List<Voo> listarTodos(){
        try{
        String sql = "SELECT * FROM `treco` ORDER by `NrVoo` DESC";
        PreparedStatement ps = c.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        List<Voo> lista = new ArrayList<>();
        
        while (rs.next()) {
            boolean isActive = rs.getBoolean("Activo");
            if(isActive){
            Voo voo = new Voo();
              voo.setNrVoo(rs.getString("NrVoo"));
              voo.setNrTrecho(rs.getString("NrTreco"));
              voo.setData(rs.getString("Data"));
              voo.setAssentosDis(rs.getString("NrAssentos"));
              voo.setCodAeronave(rs.getString("CodAeronave"));
              voo.setPartida(rs.getString("HorarioPartida"));
              voo.setChegada(rs.getString("HorarioChegada"));
              voo.setAeroPartida(rs.getString("CodAeroPartida"));
              voo.setAeroChegada(rs.getString("CodAeroChegada"));
            lista.add(voo);
            }
        }
         ps.close();
        return lista;
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Aeroporto.class.getName()).log(Level.SEVERE, null, ex);
            return new ArrayList<>();
        }
    }

    public void actualizar(Voo voo) {
        try{
        String sql;
        PreparedStatement ps;

        sql = "UPDATE `treco` SET `NrVoo`=?,`NrTreco`=?,`Data`=?,`NrAssentos`=?,`CodAeronave`=?,`CodAeroPartida`=?,`HorarioPartida`=?,`CodAeroChegada`=?,`HorarioChegada`=?  WHERE `NrVoo` = ?";
        ps = c.prepareStatement(sql);
        ps.setString(1, voo.getNrVoo());
        ps.setString(2, voo.getNrTrecho());
        ps.setString(3, voo.getData());
        ps.setString(4, voo.getAssentosDis());
        ps.setString(5, voo.getCodAeronave());
        ps.setString(6, voo.getAeroPartida());
        ps.setString(7, voo.getChegada());
        ps.setString(8, voo.getAeroChegada());
        ps.setString(9, voo.getChegada());
        ps.setString(10, voo.getNrVoo());
        ps.execute();
        
        ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Aeroporto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean deletar(int i) {
       try{
            String sql = "UPDATE `treco` SET `Activo`=? WHERE `NrVoo` = ?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, 0);
            ps.setInt(2, (int) i);
            ps.execute();
            JOptionPane.showMessageDialog(null, "Anuncio Removido");
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Aeroporto.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public Voo recuperar(int x) {
       try{
        String sql = "SELECT * FROM `treco` WHERE `NrVoo` = ?";
        PreparedStatement ps = c.prepareStatement(sql);
        ps.setInt(1, x);
        ResultSet rs = ps.executeQuery();

        Voo voo = new Voo();
        while (rs.next()) {
            boolean isActive = rs.getBoolean("Activo");
            if(isActive){
              voo.setNrVoo(rs.getString("NrVoo"));
              voo.setNrTrecho(rs.getString("NrTreco"));
              voo.setData(rs.getString("Data"));
              voo.setAssentosDis(rs.getString("NrAssentos"));
              voo.setCodAeronave(rs.getString("CodAeronave"));
              voo.setPartida(rs.getString("HorarioPartida"));
              voo.setChegada(rs.getString("HorarioChegada"));
              voo.setAeroPartida(rs.getString("CodAeroPartida"));
              voo.setAeroChegada(rs.getString("CodAeroChegada"));
            }
        }
        ps.close();
        return voo;
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Aeroporto.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public void reservar(String[] info) {
        try{
        String sql;
        PreparedStatement ps;

        sql = "INSERT INTO `reservarassento`(`NrVoo`, `NrTreco`, `Data`, `NrdoAssento`, `NomeCliente`, `TelefoneCliente`) VALUES (?,?,?,?,?,?)";
        ps = c.prepareStatement(sql);
        ps.setString(1, info[0]);
        ps.setString(2, info[1]);
        ps.setString(3, info[2]);
        ps.setString(4, info[3]);
        ps.setString(5, info[4]);
        ps.setString(6, info[5]);
        ps.execute();
        
        JOptionPane.showMessageDialog(null, "Assento reservado");
        ps.close();
        } catch (SQLException ex) {
            
        JOptionPane.showMessageDialog(null, "Erro");
            Logger.getLogger(DAO_Aeroporto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void inserirTarifa(String text, String text0,String value, String text1) {
     try{
        String sql;
        PreparedStatement ps;
        sql = "INSERT INTO `tarifa`(`NrVoo`, `CodTarifa`, `Quantidade`, `Restricoes`) VALUES (?,?,?,?)";
        ps = c.prepareStatement(sql);
        ps.setString(1, text);
        ps.setString(2, text0);
        ps.setString(3, value);
        ps.setString(4, text1);
        ps.execute();
        
        ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Aeroporto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void inserirTipoAeronave(String text, String text0, String value) {
     try{
        String sql;
        PreparedStatement ps;
        sql = "INSERT INTO `tipoaeronave`(`NomeAeronave`, `QtdmaxAssetos`, `Companhia`, `CodAero`) VALUES (?,?,?,?)";
        ps = c.prepareStatement(sql);
        ps.setString(1, text);
        ps.setString(2, value);
        ps.setString(3, text0);
        ps.setString(4, Secure.CodAeronave);
        ps.execute();
        
        ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Aeroporto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void inserirAeronave(String text, String text0,  String value) {
     try{
        String sql;
        PreparedStatement ps;
        sql = "INSERT INTO `aeronave`(`CodAero`, `NrTotalAssentos`, `TipoAeronave`,`NrVoo`) VALUES (?,?,?,?)";
        ps = c.prepareStatement(sql);
        ps.setString(1, Secure.CodAeronave);
        ps.setString(2, value);
        ps.setString(3, text0);
        ps.setString(4, Secure.NrVoo);
        ps.execute();
        
        ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Aeroporto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateTarifa(String text, String text0, String string, String text1) {
        try{
        String sql;
        PreparedStatement ps;
        sql = "UPDATE `tarifa` SET `Quantidade`=?,`Restricoes`=? WHERE `CodTarifa`= ?";
        ps = c.prepareStatement(sql);
        ps.setString(1, string);
        ps.setString(2, text1);
        ps.setString(3, text0);
        ps.execute();
        
        ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Aeroporto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    public List<Reservas> listarReservas(int x) {
        try{
        String sql = "SELECT * FROM `reservarassento` WHERE `NrVoo` = ?";
        PreparedStatement ps = c.prepareStatement(sql);
        ps.setInt(1, x);
        ResultSet rs = ps.executeQuery();

        List<Reservas> lista = new ArrayList<>();
        
        while (rs.next()) {
            //boolean isActive = rs.getBoolean("Activo");
            //if(isActive){
            Reservas voo = new Reservas();
              voo.setNrVoo(rs.getString("NrVoo"));
              voo.setNrTreco(rs.getString("NrTreco"));
              voo.setData(rs.getString("Data"));
              voo.setNrdoAssento(rs.getString("NrdoAssento"));
              voo.setNomeCliente(rs.getString("NomeCliente"));
              voo.setTelefoneCliente(rs.getString("TelefoneCliente"));
            lista.add(voo);
            //}
        }
         ps.close();
        return lista;
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Aeroporto.class.getName()).log(Level.SEVERE, null, ex);
            return new ArrayList<>();
        }
    }

    public List<Aeronaves> listarAeronaves() {
        try{
        String sql = "SELECT * FROM `tipoaeronave` t, aeronave a WHERE t.`CodAero` = a.CodAero";
        PreparedStatement ps = c.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        List<Aeronaves> lista = new ArrayList<>();
        
        while (rs.next()) {
            //boolean isActive = rs.getBoolean("Activo");
            //if(isActive){
            Aeronaves voo = new Aeronaves();
              voo.setNrVoo(rs.getString("NrVoo"));
              voo.setCompanhia(rs.getString("Companhia"));
              voo.setCodAero(rs.getString("CodAero"));
              voo.setNrTotalAssentos(rs.getString("NrTotalAssentos"));
              voo.setQtdmaxAssetos(rs.getString("QtdmaxAssetos"));
              voo.setTipoAeronave(rs.getString("TipoAeronave"));
              voo.setNomeAeronave(rs.getString("NomeAeronave"));
            lista.add(voo);
            //}
        }
         ps.close();
        return lista;
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Aeroporto.class.getName()).log(Level.SEVERE, null, ex);
            return new ArrayList<>();
        }
    }
    public boolean estaReservado(String assento,String NrVoo) {
        boolean x=false;
        try {
            String sql = "SELECT * FROM `reservarassento` WHERE `NrdoAssento`= ? AND `NrVoo`= ?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, assento);
            ps.setString(2, NrVoo);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
              if(rs.getString("NrdoAssento").equalsIgnoreCase(assento)){
                   x= true;
              }
            }
              return  x;
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Aeroporto.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean existeNomeUsuario(String nomeUsuario) {
        boolean x=false;
        try {
            String sql = "SELECT `nomeUsuario` FROM `conta` WHERE `nomeUsuario` =?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, nomeUsuario);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
              if(rs.getString("nomeUsuario").equalsIgnoreCase(nomeUsuario)){
                   x= true;
              }
            }
              return  x;
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Aeroporto.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public String getSenha(String nomeUsuario) {
        String x="";
        try {
            String sql = "SELECT `senha` FROM `conta` WHERE `nomeUsuario` = ?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, nomeUsuario);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
              x = rs.getString("senha");
            }
            return  x;
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Aeroporto.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}