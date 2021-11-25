export default {
    getAdminFaculty(state){
        return state.AdminFaculty_Publications;
    },
    getAdminStudent(state){
        return state.AdminStudent_Publications;
    },
    getAdminForgets(state){
        return state.Admin_Forget;
    },
    checkAdminFaculty(state){
        if( state.AdminFaculty_Publications.length==0){
            return false;
        }
        return true;
    },
    checkAdminForget(state){
        if( state.Admin_Forget.length==0){
            return false;
        }
        return true;
    },
    checkAdminStudent(state){
        if(state.AdminStudent_Publications.length==0 ){
            return false;
        }
        return true;
    },

    getAdminFacultyLength(state){
        return state.AdminFaculty_Publications.length;
    },
    getAdminStudentLength(state){
        return state.AdminStudent_Publications.length;
    },
    getAcceptedcount(state){
        return state.Accepted_Publications;
    },
    getRejectedcount(state){
        return state.Rejected_Publications;
    },

  
};