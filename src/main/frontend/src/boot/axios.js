import Vue from "vue";
import axios from "axios";

Vue.prototype.$axios = axios;
Window.axios = axios; // for ga
