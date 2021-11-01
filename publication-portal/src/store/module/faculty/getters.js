export default {
    getLoggedInFaculty(state){
        return state.logged_in_faculty;
       
    },
    checkFaculty(state){
        return state.logged_in_faculty.name ===undefined;
       
    },
    

  
};