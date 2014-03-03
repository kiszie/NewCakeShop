package cbsd.entity;

import org.hibernate.annotations.Cascade;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;

/**
 * Created by Dell on 28/2/2557.
 */
@Entity
@Table(name = "product")
public class Product {
    @Id
    @Column(name = "ID")
    @GeneratedValue
    private Integer id;

    public Image getImage() {
        return image;
    }
    public void setImage(Image image) {
        this.image = image;
    }

    @Column(name = "PName")
    @NotEmpty(message = "Please enter product name")
    @Size(min=3,max=12)
    String name;

    @Column(name = "description")
    @NotEmpty(message = "Please enter description")
    @Size(min=3,max=12)
    String des;

    @Column(name = "price")

    double price;



    @Cascade({org.hibernate.annotations.CascadeType.ALL})
    @OneToOne
    Image image;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (Double.compare(product.price, price) != 0) return false;
        if (id != null ? !id.equals(product.id) : product.id != null) return false;
        if (image != null ? !image.equals(product.image) : product.image != null) return false;
        if (name != null ? !name.equals(product.name) : product.name != null) return false;
        if (des != null ? !des.equals(product.des) : product.des != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (des != null ? des.hashCode() : 0);
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (image != null ? image.hashCode() : 0);
        return result;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
