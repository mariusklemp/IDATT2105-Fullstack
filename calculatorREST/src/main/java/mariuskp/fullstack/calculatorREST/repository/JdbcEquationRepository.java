package mariuskp.fullstack.calculatorREST.repository;

import java.util.List;

import mariuskp.fullstack.calculatorREST.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import mariuskp.fullstack.calculatorREST.model.Equation;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcEquationRepository implements EquationRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int save(Equation equation) {
        return jdbcTemplate.update("INSERT INTO equations (userID, equation) VALUES(?,?)",
                new Object[]{equation.getUserID(), equation.getEquation()});
    }
    @Override
    public List<Equation> findAll() {
        return jdbcTemplate.query("SELECT * from equations", BeanPropertyRowMapper.newInstance(Equation.class));
    }
    @Override
    public List<Equation> findAllfromID(int id) {
        return jdbcTemplate.query("SELECT * from equations where userID=? ",
                BeanPropertyRowMapper.newInstance(Equation.class), id);

    }
}
