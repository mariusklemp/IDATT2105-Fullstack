import axios from "axios";

export function doCalculation(calculationRequest) {
    return axios
        .post(`http://localhost:8085/demo/calculate`, calculationRequest, {
             headers: {
             'Content-Type': 'application/json',
         },
        }).then((resonse) => {
            return resonse.data;
        });
}


