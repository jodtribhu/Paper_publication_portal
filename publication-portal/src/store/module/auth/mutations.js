export default{
 
    setUser_mutation(state,payload)
    {
        state.user_id=payload.userId;
        state.isFacultyLoggedIn=payload.isFaculty;
        state.isAdminLoggedIn=payload.isAdmin;
    },
}