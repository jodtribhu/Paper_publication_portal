import RegisterService from '@/services/RegistrationService.js';
export default{
    async loadadminfacultypublication(context){ 
        console.log("inside");
        const response =await RegisterService.getFaculty()
        context.commit('setAdminFaculty_Publications',response)
    },
    async loadadminstudentpublication(context){ 
        const response =await RegisterService.getStudent()
        context.commit('setAdminStudent_Publications',response)
    },
    async loadTotalPublications(context){ 
        const response =await RegisterService.getTotalPublications()
        context.commit('setTotalPublications',response)
    }
}

