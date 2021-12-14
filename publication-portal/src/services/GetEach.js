import Api from '@/services/Api';
export default{
   getEachFaculty(){
    console.log("inside geteachfaculty");
        var f_id=localStorage.getItem("facultyid")
        var l_id=localStorage.getItem("userId")
        return Api().post('geteachfaculty',{"faculty_id":f_id,"login_id":l_id});
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