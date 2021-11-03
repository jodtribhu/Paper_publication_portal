<template>
        <admin-card>
        <h1>Student List</h1>
        <div class="button_row">
            <button  @click="opencloseDialog">Add New Student</button>

            <base-dialog :show=showDialog class="dialogbox " title="Add New Student" @close="opencloseDialog" >
                   <div class="admin_dialog">
                        <div class="admin_item">
                            <p class="label_dialog" >Student Name:</p>
                            <input v-model="stu_name" class="input_dialog" >
                        </div>
                        <div class="admin_item">
                            <p class="label_dialog">Roll Number:</p>
                            <input v-model="stu_roll" class="input_dialog" >
                        </div>
                        <div class="admin_item">
                            <p class="label_dialog">Password :</p>
                            <input v-model="stu_pass" class="input_dialog"  type="text">
                        </div>
                   </div>

                    <button class="dialogaddbutton" @click="add_Student()">Done</button>
            </base-dialog>


            <input class="searchbar" type="text" v-model="searchkey" placeholder="Search">
        </div>
        <p v-for="student in list_students" :key="student.sID">
                <student-item  @messageFromStudentChild="childMessageRecieved" :id="student.sID" :rollno="student.rollNo"  :name="student.name" :created_at="student.created_at" :modified_at="student.modified_at"></student-item>

        </p>
    </admin-card>
</template>

<script>
import RegisterService from '@/services/RegistrationService.js';
import StudentItem from './StudentItem.vue';
export default {
    components: {StudentItem},
    data(){
        return{
            showDialog:false,
            list_students:[]
        }
    },
    created() {
        
        if(this.$store.getters.checkAdminStudent==false)
         {
            this.loadstudents();
         
         }
         else{
             this.list_students=this.$store.getters.getAdminStudent
         }
    },
    methods:{
        opencloseDialog(){
            this.showDialog=!this.showDialog;           
        },
        childMessageRecieved(message){
          if(message=="valueChanged"){
            this.loadstudents();
          }
        },
        async add_Student(){
            try {
                const response =await RegisterService.addStudent({stu_name:this.stu_name,stu_roll:this.stu_roll,stu_pass:this.stu_pass});
                 this.showDialog=!this.showDialog;
                 this.loadstudents();
                console.log(response.data);
                if(response.status==200){
                    this.loadstudents();
                }
            } catch (error) {
                console.log(error);
              
            }
        },
        async loadstudents(){
            try {
                await this.$store.dispatch("loadadminstudentpublication");
                  this.list_students=this.$store.getters.getAdminStudent
            } catch (error) {
                console.log(error);
              
            }
        }
    }
    
}
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Noto+Sans+Mono&display=swap');
.label_dialog{
    width:40%;
}
.admin_dialog{
     padding:1rem 0 1rem 0;
}
.input_dialog{
    margin-top:1rem;
    width:60%;
    height:1.8rem;
}
.admin_item{
         font-family: 'Montserrat', sans-serif;
         font-size:1.2rem;
         display: flex;
         width:90%;
         padding:0;
         /* background-color:orangered; */
     }
h1{
    font-family: 'Noto Sans Mono', monospace;
     font-weight: 500;
    text-align: center;
    margin-top:0;
    padding:2rem;
    font-size:2.4rem;
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
    .dialogaddbutton{
        text-align:center;
        padding: 0.75rem 1rem;
        font-family: 'Montserrat', sans-serif;
        background-color: #551524;
        border: 1px solid #551524;
        color: white;
        cursor: pointer;
        border-radius: 10px;
        position:absolute; 
        bottom:10px;
        left:20px;
    }
</style>