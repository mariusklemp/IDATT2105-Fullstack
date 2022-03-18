package mariuskp.fullstack.calculatorREST.service;

import org.apache.commons.math3.util.Precision;
import org.springframework.stereotype.Service;


@Service
public class CalculatorService {
    public double calculate(String operand1, String operator, String operand2) {
        double answer = 0;
        if (operator.equals("+")) {
            answer = Double.parseDouble(operand1) + Double.parseDouble(operand2);
        } else if (operator.equals("-")) {
            answer = Double.parseDouble(operand1) - Double.parseDouble(operand2);
        } else if (operator.equals("*")) {
            answer = Double.parseDouble(operand1) * Double.parseDouble(operand2);
        } else if (operator.equals("/")) {
            answer = Double.parseDouble(operand1) / Double.parseDouble(operand2);
        }
        return Precision.round(answer,4);
    }
}
