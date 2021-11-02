import GetEach from '@/services/GetEach';
import EachFacultyPublication from '@/services/EachFacultyPublication';
export default{
    async loadfaculty(context){ 
        const response =await GetEach.getEachFaculty();
         context.commit('setLoggedInFaculty',response.data)
     },
     async loadfacultypublication(context){ 
         console.log("inside actions");
        const response =await EachFacultyPublication.EachFacultyPublication();
        context.commit('setLoggedInFaculty_Publications',response)
    }
}