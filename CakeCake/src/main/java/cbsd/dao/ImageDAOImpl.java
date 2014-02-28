package cbsd.dao;

import cbsd.entity.Image;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by Dell on 27/2/2557.
 */
@Repository
public class ImageDAOImpl implements ImageDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Image get(Integer id) {
        return (Image) sessionFactory.getCurrentSession().get(Image.class,id);
    }

}
