<template>
    <base-card class="bg_color">
        <h2 >Claimed Publication</h2>
        <p @click="check()" v-for="each_claimed in claimed" :key="each_claimed.PID">
          <student-claimed-card :student="student" :claimeddetails="each_claimed"></student-claimed-card>
        </p>

    </base-card>
</template>

<script>
import BaseCard from '../layout/BaseCard.vue'
import StudentClaimedCard from './StudentClaimedCard.vue'
export default {
  props:['claimed','student'],

  components: { BaseCard, StudentClaimedCard },

  methods:{
    check(){
      console.log("Inside student claimed"+ this.claimed);
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