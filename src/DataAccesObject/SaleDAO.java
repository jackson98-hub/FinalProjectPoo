package DataAccesObject;

import DataSource.Conexion;
import TransferObject.SaleDTO;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class SaleDAO implements ICrud<SaleDTO>{
    PreparedStatement ps; //insert, update, delete
    ResultSet rs; // select
    Conexion conexion;

    public SaleDAO() {
        conexion= new Conexion();
    }

    @Override
    public boolean agregar(SaleDTO t) {
        int r = 0;
        try {
            ps = conexion.conectar().prepareStatement("insert into Sale(id_sale,type_of_payment,number_proof_payment,total,sale_status,id_user,id_customer)values(?,?,?,?,?,?,?)");
            ps.setInt(1, t.getId_sale());
            ps.setString(2, t.getType_of_payment());
            ps.setString(3, t.getNumber_proof_payment());
            ps.setFloat(4, t.getTotal());
            ps.setString(5, t.getSale_status());
            ps.setInt(6, t.getId_user());
            ps.setInt(7, t.getId_customer());
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
    public boolean actualizar(SaleDTO t) {
        int r = 0;
        try {
            ps = conexion.conectar().prepareStatement("update Sale set type_of_payment=?,number_proof_payment=?,total=?,sale_status=?,id_user=?,id_customer=? where id_sale=?");
            
            ps.setString(1, t.getType_of_payment());
            ps.setString(2, t.getNumber_proof_payment());
            ps.setFloat(3, t.getTotal());
            ps.setString(4, t.getSale_status());
            ps.setInt(5, t.getId_user());
            ps.setInt(6, t.getId_customer());
            ps.setInt(7, t.getId_sale());
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
    public boolean eliminar(SaleDTO t) {
        int r = 0;
        try {
            ps = conexion.conectar().prepareStatement("delete from Sale where id_sale=?");
            ps.setInt(1, t.getId_sale());
            r = ps.executeUpdate();
            return r == 1;
        } catch (SQLException ex) {
            return false;
        } finally {
            conexion.desconectar();
        }
    }

    @Override
    public SaleDTO buscar(SaleDTO t) {
        boolean encontrado = false;
        try {
            ps = conexion.conectar().prepareStatement("select * from Sale where id_sale=?");
            ps.setInt(1, t.getId_sale());
            rs = ps.executeQuery();
            while (rs.next()) {
                t.setId_sale(rs.getInt(1));
                t.setType_of_payment(rs.getString(2));
                t.setNumber_proof_payment(rs.getString(3));
                t.setTotal(rs.getFloat(4));
                t.setSale_status(rs.getString(5));
                t.setId_user(rs.getInt(6));
                t.setId_customer(rs.getInt(7));                
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
    public List<SaleDTO> listar() {
        List<SaleDTO> lista = new ArrayList<>();
        try {
            ps = conexion.conectar().prepareStatement("select * from Sale");
            rs=ps.executeQuery();
            while (rs.next()) {
                SaleDTO t = new SaleDTO();
                t.setId_sale(rs.getInt(1));
                t.setType_of_payment(rs.getString(2));
                t.setNumber_proof_payment(rs.getString(3));
                t.setTotal(rs.getFloat(4));
                t.setSale_status(rs.getString(5));
                t.setId_user(rs.getInt(6));
                t.setId_customer(rs.getInt(7));
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
