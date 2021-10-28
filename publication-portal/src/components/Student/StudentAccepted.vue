<template >
    <base-card style="    border-radius:0 24px 24px 24px;background-color:rgb(188, 190, 196);width: 100%;margin-top:0;margin-left:3.5rem;">
            <h2>Approved Publication </h2>
            
             <p @click="check()" v-for="each_accepted in accepted2" :key="each_accepted.PID">
                <student-approved-card :accepteddetails2="each_accepted"></student-approved-card>
            </p>
       
    </base-card>
</template>
<script>

import StudentApprovedCard from './StudentApprovedCard.vue'

export default {
   props:['accepted2'],
  components: {  StudentApprovedCard },
    
}
</script>

<style scoped>
h2{
  font-family: 'Montserrat', sans-serif;
  text-align: center;
  font-weight: bold;
  
}
.bg{
    border-radius:0 24px 24px 24px;
    background-color:rgb(188, 190, 196);
    width: 100%;
    margin-top:0;
    margin-left:3.5rem;
}
</style>