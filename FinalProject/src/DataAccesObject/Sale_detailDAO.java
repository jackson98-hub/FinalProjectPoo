package DataAccesObject;

import DataSource.Conexion;
import TransferObject.Sale_detailDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;

public class Sale_detailDAO implements ICrud<Sale_detailDTO>{
    PreparedStatement ps; //insert, update, delete
    ResultSet rs; // select
    Conexion conexion;

    public Sale_detailDAO() {
        conexion= new Conexion();
    }

    @Override
    public boolean agregar(Sale_detailDTO t) {
        int r = 0;
        try {
            ps = conexion.conectar().prepareStatement("insert into Sale_detail(id_detail, id_sale,id_product,quantity,price,discount)values(?,?,?,?,?,?)");
            ps.setInt(1, t.getIdDetail());
            ps.setInt(2, t.getIdSale());
            ps.setInt(3, t.getIdProduct());
            ps.setInt(4, t.getQuantity());
            ps.setByte(5, t.getPrice());
            ps.setByte(6, t.getDiscount());
            r = ps.executeUpdate();//ejecutar la sentencia sql
            return r == 1;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            // return false;
        } finally {
            conexion.desconectar();
        }
        
        return false;
    }

    @Override
    public boolean actualizar(Sale_detailDTO t) {
        int r = 0;
        try {
            ps = conexion.conectar().prepareStatement("update Sale_detail set id_sale=?,id_product=?,quantity=?,price=?,discount=? where id_detail=?");
            
            ps.setInt(1, t.getIdSale());
            ps.setInt(2, t.getIdProduct());
            ps.setInt(3, t.getQuantity());
            ps.setByte(4, t.getPrice());
            ps.setByte(5, t.getDiscount());
            ps.setInt(6, t.getIdDetail());
            r = ps.executeUpdate();
            return r == 1;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return false;
        } finally {
            conexion.desconectar();
        }
    }

    @Override
    public boolean eliminar(Sale_detailDTO t) {
        int r = 0;
        try {
            ps = conexion.conectar().prepareStatement("delete from Sale_detail where id_detail=?");
            ps.setInt(1, t.getIdDetail());
            r = ps.executeUpdate();
            return r == 1;
        } catch (SQLException ex) {
            return false;
        } finally {
            conexion.desconectar();
        }
    }

    @Override
    public Sale_detailDTO buscar(Sale_detailDTO t) {
        boolean encontrado = false;
        try {
            ps = conexion.conectar().prepareStatement("select * from Sale_detail where id_detail=?");
            ps.setInt(1, t.getIdDetail());
            rs = ps.executeQuery();
            while (rs.next()) {
                t.setIdDetail(rs.getInt(1));
                t.setIdSale(rs.getInt(2));
                t.setIdProduct(rs.getInt(3));
                t.setQuantity(rs.getInt(4));
                t.setPrice(rs.getByte(5));
                t.setDiscount(rs.getByte(6));
                
                encontrado=true;
            }
            if (encontrado) {
                return t;
            } else {
                return null;
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        } finally {
            conexion.desconectar();
        }
    }

    @Override
    public List<Sale_detailDTO> listar() {
        List<Sale_detailDTO> lista = new ArrayList<>();
        try {
            ps = conexion.conectar().prepareStatement("select * from Sale_detail");
            rs=ps.executeQuery();
            while (rs.next()) {
                Sale_detailDTO t = new Sale_detailDTO();
                t.setIdDetail(rs.getInt(1));
                t.setIdSale(rs.getInt(2));
                t.setIdProduct(rs.getInt(3));
                t.setQuantity(rs.getInt(4));
                t.setPrice(rs.getByte(5));
                t.setDiscount(rs.getByte(6));
                
                lista.add(t);
            }
          } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }finally{
            conexion.desconectar();
        }
        return lista;
    }
}
