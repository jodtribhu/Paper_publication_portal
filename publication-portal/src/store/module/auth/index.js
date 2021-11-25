import mutations from './mutations.js';
import actions from './actions.js';
import getters from './getters.js'
export default{
    state(){
        return{
          user_id:'',
          isFacultyLoggedIn:"No",
          isAdminLoggedIn:"No",
        };
        
      },
      mutations,
      actions,
      getters,
}