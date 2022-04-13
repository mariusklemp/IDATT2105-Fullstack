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
      console.log("I state")
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
      commit("ADD_USER", userInfo);
    },
  },
  getters: {
    getUserID: state => state.userInfo.userID,
  },
  modules: {},
});
