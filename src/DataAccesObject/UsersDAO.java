package DataAccesObject;
import DataSource.Conexion;
import TransferObject.UsersDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsersDAO implements ICrud<UsersDTO>{
    PreparedStatement ps; //insert, update, delete
    ResultSet rs; // select
    Conexion conexion;

    public UsersDAO() {
        conexion= new Conexion();
    }

    @Override
    public boolean agregar(UsersDTO t) {
        int r = 0;
        try {
            ps = conexion.conectar().prepareStatement("insert into Users(id_user,users_name,users_lastname,login_user,"
                    + "login_password,user_status,id_rol,id_employee)values(?,?,?,?,?,?,?,?)");
            ps.setInt(1, t.getId_user());
            ps.setString(2, t.getUsers_name());
            ps.setString(3, t.getUsers_lastname());
            ps.setString(4, t.getLogin_user());
            ps.setString(5, t.getLogin_password());
            ps.setString(6, t.getUser_status());
            ps.setInt(7, t.getId_rol());
            ps.setInt(8, t.getId_employee());
            r = ps.executeUpdate();//ejecutar la sentencia sql
            return r == 1;
        } catch (SQLException ex) {
            return false;
        } finally {
            conexion.desconectar();
        }
    }

    @Override
    public boolean actualizar(UsersDTO t) {
        int r = 0;
        try {
            ps = conexion.conectar().prepareStatement("update Users set users_name=?,users_lastname=?,login_user=?,"
                    + "login_password=?,user_status=?,id_rol=?,id_employee=? where id_user=?");
            ps.setString(1, t.getUsers_name());
            ps.setString(2, t.getUsers_lastname());
            ps.setString(3, t.getLogin_user());
            ps.setString(4, t.getLogin_password());
            ps.setString(5, t.getUser_status());
            ps.setInt(6, t.getId_rol());
            ps.setInt(7, t.getId_employee()); 
            ps.setInt(8, t.getId_user());
            r = ps.executeUpdate();
            return r == 1;
        } catch (SQLException ex) {
            System.out.print(ex.getMessage());
            return false;
        } finally {
            conexion.desconectar();
        }
    }

    @Override
    public boolean eliminar(UsersDTO t) {
        int r = 0;
        try {
            ps = conexion.conectar().prepareStatement("delete from Users where id_user=?");
            ps.setInt(1, t.getId_user());
            r = ps.executeUpdate();
            return r == 1;
        } catch (SQLException ex) {
            return false;
        } finally {
            conexion.desconectar();
        }
    }

    @Override
    public UsersDTO buscar(UsersDTO t) {
        boolean encontrado = false;
        try {
            ps = conexion.conectar().prepareStatement("select * from Users where id_user=?");
            ps.setInt(1, t.getId_user());
            rs = ps.executeQuery();
            while (rs.next()) {
                t.setId_user(rs.getInt(1));
                t.setUsers_name(rs.getString(2));
                t.setUsers_lastname(rs.getString(3));
                t.setLogin_user(rs.getString(4));
                t.setLogin_password(rs.getString(5));
                t.setUser_status(rs.getString(6));
                t.setId_rol(rs.getInt(7));
                t.setId_employee(rs.getInt(8));
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
    public List<UsersDTO> listar() {
        List<UsersDTO> lista = new ArrayList<>();
        try {
            ps = conexion.conectar().prepareStatement("select * from Users");
            rs=ps.executeQuery();
            while (rs.next()) {
                UsersDTO t = new UsersDTO();
                t.setId_user(rs.getInt(1));
                t.setUsers_name(rs.getString(2));
                t.setUsers_lastname(rs.getString(3));
                t.setLogin_user(rs.getString(4));
                t.setLogin_password(rs.getString(5));
                t.setUser_status(rs.getString(6));
                t.setId_rol(rs.getInt(7));
                t.setId_employee(rs.getInt(8));
                lista.add(t);
            }
          } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }finally{
            conexion.desconectar();
        }
        return lista;
    }
    
    public boolean login(String user, String pss) {
        try {
            System.out.println("select * from Users where login_user="+user+" and login_password="+pss+"");
            ps = conexion.conectar().prepareStatement("select * from Users where login_user='"+user+"' and login_password='"+pss+"'");
            rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            conexion.desconectar();
        }
        
        return false;
    }
}
