import Api from '@/services/Api';
export default{
    addFaculty(data){
        return Api().post('addfaculty',data);
    },
    addStudent(data){
        return Api().post('addstudent',data);
    },
    getStudent(){
        return Api().get('addstudent');
    },
    getFaculty(){
        console.log("INTO IT "+ Api().get('addfaculty'));
        return Api().get('addfaculty');
    },
    
}

