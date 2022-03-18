package mariuskp.fullstack.calculatorREST.controller;

import mariuskp.fullstack.calculatorREST.model.User;


import mariuskp.fullstack.calculatorREST.repository.UserRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/signup")
@EnableAutoConfiguration
@CrossOrigin
public class SignupController {
    @Autowired
    UserRepository userRepository;

    private static final Logger LOGGER = LogManager.getLogger(LoginController.class);

    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.CREATED)
    public ResponseEntity<String> createUser(@RequestBody User user) {
        LOGGER.info("Signing up..." + user.getUsername());
        try {
            LOGGER.info("Kom meg inn");
            userRepository.save(new User(user.getUserID(), user.getUsername(), user.getPassw()));
            LOGGER.info("kom meg videre");
            return new ResponseEntity<>("User was created successfully.", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
