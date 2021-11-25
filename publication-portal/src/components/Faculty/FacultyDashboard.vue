<template>
    <div>
        <base-card>
            <div>
                <h2>Dashboard</h2>
            </div>
            <div class="container_flex">
                <div class="tabbed_view">
                    <div class="tabbed_view_flex">
                        <div :class="{ 'shadow1' : gotoComponentDashboard === 'ProfileInfo'}" @click="executeProfileInfo" class="tabbed_view_flex_item tab1" >
                            <p >Profile Information</p>
                        </div>
                        
                        <hr>
                        <div :class="{ 'shadow2' : gotoComponentDashboard === 'PaperList'}"  @click="executePaperList" class="tabbed_view_flex_item tab2"> 
                            <p >My Paper List</p>
                        </div>
                    </div>
                </div>

                <faculty-profile @refresh="refreshthePage()" v-if="gotoComponentDashboard=='ProfileInfo'" :faculty="getEach" > </faculty-profile>
                <faculty-paper v-if="gotoComponentDashboard=='PaperList'" :faculty_publication_count="faculty_publication_count"> </faculty-paper>
            </div>

        </base-card>
    </div>
</template>

<script>
import FacultyProfile from './FacultyProfile.vue';
import FacultyPaper from './FacultyPaper.vue';
export default {
      components: { FacultyPaper,FacultyProfile},
      data(){
      return{
                gotoComponentDashboard:"ProfileInfo",
                getEach:{},
                faculty_publication_count:{},
                f_accepted:[{}],
                f_pending:[{}],
                f_rejected:[{}],


            };
        },
    created(){
         if(this.$store.getters.checkFaculty)
         {
               this.loadeachfaculty();
               this.loadtheFacultyPublications(); 
         }
         else{
              this.getEach= this.$store.getters.getLoggedInFaculty;
              this.f_accepted=this.$store.getters.getFacultyAcceptedPublication
              this.f_pending=this.$store.getters.getFacultyPendingPublication
              this.f_rejected=this.$store.getters.getFacultyRejectedPublication
         }
    },
    methods:{
          executeProfileInfo(){
            this.gotoComponentDashboard="ProfileInfo"
          },
           executePaperList(){
            this.gotoComponentDashboard="PaperList"
          },
          async loadeachfaculty(){
              await this.$store.dispatch("loadfaculty");
              this.getEach= this.$store.getters.getLoggedInFaculty;
              console.log(this.getEach.name);
          },
        async loadtheFacultyPublications(){
           console.log("inside loadtheFacultyPublications "+ this.$store.getters.getFacultyPendingPublication.length);
            await this.$store.dispatch("loadfacultypublication");
            console.log("inside loadtheFacultyPublications "+ this.$store.getters.getFacultyPendingPublication.length);
            this.faculty_publication_count={'pending':this.$store.getters.getFacultyPendingPublication.length,
            'accepted':this.$store.getters.getFacultyAcceptedPublication.length,
            'rejected':this.$store.getters.getFacultyRejectedPublication.length,
            'total':this.$store.getters.getFacultyTotalPublication}
            
            this.f_accepted=this.$store.getters.getFacultyAcceptedPublication
            this.f_pending=this.$store.getters.getFacultyPendingPublication
            this.f_rejected=this.$store.getters.getFacultyRejectedPublication
        },
          refreshthePage(){
              console.log("inside refresh the page");
              this.loadeachfaculty();
          }
      }
}
</script>

<style scoped>

@import url('https://fonts.googleapis.com/css2?family=Montserrat:wght@500&display=swap');
.container_flex{
    display: flex;
    flex-direction:column;

}
.card_details{
    margin:0;
    padding:0;
}
h2{
     font-family: 'Montserrat', sans-serif;
     text-align: center;
}
.tabbed_view{
    max-width:35%;
    margin-left:3.5rem;
    padding-bottom:0;
}

.tabbed_view_flex{

    display: flex;
   border-style: outset;
   border-radius:24px 24px 0 0;
}
.tabbed_view_flex_item{
    padding-left: 0.8rem;
    padding-right: 0.8rem;
    width:100%;
    text-align:center;
    font-family: 'Montserrat', sans-serif;
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
    border-color: #6d1a2e;
}
.shadow2{
    font-family: 'Montserrat', sans-serif;
    /* background-color:rgba(175, 171, 171, 0.514); */
    border-radius: 0 24px 0 0;
    border-style: hidden hidden solid hidden;
    border-color: #6d1a2e;
}
</style>