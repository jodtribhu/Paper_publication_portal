import { createApp } from 'vue'
import App from './App.vue'
import router from './router/router.js';
import Formcard from './components/layout/FormCard.vue';
import BaseDialog from './components/layout/BaseDialog.vue';

const app=createApp(App);
app.component('form-card',Formcard);
app.component('base-dialog',BaseDialog);
app.use(router);
app.mount('#app');
