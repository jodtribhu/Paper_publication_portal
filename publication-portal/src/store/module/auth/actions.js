export default{
    setUser(context,payload)
    {
        const newpayload={
            userId:payload.LID,
            isFaculty:payload.isFaculty,
            isAdmin:payload.isAdmin
        }
        localStorage.setItem("isFaculty", payload.isFaculty);
        localStorage.setItem("isAdmin", payload.isAdmin);
        localStorage.setItem("userId", payload.LID);
        localStorage.setItem("studentid", payload.s_id);
        localStorage.setItem("facultyid", payload.f_id);
        return context.commit('setUser_mutation',newpayload);
    },
    logout(context) {
        localStorage.setItem("isFaculty", '');
        localStorage.setItem("isAdmin", '');
        localStorage.setItem("userId", '');
        localStorage.setItem("studentid", '');
        localStorage.setItem("facultyid", '');
        console.log("inside the logout action")
        context.commit('logout_mutation');
 

        
    },
  


}