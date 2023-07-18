package TransferObject;

public class UsersDTO {

    private int id_user;
    private String users_name;
    private String users_lastname;
    private String login_user;
    private String login_password;
    private String user_status;
    private int id_rol;
    private int id_employee;

    public UsersDTO() {
    }

    public UsersDTO(int id_user) {
        this.id_user = id_user;
    }

    public UsersDTO(int id_user, String users_name, String users_lastname, String login_user, String login_password, String user_status, int id_rol, int id_employee) {
        this.id_user = id_user;
        this.users_name = users_name;
        this.users_lastname = users_lastname;
        this.login_user = login_user;
        this.login_password = login_password;
        this.user_status = user_status;
        this.id_rol = id_rol;
        this.id_employee = id_employee;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getUsers_name() {
        return users_name;
    }

    public void setUsers_name(String users_name) {
        this.users_name = users_name;
    }

    public String getUsers_lastname() {
        return users_lastname;
    }

    public void setUsers_lastname(String users_lastname) {
        this.users_lastname = users_lastname;
    }

    public String getLogin_user() {
        return login_user;
    }

    public void setLogin_user(String login_user) {
        this.login_user = login_user;
    }

    public String getLogin_password() {
        return login_password;
    }

    public void setLogin_password(String login_password) {
        this.login_password = login_password;
    }

    public String getUser_status() {
        return user_status;
    }

    public void setUser_status(String user_status) {
        this.user_status = user_status;
    }

    public int getId_rol() {
        return id_rol;
    }

    public void setId_rol(int id_rol) {
        this.id_rol = id_rol;
    }

    public int getId_employee() {
        return id_employee;
    }

    public void setId_employee(int id_employee) {
        this.id_employee = id_employee;
    }
    
}
