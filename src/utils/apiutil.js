import axios from "axios";

export function doLogin(loginRequest) {
  return axios
    .post(`http://localhost:8085/demo/login`, loginRequest)
    .then((resonse) => {
      return resonse.data;
    });
}
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
