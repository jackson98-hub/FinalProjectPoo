package TransferObject;
public class SaleDTO {
    private int id_sale,id_user,id_customer;
    private String type_of_payment,number_proof_payment,sale_status;
    private float total;

    public SaleDTO() {
    }

    public SaleDTO(int id_sale) {
        this.id_sale = id_sale;
    }

    public SaleDTO(int id_sale, String type_of_payment, String number_proof_payment, float total, String sale_status, int id_user, int id_customer) {
        this.id_sale = id_sale;
        this.id_user = id_user;
        this.id_customer = id_customer;
        this.type_of_payment = type_of_payment;
        this.number_proof_payment = number_proof_payment;
        this.sale_status = sale_status;
        this.total = total;
    }

    public int getId_sale() {
        return id_sale;
    }

    public void setId_sale(int id_sale) {
        this.id_sale = id_sale;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getId_customer() {
        return id_customer;
    }

    public void setId_customer(int id_customer) {
        this.id_customer = id_customer;
    }

    public String getType_of_payment() {
        return type_of_payment;
    }

    public void setType_of_payment(String type_of_payment) {
        this.type_of_payment = type_of_payment;
    }

    public String getNumber_proof_payment() {
        return number_proof_payment;
    }

    public void setNumber_proof_payment(String number_proof_payment) {
        this.number_proof_payment = number_proof_payment;
    }

    public String getSale_status() {
        return sale_status;
    }

    public void setSale_status(String sale_status) {
        this.sale_status = sale_status;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }
    
}
