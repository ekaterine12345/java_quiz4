public class Product {
    private Long id;
    private String name;
    private String creator;
    private Integer price;
    private Integer year;
    private Integer quantity;

    public Product(Long id, String name, String creator, Integer price, Integer year, Integer quantity) {
        this.id = id;
        this.name = name;
        this.creator = creator;
        this.price = price;
        this.year = year;
        this.quantity = quantity;
    }

    public Product(String name, String creator, Integer price, Integer year, Integer quantity) {
        this.name = name;
        this.creator = creator;
        this.price = price;
        this.year = year;
        this.quantity = quantity;
    }

    public Product() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return id+" "+name+" "+creator+" "+price+" "+year+" "+quantity;
    }
}
