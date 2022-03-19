package mariuskp.fullstack.calculatorREST.controller;

import mariuskp.fullstack.calculatorREST.model.CalculatorRequest;
import mariuskp.fullstack.calculatorREST.model.CalculatorResponse;

import mariuskp.fullstack.calculatorREST.model.Equation;
import mariuskp.fullstack.calculatorREST.repository.EquationRepository;
import mariuskp.fullstack.calculatorREST.service.CalculatorService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@EnableAutoConfiguration
@CrossOrigin
public class CalculatorController {
    @Autowired
    EquationRepository equationRepository;

    private static final Logger LOGGER = LogManager.getLogger(CalculatorController.class);

    @Autowired
    private CalculatorService service;

    @PostMapping("/calculate")
    @ResponseStatus(value = HttpStatus.CREATED)
    public CalculatorResponse doCalculation(final @RequestBody CalculatorRequest calculatorRequest) {
        LOGGER.info("Calculating..." + calculatorRequest.getOperand1() + " " + calculatorRequest.getOperatorSign() + " " + calculatorRequest.getOperand2());

        double answer = service.calculate(calculatorRequest.getOperand1(), calculatorRequest.getOperatorSign(), calculatorRequest.getOperand2());

        equationRepository.save(new Equation(calculatorRequest.getUserID(),calculatorRequest.getOperand1() + calculatorRequest.getOperatorSign() + calculatorRequest.getOperand2() + "=" + answer));

        return new CalculatorResponse(Double.toString(answer));
    }

    @GetMapping("/equations/{id}")
    public List<Equation> getAllEquationsById(@PathVariable("id") int id) {

            List<Equation> equations = new ArrayList<>();

            equationRepository.findAllfromID(id).forEach(equations::add);

            return equations;
    }
}
