import Vue from "vue";
import Vuex from "vuex";

import main from "./main";

Vue.use(Vuex);

const Store = new Vuex.Store({
  modules: {
    main
  },
  strict: process.env.DEV
});

export { Store };

export default (/* { ssrContext } */) => {
  return Store;
};
