import { createApp } from 'vue'
import App from './App.vue'
import router from './router/router.js';
import Formcard from './components/layout/FormCard.vue';
import BaseDialog from './components/layout/BaseDialog.vue';
import BaseCard from './components/layout/BaseCard.vue';
import ForgetCard from './components/layout/ForgetCard.vue';
import TheHeader from './components/layout/TheHeader.vue';
import FacultyHeader from './components/layout/FacultyHeader.vue';
import SideBar from './components/layout/Sidebar.vue';
import DashboardCard from './components/layout/DashboardCard.vue';
import AdminCard from './components/layout/AdminCard.vue';


const app=createApp(App);
app.component('form-card',Formcard);
app.component('base-dialog',BaseDialog);
app.component('base-card',BaseCard);
app.component('forget-card',ForgetCard);
app.component('the-header',TheHeader);
app.component('faculty-header',FacultyHeader);
app.component('side-bar',SideBar);
app.component('dashboard-card',DashboardCard);
app.component('admin-card',AdminCard);

app.use(router);
app.mount('#app');
