package BussinesObject;

import DataAccesObject.UsersDAO;
import TransferObject.UsersDTO;
import java.util.List;

public class Users {
    private UsersDAO usersDAO;
    private UsersDTO usersDTO;

    public Users() {
        usersDAO = new UsersDAO();
    }    
    public String agregar(int id_user, String users_name, String users_lastname, String login_user, String login_password, String user_status, int id_rol, int id_employee) {
        String mensaje;
        usersDTO = new UsersDTO(id_user, users_name, users_lastname, login_user, login_password, user_status, id_rol, id_employee);
        if (usersDAO.agregar(usersDTO)) {
            mensaje = "Registro Insertado";
        } else {
            mensaje = "Registro no Insertado";
        }
        return mensaje;
    }
    public String actualizar(int id_user, String users_name, String users_lastname, String login_user, String login_password, String user_status, int id_rol, int id_employee) {
        String mensaje;
        usersDTO = new UsersDTO(id_user, users_name, users_lastname, login_user, login_password, user_status, id_rol, id_employee);
        if (usersDAO.actualizar(usersDTO)) {
            mensaje = " se actualizó exitosamente";
        } else {
            mensaje = "Error , no se pudo actualizar";
        }
        return mensaje;
    }
    public String eliminar(int id_user) {
        String mensaje;
        usersDTO = new UsersDTO(id_user);
        if (usersDAO.eliminar(usersDTO)) {
            mensaje = "Registro Eliminado";
        } else {
            mensaje = "Registro no eliminado";
        }
        return mensaje;
    }
    public UsersDTO buscar(int id_user) {
        usersDTO = usersDAO.buscar(new UsersDTO(id_user));
        if (usersDTO != null) {
            return usersDTO;
        }
        return null;
    }
    public List<UsersDTO> listar() {
        if (usersDAO.listar() != null) {
            List<UsersDTO> lista = usersDAO.listar();
            return lista;
        }
        return null;
    }
    
    public boolean login(String user, String pss){
        return usersDAO.login(user, pss);
    }
}
