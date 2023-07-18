package BussinesObject;

import DataAccesObject.RolDAO;
import TransferObject.RolDTO;
import java.util.List;

public class Rol {
    private RolDAO rolDAO;
    private RolDTO rolDTO;

    public Rol() {
        rolDAO = new RolDAO();
    }
    public String agregar(int id_rol, String rol_name, String rol_description, String rol_status) {
        String mensaje;
        rolDTO = new RolDTO(id_rol, rol_name, rol_description, rol_status);
        if (rolDAO.agregar(rolDTO)) {
            mensaje = "Registro Insertado";
        } else {
            mensaje = "Registro no Insertado";
        }
        return mensaje;
    }
    public String actualizar(int id_rol, String rol_name, String rol_description, String rol_status) {
        String mensaje;
        rolDTO = new RolDTO(id_rol, rol_name, rol_description, rol_status);
        if (rolDAO.actualizar(rolDTO)) {
            mensaje = " se actualizó exitosamente";
        } else {
            mensaje = "Error , no se pudo actualizar";
        }
        return mensaje;
    }
    public String eliminar(int id_rol) {
        String mensaje;
        rolDTO = new RolDTO(id_rol);
        if (rolDAO.eliminar(rolDTO)) {
            mensaje = "Registro Eliminado";
        } else {
            mensaje = "Registro no eliminado";
        }
        return mensaje;
    }
    public RolDTO buscar(int id_rol) {
        rolDTO = rolDAO.buscar(new RolDTO(id_rol));
        if (rolDTO != null) {
            return rolDTO;
        }
        return null;
    }
    public List<RolDTO> listar() {
        if (rolDAO.listar() != null) {
            List<RolDTO> lista = rolDAO.listar();
            return lista;
        }
        return null;
    }
}
