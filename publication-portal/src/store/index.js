import { createStore } from 'vuex';
import facultyModule from './module/faculty/index.js';
import studentModule from './module/student/index.js';
import adminModule from './module/admin/index.js';
import authModule from './module/auth/index.js';

const store=createStore({
    modules:{
        faculty:facultyModule,
        student:studentModule,
        admin:adminModule,
        auth:authModule
    },
  });
  
  export default store;