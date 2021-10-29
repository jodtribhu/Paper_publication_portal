import Api from '@/services/Api';
export default{
    addForm(data){
        return Api().post('addpublication',data);
    },

    
}
