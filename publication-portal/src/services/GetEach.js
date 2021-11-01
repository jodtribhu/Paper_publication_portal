import Api from '@/services/Api';
export default{
   getEachFaculty(){
    console.log("inside geteachfaculty");
        return Api().get('geteachfaculty');
    },
    getEachStudent(){
        console.log("inside getEachStudent");
        return Api().get('geteachstudent');
    },
    editEachStudent(data){
        console.log("inside editstudent");
        return Api().post('editstudent',data);
    },

}