import { createRouter, createWebHistory } from 'vue-router';
import TopPage from "./TopPage.vue";

const routes = [
    { path: '/', name: 'TopPage', component: TopPage },
    { path: '/add_politician_orgnization', name: 'AddPoliticianOrgnization', component: () => import("./components/pages/add_politician_orgnization/AddPoliticianOrgnization.vue") },
    { path: '/start_manage_political_organization', name: 'StartManagePoliticalOrganization', component: () => import("./components/pages/start_manage_political_organization/StartManagePoliticalOrganization.vue") },
    { path: '/start_manage_political_organization/accept', name: 'AcceptPersonManager', component: () => import("./components/pages/start_manage_political_organization/AcceptPersonManager.vue") },
    { path: '/propose_not_regist_organization', name: 'ProposeNotRegistOrganization', component: () => import("./components/pages/propose_not_regist_organization/ProposeNotRegistOrganization.vue") },

    { path: '/edit-estate', name: 'EditEstate', component: () => import("./components/pages/edit_estate/EditEstate.vue") },

    { path: '/read_fin_institution_csv', name: 'ReadFinInstitutionCsv', component: () => import("./components/read_fin_institution_csv/ReadFinInstitutionCsv.vue") },
    { path: '/login_user', name: 'LoginUser', component: () => import("./components/pages/login_user/LoginUser.vue") },
    { path: '/publish_submisson', name: 'PublishSubmission', component: () => import("./components/pages/publish_submisson/PublishSubmission.vue") },

    { path: '/regist-continue-buissiness', name: 'RegistContinueBuissiness', component: () => import("./components/pages/regist_continue_buissiness/RegistContinueBuissiness.vue") },
    { path: '/inquire-nationarity', name: 'InquireNationarity', component: () => import("./components/pages/inquire_nationarity/InquireNationarity.vue") },

    //ユーザ登録
    { path: '/regist_account', name: 'RegistAccount', component: () => import("./components/pages/regist_user/RegistUserAccount.vue") },
    { path: '/accept_account', name: 'AcceptUserAccount', component: () => import("./components/pages/regist_user/AcceptUserAccount.vue") },
    { path: '/regist_user', name: 'RegistUser', component: () => import("./components/pages/regist_user/RegistUserInfo.vue") },

    { path: '/show_group_member', name: 'ShowGroupMember', component: () => import("./components/pages/show_group_member/ShowGroupMember.vue") },

    //仮想団体設定
    { path: '/regist_virtual_org', name: 'ProposeVirtualOrganization', component: () => import("./components/pages/virtual_organization/ProposeVirtualOrganization.vue") },
    { path: '/accept_virtual_org', name: 'AcceptVirtualOrganizationgMember', component: () => import("./components/pages/virtual_organization/AcceptVirtualOrganizationgMember.vue") },

    //パスワードリセット
    { path: '/reset_password/propose', name: 'PropseResetPassword', component: () => import("./components/pages/reset_password/PropseResetPassword.vue") },
    { path: '/reset_password/execute', name: 'ExecuteResetPassword', component: () => import("./components/pages/reset_password/ExecuteResetPassword.vue") },

    //コンポーネント台紙
    { path: '/components', name: 'BaseComponent', component: () => import("./components/BaseComponent.vue") },
]
const router = createRouter({
    history: createWebHistory(), // HTML5 History モード
    routes,
})

export default router;