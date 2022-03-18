package mariuskp.fullstack.calculatorREST.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CalculatorRequest {

    private final String operand1;
    private final String operatorSign;
    private final String operand2;

    @JsonCreator
    public CalculatorRequest(@JsonProperty("operand1") final String operand1, @JsonProperty("operand2") final String operand2, @JsonProperty("operatorSign") final String operatorSign, double answer) {
        this.operand1 = operand1;
        this.operatorSign = operatorSign;
        this.operand2 = operand2;
    }

    @JsonProperty("operand1")
    public String getOperand1() {
        return operand1;
    }

    @JsonProperty("operand2")
    public String getOperand2() {
        return operand2;
    }

    @JsonProperty("operator")
    public String getOperatorSign() {
        return operatorSign;
    }
}

