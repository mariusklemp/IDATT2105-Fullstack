import axios from "axios";

const apiClient = axios.create({
  baseURL: "http://localhost:3000",
  withCredentials: false,
  headers: {
    Accept: "application/json",
    "Content-Type": "application/json",
  },
});

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
  login(userInfo) {
    const loginRequest = {
      username: userInfo.username,
      passw: userInfo.password,
    };
    const loginResponse = axios.post(
      "http://localhost:8085/demo/login",
      loginRequest
    );
    loginResponse.then((resolvedResult) => {
      userInfo.loginStatus = resolvedResult.data.loginStatus;
      userInfo.userID = resolvedResult.data.userID;
    });
    return loginResponse;
  },
};
