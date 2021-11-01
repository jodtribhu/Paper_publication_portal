<template>
    <div>
        <student-header></student-header>
        <div class="faculty_display">
            <div class="side">
                <student-sidebar :tabbed_view="gotoComponent" @messageFromChild="childMessageRecieved" ></student-sidebar>  
            </div>
            
            <div class="main">
                <student-dashboard v-if="gotoComponent=='Dashboard'" > </student-dashboard> 
                <student-form v-if="gotoComponent=='Form'" > </student-form> 
                <student-publication v-if="gotoComponent=='Publication'" > </student-publication> 
            </div>
            
           
        </div>
    </div>
</template>
<script>
import StudentDashboard from './StudentDashboard.vue';
import StudentForm from './StudentForm.vue';
import StudentPublication from './StudentPublication.vue';
export default {
  components: { StudentDashboard,StudentForm,StudentPublication},
  data(){
      return {
          gotoComponent:'Dashboard',
      };
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