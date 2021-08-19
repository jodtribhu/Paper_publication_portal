<template>

<div class="full" :style="{'background-image': 'url(' + require(`/src/assets/images/background_1.jpg`) + ')'}">
     <base-dialog :show=showDialog class="dialogbox" title="Add Contributers" @close="opencloseDialog">
            <div class="student_name">
                <p>Name:</p>
                <input class="input" type="text">
            </div>
            <div class="student_name">
                <p>Roll Number :</p>
                <input class="input" type="text">
            </div>
            <button class="dialogaddbutton" >Add</button>
     </base-dialog>
      <form-card class="form_padding">
            
        <div class="centered_form">
            <h1 class="form_header">Student Form</h1>
            <div class="student_name">
                <p>Name:</p>
                <input class="input" type="text">
            </div>
            <div class="student_name">
                <p>Roll Number :</p>
                <input class="input" type="text">
            </div>
            <div class="student_name">
                <p>Email :</p>
                <input class="input" type="email">
            </div>
            <div class="student_name">
                <p>Add other contributers to the project if any:</p>
                 <button @click="opencloseDialog" class="addbutton">+</button>
            </div>
            <div class="student_name">
                <p>Publication Title :</p>
                <input class="input" type="text">
            </div>
            <div class="student_name " >
                <p>Publication Duration :</p>
                <div class="two_column">
                    <div class="each_label_two_column">
                        <label>Start : </label>
                        <input class="input_date" type="date">
                    </div>
                    <div class="each_label_two_column">
                        <label>End: </label>
                        <input class="input_date" type="date">
                    </div>
                </div>

                
            </div>
            <div class="student_name padding_checkbox">
                <label class="label_container">Published in a Journal
                    <input @click="journal_check" class="check" type="checkbox">
                </label>
                <label>Presented in Conference
                    <input @click="conference_check" class="check" type="checkbox">
                </label>
            </div>
            <div v-if="journal_checked" class="student_name">
                <p>Journal Name :</p>
                <input class="input" type="text">
            </div>
            <div v-if="conference_checked" class="student_name">
                <p>Conference Name :</p>
                <input class="input" type="text">
            </div>
        </div>

            
    </form-card>  
    
</div>

</template>

<script>
export default {
    data(){
        return{
            showDialog:false,
            journal_checked:false,
            conference_checked:false,
        }
    },
    methods:{
        opencloseDialog(){
            this.showDialog=!this.showDialog;           
        },
        journal_check(){
            this.journal_checked=!this.journal_checked;
        },
        conference_check(){
            this.conference_checked=!this.conference_checked;
        }
    }
}
</script>

<style scoped>
.each_label_two_column{
    width:100%;
}
.two_column{
    display:flex;
    justify-content: space-around;
}
    .input_date{
        width:60%;
        height: 1.5rem;
        font-family: 'Montserrat', sans-serif;
    }
    .centered_form{
        width:50%;
        padding:2rem;
    }
    .padding_checkbox{
        padding-top:1rem;
    }
    .check{
        height:1.2rem;
        width:1.2rem;
    }
    .label_container{
        padding-right:2rem;
    }
    .addbutton{
        text-align:center;
        font-size:1.2rem;
        padding:0.1rem;
        height:2rem;
        width: 2rem;
        background-color: #271d57;
        color: white;
        cursor: pointer;
        border-radius: 100px;
    }
    .dialogaddbutton{
        text-align:center;
        padding: 0.75rem 1rem;
        font-family: 'Montserrat', sans-serif;
        background-color: #271d57;
        border: 1px solid #3a0061;
        color: white;
        cursor: pointer;
        border-radius: 10px;
        position:absolute; 
        bottom:10px;
        left:20px;
    }
    .dialogbox{
        font-family: 'Montserrat', sans-serif;
        padding: 2px 10px 2px 2px;
    }
    .form_header{
        font-family: 'Montserrat', sans-serif;
        text-align:center;
    }
     .full{
         height:100vh;
         background-size: cover;
     }

     .form_padding{
         top:1rem;
         bottom:1rem;
         overflow: scroll;
         height:90vh;   
         display:flex;
         justify-content: center;
     }
    .input{
          border: none;
          border-bottom: 2px solid rgb(19, 17, 17);
          height:1rem;
          padding:0.5rem;
          width:100%;
    }
     .student_name{
         font-family: 'Montserrat', sans-serif;
         font-size:1.2rem;
     }

     ::-webkit-scrollbar {
  width: 8px;
}

/* Track */
::-webkit-scrollbar-track {
  background: #f1f1f100; 
}
 
/* Handle */
::-webkit-scrollbar-thumb {
  background: #888; 
}

/* Handle on hover */
::-webkit-scrollbar-thumb:hover {
  background: #555; 
}
</style>