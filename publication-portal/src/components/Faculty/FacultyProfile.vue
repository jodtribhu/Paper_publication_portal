<template>
<div class="margin">
    <base-dialog :show=showDialog  title="Team Mates" @close="opencloseDialog">
            <div class="input_cont">
                <div class="each_input">
                    <label class="input_label" for="" >Name:</label>
                    <input class="input_text" v-model="editname" type="text" >
                </div>
                <div class="each_input">
                    <label class="input_label" for="">Roll Number:</label>
                    <input class="input_text" v-model="editroll" type="text" >
                </div>
                 <div class="each_input">
                    <label class="input_label" for="">Mail:</label>
                    <input class="input_text" v-model="editemail" type="text" >
                </div>
                <div class="each_input"> 
                    <label class="input_label" for="">Department:</label>
                    <input class="input_text" v-model="editdept" type="text" >
                </div>
                <div class="each_input">
                    <label class="input_label" for="">Designation:</label>
                    <input class="input_text" v-model="editdesig" type="text" >
                </div>
                <div class="each_input">
                    <label class="input_label" for="">Campus:</label>
                    <input class="input_text" v-model="editcampus"  type="text" >
                </div>
                <div class="each_input">
                    <label class="input_label" for="">Mobile Number:</label>
                    <input class="input_text" type="text" v-model="editmobile"  >
                </div>
                <button class="button" @click="editFaculty()">Edit</button>
            </div>
        </base-dialog>  
<dashboard-card >
    <div class="card container_flex">
        <div class="edit" @click="opencloseDialog">
            <i class="far fa-edit"></i>
        </div>
        <div class="container_flex_each class1">
            <div class="each_item"> 
                <p class="each_item_label">Name:</p>
                <p class="each_item_answer"> {{faculty.name}}</p>
            </div>
            <div  class="each_item"> 
                <p class="each_item_label">Faculty ID Number:</p>
                <p  class="each_item_answer"> {{faculty.IDNO}}</p>
            </div>
            <div  class="each_item"> 
                <p class="each_item_label">Campus:</p>
                <p  class="each_item_answer"> {{faculty.campus}}</p>
            </div>
        </div>

        <div class="container_flex_each class2">
            <div class="align">
                <div  class="each_item"> 
                    <p class="each_item_label">Department:</p>
                    <p  class="each_item_answer"> {{faculty.department}}</p>
                </div>
                <div  class="each_item"> 
                    <p class="each_item_label">Designation:</p>
                    <p  class="each_item_answer"> {{faculty.designation}}</p>
                </div>
                <div  class="each_item"> 
                    <p class="each_item_label">Email:</p>
                    <p  class="each_item_answer"> {{faculty.email}}</p>
                </div>
                <div  class="each_item"> 
                    <p class="each_item_label">Mobile:</p>
                    <p  class="each_item_answer"> {{faculty.phoneNO}}</p>
                </div>
            </div>

        </div>

    </div>

    </dashboard-card>
</div>

</template>

<script>
import GetEach from '@/services/GetEach';
export default {
    props:['faculty'],
    data(){
        return {
                editname:'',
                editroll:'',
                editdept:'',
                editdesig:'',
                editcampus:'',
                editmobile:'',
                editemail:'',
                showDialog:false,
        }
    },
    methods:{
        opencloseDialog(){
            if(this.showDialog==false){
                this.editname=this.faculty.name;
                this.editroll=this.faculty.IDNO;
                this.editdept=this.faculty.department;
                this.editdesig=this.faculty.designation;
                this.editcampus=this.faculty.campus;
                this.editmobile=this.faculty.phoneNO;
                this.editemail=this.faculty.email;
             }
             this.showDialog=!this.showDialog;  

             
        },  
        async editFaculty(){
            this.showDialog=!this.showDialog;  
            await GetEach.editEachFaculty({"f_id":this.faculty.fID,"editname":this.editname,"editroll":this.editroll,
            "editdept":this.editdept,"editdesig":this.editdesig,"editcampus":this.editcampus,"editmobile":this.editmobile,"editemail":this.editemail})
            this.$emit('refresh')
        }
    }
}
</script>
<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Montserrat:wght@500&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Lato&display=swap');
.container_flex_each{
        min-width:60%;    
}
.edit{
    position:absolute;
    right:1rem;
    top:1rem;
    font-size:1.5rem;
}

.card{
    background-color:rgba(143, 160, 165, 0.781);
    border-radius: 0 24px 24px 24px;
}
.container_flex{
    padding-top:2rem;
    padding-bottom:2rem;
    padding-left:4rem;
    padding-right:4rem;
    display: flex;
  

    
}
.each_item{
    display: flex;
    width:80%;
 
    font-size:1.2rem;
  
}
.each_item_answer{
    padding-left:0.5rem;
    font-family: 'Lato', sans-serif;
   
}
.each_item_label{
    font-weight: bold;
    font-size:1.2rem;
    font-family: 'Montserrat', sans-serif;

}

/* edit */

.input_label{
    font-size: 1.2rem;
    font-weight:bold;
}
.input_text{
    font-size:1.2rem;
}
.input_cont{
    width:80%;
    padding-bottom: 2rem;
}
.each_input{
    display: flex;
    padding-top:1rem;
    justify-content: space-between;
}
.button{
    position:absolute;
    bottom:1rem;
    left:1rem;
    width:8rem;
    height:40px;
    background-color: rgb(24, 11, 99);
    font-family: 'Montserrat', sans-serif;
    font-size:1rem;
    border-radius:12px;
    color:rgb(212, 206, 195);
    cursor: pointer;
    border-style:none;
}
.button:hover{
    background-color: rgba(69, 70, 82, 0.753);
    color:white;
}
</style>