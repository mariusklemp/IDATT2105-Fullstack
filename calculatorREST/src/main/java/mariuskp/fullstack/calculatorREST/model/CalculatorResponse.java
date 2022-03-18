package mariuskp.fullstack.calculatorREST.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CalculatorResponse {

    final private String screen;

    public CalculatorResponse(@JsonProperty("screen") String screen) {
        this.screen = screen;
    }

    @JsonProperty("screen")
    public String getResult() {
        return screen;
    }
}
