import { createStore } from "vuex";
import EventService from "@/services/EventService";

export default createStore({
  state: {
    complaints: [],
    userInfo: {},
  },
  mutations: {
    ADD_COMPLAINT(state, complaint) {
      state.complaints.push(complaint);
    },
    ADD_USER(state, userInfo) {
      state.userInfo = userInfo;
    },
  },
  actions: {
    createComplaint({ commit }, complaint) {
      EventService.postComplaint(complaint)
        .then(() => {
          commit("ADD_COMPLAINT", complaint);
        })
        .catch((error) => {
          console.log(error);
        });
    },
    storeUser({ commit }, userInfo) {
      EventService.login(userInfo)
        .then(() => {
          if (userInfo.loginStatus === "Success") {
            commit("ADD_USER", userInfo);
          }
        })
        .catch((error) => {
          console.log(error);
        });
    },
  },
  modules: {},
});
