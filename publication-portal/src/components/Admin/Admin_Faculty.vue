<template>
    <admin-card>
            <base-dialog :show=showDialog class="dialogbox " title="Add New Faculty" @close="opencloseDialog" >
                    <div class="admin_dialog">
                        <div class="admin_item">
                            <p class="label_dialog" >Faculty Name:</p>
                            <input v-model="faculty_name" class="input_dialog" >
                        </div>
                        <div class="admin_item">
                            <p class="label_dialog">Faculty Email:</p>
                            <input v-model="faculty_email" type="email"  class="input_dialog" >
                        </div>
                        <div class="admin_item">
                            <p class="label_dialog">Password :</p>
                            <input v-model="faculty_password" class="input_dialog" >
                        </div>
                    </div>

                    <button class="dialogaddbutton" @click="add_Faculty()">Done</button>
            </base-dialog>


            <h1>Faculty List</h1>
            <div class="button_row">
                <button @click="opencloseDialog">Add New Faculty</button>
                <input class="searchbar" type="text" v-model="searchkey" placeholder="Search">
            </div>
            <p v-for="faculty in list_faculties" :key="faculty.fID">
                <faculty-item :id=faculty.fID :email=faculty.email :created_at=faculty.created_at :modified_at=faculty.modified_at></faculty-item>
            </p>
            

    </admin-card>
</template>

<script>
import RegisterService from '@/services/RegistrationService.js';
import FacultyItem from './FacultyItem.vue';
export default {
    components: {FacultyItem},
    data(){
        return{
            showDialog:false,
            faculty_name:'',
            faculty_email:'',
            faculty_password:'',
            list_faculties:[]
        }
    },
    created() {
        this.loadfaculties();
    },
    methods:{
        opencloseDialog(){
            this.showDialog=!this.showDialog;           
        },
        async add_Faculty(){
            try {
                  const response =await RegisterService.addFaculty({fname:this.faculty_name,femail:this.faculty_email,fpassword:this.faculty_password})
                    this.showDialog=!this.showDialog;
                //   if(response.data.registration=="Successfull"){
                //       this.$router.replace({name: 'admin', params: { load: "Faculty" }});
                //   }
                if(response.status==200){
                    this.loadfaculties();
                }
                console.log(response.data);
            } catch (error) {
                console.log(error);
              
            }
        },
        async loadfaculties(){
            try {
                  const response =await RegisterService.getFaculty()
            
                  this.list_faculties=response.data.f;
            } catch (error) {
                console.log(error);
              
            }
        }
    
    }
    
}
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Montserrat:wght@500&display=swap');
.label_dialog{
    width:40%;
}
.input_dialog{
    margin-top:1rem;
    width:60%;
    height:1.8rem;
}
.admin_dialog{
    padding:1rem 0 1rem 0;
}
.admin_item{
         font-family: 'Montserrat', sans-serif;
         font-size:1.2rem;
         display: flex;
         width:90%;
         padding:0;
         
}    
.dialogaddbutton{
        text-align:center;
        padding: 0.75rem 1rem;
        font-family: 'Montserrat', sans-serif;
        background-color: #551524;
        border: 1px solid #551524;;
        color: white;
        cursor: pointer;
        border-radius: 10px;
        position:absolute; 
        bottom:10px;
        left:20px;
    } 
.faculty_Card {
  border-radius: 12px;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.26);
  padding: 1rem;
  margin:auto;
  background-color: #f6f6f6;
  width: 70%;
}
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