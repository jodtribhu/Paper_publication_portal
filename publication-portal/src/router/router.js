import {createRouter,createWebHistory} from 'vue-router';
import StudentForm from '../components/Student/StudentForm.vue';
import FacultyView from '../components/Faculty/FacultyView.vue';
const router=createRouter({
    history:createWebHistory(),
    routes:[
        {path:'/',redirect:'/home'},
        {path:'/home',component:StudentForm},
        {path:'/faculty',component:FacultyView},
    ]
});
export default router;