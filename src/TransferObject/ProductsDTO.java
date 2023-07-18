package TransferObject;

public class ProductsDTO {
    private int idProduct, stock;
    private String productName, productDescription, productStatus;
    private byte price, discount;

    public ProductsDTO(int idProduct, int stock, String productName, String productDescription, String productStatus, byte price, byte discount) {
        this.idProduct = idProduct;
        this.stock = stock;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productStatus = productStatus;
        this.price = price;
        this.discount = discount;
    }
    
    public ProductsDTO(int idProdut) {
        this.idProduct = idProdut;
    }
    public ProductsDTO(){};

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(String productStatus) {
        this.productStatus = productStatus;
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
