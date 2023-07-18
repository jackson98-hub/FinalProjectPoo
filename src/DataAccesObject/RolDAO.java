package DataAccesObject;

import DataSource.Conexion;
import TransferObject.EmployeesDTO;
import TransferObject.RolDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RolDAO implements ICrud<RolDTO>{
    PreparedStatement ps; //insert, update, delete
    ResultSet rs; // select
    Conexion conexion;

    public RolDAO() {
        conexion= new Conexion();
    }

    @Override
    public boolean agregar(RolDTO t) {
        int r = 0;
        try {
            ps = conexion.conectar().prepareStatement("insert into Rol(id_rol,rol_name,rol_description,rol_status)values(?,?,?,?)");
            ps.setInt(1, t.getId_rol());
            ps.setString(2, t.getRol_name());
            ps.setString(3, t.getRol_description());
            ps.setString(4, t.getRol_status());            
            r = ps.executeUpdate();//ejecutar la sentencia sql
            return r == 1;
        } catch (SQLException ex) {
            return false;
        } finally {
            conexion.desconectar();
        }
    }

    @Override
    public boolean actualizar(RolDTO t) {
        int r = 0;
        try {
            ps = conexion.conectar().prepareStatement("update Rol set rol_name=?,rol_description=?,rol_status=? where id_rol=?");
            ps.setString(1, t.getRol_name());
            ps.setString(2, t.getRol_description());
            ps.setString(3, t.getRol_status());
            ps.setInt(4, t.getId_rol());            
            r = ps.executeUpdate();
            return r == 1;
        } catch (SQLException ex) {
            return false;
        } finally {
            conexion.desconectar();
        }
    }

    @Override
    public boolean eliminar(RolDTO t) {
        int r = 0;
        try {
            ps = conexion.conectar().prepareStatement("delete from Rol where id_rol=?");
            ps.setInt(1, t.getId_rol());
            r = ps.executeUpdate();
            return r == 1;
        } catch (SQLException ex) {
            return false;
        } finally {
            conexion.desconectar();
        }
    }

    @Override
    public RolDTO buscar(RolDTO t) {
        boolean encontrado = false;
        try {
            ps = conexion.conectar().prepareStatement("select * from Rol where id_rol=?");
            ps.setInt(1, t.getId_rol());
            rs = ps.executeQuery();
            while (rs.next()) {
                t.setId_rol(rs.getInt(1));
                t.setRol_name(rs.getString(2));
                t.setRol_description(rs.getString(3));
                t.setRol_status(rs.getString(4));
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
    public List<RolDTO> listar() {
        List<RolDTO> lista = new ArrayList<>();
        try {
            ps = conexion.conectar().prepareStatement("select * from Rol");
            rs=ps.executeQuery();
            while (rs.next()) {
                RolDTO t = new RolDTO();
                t.setId_rol(rs.getInt(1));
                t.setRol_name(rs.getString(2));
                t.setRol_description(rs.getString(3));
                t.setRol_status(rs.getString(4));                
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
