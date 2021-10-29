<template>
<div class="margin_correct">
    <form-outercard>
        <div class="full" :style="imagesselect()" >
            <base-dialog :show=showDialog class="dialogbox " title="Add Contributers" @close="opencloseDialog" >
            <div class="admin_dialog">
                    <div class="student_form">
                        <p class="label_dialog">Name :</p>
                        <input v-model="person_name" class="input_dialog" >
                    </div>
                    <div class="student_form">
                        <p class="label_dialog">Roll Number :</p>
                        <input v-model="person_roll_no" class="input_dialog"   type="text">
                    </div>
                    <div class="student_form">
                        <p class="label_dialog">Email :</p>
                        <input v-model="person_email" class="input_dialog"  type="text">
                    </div>
            </div>

                    <button class="dialogaddbutton" @click="add_Contributer">Done</button>
            </base-dialog>
            <form-card class="form_padding" >
                <div  class="form_flex">
                    <div class="centered_form">
                        <h1 class="form_header">Student Form</h1>
                       <div class="form_item">
                            <div class="student_name">
                                <p>Publication Title :</p>
                                <input v-model="student_publication_title"  type="text" :class="[student_publication_title_error ? 'error_div' : 'input_form']">
                            </div>
                            <div class="student_name">
                                <p>Document Link (Google Drive) :</p>
                                <input v-model="student_publication_link"  type="text" :class="[student_publication_link_error ? 'error_div' : 'input_form']">
                            </div>
                            <div class="student_name">
                                <p>Add other contributers to the project (if any):</p>
                                    <div v-for="Person in addPerson" :key="Person" class="student_add_contribution">
                                        <div class="contributer_section">
                                            <p class="contributer"><span class="contributer_span">Name : </span> {{Person.Name}}</p>
                                            <p class="contributer"><span class="contributer_span">Roll Number : </span>  {{Person.RollNo}}</p>
                                            <p class="contributer"><span class="contributer_span">Email : </span> {{Person.Email}}</p>
                                        </div>
                                        <div class="contributer_section_edit" >
                                            <i class="far fa-edit"></i>
                                        </div>
                                        
                                    </div>
                                <div class="addbutton_position">
                                    <button @click="opencloseDialog" class="addbutton"><span class="add_letter">+</span></button>
                                </div>
                                
                            </div>
                       </div>
                        <div class="student_name " >
                            <p>Publication Duration :</p>
                            <div class="two_column">
                                <div class="each_label_two_column">
                                    <label>Start : </label>
                                    <input v-model="student_publication_start"  type="date" :class="[student_publication_start_error ? 'error_div' : 'input_date']">
                                </div>
                                <div class="each_label_two_column">
                                    <label>End: </label>
                                    <input v-model="student_publication_end"  type="date" :class="[student_publication_end_error ? 'error_div' : 'input_date']">
                                </div>
                            </div>
                        </div>
                        <div class="published_twocolumn_scopus">
                            <label class="label_container"><input type="radio" >Scopus Indexed</label>
                        </div>
                        <div class="published_twocolumn">
                            <label class="label_container"><input @click="journal_check" class="check"  name="test" type="radio" >Published in a Journal
                                
                            </label>
                            <label> <input @click="conference_check" class="check" name="test" type="radio" > Presented in Conference
                               
                            </label>
                        </div>






                        <transition name = "fade">
                            <div v-if="journal_checked" class="student_name show_transition">
                                <p>Journal Name :</p>
                                <input v-model="student_journal_name"  type="text" :class="[student_journal_name_error ? 'error_div' : 'input_form']">
                            </div>
                        </transition>
                        <transition name = "fade">
                            <div v-if="conference_checked" class="student_name">
                                <p>Conference Name :</p>
                                <input v-model="student_conference_name"  type="text" :class="[student_conference_name_error ? 'error_div' : 'input_form']">
                            </div>
                        </transition>

                        <div class="published_twocolumn_surv">
                            <label class="label_container">  <input @click="survey_check" class="check"  name="test2" type="radio" >Survey 
                              
                            </label>
                            <label> <input @click="implementation_check" class="check" name="test2" type="radio" >Implementation
                               
                            </label>
                        </div>

                    </div>
                </div>   
                <div class="button_position">
                    <button @click="submitForm()" class="submitButton">SUBMIT</button>
                </div>
                
            </form-card>  
            
        </div>
    </form-outercard>
</div>

</template>

<script>
import FormServices from '@/services/FormServices.js';
import FormOutercard from '../layout/FormOutercard.vue';
export default {
     components: { FormOutercard},
    data(){
        return{
            student_name:'',
            student_roll_no:'',
            student_email:'',
            student_publication_title:'',
            student_publication_start:'',
            student_publication_end:'',
            student_journal_name:'',
            student_conference_name:'',
            student_publication_link:'',
            student_name_error:false,
            student_roll_no_error:false,
            student_email_error:false,
            student_publication_title_error:false,
            student_publication_start_error:false,
            student_publication_end_error:false,
            student_journal_name_error:false,
            student_survey:false,
            student_implementation:false,
            
            isAddClass:'',
            person_name:'',
            person_roll_no:'',
            person_email:'',
            addPerson:[],
            showDialog:false,
            journal_checked:false,
            conference_checked:false,
            l:['image_1.png','image_2.png','image_3.png','image_4.png','image_5.png','image_6.png','image_7.png','image_8.png'],
            x:''
        }
    },
    methods:{
        add_Contributer(){
            this.addPerson.push({'Name':this.person_name,'RollNo':this.person_roll_no,'Email':this.person_email})
            this.showDialog=!this.showDialog; 
        },
        opencloseDialog(){
            this.showDialog=!this.showDialog;           
        },
        journal_check(){
            this.journal_checked=true;
            this.conference_checked=false;
        },
        conference_check(){
            this.conference_checked=true;
            this.journal_checked=false;
        },
        survey_check(){
            this.student_survey=true;
            this.student_implementation=false;
        },
        implementation_check(){
            this.student_survey=false;
            this.student_implementation=true;
        },
        imagesselect(){
            var randomElement=this.l[Math.floor(Math.random() * this.l.length)]  
            var k=require(`/src/assets/images/${randomElement}`)
            var l='background-image'+':'+ 'url(' + k + ')'
            if(this.x==''){
                this.x=l    
            }
            
            return this.x
        },
        async submitForm(){
            if(this.student_name==''){
                this.student_name_error=true
            }
            if(this.student_roll_no==''){
                this.student_roll_no_error=true
            }
            if(this.student_email==''){
                this.student_email_error=true
            }
            if(this.student_publication_title==''){
                this.student_publication_title_error=true
            }
            if(this.student_publication_start==''){
                this.student_publication_start_error=true
            }
            if(this.student_publication_link==''){
                this.student_publication_link_error=true
            }
            if(this.student_publication_end==''){
               this.student_publication_end_error=true
            }
            if(this.student_journal_name==''){
                this.student_journal_name_error=true
            }
            if(this.student_conference_name==''){
                this.student_conference_name_error=true
            }

            try {
                var is_jo="No";
                var is_conf="No";
                var stu_imp="No";
                var stu_surv="No";

                if(this.student_publication_isjor==true){
                    is_jo="Yes";    
                }
                if(this.student_publication_isconf==true){
                    is_conf="Yes";    
                }
                if(this.student_implementation==true){
                    stu_imp="Yes"
                }
                if(this.student_survey==true){
                    stu_surv="Yes"
                }
                const date = new Date()
                const dateFormatter = Intl.DateTimeFormat('sv-SE');
                dateFormatter.format(date)
                var addp1='';
                var addp2='';
                var addp3='';
                var addp4='';
                addp1='1'
                for (let i = 0; i < this.addPerson.length; i++) {
                    if(i==0){
                         addp2=this.addPerson[i].RollNo
                    }
                    if(i==1){
                         addp3=this.addPerson[i].RollNo
                    }
                    if(i==2){
                         addp4=this.addPerson[i].RollNo
                    }

                }
                  const response =await FormServices.addForm(
                {student_publication_title:this.student_publication_title,
                  student_publication_start:this.student_publication_start,
                  student_publication_link:this.student_publication_link,
                  student_journal_name:this.student_journal_name,
                  student_conference_name:this.student_conference_name,
                  student_publication_end:this.student_publication_end,
                  student_publication_submitdate:dateFormatter.format(date),
                  addPerson1:addp1,
                  addPerson2:addp2,
                  addPerson3:addp3,
                  addPerson4:addp4,
                  student_publication_isimp:stu_imp,
                  student_publication_issurv:stu_surv,
                  student_publication_isconf:is_conf,
                  student_publication_isjor:is_jo
                  })

               
            this.student_publication_title='';
            this.student_publication_start='';
            this.student_publication_end='';
            this.student_journal_name='';
            this.student_conference_name='';
            this.student_publication_link='';
            this.student_name_error=false;
            this.student_roll_no_error=false;
            this.student_email_error=false;
            this.student_publication_title_error=false;
            this.student_publication_start_error=false;
            this.student_publication_end_error=false;
            this.student_journal_name_error=false;
            this.student_survey=false;
            this.student_implementation=false;
            
            this.isAddClass='';
            this.person_name='';
            this.person_roll_no='';
            this.person_email='';
            this.addPerson=[];
            this.showDialog=false;
            this.journal_checke=false;
            this.conference_checked=false;


                  
                console.log(response.data);
            } catch (error) {
                console.log(error);
              
            }



        }
    }
}
</script>

<style scoped>

.margin_correct{

    overflow: hidden;
    
}
.form_item{
    padding-top:2rem;
}
.error_div:focus{
    height:1.2rem;
    border: none;
    outline: none;
    border-bottom: 3px solid rgb(211, 21, 21);
}
.error_div{
          border: none;
          transition: all 0.2s;
          border-bottom: 3px solid rgb(211, 21, 21);
          height:0.9rem;
          border-radius: 4px;
          padding:0.5rem;
          width:95%
}
.contributer_section_edit{
    display: flex;
    flex-direction: column;
    justify-content:center;
}
.student_add_contribution{
    padding-top:0.2rem;
    
    display: flex;
    justify-content:space-between;
}
.contributer_span{
    font-weight: bold;
}
.fade-enter-active,
.fade-leave-active {
  transition: opacity 0.5s ease;
}

.fade-enter-from,
.fade-leave-to {
  opacity: 0;
}
.published_twocolumn{
    display: flex;
    justify-content:space-between;
    padding-top:2rem;
    font-family: 'Montserrat', sans-serif;
    font-size:1rem;
    font-weight: bold;
}
.published_twocolumn_surv{
    width:88.5%;
    display: flex;
    justify-content:space-between;
    padding-top:2rem;
    font-family: 'Montserrat', sans-serif;
    font-size:1rem;
    font-weight: bold;
    padding-left:0.2rem;
}
.published_twocolumn_scopus{
    padding-left:0.2rem;
    display: flex;
    justify-content:space-between;
    padding-top:2rem;
    font-family: 'Montserrat', sans-serif;
    font-size:1rem;
    font-weight: bold;
}
/*input*/

.input_form:focus{
    height:1.2rem;
    border: none;
    outline: none;
    border-bottom: 2px solid rgb(19, 17, 17);
}
.input_form{
          border: none;
          transition: all 0.2s;
          border-bottom: 2px solid rgb(19, 17, 17);
          height:0.9rem;
          border-radius: 4px;
          padding:0.5rem;
          width:95%;
    }

.label_dialog{
    width:40%;
    font-weight: bold;
}
.admin_dialog{
     padding:1rem 0 1rem 0;
}
.input_dialog{
    margin-top:1rem;
    width:60%;
    height:1.8rem;
    transition:1sec;
    transition-timing-function: ease-out;
}
.input_dialog:focus{
    height:1.2rem;
    border: none;
    outline: none;
    border-bottom: 2px solid rgb(19, 17, 17);
}

.contributer_section{
    font-size:1rem;
    border-radius: 10px;
    border-left: 7px solid rgb(73, 40, 40);
}
.contributer{
    padding-left:1rem;
}

.each_label_two_column{
    width:100%;
    font-weight:normal;
}
.two_column{
    width:100%;
    margin-left:3.5rem;
    display:flex;
    justify-content: space-between;
}
.input_date{
        width:60%;
        height: 1.5rem;
        font-family: 'Montserrat', sans-serif;
    }
    .centered_form{
        width:80%;
        padding:2rem;
    }
    .check{
        height:0.8rem;
        width:1.2rem;
    }
    .label_container{
        padding-right:1rem;
    }
    .addbutton{
        text-align:center;
        font-size:1.5rem;
        /* padding:0.1rem; */
        height:2.5rem;
        width: 3rem;
        margin:0.1rem auto;
        background-color: #271d57;
        border:none;
        color: white;
        cursor: pointer;
        border-radius:12px;
        font-family: 'Montserrat', sans-serif;
    }

    .addbutton_position{
        text-align: center;

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
        margin:0;
        font-family: 'Montserrat', sans-serif;
        text-align:center;
        font-size: 2rem;
    }
     .full{
        padding:2rem;
        height:90%;
        margin-bottom: 2rem;
        border-radius:24px;
     }
     .form_flex{
         display:flex;
         justify-content: center;
     }
 
     .student_name{
         font-family: 'Montserrat', sans-serif;
         font-size:1.2rem;
         font-weight:bold;
         padding-top:1rem;
     }
     .student_form{
        font-family: 'Montserrat', sans-serif;
         font-size:1.2rem;
         display: flex;
         width:90%;
         padding:0;
     }

.submitButton{
    background-color: #041d36;
  border-radius: 5px;
  border: 1px solid #337bc4;
  cursor: pointer;
  color: #ffffffdc;
  font-size: 1rem;
  padding: 12px 44px;
  text-shadow: 0px 1px 0px #558ac0;
  font-family: 'Montserrat', sans-serif;
}
.button_position{
    display: flex;
    justify-content:flex-end;
}

</style>