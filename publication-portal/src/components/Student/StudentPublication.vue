<template>
    <div class="center">
            <div class="container_flex">
                <div class="tabbed_view">
                    <div class="tabbed_view_flex">
                        <div :class="{ 'shadow1' : gotoComponentDashboard === 'StudentPending'}" @click="executePending" class="tabbed_view_flex_item tab1" >
                            <p> Pending Publication</p>
                        </div>
                        
                        <hr>

                        <div :class="{ 'shadow2' : gotoComponentDashboard === 'StudentClaimed'}"  @click="executeClaimed" class="tabbed_view_flex_item tab2"> 
                            <p>Claimed Publication</p>
                        </div>

                        <hr>
                        <div :class="{ 'shadow2' : gotoComponentDashboard === 'StudentAccepted'}"  @click="executeAccepted" class="tabbed_view_flex_item tab2"> 
                            <p >Approved Publication</p>
                        </div>

                        <hr>
                         <div :class="{ 'shadow3' : gotoComponentDashboard === 'StudentRejected'}"  @click="executeRejected" class="tabbed_view_flex_item tab3"> 
                            <p  > Rejected Publication</p>
                        </div>
                    </div>
                </div>

                
                <student-pending @claimed_it_p="refresh()" :student="student" :pending="pending_publication"  v-if="gotoComponentDashboard=='StudentPending'"></student-pending >
                <student-claimed @unclaimedit_pending="refresh()" :student="student" :claimed="claimed_publication"  v-if="gotoComponentDashboard=='StudentClaimed'"></student-claimed >               
                <student-accepted :student="student" :accepted2="accepted_publication"   v-if="gotoComponentDashboard=='StudentAccepted'"></student-accepted >
                <student-rejected :student="student"  :rejected="rejected_publication"  v-if="gotoComponentDashboard=='StudentRejected'"></student-rejected >
            </div> 
    </div>
</template>
<script>
import StudentAccepted from './StudentAccepted.vue';
import StudentRejected from './StudentRejected.vue';
import StudentPending from './StudentPending.vue';
import StudentClaimed from './StudentClaimed.vue';

export default {
      components: { StudentAccepted,StudentRejected,StudentPending,StudentClaimed},
      created(){
         if(this.$store.getters.checkStudent)
         {
               this.loadeachstudent(); 
               this.loadthePublications();
         }
         else{
              this.student= this.$store.getters.getLoggedInStudent;
              this.pending_publication= this.$store.getters.getPendingPublication;
               this.claimed_publication= this.$store.getters.getClaimedPublication;
              this.accepted_publication= this.$store.getters.getAcceptedPublication;
              this.rejected_publication= this.$store.getters.getRejectedPublication;
         }
        
        },
      data(){
      return{
          gotoComponentDashboard:"StudentPending",
          pending_publication:[{}],
          accepted_publication:[{}],
          rejected_publication:[{}],
          claimed_publication:[{}]

            };
        },
    methods:{
          executeAccepted(){
            this.gotoComponentDashboard="StudentAccepted"
          },
           executePending(){
            this.gotoComponentDashboard="StudentPending"
          },
           executeRejected(){
            this.gotoComponentDashboard="StudentRejected"
          },
           executeClaimed(){
            this.gotoComponentDashboard="StudentClaimed"
          },

        async loadeachstudent(){
            console.log("inside the studentpublication.vue");
              await this.$store.dispatch("loadstudent");
              this.student= this.$store.getters.getLoggedInStudent;
          },
        async loadthePublications(){
            await this.$store.dispatch("loadpublication");
            this.student= this.$store.getters.getLoggedInStudent;
            this.pending_publication=this.$store.getters.getPendingPublication
            this.claimed_publication= this.$store.getters.getClaimedPublication;
            this.accepted_publication=this.$store.getters.getAcceptedPublication
            this.rejected_publication=this.$store.getters.getRejectedPublication
        },
        refresh(){
            console.log("inside refresh 2");
            this.loadthePublications();
        }
      }
}
</script>
<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Montserrat:wght@500&display=swap');
.width_Correct{
    width: 100%;
    margin-top:0;
    margin-left:3.5rem;
}
.center{
    margin:2rem auto;
}
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
    max-width:70%;
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
    border-radius: 0 0 0 0;
}
.tab3:hover{
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
    border-radius: 0 0 0 0;
    border-style: hidden hidden solid hidden;
    border-color: #6d1a2e;
}
.shadow3{
    font-family: 'Montserrat', sans-serif;
    /* background-color:rgba(175, 171, 171, 0.514); */
    border-radius: 0 24px 0 0;
    border-style: hidden hidden solid hidden;
    border-color: #6d1a2e;
}
</style>