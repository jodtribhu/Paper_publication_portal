<template>
    <div>
        <the-header></the-header>
        <!-- <base-card> -->
            <div class="tabbed_view">
                <div class="tabbed_view_flex">
                    <div :class="{ 'shadow1' : gotoComponentDashboard === 'Faculty'}" @click="executeFacultyTab" class="tabbed_view_flex_item tab1" >
                        <div>
                            <i class="fas fa-chalkboard-teacher"></i>
                            <p>Faculty</p>
                        </div>
                    </div>
                    
                     <hr>
                    <div :class="{ 'shadow2' : gotoComponentDashboard === 'Student'}" @click="executeStudentTab" class="tabbed_view_flex_item tab2"> 
                        <div>
                            <i class="fas fa-user-graduate"></i> 
                            <p>Student</p>
                        </div>
                       
                    </div>
                </div>
            </div>
            <admin-faculty v-if="gotoComponentDashboard=='Faculty'" ></admin-faculty>
            <admin-student v-if="gotoComponentDashboard=='Student'"></admin-student>


        <!-- </base-card> -->
    </div>

</template>
<script>
import AdminFaculty from './Admin_Faculty.vue';
import AdminStudent from './Admin_Student.vue';
export default {
  
    components: {AdminStudent,AdminFaculty},
          data(){
      return{
          gotoComponentDashboard:"Faculty"
            };
        },
    methods:{
          executeFacultyTab(){
            this.gotoComponentDashboard="Faculty"
          },
           executeStudentTab(){
            this.gotoComponentDashboard="Student"
          }
      }
    
}
</script>

<style scoped>
.fa-chalkboard-teacher{
    padding-top:1rem;
   font-size:1.5rem; 
   color:rgb(194, 183, 133);
   margin:0;
}
.fa-user-graduate{
     padding-top:1rem;
     color:rgb(194, 183, 133);
    font-size:1.5rem;
}
.tabbed_view{
    max-width:35%;
    margin-left:3.5rem;
     margin-top:2rem;
    padding-bottom:0;
}
p{
    margin:0;
    padding-bottom:1rem;
    color:rgb(194, 183, 133);
}
.tabbed_view_flex{
    background-color:#79263b;
    display: flex;
 
   border-radius:24px 24px 0 0;
}
.tabbed_view_flex_item{
    padding-left: 0.8rem;
    padding-right: 0.8rem;
    
    width:100%;
    text-align:center;
    font-family: 'Montserrat', sans-serif;
    font-weight:bold;
    font-size:1.2rem;
}
.tab1:hover{
    font-family: 'Montserrat', sans-serif;
    background-color:rgba(175, 171, 171, 0.514);
    border-radius: 24px 0 0 0;
}
.tab2:hover{
    font-family: 'Montserrat', sans-serif;
    background-color:rgba(175, 171, 171, 0.514);
    border-radius: 0 24px 0 0;
}
.shadow1{
    font-family: 'Montserrat', sans-serif;
    /* background-color:rgba(175, 171, 171, 0.514); */
    border-radius: 24px 0 0 0;
    border-style: hidden hidden solid hidden;
    border-width:0.4rem;
    border-color: rgb(141, 139, 135);
}
.shadow2{
    font-family: 'Montserrat', sans-serif;
    /* background-color:rgba(175, 171, 171, 0.514); */
    border-radius: 0 24px 0 0;
    border-style: hidden hidden solid hidden;
    border-width:0.4rem;
      border-color: rgb(141, 139, 135);
}
</style>