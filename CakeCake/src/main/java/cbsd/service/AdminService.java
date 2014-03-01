package cbsd.service;

import cbsd.entity.Admin;

import java.util.List;

/**
 * Created by Dell on 28/2/2557.
 */
public interface AdminService {
    public void addAdmin(Admin admin);
    public List<Admin> getAdmin();
    Admin findByID(Integer id);

}
