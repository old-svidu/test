package spring.models.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import spring.models.dao.TypesDao;
import spring.models.pojo.Types;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class TypesDaoImpl implements TypesDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final String QUERY = "SELECT * FROM types";

    @Override
    public List<Types> selectAll() {
        List<Types> types = jdbcTemplate.query(QUERY, new TypesMapper());
        return types;
    }

    class TypesMapper implements RowMapper {
        @Override
        public Types mapRow(ResultSet resultSet, int i) throws SQLException {
            Types type = new Types();
            type.setId(resultSet.getInt("id"));
            type.setName(resultSet.getString("name"));
            return type;
        }
    }
}
