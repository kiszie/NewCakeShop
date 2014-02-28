package cbsd.entity;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;


/**
 * Created by Dell on 27/2/2557.
 */
@Entity
@Table(name = "customer")
public class Customer {
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

    @Column(name = "CName")
    @NotEmpty(message = "Please enter name")
    @Size(min=3,max=12)
    String name;

    @Column(name = "surname")
    @NotEmpty(message = "Please enter surname")
    @Size(min=3,max=12)
    String surname;

    @Column(name = "username")
    @NotEmpty(message = "Please enter username")
    @Size(min=3,max=12,message = "Name must between 3 to 13 charecter")
    String username;

    @Column(name = "password")
    @NotEmpty(message = "Please enter password")
    @Size(min=3,max=12)
    String password;

    @Column(name = "password1")
    @NotEmpty(message = "Please enter password")
    @Size(min=3,max=12)
    String password1;


    @Column(name = "address")
    @NotEmpty(message = "Please enter address")
    @Size(min=3,max=12)
    String address;


     @Cascade({CascadeType.ALL})
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword1() {
        return password1;
    }

    public void setPassword1(String password1) {
        this.password1 = password1;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        if (address != null ? !address.equals(customer.address) : customer.address != null) return false;
        if (id != null ? !id.equals(customer.id) : customer.id != null) return false;
        if (image != null ? !image.equals(customer.image) : customer.image != null) return false;
        if (name != null ? !name.equals(customer.name) : customer.name != null) return false;
        if (password != null ? !password.equals(customer.password) : customer.password != null) return false;
        if (password1 != null ? !password1.equals(customer.password1) : customer.password1 != null) return false;
        if (surname != null ? !surname.equals(customer.surname) : customer.surname != null) return false;
        if (username != null ? !username.equals(customer.username) : customer.username != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (password1 != null ? password1.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (image != null ? image.hashCode() : 0);
        return result;
    }

    public Customer(String name, String surname,String username,String password,String password1,String address ) {

        this.name=name;
        this.surname=surname;
        this.username=username;
        this.password=password;
        this.password1=password1;
        this.address=address;
    }

    public Customer() {

    }


}

