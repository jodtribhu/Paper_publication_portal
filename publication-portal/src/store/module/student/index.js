import mutations from './mutations.js';
import actions from './actions.js';
import getters from './getters.js'
export default{
    state(){
        return{
            logged_in_student:{},
            logged_in_student_publication_pending:[],
            logged_in_student_publication_accepted:[],
            logged_in_student_publication_rejected:[],
            logged_in_student_publication_claimed:[],
            logged_in_student_publication_total:0
        };
        
      },
      mutations,
      actions,
      getters,
}