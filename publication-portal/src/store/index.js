import { createStore } from 'vuex';
import facultyModule from './module/faculty/index.js';
import studentModule from './module/student/index.js';
import adminModule from './module/admin/index.js';

const store=createStore({
    modules:{
        faculty:facultyModule,
        student:studentModule,
        admin:adminModule
    },
  });
  
  export default store;