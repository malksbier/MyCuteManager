import { createRouter, createWebHistory } from 'vue-router'

import Home from '@/views/HomeView.vue'
import Topics from '@/views/TopicsView.vue'
import Rules from '@/views/RulesView.vue'
import About from '@/views/AboutView.vue'
import NotFound from '@/views/NotFoundView.vue'

const routes = [
    {path:'/', name: 'Home', component: Home},
    {path:'/topics', name: 'Topics', component: Topics},
    {path:'/rules', name: 'Rules', component: Rules},
    {path:'/about', name: 'About', component: About},
    {path:'/:pathMatch(.*)*', name: 'NotFound', component: NotFound},
]

const router = createRouter({
    history:createWebHistory(),
    routes: routes,
})

export default router