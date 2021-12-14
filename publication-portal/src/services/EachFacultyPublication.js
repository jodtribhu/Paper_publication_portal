import Api from '@/services/Api';
export default{
   async EachFacultyPublication(){ 
    var f_id=localStorage.getItem("facultyid")
    var l_id=localStorage.getItem("userId")
    var x=await Api().post('geteachfacultypublication',{"faculty_id":f_id,"login_id":l_id});
    return x
    }, 
    async acceptPublication(data){ 
        var x=await Api().post('acceptpublication',data);
        return x
    }, 
    async declinePublication(data){ 
        var x=await Api().post('declinepublication',data);
        return x
    }, 
    async undo(data){ 
        var x=await Api().post('undofacultypublication',data);
        return x
    }, 

}