import Api from '@/services/Api';
export default{
    addForm(data){
        return Api().post('addform',data);
    },

    
}
