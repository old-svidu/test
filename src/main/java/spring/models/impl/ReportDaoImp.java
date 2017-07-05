package spring.models.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import spring.models.dao.ReportDao;
import spring.models.pojo.Report;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ReportDaoImp implements ReportDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final String SELECT_REPORTS = "SELECT" +
            "  CASE WHEN tmp.name IS NULL THEN tps.name ELSE tmp.name END  Article_name," +
            "  CASE WHEN offt IS NULL THEN 0 ELSE offt END  Count_Official_text," +
            "  CASE WHEN engt IS NULL THEN 0 ELSE engt END  Count_English_text " +
            "FROM types tps LEFT JOIN(" +
            "    SELECT" +
            "      name     name," +
            "      typeId   typeId," +
            "      sum(off) offt," +
            "      sum(eng) engt" +
            "    FROM (" +
            "           SELECT  name,CASE WHEN article2_id IS NULL THEN 0 ELSE 1 END AS off, 0 eng, typeId" +
            "           FROM articles art" +
            "             LEFT JOIN" +
            "             (SELECT * FROM article_link WHERE article2_id IN (SELECT id FROM articles" +
            "                  WHERE typeId IN (SELECT id FROM types WHERE name = 'Официальный текст'))) tmp" +
            "               ON art.id = tmp.article1_id" +
            "    UNION" +
            "           SELECT name,0 off,CASE WHEN article2_id IS NULL THEN 0 ELSE 1 END  eng," +
            "             typeId" +
            "           FROM articles art" +
            "             LEFT JOIN" +
            "             (SELECT * FROM article_link WHERE article2_id IN (SELECT id FROM articles" +
            "                    WHERE typeId IN (SELECT id FROM types WHERE name = 'Английский текст'))) tmp" +
            "               ON art.id = tmp.article1_id" +
            "         ) tmp" +
            "    GROUP BY name, typeId" +
            "  ) tmp ON tps.id = tmp.typeId " +
            "WHERE tps.name = (?) ";


    @Override
    public List<Report> selectByType(String type) {
        List<Report> reports = jdbcTemplate.query(SELECT_REPORTS, new Object[]{type},new ReportMapper());
        return reports;
    }

    class ReportMapper implements RowMapper {
        @Override
        public Report mapRow(ResultSet resultSet, int i) throws SQLException {
            Report report = new Report();
            report.setName(resultSet.getString("Article_name"));
            report.setCountOfficialText(resultSet.getInt("Count_Official_Text"));
            report.setCountEnglishText(resultSet.getInt("Count_English_Text"));
            return report;
        }
    }
}
