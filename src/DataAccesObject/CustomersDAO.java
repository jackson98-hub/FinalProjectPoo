
package DataAccesObject;

import DataSource.Conexion;
import TransferObject.CustomersDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class CustomersDAO implements ICrud<CustomersDTO>{
    PreparedStatement ps; //insert, update, delete
    ResultSet rs; // select
    Conexion conexion;

    public CustomersDAO() {
        conexion= new Conexion();
    }

    @Override
    public boolean agregar(CustomersDTO t) {
        int r = 0;
        try {
            ps = conexion.conectar().prepareStatement("insert into Customers(id_customer,customer_name,customer_lastname,"
                    + "document_type,document_number,phone,email,customer_adress,customer_status)values(?,?,?,?,?,?,?,?,?)");
            ps.setInt(1, t.getCustomerId());
            ps.setString(2, t.getCustomerName());
            ps.setString(3, t.getCustomerLastName());
            ps.setString(4, t.getDocumentType());
            ps.setString(5, t.getDocumentNumber());
            ps.setString(6, t.getPhone());
            ps.setString(7, t.getEmail());
            ps.setString(8, t.getCustomerAdress()); 
            ps.setString(9, t.getCustomerStatus());
            r = ps.executeUpdate();//ejecutar la sentencia sql
            return r == 1;
        } catch (SQLException ex) {
            return false;
        } finally {
            conexion.desconectar();
        }
    }

    @Override
    public boolean actualizar(CustomersDTO t) {
        int r = 0;
        try {
            ps = conexion.conectar().prepareStatement("update Customers set customer_name=?,customer_lastname=?,"
                    + "document_type=?,document_number=?,phone=?,email=?,customer_adress=?,customer_status=? where id_customer=?");
            
            ps.setString(1, t.getCustomerName());
            ps.setString(2, t.getCustomerLastName());
            ps.setString(3, t.getDocumentType());
            ps.setString(4, t.getDocumentNumber());
            ps.setString(5, t.getPhone());
            ps.setString(6, t.getEmail());
            ps.setString(7, t.getCustomerAdress()); 
            ps.setString(8, t.getCustomerStatus());
            ps.setInt(9, t.getCustomerId());
            r = ps.executeUpdate();
            return r == 1;
        } catch (SQLException ex) {
            return false;
        } finally {
            conexion.desconectar();
        }
    }

    @Override
    public boolean eliminar(CustomersDTO t) {
        int r = 0;
        try {
            ps = conexion.conectar().prepareStatement("delete from Customers where id_customer=?");
            ps.setInt(1, t.getCustomerId());
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
    public CustomersDTO buscar(CustomersDTO t) {
                boolean encontrado = false;
        try {
            ps = conexion.conectar().prepareStatement("select * from Customers where id_customer=?");
            ps.setInt(1, t.getCustomerId());
            rs = ps.executeQuery();
            while (rs.next()) {
                t.setCustomerId(rs.getInt(1));
                t.setCustomerName(rs.getString(2));
                t.setCustomerLastName(rs.getString(3));
                t.setDocumentType(rs.getString(4));
                t.setDocumentNumber(rs.getString(5));
                t.setPhone(rs.getString(6));
                t.setEmail(rs.getString(7));
                t.setCustomerAdress(rs.getString(8));
                t.setCustomerStatus(rs.getString(9));          
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
    public List<CustomersDTO> listar() {
        List<CustomersDTO> lista = new ArrayList<>();
        try {
            ps = conexion.conectar().prepareStatement("select * from Customers");
            rs=ps.executeQuery();
            while (rs.next()) {
                CustomersDTO t = new CustomersDTO();
                t.setCustomerId(rs.getInt(1));
                t.setCustomerName(rs.getString(2));
                t.setCustomerLastName(rs.getString(3));
                t.setDocumentType(rs.getString(4));
                t.setDocumentNumber(rs.getString(5));
                t.setPhone(rs.getString(6));
                t.setEmail(rs.getString(7));
                t.setCustomerAdress(rs.getString(8));
                t.setCustomerStatus(rs.getString(9));
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
