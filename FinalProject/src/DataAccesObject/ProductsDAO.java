package DataAccesObject;

import DataSource.Conexion;
import TransferObject.ProductsDTO;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ProductsDAO implements ICrud<ProductsDTO>{
    PreparedStatement ps; //insert, update, delete
    ResultSet rs; // select
    Conexion conexion;

    public ProductsDAO() {
        conexion= new Conexion();
    }

    @Override
    public boolean agregar(ProductsDTO t) {
        int r = 0;
        try {
            ps = conexion.conectar().prepareStatement("insert into Products(id_product,product_name,product_description,price,discount,stock,product_status)values(?,?,?,?,?,?,?)");
            ps.setInt(1, t.getIdProduct());
            ps.setString(2, t.getProductName());
            ps.setString(3, t.getProductDescription());
            ps.setByte(4, t.getPrice());
            ps.setByte(5, t.getDiscount());
            ps.setInt(6, t.getStock());
            ps.setString(7, t.getProductStatus());
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
    public boolean actualizar(ProductsDTO t) {
        int r = 0;
        try {
            ps = conexion.conectar().prepareStatement("update Products set product_name=?,product_description=?,price=?,discount=?,stock=?,product_status=? where id_product=?");
            
            ps.setString(1, t.getProductName());
            ps.setString(2, t.getProductDescription());
            ps.setByte(3, t.getPrice());
            ps.setByte(4, t.getDiscount());
            ps.setInt(5, t.getStock());
            ps.setString(6, t.getProductStatus());
            ps.setInt(7, t.getIdProduct());
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
    public boolean eliminar(ProductsDTO t) {
        int r = 0;
        try {
            ps = conexion.conectar().prepareStatement("delete from Products where id_product=?");
            ps.setInt(1, t.getIdProduct());
            r = ps.executeUpdate();
            return r == 1;
        } catch (SQLException ex) {
            return false;
        } finally {
            conexion.desconectar();
        }
    }

    @Override
    public ProductsDTO buscar(ProductsDTO t) {
        boolean encontrado = false;
        try {
            ps = conexion.conectar().prepareStatement("select * from Products where id_product=?");
            ps.setInt(1, t.getIdProduct());
            rs = ps.executeQuery();
            while (rs.next()) {
                t.setIdProduct(rs.getInt(1));
                t.setProductName(rs.getString(2));
                t.setProductDescription(rs.getString(3));
                t.setPrice(rs.getByte(4));
                t.setDiscount(rs.getByte(5));
                t.setStock(rs.getInt(6));
                t.setProductStatus(rs.getString(7));
                
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
    public List<ProductsDTO> listar() {
        List<ProductsDTO> lista = new ArrayList<>();
        try {
            ps = conexion.conectar().prepareStatement("select * from Products");
            rs=ps.executeQuery();
            while (rs.next()) {
                ProductsDTO t = new ProductsDTO();
                t.setIdProduct(rs.getInt(1));
                t.setProductName(rs.getString(2));
                t.setProductDescription(rs.getString(3));
                t.setPrice(rs.getByte(4));
                t.setDiscount(rs.getByte(5));
                t.setStock(rs.getInt(6));
                t.setProductStatus(rs.getString(7));
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
