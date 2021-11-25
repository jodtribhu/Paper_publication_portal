<template>
    <div >
    
    <admin-card>
        <h1>Requests</h1>
        <h4 v-if="list_forget.length==0">There are no requests available</h4>
        <p v-for="forgetrequest in list_forget" :key="forgetrequest.id">
          <forget-item  @messageFromStudentChild="childMessageRecieved" :username=forgetrequest.f_username :status=forgetrequest.f_status ></forget-item > 
        </p>
    </admin-card>
    </div>
    
</template>

<script>
import ForgetItem from './ForgetItem.vue';
export default {
    components: {ForgetItem},
    data(){
        return{
             list_forget:[]
        }
    },

    created() {
        if(this.$store.getters.checkAdminForget==false)
         {
            this.loadforgetrequests();
         }
         else{
             this.list_forget=this.$store.getters.getAdminForgets
         }
        
    },
    
    
  
    methods:{
      childMessageRecieved(message){
          if(message=="valueChanged"){
            this.loadforgetrequests();
          }
        },
        async loadforgetrequests(){
            try {
                  await this.$store.dispatch("loadforgetrequests");
                  this.list_forget=this.$store.getters.getAdminForgets;
                  
            } catch (error) {
                console.log(error);
              
            }
        
        },

    }
}
</script>

<style scoped>
h4{
  text-align:center;
  font-family: 'Montserrat', sans-serif;
}
.searchbar {
  margin-left:60%;
  padding: 6px;
  margin-top: 8px;
  margin-right: 16px;
  font-size: 17px;
  border: 1px solid #ccc;
}

  html {
  font-family: "Roboto", sans-serif;
  background-color: #ffffff;
}
button {
  text-decoration: none;
  padding: 0.75rem 1.5rem;
  margin-top: 8px;
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
  border-color: #270041;
  color: #270041;
}

.flat:hover,
.flat:active,
.outline:hover,
.outline:active {
  background-color: #edd2ff;
}
h1{
    font-family: 'Noto Sans Mono', monospace;
     font-weight: 500;
    text-align: center;
    margin-top:0;
    padding:2rem;
    font-size:2.4rem;
   
}

</style>
