package spring.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.models.dao.TypesDao;
import spring.models.pojo.Types;
import spring.services.interfaces.TypesService;

import java.util.List;

@Service
public class TypesServiceImpl implements TypesService {
    @Autowired
    private TypesDao typesDao;

    @Override
    public List<Types> getAllTypes() {
        return typesDao.selectAll();
    }
}
