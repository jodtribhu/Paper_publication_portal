<template>
    <div >
<base-dialog :show=showDialog class="dialogbox " title=" Additional Details" @close="opencloseDialog" >
            <div class="student_name">
                <p> <span class="boldit">Student Email :</span>   <span>{{publication_record.email}}</span> </p>
            </div>
            <div class="student_name">
                <p> <span class="boldit">Student Roll Number :</span>   <span>{{publication_record.rollNo}}</span> </p>
            </div>
            <div class="student_name">
                <p> <span class="boldit">Student Phone Number :</span>  <span>{{publication_record.phoneno}}</span> </p>
            </div>
            <div class="student_name">
                <p> <span class="boldit">Publication Link :</span>  <span><a :href="publication_record.link">Click Here</a></span> </p>
            </div>
            <div class="student_name" v-if="publication_record.jname!=0">
                <p><span class="boldit">Journal Name :</span>  <span >{{publication_record.jname}}</span>
                <span v-if="publication_record.jname==null">: Not in a Journal</span>
                </p>
            </div>
            <div class="student_name"  v-if="publication_record.cname!=0">
                <p><span class="boldit">Conference Name : </span> <span>{{publication_record.cname}}</span>
                <span v-if="publication_record.cname==null">:Not presented in a Conference</span>
                
                </p>
            </div>
            <div class="student_name">
                <p> <span class="boldit">Scopus Indexed :</span>  <span>{{publication_record.scp_index}} </span> </p>
            </div>
            
            <div class="student_name" v-if="getTemsize(publication_record.team)>0">
                <p><span class="boldit">Team: </span> 
                <span v-for="(member,index) in publication_record.team" :key="member.mate_id" > <span v-if="index!=0"> , </span> {{member.mate_name}}  </span>
    
                </p>
            </div>
            <div class="buttons_position">
              <button class="acceptButton" @click="opencloseAcceptDialog">Accept</button>
              <button class="declineButton" @click="opencloseDeclineDialog">Decline</button>
            </div>
     </base-dialog>


     
     <base-dialog :show=showAcceptDialog class="dialogbox " title="Accept" @close="opencloseAcceptDialog" >
        <div class="remark_container">
            <p class="label_accept">Enter Your Remarks: </p>
            <textarea class="textarea_accept" v-model="publication_remarks" ></textarea>
        </div>
        <div class="accept_container" v-if="getTemsize(publication_record.team)==1">
            <p class="label_accept">Enter Your Marks: </p>
            <input class="input_accept" type="text" v-model="publication_marks">
        </div>
        <div class="buttons_position">
              <button class="acceptButton" @click="opencloseApprovePublicationDialog">Accept</button>
             
        </div>
     </base-dialog>
     <base-dialog :show=showDeclineDialog class="dialogbox " title="Accept" @close="opencloseDeclineDialog" >
        <div class="remark_container">
            <p class="label_accept">Enter Your Remarks: </p>
            <textarea class="textarea_accept" v-model="publication_remarks" ></textarea>
        </div>
        <div class="buttons_position">
              <button class="declineButton"  @click="opencloseDeclinePublicationDialog">Decline</button>
        </div>
     </base-dialog>


        <div >
            <table >
                <tr>
                    <td> {{publication_record.name}}</td>
                    <td class="title_size">  {{publication_record.title}}</td>
                    <td class="m_size"> {{getTemsize(publication_record.team)}}</td>
                    <td class="details_size" @click="opencloseDialog"> <button class="detailsbutton">Show Details</button> </td>
                </tr>
            </table>


        </div>
        <div>

        </div>
    </div>
</template>


<script>
import EachFacultyPublication from '@/services/EachFacultyPublication.js';
export default {
    props:['publication_record'],
     data(){
        return{
            showDialog:false,
            showAcceptDialog:false,
            showDeclineDialog:false,
            publication_remarks:'',
            publication_marks:0,

        };
     },
    methods:{
        opencloseDialog(){
            this.showDialog=!this.showDialog;           
        },
        getTemsize(teamarray){
            return teamarray.length
        },
        async opencloseAcceptDialog(){
            this.showAcceptDialog=!this.showAcceptDialog;  
            this.showDialog=false; 
        },
        async opencloseApprovePublicationDialog(){
            this.showAcceptDialog=!this.showAcceptDialog;  
            this.showDialog=false; 
            await EachFacultyPublication.acceptPublication({p_remark:this.publication_remarks,p_mark:this.publication_marks,SP_ID:this.publication_record.SP_ID});
            this.$emit("refreshthepublication")
        },
        async opencloseDeclinePublicationDialog(){
            this.showAcceptDialog=!this.showAcceptDialog;  
            this.showDialog=false; 
            await EachFacultyPublication.declinePublication({p_remark:this.publication_remarks,SP_ID:this.publication_record.SP_ID});
            this.$emit("refreshthepublication")
        }, 
        opencloseDeclineDialog(){
            this.showDeclineDialog=!this.showDeclineDialog;  
            this.showDialog=false; 
        }
   }
}
</script>


<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Montserrat:wght@500&display=swap');
.title_size{
    width:40%;
}
.label_accept{
  font-weight: bold;
  font-size: 1rem;
}
.textarea_accept{
  width:90%;
  margin-top:0.8rem;
  height:5rem;
}
.input_accept{
  width:5%;
  margin-left:1.5rem;
  font-size:1.2rem;
  margin-top:0.8rem;
  height:1.5rem;
}
.accept_container{
  display:flex;
  justify-content:flex-start;

}
.remark_container{
  width:100%;

}
.buttons_position{
  position:absolute;
  bottom:0;
  /* background-color: orangered; */
}
.acceptButton{
  background-color: #08441a;
  margin-right:1rem;
  border-radius: 12px;
  cursor: pointer;
  color: #ffffffdc;
  font-size: 1rem;
  padding: 12px 20px;
  text-shadow: 0px 1px 0px #558ac0;
  border:none;
  font-family: 'Montserrat', sans-serif;
}
.declineButton{
  background-color: #6d0707;
  border:none;
  border-radius: 12px;
  cursor: pointer;
  color: #ffffffdc;
  font-size: 1rem;
  padding: 12px 20px;
  text-shadow: 0px 1px 0px #558ac0;
  font-family: 'Montserrat', sans-serif;
}
.m_size{
  width:10%;
}
.details_size{
  width:5%;
}
.boldit{
    font-weight: bold;
}
.detailsbutton{
        text-align:center;
        font-size:0.7rem;
        font-family: 'Montserrat', sans-serif;
        padding: 0.3rem 1rem;
        background-color: #271d57;
        border: 1px solid #3a0061;
        color: white;
        cursor: pointer;
        border-radius: 10px;

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
.table{
    display:flex;
    justify-content:space-between
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
  background-color:#fcfcfc;
  border-radius: 12px;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.26);
  border: 1px solid #424242;
  text-align: left;
  padding: 0.5rem 1rem;
  margin: 2rem auto;
  max-width: 40rem;
}
.far {
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
h4 {
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
  font-size: 1rem;
  font-weight:normal;
  font-family: 'Montserrat', sans-serif;
}
.fa-user-times{
 position: relative;
   margin-left:98%;
  font-size: 1.0rem;
  color: red;
}
.fa-user-times:hover{
    color: grey;
}
table{
     width: 100%;
     border: 1px solid black;
}
 th, td {
    width:20%;

}
tr{
    text-align:center;
    font-family: 'Montserrat', sans-serif;
    
    
}
th{
    font-family: 'Montserrat', sans-serif;
}
</style>