package TransferObject;
public class EmployeesDTO {
    private int id_employee;
    private String employee_name;
    private String employee_lastname;
    private String gender;
    private String document_type;
    private String document_number;
    private String phone;
    private String email;
    private String employee_address;
    private String category;
    private String employee_status;

    public EmployeesDTO(int id_employee, String employee_name, String employee_lastname, String gender, String document_type, String document_number, String phone, String email, String employee_address, String category, String employee_status) {
        this.id_employee = id_employee;
        this.employee_name = employee_name;
        this.employee_lastname = employee_lastname;
        this.gender = gender;
        this.document_type = document_type;
        this.document_number = document_number;
        this.phone = phone;
        this.email = email;
        this.employee_address = employee_address;
        this.category = category;
        this.employee_status = employee_status;
    }

    public EmployeesDTO(int id_employee) {
        this.id_employee = id_employee;
    }

    public EmployeesDTO() {
    }

    public int getId_employee() {
        return id_employee;
    }

    public void setId_employee(int id_employee) {
        this.id_employee = id_employee;
    }

    public String getEmployee_name() {
        return employee_name;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }

    public String getEmployee_lastname() {
        return employee_lastname;
    }

    public void setEmployee_lastname(String employee_lastname) {
        this.employee_lastname = employee_lastname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmployee_address() {
        return employee_address;
    }

    public void setEmployee_address(String employee_address) {
        this.employee_address = employee_address;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDocument_type() {
        return document_type;
    }

    public void setDocument_type(String document_type) {
        this.document_type = document_type;
    }

    public String getDocument_number() {
        return document_number;
    }

    public void setDocument_number(String document_number) {
        this.document_number = document_number;
    }

    public String getEmployee_status() {
        return employee_status;
    }

    public void setEmployee_status(String employee_status) {
        this.employee_status = employee_status;
    }  
    
}
