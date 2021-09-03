import { createApp } from 'vue'
import App from './App.vue'
import router from './router/router.js';
import Formcard from './components/layout/FormCard.vue';
import BaseDialog from './components/layout/BaseDialog.vue';
import BaseCard from './components/layout/BaseCard.vue';
import ForgetCard from './components/layout/ForgetCard.vue';
import TheHeader from './components/layout/TheHeader.vue';


const app=createApp(App);
app.component('form-card',Formcard);
app.component('base-dialog',BaseDialog);
app.component('base-card',BaseCard);
app.component('forget-card',ForgetCard);
app.component('the-header',TheHeader);
app.use(router);
app.mount('#app');
