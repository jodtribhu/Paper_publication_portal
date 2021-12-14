import Api from '@/services/Api';
export default{
   getEachFaculty(){
    console.log("inside geteachfaculty");
        return Api().get('geteachfaculty');
    },
    getEachStudent(){
        console.log("inside getEachStudent");
        var s_id=localStorage.getItem("studentid")
        var l_id=localStorage.getItem("userId")
        return Api().post('geteachstudent',{"student_id":s_id,"login_id":l_id});
    },
    editEachStudent(data){
 
        return Api().post('editstudent',data);
    },
    editEachFaculty(data){
        return Api().post('editfaculty',data);
    },


}