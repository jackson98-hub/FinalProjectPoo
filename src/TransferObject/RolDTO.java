package TransferObject;
public class RolDTO {
    private int id_rol;
    private String rol_name;
    private String rol_description;
    private String rol_status;

    public RolDTO() {
    }

    public RolDTO(int id_rol) {
        this.id_rol = id_rol;
    }

    public RolDTO(int id_rol, String rol_name, String rol_description, String rol_status) {
        this.id_rol = id_rol;
        this.rol_name = rol_name;
        this.rol_description = rol_description;
        this.rol_status = rol_status;
    }

    public int getId_rol() {
        return id_rol;
    }

    public void setId_rol(int id_rol) {
        this.id_rol = id_rol;
    }

    public String getRol_name() {
        return rol_name;
    }

    public void setRol_name(String rol_name) {
        this.rol_name = rol_name;
    }

    public String getRol_description() {
        return rol_description;
    }

    public void setRol_description(String rol_description) {
        this.rol_description = rol_description;
    }

    public String getRol_status() {
        return rol_status;
    }

    public void setRol_status(String rol_status) {
        this.rol_status = rol_status;
    }
    
}
