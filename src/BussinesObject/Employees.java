package BussinesObject;

import DataAccesObject.EmployeesDAO;
import TransferObject.EmployeesDTO;
import java.util.List;

public class Employees {
    private EmployeesDAO employeesDAO;
    private EmployeesDTO employeesDTO;

    public Employees() {
        employeesDAO = new EmployeesDAO();
    }
    public String agregar(int id_employee, String employee_name, String employee_lastname, String gender, String document_type, String document_number, String phone, String email, String employee_address, String category, String employee_status) {
        String mensaje;
        employeesDTO = new EmployeesDTO(id_employee, employee_name, employee_lastname, gender, document_type, document_number, phone, email, employee_address,
                                        category, employee_status);
        if (employeesDAO.agregar(employeesDTO)) {
            mensaje = "Registro Insertado";
        } else {
            mensaje = "Registro no Insertado";
        }
        return mensaje;
    }
    
    public String actualizar(int id_employee, String employee_name,  String employee_lastname, String gender, String document_type, String document_number,
                           String phone, String email, String employee_address, String category, String employee_status) {
        String mensaje;
        employeesDTO = new EmployeesDTO(id_employee, employee_name, employee_lastname, gender, document_type, document_number, phone, email, employee_address,
                                        category, employee_status);
        if (employeesDAO.actualizar(employeesDTO)) {
            mensaje = " se actualizó exitosamente";
        } else {
            mensaje = "Error , no se pudo actualizar";
        }
        return mensaje;
    }
    
    public String eliminar(int id_employee) {
        String mensaje;
        employeesDTO = new EmployeesDTO(id_employee);
        if (employeesDAO.eliminar(employeesDTO)) {
            mensaje = "Registro Eliminado";
        } else {
            mensaje = "Registro no eliminado";
        }
        return mensaje;
    }
    
    public EmployeesDTO buscar(int id_employee) {
        employeesDTO = employeesDAO.buscar(new EmployeesDTO(id_employee));
        if (employeesDTO != null) {
            return employeesDTO;
        }
        return null;
    }
    
    public List<EmployeesDTO> listar() {
        if (employeesDAO.listar() != null) {
            List<EmployeesDTO> lista = employeesDAO.listar();
            return lista;
        }
        return null;
    }
}
