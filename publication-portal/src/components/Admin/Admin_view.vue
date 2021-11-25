<template>
    <div>
        <the-header></the-header>
        <h1 class="admin_title">Admin </h1>
        <div class="center">
            <div class="tabbed_view">
                <div class="tabbed_view_flex">
                    <div :class="{ 'shadow1' : gotoComponentDashboard === 'Dashboard'}" @click="executeDashboardTab" class="tabbed_view_flex_item tab1" >
                        <div>
                            <i class="fas fa-chart-area"></i>
                            <p>Dashboard</p>
                        </div>
                    </div>
                    
                     <hr>
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
                    <hr>
                    <div :class="{ 'shadow2' : gotoComponentDashboard === 'ForgetPassword'}" @click="executeForgetPasswordTab" class="tabbed_view_flex_item tab2"> 
                        <div>
                            <i class="far fa-comment"></i>
                            <p>Requests</p>
                        </div>
                       
                    </div>
                </div>
            </div>
            <admin-dashboard v-if="gotoComponentDashboard=='Dashboard'" ></admin-dashboard>
            <admin-faculty v-if="gotoComponentDashboard=='Faculty'" ></admin-faculty>
            <admin-student v-if="gotoComponentDashboard=='Student'"></admin-student>
            <admin-forget v-if="gotoComponentDashboard=='ForgetPassword'"></admin-forget>


        </div>
    </div>

</template>
<script>
import AdminFaculty from './Admin_Faculty.vue';
import AdminStudent from './Admin_Student.vue';
import AdminDashboard from './Admin_Dashboard.vue';
import AdminForget from './Admin_Forget.vue';
export default {
  
    components: {AdminStudent,AdminFaculty,AdminDashboard,AdminForget},
          data(){
            return{
                gotoComponentDashboard:"Dashboard"
            };
        },
    methods:{
          executeFacultyTab(){
            this.gotoComponentDashboard="Faculty"
          },
           executeStudentTab(){
            this.gotoComponentDashboard="Student"
          },
           executeDashboardTab(){
            this.gotoComponentDashboard="Dashboard"
          },        
           executeForgetPasswordTab(){
            this.gotoComponentDashboard="ForgetPassword"
          }
        
      },
      created(){
        var isAdmin= localStorage.getItem("isAdmin");
        var isFaculty=localStorage.getItem("isFaculty");
         if(isAdmin== "No" || isFaculty=="Yes"){
             
             this.$router.push({path: '/forbidden'});
         }
      }
    
}
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Bungee+Inline&family=Comfortaa:wght@700&family=Noto+Sans+Mono:wght@300;900&family=Oswald:wght@700&family=Roboto:wght@100;900&display=swap');
.title{
    color:#682132;
    padding:0;
    margin:0;
}

.letter{
    padding:0;
     color:#551524;
    
}
.admin_title{
     text-align:center;
    font-family: 'Montserrat', sans-serif;
    font-size: 3.5rem;
}
.style_font{
    width:20%;
    margin:1rem auto;
    font-family: 'Oswald', sans-serif;
    background-color:rgba(184, 174, 174, 0.781);
    /* padding:1rem; */
    border-radius:24px;
    font-size:3.5rem;
    letter-spacing: 0.4rem;
    font-weight: 700;
    border-width:0.5rem;
    border-style:hidden hidden solid hidden  ;
    text-align:center;
}
.center{
   
    width:70%;
    margin:2rem auto;
   
}
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
.far,.fa-comment{
    padding-top:1rem;
    color:rgb(194, 183, 133);
    font-size:1.5rem; 
}
.fas, .fa-chart-area{
    padding-top:1rem;
    color:rgb(194, 183, 133);
    font-size:1.5rem; 
}
.tabbed_view{
    max-width:70%;
    
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