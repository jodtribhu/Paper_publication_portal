<template>
    <admin-card>
        <h1>Faculty List</h1>
        <div class="button_row">
            <button>Add New Faculty</button>
            <input class="searchbar" type="text" v-model="searchkey" placeholder="Search">
        </div>
        <faculty-item></faculty-item>
        <faculty-item></faculty-item>
        <faculty-item></faculty-item>
    </admin-card>
</template>

<script>
import FacultyItem from './FacultyItem.vue';
export default {
    components: {FacultyItem},
    
}
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Montserrat:wght@500&display=swap');
h1{
    font-family: 'Montserrat', sans-serif;
    text-align: center;
    margin-top:0;
    padding:2rem;
}
.button_row{
    margin:auto;
    padding-bottom: 0.8rem;
 
    max-width: 52rem;
}
button{
    border-radius: 10px 10px;
    height: 3rem;
    color: rgb(212, 205, 205);
    padding-left:1.5rem;
    padding-right:1.5rem;
    font-family: 'Montserrat', sans-serif;
    font-weight: bold;
    font-size: 1rem;
   
    background-color:rgb(31, 29, 119);
    border-style:0 solid;
}
.searchbar {
    border-radius: 10px 10px;
  float: right;
  padding: 6px;
  height: 1.8rem;
    font-family: 'Montserrat', sans-serif;
  margin-top: 8px;
  margin-right: 16px;
  font-size: 17px;
  border: 1px solid #ccc;
}

</style>