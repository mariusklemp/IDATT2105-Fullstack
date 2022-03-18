package mariuskp.fullstack.calculatorREST.service;

import mariuskp.fullstack.calculatorREST.model.LoginRequest;
import mariuskp.fullstack.calculatorREST.model.LoginResponse;
import mariuskp.fullstack.calculatorREST.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired UserRepository userRepository;

    public LoginResponse doLoginRequest(LoginRequest loginRequest){
        return userRepository.findByLoginRequest(loginRequest);
    }
}
