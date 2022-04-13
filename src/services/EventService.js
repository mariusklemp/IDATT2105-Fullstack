import axios from "axios";


const apiClient = axios.create({
  baseURL: "http://localhost:3000",
  withCredentials: false,
  headers: {
    Accept: "application/json",
    "Content-Type": "application/json",
  },
});

export async function doLoginWithToken(userInfo) {

  const loginRequest = {
    username: userInfo.username,
    passw: userInfo.password,
  };

  return axios.post(
      `http://localhost:8085/demo/token`,
      loginRequest,
  ).then(response => {
    return response.data;
  }).catch( err => {
    console.log(err);
  });
}
export default {
  getComplaints() {
    return apiClient.get("/complaints");
  },
  getComplaint(id) {
    return apiClient.get("/complaints/" + id);
  },
  postComplaint(complaint) {
    return apiClient.post("/complaints", complaint);
  },
  async doEquation(calculatorRequest, token){

    const calculatorResponse = axios.post(
      "http://localhost:8085/demo/calculate",
        calculatorRequest, {
          headers: {
            Authorization: "Bearer " + token,
          },
        });
    return calculatorResponse;
  },
  async findRecentLog(userID, token){

    const logResponse = axios.get(
        "http://localhost:8085/demo/equations/" + userID, {
          headers: {
            Authorization: "Bearer " + token,
          },
        });

    return logResponse;
  },

};
