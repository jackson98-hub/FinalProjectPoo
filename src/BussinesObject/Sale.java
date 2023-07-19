package BussinesObject;

import DataAccesObject.SaleDAO;
import TransferObject.SaleDTO;
import java.util.List;

public class Sale {
    private SaleDAO saleDAO;
    private SaleDTO saleDTO;

    public Sale() {
        saleDAO = new SaleDAO();
    }
    public String agregar(int id_sale, String type_of_payment, String number_proof_payment, float total, String sale_status, int id_user, int id_customer) {
        String mensaje;
        saleDTO = new SaleDTO(id_sale, type_of_payment, number_proof_payment, total, sale_status, id_user, id_customer);
        if (saleDAO.agregar(saleDTO)) {
            mensaje = "Registro Insertado";
        } else {
            mensaje = "Registro no Insertado";
        }
        return mensaje;
    }
    public String actualizar(int id_sale, String type_of_payment, String number_proof_payment, float total, String sale_status, int id_user, int id_customer) {
        String mensaje;
        saleDTO = new SaleDTO(id_sale, type_of_payment, number_proof_payment, total, sale_status, id_user, id_customer);
        if (saleDAO.actualizar(saleDTO)) {
            mensaje = " se actualizó exitosamente";
        } else {
            mensaje = "Error , no se pudo actualizar";
        }
        return mensaje;
    }
    public String eliminar(int id_sale) {
        String mensaje;
        saleDTO = new SaleDTO(id_sale);
        if (saleDAO.eliminar(saleDTO)) {
            mensaje = "Registro Eliminado";
        } else {
            mensaje = "Registro no eliminado";
        }
        return mensaje;
    }
    public SaleDTO buscar(int id_sale) {
        saleDTO = saleDAO.buscar(new SaleDTO(id_sale));
        if (saleDTO != null) {
            return saleDTO;
        }
        return null;
    }
    
    public List<SaleDTO> listar() {
        if (saleDAO.listar() != null) {
            List<SaleDTO> lista = saleDAO.listar();
            return lista;
        }
        return null;
    }
}
