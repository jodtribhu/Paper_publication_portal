export default {
    getLoggedInFaculty(state){
        return state.logged_in_faculty;
       
    },
    checkFaculty(state){
        console.log("Inside checkFaculty"+state.logged_in_faculty.name );
        return state.logged_in_faculty.name ===undefined;
    },
    getFacultyPendingPublication(state)
    {
      
        return state.logged_in_faculty_publication_pending
    },
    getFacultyAcceptedPublication(state)
    {
        return state.logged_in_faculty_publication_accepted
    },
    getFacultyRejectedPublication(state)
    {
        return state.logged_in_faculty_publication_rejected
    },
    getFacultyTotalPublication(state){
        return state.logged_in_faculty_publication_total
    }

  
};