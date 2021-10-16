<template>
    <div>
        <student-header></student-header>
        <div class="faculty_display">
            <div class="side">
                <student-sidebar :tabbed_view="gotoComponent" @messageFromChild="childMessageRecieved" ></student-sidebar>  
            </div>
            <div class="main">
                 <!-- <faculty-publication v-if="gotoComponent=='Publication'" > </faculty-publication>  -->
                 <!-- <faculty-approved v-if="gotoComponent=='Approved'" > </faculty-approved> 
                <faculty-rejected v-if="gotoComponent=='Rejected'" > </faculty-rejected>  -->
                <student-dashboard v-if="gotoComponent=='Dashboard'" > </student-dashboard> 
            </div>
            
           
        </div>
    </div>
</template>
<script>
import StudentDashboard from './StudentDashboard.vue';

export default {
  components: { StudentDashboard},
  data(){
      return {
          gotoComponent:'Dashboard',
      };
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