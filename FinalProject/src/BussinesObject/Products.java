package BussinesObject;

import DataAccesObject.ProductsDAO;
import TransferObject.ProductsDTO;
import java.util.List;


public class Products {
    private ProductsDAO productsDAO;
    private ProductsDTO productsDTO;

    public Products() {
        productsDAO = new ProductsDAO();
    }
    public String agregar(int idProduct, int stock, String productName, String productDescription, String productStatus, byte price, byte discount) {
        String mensaje;
        productsDTO = new ProductsDTO(idProduct, stock, productName, productDescription, productStatus, price, discount);
        if (productsDAO.agregar(productsDTO)) {
            mensaje = "Registro Insertado";
        } else {
            mensaje = "Registro no Insertado";
        }
        return mensaje;
    }
    
    public String actualizar(int idProduct, int stock, String productName, String productDescription, String productStatus, byte price, byte discount) {
        String mensaje;
        productsDTO = new ProductsDTO(idProduct, stock, productName, productDescription, productStatus, price, discount);
        if (productsDAO.actualizar(productsDTO)) {
            mensaje = " se actualizó exitosamente";
        } else {
            mensaje = "Error , no se pudo actualizar";
        }
        return mensaje;
    }
    
    public String eliminar(int id_product) {
        String mensaje;
        productsDTO = new ProductsDTO(id_product);
        if (productsDAO.eliminar(productsDTO)) {
            mensaje = "Registro Eliminado";
        } else {
            mensaje = "Registro no eliminado";
        }
        return mensaje;
    }
    
    public ProductsDTO buscar(int id_product) {
        productsDTO = productsDAO.buscar(new ProductsDTO(id_product));
        if (productsDTO != null) {
            return productsDTO;
        }
        return null;
    }
    
    public List<ProductsDTO> listar() {
        if (productsDAO.listar() != null) {
            List<ProductsDTO> lista = productsDAO.listar();
            return lista;
        }
        return null;
    }
}
