<template>
    <base-card>
        <h2>Rejected Publications</h2>
        <faculty-rejectedcard></faculty-rejectedcard>       
        <faculty-rejectedcard></faculty-rejectedcard>  
        <faculty-rejectedcard></faculty-rejectedcard> 
        <faculty-rejectedcard></faculty-rejectedcard> 
    </base-card>    
</template>

<script>
import FacultyRejectedcard from './FacultyRejectedcard.vue';
export default {
     components: { FacultyRejectedcard},
}
</script>

<style scoped>
h2{
    font-family: 'Montserrat', sans-serif;
    text-align: center;
}

</style>