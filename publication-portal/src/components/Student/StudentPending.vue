<template>
    <base-card class="bg_color">
        <h2 >Pending Publication</h2>
        <p @click="check()" v-for="each_pending in pending" :key="each_pending.PID">
          <student-pending-card :pendingdetails="each_pending"></student-pending-card>
        </p>

    </base-card>
</template>

<script>
import BaseCard from '../layout/BaseCard.vue'
import StudentPendingCard from './StudentPendingCard.vue'
export default {
  props:['pending'],

  components: { BaseCard, StudentPendingCard },

  methods:{
    check(){
      console.log("Inside student pending"+ this.pending);
    }
  }
    
}
</script>
<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Montserrat:wght@500&display=swap');
h2{
  font-family: 'Montserrat', sans-serif;
  text-align: center;
  font-weight: bold;
}
.bg_color{
    border-radius:0 24px 24px 24px;
    background-color:rgb(188, 190, 196);
    width: 100%;
    margin-top:0;
    margin-left:3.5rem;
}
</style>