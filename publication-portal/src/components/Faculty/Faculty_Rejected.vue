<template>
    <base-card>
        <h2>Rejected Publication</h2>
        <p v-for="rj_publication in rejected_publication" :key="rj_publication.PF_ID">
                <faculty-rejectedcard @refreshpublication="reload()" :rj_publication="rj_publication"></faculty-rejectedcard>    
        </p>
           
    </base-card>    
</template>

<script>
import FacultyRejectedcard from './FacultyRejectedcard.vue';
export default {
     components: { FacultyRejectedcard},
    created(){
        if(this.$store.getters.checkFaculty)
         {
        
               this.loadtheRejectedFacultyPublications(); 
         }
         else{
              this.getEach= this.$store.getters.getLoggedInFaculty;
              this.rejected_publication=this.$store.getters.getFacultyRejectedPublication
         }
    },
    data(){
        return{
            rejected_publication:[{}]
        };
    },
     methods:
     {
         async loadtheRejectedFacultyPublications(){
            await this.$store.dispatch("loadfacultypublication");
            this.rejected_publication=this.$store.getters.getFacultyRejectedPublication
       
        },
         reload(){
            this.loadtheRejectedFacultyPublications()
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