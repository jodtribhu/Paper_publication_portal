<template>
    <div >
        <faculty-header></faculty-header>
        <div class="faculty_display">
            <div class="side">
                <side-bar :tabbed_view="gotoComponent" @messageFromChild="childMessageRecieved" ></side-bar>  
            </div>
            <div class="main">
                 <faculty-publication v-if="gotoComponent=='Publication'" > </faculty-publication> 
                 <faculty-approved v-if="gotoComponent=='Accepted'" > </faculty-approved> 
                 <faculty-rejected v-if="gotoComponent=='Rejected'" > </faculty-rejected> 
                 <faculty-dashboard v-if="gotoComponent=='Dashboard'" > </faculty-dashboard> 
            </div>
            
        </div>

    </div>  
    
</template>
<script>
import FacultyDashboard from './FacultyDashboard.vue';
import FacultyPublication from './FacultyPublication.vue';
import FacultyApproved from './Faculty_Approved.vue';
import FacultyRejected from './Faculty_Rejected.vue';
export default {
    
  components: { FacultyPublication,FacultyApproved,FacultyRejected, FacultyDashboard},
  data(){
      return{
          gotoComponent:"Dashboard"
      }
  },
 created(){
       var isFaculty= localStorage.getItem("isFaculty");
       var isAdmin= localStorage.getItem("isAdmin");
         if(isFaculty == "No" ||isAdmin=="Yes" || isFaculty==''||isAdmin=='' ){
             this.$router.push({path: '/forbidden'});
         }
 },
  methods:{
        childMessageRecieved(message){
           this.gotoComponent=message
        },
  }
}
</script>
<style scoped>
.faculty_display{

    display:flex;
    justify-content:space-between;
    height:90vh;
}
.side{
    padding-top:2rem;
    height: 100%;
    width:10%; 
}
.main{
    height: 100%;
    width:100%;  
}
</style>