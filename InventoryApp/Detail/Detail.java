package Detail;


import com.example.InventoryApp.product.Product;

import javax.persistence.*;


@Entity

public class Detail {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "description")
    private String description;

    @OneToOne
    @JoinColumn(name = "product_id")
    private  Product product;

    public Detail(Integer id, String description) {
        this.id = id;
        this.description = description;
    }

    public Detail() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}