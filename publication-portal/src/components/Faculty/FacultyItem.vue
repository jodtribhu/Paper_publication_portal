<template>
    <div >
     <base-dialog :show=showDialog class="dialogbox " title=" Additional Details" @close="opencloseDialog" >
            <div class="student_name">
                <p> <span class="boldit">Student Email</span>  : <span>{{publication_record.email}}</span> </p>
            </div>
            <div class="student_name">
                <p><span class="boldit">Journal Name </span> : <span v-if="publication_record.jname!=''">{{publication_record.jname}}</span>
                <span v-if="publication_record.jname==null">: Not in a Journal</span>
                </p>
            </div>
            <div class="student_name">
                <p><span class="boldit">Conference Name </span> <span v-if="publication_record.cname!=''">{{publication_record.cname}}</span>
                <span v-if="publication_record.cname==null">:Not presented in a Conference</span>
                
                </p>
            </div>
            <div class="student_name">
                <p><span class="boldit">Team Mates </span> <span v-if="publication_record.teammates!=''">: {{publication_record.teammates}}</span>
                <span v-if="publication_record.teammates==null">: Himself</span>   
                </p>
            </div>
       
       
     </base-dialog>
        <div >
            <table >
                <tr>
                    <td> {{publication_record.name}}</td>
                    <td> {{publication_record.rollNo}}</td>
                    <td class="title_size">  {{publication_record.ptitle}}</td>
                    <td class="m_size"> {{publication_record.teamsize}}</td>
                    <td class="m_size"> {{publication_record.mark}}</td>
                    <td @click="opencloseDialog"> <button class="detailsbutton">Show Details</button> </td>
                </tr>
            </table>


        </div>
        <div>

        </div>
    </div>
</template>


<script>
export default {
    props:['publication_record'],
     data(){
        return{
            showDialog:false,
        };
     },
    methods:{
        opencloseDialog(){
            this.showDialog=!this.showDialog;           
        },
   }
}
</script>


<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Montserrat:wght@500&display=swap');
.title_size{
    width:40%;
}
.m_size{
  width:10%;
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