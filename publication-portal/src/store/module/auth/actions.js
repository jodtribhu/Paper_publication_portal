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
        localStorage.setItem("userId", payload.userId);
        
        return context.commit('setUser_mutation',newpayload);
    },
    logout(context) {
        context.commit('setUser_mutation',{
            token: null,
            userId: null,
            expiresIn: null,
        })
        localStorage.setItem("isFaculty", '');
        localStorage.setItem("isAdmin", '');
        localStorage.setItem("userId", '');
    },
  


}