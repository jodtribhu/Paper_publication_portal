export default {
    getLoggedInStudent(state){
        return state.logged_in_student;
       
    },
    checkStudent(state){
        return state.logged_in_student.name ===undefined;  
    },
    getPendingPublication(state)
    {
        return state.logged_in_student_publication_pending
    },
    getAcceptedPublication(state)
    {
        return state.logged_in_student_publication_accepted
    },
    getRejectedPublication(state)
    {
        return state.logged_in_student_publication_rejected
    },
    getClaimedPublication(state){
        return state.logged_in_student_publication_claimed
    },
    getTotal(state){
        return state.logged_in_student_publication_total
    }
};