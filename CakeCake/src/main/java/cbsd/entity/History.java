//package cbsd.entity;
//
//import org.hibernate.annotations.Cascade;
//import org.hibernate.validator.constraints.NotEmpty;
//import org.springframework.format.annotation.NumberFormat;
//
//import javax.persistence.*;
//import javax.validation.constraints.Size;
//import java.util.Date;
//
///**
//     * Created by Dell on 28/2/2557.
//     */
//    @Entity
//    @Table(name = "history")
//    public class History {
//        @Id
//        @Column(name = "ID")
//        @GeneratedValue
//        private Integer id;
//
//
//
//        @Column(name = "CustomerName")
//        @NotEmpty(message = "Please enter product name")
//        @OneToOne
//        @Size(min=3,max=12)
//        String name;
//
//        @Column(name = "product")
//        @NotEmpty(message = "Please enter description")
//        @OneToMany
//        @Size(min=3,max=12)
//        String product;
//
//        @Column(name = "price")
//        @NumberFormat(style = NumberFormat.Style.NUMBER)
//        double price;
//
//        @Column(name = "date")
//        @NotEmpty(message = "Please enter date")
//        Date date;
//
//
//
//        @Cascade({org.hibernate.annotations.CascadeType.ALL})
//        @OneToOne
//        Image image;
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getProduct() {
//        return product;
//    }
//
//    public void setProduct(String product) {
//        this.product = product;
//    }
//
//    public double getPrice() {
//        return price;
//    }
//
//    public void setPrice(double price) {
//        this.price = price;
//    }
//
//    public Date getDate() {
//        return date;
//    }
//
//    public void setDate(Date date) {
//        this.date = date;
//    }
//
//    public Image getImage() {
//        return image;
//    }
//
//    public void setImage(Image image) {
//        this.image = image;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        History history = (History) o;
//
//        if (Double.compare(history.price, price) != 0) return false;
//        if (date != null ? !date.equals(history.date) : history.date != null) return false;
//        if (id != null ? !id.equals(history.id) : history.id != null) return false;
//        if (image != null ? !image.equals(history.image) : history.image != null) return false;
//        if (name != null ? !name.equals(history.name) : history.name != null) return false;
//        if (product != null ? !product.equals(history.product) : history.product != null) return false;
//
//        return true;
//    }
//
//    @Override
//    public int hashCode() {
//        int result;
//        long temp;
//        result = id != null ? id.hashCode() : 0;
//        result = 31 * result + (name != null ? name.hashCode() : 0);
//        result = 31 * result + (product != null ? product.hashCode() : 0);
//        temp = Double.doubleToLongBits(price);
//        result = 31 * result + (int) (temp ^ (temp >>> 32));
//        result = 31 * result + (date != null ? date.hashCode() : 0);
//        result = 31 * result + (image != null ? image.hashCode() : 0);
//        return result;
//    }
//}
//
//
//
