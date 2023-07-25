package BussinesObject;

import DataAccesObject.CustomersDAO;
import TransferObject.CustomersDTO;
import java.util.List;
public class Customers {
    private CustomersDAO customersDAO;
    private CustomersDTO customersDTO;

    public Customers() {
        customersDAO = new CustomersDAO();
    }
    public String agregar(int customerId, String customerName, String customerLastName, String documentType, String documentNumber, String phone, String email, String customerAdress, String customerStatus) {
        String mensaje;
        customersDTO = new CustomersDTO(customerId, customerName, customerLastName, documentType, documentNumber, phone, email, customerAdress,customerStatus);
        if (customersDAO.agregar(customersDTO)) {
            mensaje = "Registro Insertado";
        } else {
            mensaje = "Registro no Insertado";
        }
        return mensaje;
    }
    
        public String actualizar(int customerId, String customerName, String customerLastName, String documentType, String documentNumber, String phone, String email, String customerAdress, String customerStatus) {
        String mensaje;
        customersDTO = new CustomersDTO(customerId, customerName, customerLastName, documentType, documentNumber, phone, email, customerAdress,customerStatus);
        if (customersDAO.actualizar(customersDTO)) {
            mensaje = " se actualizó exitosamente";
        } else {
            mensaje = "Error , no se pudo actualizar";
        }
        return mensaje;
    }
        
    public String eliminar(int customerId) {
        String mensaje;
        customersDTO = new CustomersDTO(customerId);
        if (customersDAO.eliminar(customersDTO)) {
            mensaje = "Registro Eliminado";
        } else {
            mensaje = "Registro no eliminado";
        }
        return mensaje;
    }
    
    public CustomersDTO buscar(int customerId) {
        customersDTO = customersDAO.buscar(new CustomersDTO(customerId));
        if (customersDTO != null) {
            return customersDTO;
        }
        return null;
    }
    
    public List<CustomersDTO> listar() {
        if (customersDAO.listar() != null) {
            List<CustomersDTO> lista = customersDAO.listar();
            return lista;
        }
        return null;
    }
}
