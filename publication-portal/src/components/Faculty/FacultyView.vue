<template>
    <div >
        <faculty-header></faculty-header>
        <div class="faculty_display">
            <div class="side">
                <side-bar ></side-bar>  
            </div>
            <div class="main">
                 <faculty-publication > </faculty-publication> 
            </div>
            
           
        </div>

    </div>
    
</template>
<script>
import FacultyPublication from './FacultyPublication.vue';
export default {
  components: { FacultyPublication},
  data(){
      return{
          
      }
  },
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