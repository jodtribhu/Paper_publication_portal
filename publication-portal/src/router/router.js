import {createRouter,createWebHistory} from 'vue-router';
import StudentForm from '../components/Student/StudentForm.vue';
const router=createRouter({
    history:createWebHistory(),
    routes:[
        {path:'/',redirect:'/home'},
        {path:'/home',component:StudentForm},
    ]
});
export default router;