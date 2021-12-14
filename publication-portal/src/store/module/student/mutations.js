
export default{
    setLoggedInStudent(state,payload){
        state.logged_in_student=payload;

    },
    setLoggedInStudent_Publications(state,payload){
       
        state.logged_in_student_publication_pending= payload.data.publications.filter(function (e) {
                    return e.p_status =="Pending" && e.is_claimed=="No";
        });
        state.logged_in_student_publication_claimed  = payload.data.publications.filter(function (e) {
                    return e.p_status =="Pending" && e.is_claimed=="Yes";
        });
        state.logged_in_student_publication_accepted = payload.data.publications.filter(function (e) {
                    return e.p_status=="Accepted" && e.is_claimed=="Yes";
        });
        state.logged_in_student_publication_rejected  = payload.data.publications.filter(function (e) {
                    return e.p_status=="Rejected" && e.is_claimed=="Yes";
        });
        
        

        state.logged_in_student_publication_total =state.logged_in_student_publication_pending.length+ state.logged_in_student_publication_accepted.length+state.logged_in_student_publication_rejected.length+state.logged_in_student_publication_claimed.length;
        
    },
    logout_student_mutation(state){
        console.log("Inside logout student mutations")
        state.logged_in_student={};
        state.logged_in_student_publication_pending=[];
        state.logged_in_student_publication_accepted=[];
        state.logged_in_student_publication_rejected=[];
        state.logged_in_student_publication_claimed=[];
        state.logged_in_student_publication_total=0;
    }
}