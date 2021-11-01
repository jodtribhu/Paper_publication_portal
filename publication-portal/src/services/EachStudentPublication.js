import Api from '@/services/Api';
export default{
   async getEachStudentPublciation(){ 
       console.log("inside geteachstudentpublication");
    var x=await Api().get('geteachstudentpublication');
    return x
    }, 
   async claimPublication(data){
    return Api().post('claimpublication',data);
   }   
}