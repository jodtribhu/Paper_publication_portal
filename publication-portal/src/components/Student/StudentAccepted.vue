<template >
    <base-card style="    border-radius:0 24px 24px 24px;background-color:rgb(188, 190, 196);width: 100%;margin-top:0;margin-left:3.5rem;">
            <h2>Approved Publication</h2>
            <student-approved-card></student-approved-card>
            <student-approved-card></student-approved-card>
    </base-card>
</template>
<script>

import StudentApprovedCard from './StudentApprovedCard.vue'

export default {
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