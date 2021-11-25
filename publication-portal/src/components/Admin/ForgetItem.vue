<template>
    <div  class="card">
        <!-- <em @click="deleteFacultyRequest" class="far fa-trash-alt"></em> -->
      
        <h4><em class="fas fa-user-tie"> </em>  Faculty Username: <span>{{username}}</span></h4> 
    
        <div class="center">
           <h4 v-if="status=='done'" class="green">Done</h4>
           <button @click="resetPassword" class="outline" v-if="status!='done'">Reset Password</button>
        </div>
    </div>
</template>


<script>
import RegisterService from '@/services/RegistrationService.js';
export default {
    props:['username','status'],
    data(){
      return{
        completed:false,
        
      }
      
    },
  methods:{
    async resetPassword(){
   
      try {
        await RegisterService.changePassword({username:this.username,pass:"default"})
               this.$emit('messageFromStudentChild','valueChanged')
            } catch (error) {
                console.log(error);
            }
  
    },

  }
}
</script>


<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Montserrat:wght@500&display=swap');
.green{
  margin-top:2rem;
  color: green;
}
.center{
  text-align:center
}
.left
{
  text-align: left;
}
.right
{
  text-align: right;
  font-size: 0.8rem;
  padding-left: 18%;
}
.card {
  border-radius: 12px;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.26);
  border: 1px solid #424242;
  text-align: left;
  padding: 0.5rem 1rem;
  margin: 2rem auto;
  max-width: 40rem;
}
.far,.fas,.fa {
    font-size: 2.0rem;
    padding: 5px 2px 2px 0;
    }
li {
  margin: 1rem 0;
  border-radius: 12px;
  text-align: left;
  padding: 1rem;
}

h4 {
  font-size: 1.2rem;
}

h3,
h4,h5 {
  font-family: 'Montserrat', sans-serif;
  margin: 0.5rem 0.5rem;
}

div {
  margin: 0.5rem 0;
}

.actions {
  display: flex;
  justify-content: flex-end;
}
p{
  font-family: 'Montserrat', sans-serif;
  padding-top:2px;
  font-size: 0.8rem;
}
span{
  font-size: 1.2rem;
  font-weight:normal;
  font-family: 'Montserrat', sans-serif;
}
.fa-trash-alt{
 position: relative;
   margin-left:98%;
  font-size: 1.0rem;
  color: red;
}
.fa-trash-alt:hover{
    color: grey;
}

button {
  
  text-align:center;
  padding: 0.75rem 1.5rem;
  
  font-family: 'Montserrat', sans-serif;
  background-color: #3a0061;
  border: 1px solid #3a0061;
  color: white;
  cursor: pointer;
  border-radius: 30px;
}

button:hover,
button:active {
  background-color: #270041;
  border-color: #270041;
}

.flat {
  background-color: transparent;
  color: #3a0061;
  border: none;
}

.outline {
  background-color: transparent;
  margin-top:2rem;
  border-color: #270041;
  color: #270041;
}

.flat:hover,
.flat:active,
.outline:hover,
.outline:active {
  background-color: #edd2ff;
}
</style>