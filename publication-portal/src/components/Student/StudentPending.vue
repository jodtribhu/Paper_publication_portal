<template>
    <base-card class="bg_color">
        <h2>Pending Publication</h2>
        <student-pending-card></student-pending-card>
        <student-pending-card></student-pending-card>
        <student-pending-card></student-pending-card>
        <student-pending-card></student-pending-card>
    </base-card>
</template>

<script>
import BaseCard from '../layout/BaseCard.vue'
import StudentPendingCard from './StudentPendingCard.vue'
export default {
  components: { BaseCard, StudentPendingCard },
    
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