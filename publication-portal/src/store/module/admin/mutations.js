export default{
    setLoggedInFaculty(state,payload){
        state.logged_in_faculty=payload;
    },
    setAdminFaculty_Publications(state,payload){
        console.log("inside");
        state.AdminFaculty_Publications=payload.data.adminfaculty;
    },
    setAdminStudent_Publications(state,payload){
        state.AdminStudent_Publications=payload.data.adminstudent;
    },
    setTotalPublications(state,payload){
        state.Accepted_Publications=payload.data.accepted_count;
        state.Rejected_Publications=payload.data.rejected_count;
    }
}