import { createRouter,createWebHistory } from 'vue-router';
import TopPage from "./TopPage.vue";
 
const routes = [
    { path: '/', name: 'TopPage', component: TopPage },
]
const router = createRouter({
    history: createWebHistory(), // HTML5 History モード
    routes,
})
 
export default router;