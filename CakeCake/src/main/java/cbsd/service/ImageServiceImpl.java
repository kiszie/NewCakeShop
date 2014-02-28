package cbsd.service;

import cbsd.dao.ImageDAO;
import cbsd.entity.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Dell on 27/2/2557.
 */
@Service
public class ImageServiceImpl implements ImageService {
    @Autowired
    ImageDAO imageDAO;
    @Override
    @Transactional
    public Image get(Integer id) {
        return imageDAO.get(id);
    }
}
