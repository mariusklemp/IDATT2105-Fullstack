package mariuskp.fullstack.calculatorREST.repository;

import mariuskp.fullstack.calculatorREST.model.Equation;

import java.util.List;

public interface EquationRepository {
    int save(Equation equation);

    List<Equation> findAll();

    /*
    int update(Tutorial book);

    Tutorial findById(Long id);

    int deleteById(Long id);

    List<Tutorial> findAll();

    List<Tutorial> findByPublished(boolean published);

    List<Tutorial> findByTitleContaining(String title);

    int deleteAll();
    */
}
