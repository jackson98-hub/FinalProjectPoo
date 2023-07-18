package TransferObject;


public class Sale_detailDTO {
    private int idDetail, idSale, idProduct, quantity;
    private byte price, discount;

    public Sale_detailDTO(int idDetail, int idSale, int idProduct, int quantity, byte price, byte discount) {
        this.idDetail = idDetail;
        this.idSale = idSale;
        this.idProduct = idProduct;
        this.quantity = quantity;
        this.price = price;
        this.discount = discount;
    }
    
     public Sale_detailDTO(int idDetail) {
        this.idDetail = idDetail;
    }
    public Sale_detailDTO(){};

    public int getIdDetail() {
        return idDetail;
    }

    public void setIdDetail(int idDetail) {
        this.idDetail = idDetail;
    }

    public int getIdSale() {
        return idSale;
    }

    public void setIdSale(int idSale) {
        this.idSale = idSale;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public byte getPrice() {
        return price;
    }

    public void setPrice(byte price) {
        this.price = price;
    }

    public byte getDiscount() {
        return discount;
    }

    public void setDiscount(byte discount) {
        this.discount = discount;
    }
    
    
}
