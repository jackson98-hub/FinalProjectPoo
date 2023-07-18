package BussinesObject;

import DataAccesObject.Sale_detailDAO;
import TransferObject.Sale_detailDTO;
import java.util.List;

public class Sale_detail {
    private Sale_detailDAO sale_detailDAO;
    private Sale_detailDTO sale_detailDTO;

    public Sale_detail() {
        sale_detailDAO = new Sale_detailDAO();
    }
    public String agregar(int idDetail, int idSale, int idProduct, int quantity, byte price, byte discount) {
        String mensaje;
        sale_detailDTO = new Sale_detailDTO(idDetail, idSale, idProduct, quantity, price, discount);
        if (sale_detailDAO.agregar(sale_detailDTO)) {
            mensaje = "Registro Insertado";
        } else {
            mensaje = "Registro no Insertado";
        }
        return mensaje;
    }
    
    public String actualizar(int idDetail, int idSale, int idProduct, int quantity, byte price, byte discount) {
        String mensaje;
        sale_detailDTO = new Sale_detailDTO(idDetail, idSale, idProduct, quantity, price, discount);
        if (sale_detailDAO.actualizar(sale_detailDTO)) {
            mensaje = " se actualizó exitosamente";
        } else {
            mensaje = "Error , no se pudo actualizar";
        }
        return mensaje;
    }
    
    public String eliminar(int idDetail) {
        String mensaje;
        sale_detailDTO = new Sale_detailDTO(idDetail);
        if (sale_detailDAO.eliminar(sale_detailDTO)) {
            mensaje = "Registro Eliminado";
        } else {
            mensaje = "Registro no eliminado";
        }
        return mensaje;
    }
    
    public Sale_detailDTO buscar(int id_product) {
        sale_detailDTO = sale_detailDAO.buscar(new Sale_detailDTO(id_product));
        if (sale_detailDTO != null) {
            return sale_detailDTO;
        }
        return null;
    }
    
    public List<Sale_detailDTO> listar() {
        if (sale_detailDAO.listar() != null) {
            List<Sale_detailDTO> lista = sale_detailDAO.listar();
            return lista;
        }
        return null;
    }
}
