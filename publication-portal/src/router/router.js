import {createRouter,createWebHistory} from 'vue-router';
import StudentForm from '../components/Student/StudentForm.vue';
import FacultyView from '../components/Faculty/FacultyView.vue';
import Login from '../components/Authentication/Login.vue';
import ForgotPassword from '../components/Authentication/ForgotPassword.vue';
const router=createRouter({
    history:createWebHistory(),
    routes:[
        {path:'/',redirect:'/home'},
        {path:'/home',component:StudentForm},
        {path:'/faculty',component:FacultyView},
        {path:'/login',component:Login},
        {path:'/ForgotPassword',component:ForgotPassword},
    ]
});
export default router;