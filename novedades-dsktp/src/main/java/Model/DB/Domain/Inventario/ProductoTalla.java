package Model.DB.Domain.Inventario;

/**
 * Representa la entidad Prod_Talla de la base de datos como
 * objeto de Java
 *
 * @author jefe_mayoneso
 */
public class ProductoTalla {

    private Producto product;
    private Talla size;
    private double price;
    private double specialPrice;

    public ProductoTalla(Talla size, double price, double specialPrice) {
        this(null, size, price, specialPrice);
    }

    public ProductoTalla(Producto product, Talla size, double price, double specialPrice) {
        this.product = product;
        this.size = size;
        this.price = price;
        this.specialPrice = specialPrice;
    }

    public Producto getProduct() {
        return product;
    }

    public void setProduct(Producto product) {
        this.product = product;
    }

    public Talla getSize() {
        return size;
    }

    public void setSize(Talla size) {
        this.size = size;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getSpecialPrice() {
        return specialPrice;
    }

    public void setSpecialPrice(double specialPrice) {
        this.specialPrice = specialPrice;
    }

    @Override
    public String toString() {
        return "ProductoTalla{" +
                "product=" + product.toString() +
                ", size=" + size.getSize() +
                ", price=" + price +
                ", specialPrice=" + specialPrice +
                '}';
    }
}
