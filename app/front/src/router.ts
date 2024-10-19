import { createRouter, createWebHistory } from "vue-router";
import TopPage from "./TopPage.vue";

const routes = [
    { path: "/", name: "TopPage", component: TopPage },

    //ユーザ登録
    { path: '/regist_account', name: 'RegistAccount', component: () => import("./components/pages/regist_user/RegistUserAccount.vue") },
    { path: '/accept_account', name: 'AcceptUserAccount', component: () => import("./components/pages/regist_user/AcceptUserAccount.vue") },

    //パスワードリセット
    { path: '/reset_password/propose', name: 'PropseResetPassword', component: () => import("./components/pages/reset_password/PropseResetPassword.vue") },
    { path: '/reset_password/execute', name: 'ExecuteResetPassword', component: () => import("./components/pages/reset_password/ExecuteResetPassword.vue") },

    { path: "/component", name: "Component", component: () => import("./components/BaseComponent.vue") },
];
const router = createRouter({
    history: createWebHistory(), // HTML5 History モード
    routes,
});

export default router;