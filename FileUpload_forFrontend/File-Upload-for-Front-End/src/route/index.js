import {createRouter, createWebHistory} from 'vue-router';
import Home from '../views/Home.vue'
import Upload from '../views/Upload.vue'
import Detail from '../views/Detail.vue'

// history
const history = createWebHistory()

// routes
const routes = [
    {
        path: '/',
        name: 'Home',
        component: Home
    },
    {
        path: '/upload',
        name: 'Upload',
        component: Upload,
    },
    {
        path: '/user-detail/:id',
        name: 'Detail',
        component: Detail
    }
]

// router
const router = createRouter({history, routes})
// จำเป็นต้อง export default router ให้ view ไปทำงาน
export default router