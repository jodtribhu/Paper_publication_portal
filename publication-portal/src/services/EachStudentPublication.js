import Api from '@/services/Api';
export default{
   async getEachStudentPublciation(){ 
       console.log("inside geteachstudentpublication");
       var s_id=localStorage.getItem("studentid")
       var l_id=localStorage.getItem("userId")
       return Api().post('geteachstudentpublication',{"student_id":s_id,"login_id":l_id});

    }, 
   async claimPublication(data){
    return Api().post('claimpublication',data);
   }   
}