import { createStore } from "vuex";

export default createStore({
  state: {
    info: []
  },
  mutations: {
    ADD_INFO(state, info) {
      state.info.push(info);
      console.log("hei");
    }
  },
  actions: {
    storeInfo({commit}, info) {
      commit("ADD_INFO", info).catch((error) => {
        throw error;
      });
    },
  },
  modules: {}
});
