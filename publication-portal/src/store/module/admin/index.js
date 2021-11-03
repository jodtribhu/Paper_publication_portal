import mutations from './mutations.js';
import actions from './actions.js';
import getters from './getters.js'
export default{
    state(){
        return{
            AdminFaculty_Publications:[],
            AdminStudent_Publications:[],
            Accepted_Publications:-1,
            Rejected_Publications:-1,
        };
        
      },
      mutations,
      actions,
      getters,
}