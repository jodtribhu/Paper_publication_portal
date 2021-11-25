import Api from '@/services/Api';
export default{
    addFaculty(data){
        return Api().post('addfaculty',data);
    },
    addStudent(data){
        return Api().post('addstudent',data);
    },
    getStudent(){
        return Api().get('getadminstudent');
    },
    getFaculty(){
        return Api().get('getadminfaculty');
    },
    deleteFaculty(data){
        return Api().post('deleteadminfaculty',data);
    },
    deleteStudent(data){
        return Api().post('deleteAdminStudent',data);
    },
    getTotalPublications(){
        return Api().get('gettotalpublications');
    },
    getForget_Requests(){
        console.log("Inside forget requests")
        return Api().get('getAdminForget');
    },
    login(data){
        return Api().post('login',data);
    },
    fpassword(data){
        return Api().post('fpassword',data);
    },
    changePassword(data){
        return Api().post('changePassword',data);
    }
    
}

