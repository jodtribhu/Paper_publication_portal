import GetEach from '@/services/GetEach';
import EachFacultyPublication from '@/services/EachFacultyPublication';
export default{
    async loadfaculty(context){ 
        var userid= localStorage.getItem("userId");
        const response =await GetEach.getEachFaculty({'userid':userid});
         context.commit('setLoggedInFaculty',response.data)
     },
     async loadfacultypublication(context){ 
         console.log("inside actions");
         var userid= localStorage.getItem("userId");
        const response =await EachFacultyPublication.EachFacultyPublication({'userid':userid});
        context.commit('setLoggedInFaculty_Publications',response)
    },
    logout_the_faculty(context){ 
        
        context.commit('logout_faculty_mutation')
    },
    
}