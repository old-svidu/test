package spring.models.dao;

import spring.models.pojo.Types;

import java.util.List;

public interface TypesDao {
    List<Types> selectAll();
}
