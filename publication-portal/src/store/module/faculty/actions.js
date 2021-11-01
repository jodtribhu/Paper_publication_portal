import GetEach from '@/services/GetEach';
export default{
    async loadfaculty(context){ 
        const response =await GetEach.getEachFaculty();
         context.commit('setLoggedInFaculty',response.data)
     },
}