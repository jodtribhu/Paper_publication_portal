import {createRouter,createWebHistory} from 'vue-router';
import StudentForm from '../components/Student/StudentForm.vue';
import FacultyView from '../components/Faculty/FacultyView.vue';
import Login from '../components/Authentication/Login.vue';
import ForgotPassword from '../components/Authentication/ForgotPassword.vue';
import Forbidden from '../components/Authentication/Forbidden.vue';

import Sidebar from '../components/layout/Sidebar.vue';
import AdminView from '../components/Admin/Admin_view.vue';
import StudentView from '../components/Student/Student_view.vue';

const router=createRouter({
    history:createWebHistory(),
    routes:[
        {path:'/',redirect:'/login'},
        {path:'/studentform',component:StudentForm},
        {path:'/faculty',component:FacultyView},
        {path:'/login',component:Login},
        {path:'/ForgotPassword',component:ForgotPassword},
        {path:'/admin',component:AdminView},
        {path:'/student',component:StudentView},
        {path:'/fpassword',component:ForgotPassword},
        {path:'/forbidden',component:Forbidden},
        {path:'/trial',component:Sidebar},
    ]
});
export default router;