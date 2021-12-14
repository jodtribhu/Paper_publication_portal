
export default{
    setLoggedInFaculty(state,payload){
        state.logged_in_faculty=payload;

    },
    setLoggedInFaculty_Publications(state,payload){
       
        state.logged_in_faculty_publication_pending= payload.data.publications.filter(function (e) {
            return e.p_status =="Pending" && e.is_claimed=="Yes";
        });
        state.logged_in_faculty_publication_accepted = payload.data.publications.filter(function (e) {
                    return e.p_status=="Accepted" && e.is_claimed=="Yes";
        });
        state.logged_in_faculty_publication_rejected  = payload.data.publications.filter(function (e) {
                    return e.p_status=="Rejected" && e.is_claimed=="Yes";
        });
        state.logged_in_faculty_publication_total =state.logged_in_faculty_publication_pending.length+ state.logged_in_faculty_publication_accepted.length+state.logged_in_faculty_publication_rejected.length;
    },
    logout_faculty_mutation(state){
        console.log("Inside logout student mutations")
        state.logged_in_faculty={};
        state.logged_in_faculty_publication_pending=[];
        state.logged_in_faculty_publication_accepted=[];
        state.logged_in_faculty_publication_rejected=[];
        state.logged_in_faculty_publication_total=0;
    }
    
}