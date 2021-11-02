<template>
    <base-card>
        <h2>Approved Publication </h2>
        <p v-for="ap_publication in approved_publication" :key="ap_publication.PF_ID">
                <faculty-approvedcard @refreshpublication="reload()"   :ap_publication="ap_publication"></faculty-approvedcard>
        </p>
              
    </base-card>    
</template>

<script>
import FacultyApprovedcard from './FacultyApprovedCard.vue';
export default {
     components: { FacultyApprovedcard},
     created(){
        if(this.$store.getters.checkFaculty)
         {
               this.loadtheApprovedFacultyPublications(); 
         }
         else{
              this.getEach= this.$store.getters.getLoggedInFaculty;
              this.approved_publication=this.$store.getters.getFacultyAcceptedPublication
         }
    },
    data(){
        return{
            approved_publication:[{}]
        };
    },
     methods:
     {
         async loadtheApprovedFacultyPublications(){
            await this.$store.dispatch("loadfacultypublication");
            this.approved_publication=this.$store.getters.getFacultyAcceptedPublication
       
        },
        reload(){
            this.loadtheApprovedFacultyPublications()
        },
     }
}
</script>

<style scoped>
h2{
    font-family: 'Montserrat', sans-serif;
    text-align: center;
}

</style>