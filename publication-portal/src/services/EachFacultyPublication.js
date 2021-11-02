import Api from '@/services/Api';
export default{
   async EachFacultyPublication(){ 
    var x=await Api().get('geteachfacultypublication');
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