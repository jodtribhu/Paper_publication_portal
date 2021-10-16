<template>
    <base-card class="bg_color">
        <h2>Rejected Publication</h2>
        <student-rejected-card></student-rejected-card>
        <student-rejected-card></student-rejected-card>
    </base-card>
</template>

<script>
import BaseCard from '../layout/BaseCard.vue'
import StudentRejectedCard from './StudentRejectedCard.vue'
export default {
  components: { BaseCard, StudentRejectedCard },
    
}
</script>
<style scoped>
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