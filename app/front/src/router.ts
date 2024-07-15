import { createRouter,createWebHistory } from 'vue-router';
import TopPage from "./TopPage.vue";
 
const routes = [
    { path: '/', name: 'TopPage', component: TopPage },
    { path: '/add_politician_orgnization', name: 'AddPoliticianOrgnization', component: () => import("./components/pages/add_politician_orgnization/AddPoliticianOrgnization.vue") },
    { path: '/read_fin_institution_csv', name: 'ReadFinInstitutionCsv', component: () => import("./components/read_fin_institution_csv/ReadFinInstitutionCsv.vue") },
    { path: '/publish_submisson', name: 'PublishSubmission', component: () => import("./components/pages/publish_submisson/PublishSubmission.vue") },
    { path: '/component', name: 'BaseComponent', component: () => import("./components/BaseComponent.vue") },
]
const router = createRouter({
    history: createWebHistory(), // HTML5 History モード
    routes,
})
 
export default router;