package cbsd.entity;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: Dto
 * Date: 2/3/13
 * Time: 1:38 AM
 * To change this template use File | Settings | File Templates.
 */
@Entity

public class User implements Serializable {

    @Id
    @GeneratedValue
    Long id;

    @NotEmpty(message = "Please insert name")
    @Size(min=4,max=16,message = "Name must between 4 to 16 charecter")
    String name;

    @NotEmpty(message = "Please insert password")
    String password;

    @NotEmpty(message = "Please insert password")
    String password1;

    int role=2;

    @Cascade({CascadeType.ALL})
    @OneToOne
    Image image;

    @NotEmpty(message = "Please insert surname")
    String surname;

    @NotEmpty(message = "Please insert username")
    String username;

    @NotEmpty(message = "Please insert address")
    String address;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (role != user.role) return false;
        if (address != null ? !address.equals(user.address) : user.address != null) return false;
        if (id != null ? !id.equals(user.id) : user.id != null) return false;
        if (image != null ? !image.equals(user.image) : user.image != null) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (password1 != null ? !password1.equals(user.password1) : user.password1 != null) return false;
        if (surname != null ? !surname.equals(user.surname) : user.surname != null) return false;
        if (username != null ? !username.equals(user.username) : user.username != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (password1 != null ? password1.hashCode() : 0);
        result = 31 * result + role;
        result = 31 * result + (image != null ? image.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        return result;
    }

    public String getPassword1() {
        return password1;
    }

    public void setPassword1(String password1) {
        this.password1 = password1;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Image getImage() {
        return image;
    }
    public void setImage(Image image) {
        this.image = image;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User(String name, String surname,String username,String password,String password1,String address,int role ) {

        this.name=name;
        this.surname=surname;
        this.username=username;
        this.password=password;
        this.password1=password1;
        this.address=address;
        this.role=role;
    }


    public User(){

    }
}
