package cbsd.service;

import cbsd.dao.AdminDAO;
import cbsd.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Dell on 28/2/2557.
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminDAO adminDAO;
    @Override
    @Transactional
    public void addAdmin(Admin admin) {
        adminDAO.addAdmin(admin);
    }

    @Override
    @Transactional
    public List<Admin> getAdmin() {
        return adminDAO.getAdmin();
    }

    @Override
    @Transactional
    public Admin findByID(Integer id) {
        return  adminDAO.findByID(id);
    }

}
