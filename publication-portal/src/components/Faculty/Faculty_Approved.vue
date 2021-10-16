<template>
    <base-card>
        <h2>Approved Publications</h2>
        <faculty-approvedcard></faculty-approvedcard>       
        <faculty-approvedcard></faculty-approvedcard>  
        <faculty-approvedcard></faculty-approvedcard> 
        <faculty-approvedcard></faculty-approvedcard> 
    </base-card>    
</template>

<script>
import FacultyApprovedcard from './FacultyApprovedCard.vue';
export default {
     components: { FacultyApprovedcard},
}
</script>

<style scoped>
h2{
    font-family: 'Montserrat', sans-serif;
    text-align: center;
}

</style>