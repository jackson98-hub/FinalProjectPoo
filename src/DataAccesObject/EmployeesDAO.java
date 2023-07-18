package DataAccesObject;

import DataSource.Conexion;
import TransferObject.EmployeesDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeesDAO implements ICrud<EmployeesDTO>{
    PreparedStatement ps; //insert, update, delete
    ResultSet rs; // select
    Conexion conexion;

    public EmployeesDAO() {
        conexion= new Conexion();
    }

    @Override
    public boolean agregar(EmployeesDTO t) {
        int r = 0;
        try {
            ps = conexion.conectar().prepareStatement("insert into Employees(id_employee,employee_name,employee_lastname,gender,"
                    + "document_type,document_number,phone,email,employee_address,category,employee_status)values(?,?,?,?,?,?,?,?,?,?,?)");
            ps.setInt(1, t.getId_employee());
            ps.setString(2, t.getEmployee_name());
            ps.setString(3, t.getEmployee_lastname());
            ps.setString(4, t.getGender());
            ps.setString(5, t.getDocument_type());
            ps.setString(6, t.getDocument_number());
            ps.setString(7, t.getPhone());
            ps.setString(8, t.getEmail()); 
            ps.setString(9, t.getEmployee_address());
            ps.setString(10, t.getCategory());
            ps.setString(11, t.getEmployee_status());
            r = ps.executeUpdate();//ejecutar la sentencia sql
            return r == 1;
        } catch (SQLException ex) {
            return false;
        } finally {
            conexion.desconectar();
        }
    }

    @Override
    public boolean actualizar(EmployeesDTO t) {
        int r = 0;
        try {
            ps = conexion.conectar().prepareStatement("update Employees set employee_name=?,employee_lastname=?,gender=?,"
                    + "document_type=?,document_number=?,phone=?,email=?,employee_address=?,category=?,employee_status=? where id_employee=?");
            ps.setString(1, t.getEmployee_name());
            ps.setString(2, t.getEmployee_lastname());
            ps.setString(3, t.getGender());
            ps.setString(4, t.getDocument_type());
            ps.setString(5, t.getDocument_number());
            ps.setString(6, t.getPhone());
            ps.setString(7, t.getEmail()); 
            ps.setString(8, t.getEmployee_address());
            ps.setString(9, t.getCategory());
            ps.setString(10, t.getEmployee_status());
            ps.setInt(11, t.getId_employee());
            r = ps.executeUpdate();
            return r == 1;
        } catch (SQLException ex) {
            return false;
        } finally {
            conexion.desconectar();
        }
    }

    @Override
    public boolean eliminar(EmployeesDTO t) {
        int r = 0;
        try {
            ps = conexion.conectar().prepareStatement("delete from Employees where id_employee=?");
            ps.setInt(1, t.getId_employee());
            r = ps.executeUpdate();
            return r == 1;
        } catch (SQLException ex) {
            return false;
        } finally {
            conexion.desconectar();
        }
    }

    @Override
    public EmployeesDTO buscar(EmployeesDTO t) {
        boolean encontrado = false;
        try {
            ps = conexion.conectar().prepareStatement("select * from Employees where id_employee=?");
            ps.setInt(1, t.getId_employee());
            rs = ps.executeQuery();
            while (rs.next()) {
                t.setId_employee(rs.getInt(1));
                t.setEmployee_name(rs.getString(2));
                t.setEmployee_lastname(rs.getString(3));
                t.setGender(rs.getString(4));
                t.setDocument_type(rs.getString(5));
                t.setDocument_number(rs.getString(6));
                t.setPhone(rs.getString(7));
                t.setEmail(rs.getString(8));
                t.setEmployee_address(rs.getString(9));
                t.setCategory(rs.getString(10));
                t.setEmployee_status(rs.getString(11));           
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
    public List<EmployeesDTO> listar() {
        List<EmployeesDTO> lista = new ArrayList<>();
        try {
            ps = conexion.conectar().prepareStatement("select * from Employees");
            rs=ps.executeQuery();
            while (rs.next()) {
                EmployeesDTO t = new EmployeesDTO();
                t.setId_employee(rs.getInt(1));
                t.setEmployee_name(rs.getString(2));
                t.setEmployee_lastname(rs.getString(3));
                t.setGender(rs.getString(4));
                t.setDocument_type(rs.getString(5));
                t.setDocument_number(rs.getString(6));
                t.setPhone(rs.getString(7));
                t.setEmail(rs.getString(8));
                t.setEmployee_address(rs.getString(9));
                t.setCategory(rs.getString(10));
                t.setEmployee_status(rs.getString(11));
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
