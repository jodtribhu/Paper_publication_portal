export default{
 
    setUser_mutation(state,payload)
    {
        state.user_id=payload.userId;
        state.isFacultyLoggedIn=payload.isFaculty;
        state.isAdminLoggedIn=payload.isAdmin;
        
    },
    logout_mutation(state){
        console.log("inside the logout_mutation")
        state.token=null;
        state.userId=null;
        state.expiresIn= null;
    }
}