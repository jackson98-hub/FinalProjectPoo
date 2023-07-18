package BussinesObject;

import DataAccesObject.CustomersDAO;
import TransferObject.CustomersDTO;
import java.util.List;

public class Customers {

    private CustomersDAO customersDAO;
    private CustomersDTO customersDTO;

    public Customers() {
        customersDTO = new CustomersDTO();
    }

    public String agregar(int idCustomers, String customerName, String customerLastName, String documentType, String dcoumentNumber, String phone, String email, String customerAdress, String customerStatus) {
        customersDTO = new CustomersDTO(idCustomers, customerName, customerLastName, documentType, dcoumentNumber, phone, email, customerAdress, customerStatus);
        String mensaje;
        if (customersDAO.agregar(customersDTO)) {
            mensaje = "Registro Insertado";
        } else {
            mensaje = "Registro no Insertado";
        }
        return mensaje;
    }
    
    public String actualizar(int idCustomers, String customerName, String customerLastName, String documentType, String dcoumentNumber, String phone, String email, String customerAdress, String customerStatus) {
        customersDTO = new CustomersDTO(idCustomers, customerName, customerLastName, documentType, dcoumentNumber, phone, email, customerAdress, customerStatus);
        if (customersDAO.actualizar(customersDTO)) {
            return "se actualizó exitosamente";
        }
        return null;
    }

    public String eliminar(int idCustomers) {
        customersDTO = new CustomersDTO(idCustomers);
        if (customersDAO.eliminar(customersDTO)) {
            return "Registro Eliminado";
        }
        return null;
    }

    public CustomersDTO buscar(int idCustomer) {
        customersDTO = customersDAO.buscar(new CustomersDTO(idCustomer));
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
