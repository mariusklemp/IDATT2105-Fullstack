import { createRouter, createWebHashHistory } from "vue-router";
import Home from "../views/Home.vue";
import ComplaintList from "@/views/ComplaintList";
import Login from "@/views/Login";
import Signup from "@/components/Signup";

const routes = [
  {
    path: "/",
    name: "Calculator",
    component: Home,
  },
  {
    path: "/kontaktskjema",
    name: "Kontaktskjema",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/Contact.vue"),
  },
  {
    path: "/complaints",
    name: "Complaints",
    component: ComplaintList,
  },
  {
    path: "/login",
    name: "Loging",
    component: Login,
  },
  {
    path: "/signup",
    name: "Signup",
    component: Signup,
  },
];

const router = createRouter({
  history: createWebHashHistory(),
  routes,
});

export default router;
