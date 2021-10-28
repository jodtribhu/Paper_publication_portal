import Api from '@/services/Api';
export default{
   async getEachStudentPublciation(){ 
    var x=await Api().get('geteachstudentpublication');
    return x
    },    
}