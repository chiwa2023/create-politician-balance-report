import { createRouter,createWebHistory } from "vue-router";
import TopPage from "./TopPage.vue";
 
const routes = [
    { path: "/", name: "TopPage", component: TopPage },
    { path: "/read_fin_institution_csv", name: "ReadFinInstitutionCsv", component: () => import("./components/read_fin_institution_csv/ReadFinInstitutionCsv.vue") },
    { path: "/meeting_adjust_income", name: "MeetingAdjustIncome", component: () => import("./components/meeting_adjust_income/MeetingAdjustIncome.vue") },
    { path: "/meeting_adjust_outcome", name: "MeetingAdjustOutcome", component: () => import("./components/meeting_adjust_outcome/MeetingAdjustOutcome.vue") },
    { path: "/publish_submisson", name: "PublishSubmission", component: () => import("./components/publish_submisson/PublishSubmission.vue") },
    { path: "/component", name: "Component", component: () => import("./components/BaseComponent.vue") },
];
const router = createRouter({
    history: createWebHistory(), // HTML5 History モード
    routes,
});
 
export default router;