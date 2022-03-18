package mariuskp.fullstack.calculatorREST.repository;

import mariuskp.fullstack.calculatorREST.model.LoginRequest;
import mariuskp.fullstack.calculatorREST.model.LoginResponse;
import mariuskp.fullstack.calculatorREST.model.User;

import java.util.List;

public interface UserRepository {
    int save(User user);

    List<User> findAll();

    User findById(int id);

    LoginResponse findByLoginRequest(LoginRequest loginRequest);
}
