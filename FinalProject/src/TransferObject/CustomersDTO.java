package TransferObject;

public class CustomersDTO {
    private int idCustomers;
    private String customerName, customerLastName, documentType, dcoumentNumber, phone, email, customerAdress, customerStatus;

    public CustomersDTO(int idCustomers, String customerName, String customerLastName, String documentType, String dcoumentNumber, String phone, String email, String customerAdress, String customerStatus) {
        this.idCustomers = idCustomers;
        this.customerName = customerName;
        this.customerLastName = customerLastName;
        this.documentType = documentType;
        this.dcoumentNumber = dcoumentNumber;
        this.phone = phone;
        this.email = email;
        this.customerAdress = customerAdress;
        this.customerStatus = customerStatus;
    }

    
    public CustomersDTO(int idCustomers) {
        this.idCustomers = idCustomers;
    }

    public CustomersDTO() {
    }

    public int getIdCustomers() {
        return idCustomers;
    }

    public void setIdCustomers(int idCustomers) {
        this.idCustomers = idCustomers;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerLastName() {
        return customerLastName;
    }

    public void setCustomerLastName(String customerLastName) {
        this.customerLastName = customerLastName;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getDcoumentNumber() {
        return dcoumentNumber;
    }

    public void setDcoumentNumber(String dcoumentNumber) {
        this.dcoumentNumber = dcoumentNumber;
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

    public String getCustomerAdress() {
        return customerAdress;
    }

    public void setCustomerAdress(String customerAdress) {
        this.customerAdress = customerAdress;
    }

    public String getCustomerStatus() {
        return customerStatus;
    }

    public void setCustomerStatus(String customerStatus) {
        this.customerStatus = customerStatus;
    }
    
    
}
