import GetEach from '@/services/GetEach';
import EachStudentPublication from '@/services/EachStudentPublication';
export default{
    async loadstudent(context){ 
        const response =await GetEach.getEachStudent();
         context.commit('setLoggedInStudent',response.data)
     },
    async loadpublication(context){ 
        const response =await EachStudentPublication.getEachStudentPublciation();
        context.commit('setLoggedInStudent_Publications',response)

    
    }
}