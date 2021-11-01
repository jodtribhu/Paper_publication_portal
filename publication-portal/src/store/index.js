import { createStore } from 'vuex';
import facultyModule from './module/faculty/index.js';
import studentModule from './module/student/index.js';

const store=createStore({
    modules:{
        faculty:facultyModule,
        student:studentModule
    },
  });
  
  export default store;