package mariuskp.fullstack.calculatorREST.controller;

import mariuskp.fullstack.calculatorREST.model.LoginRequest;
import mariuskp.fullstack.calculatorREST.model.LoginResponse;
import mariuskp.fullstack.calculatorREST.model.User;
import mariuskp.fullstack.calculatorREST.repository.UserRepository;
import mariuskp.fullstack.calculatorREST.service.LoginService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/login")
@EnableAutoConfiguration
@CrossOrigin
public class LoginController {
    @Autowired
    private LoginService loginService;

    private static final Logger LOGGER = LogManager.getLogger(LoginController.class);

    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.CREATED)
    public LoginResponse doLogin(final @RequestBody LoginRequest loginRequest) {
        LOGGER.info("Logging in..." + loginRequest.getUsername());

        return loginService.doLoginRequest(loginRequest);
    }
}
