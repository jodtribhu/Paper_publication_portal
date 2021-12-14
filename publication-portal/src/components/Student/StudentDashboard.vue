<template>
    <div class="margin_Correct">
        <base-dialog :show=showPasswordDialog  title="Edit Password" @close="openclosePasswordDialog">
        
        <div class="input_cont">
            <div class="each_input">
                <label class="input_label">Enter new Password:</label>
                <input class="input_text" v-model="editpass" type="text" >
            </div>
            <button class="button" @click="updatePassword()">Edit</button>
        </div>

     </base-dialog> 

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
                    <label class="input_label" for="">Gender:</label>
                    <input class="input_text" v-model="editgender" type="text" >
                </div>
                <div class="each_input">
                    <label class="input_label" for="">Campus:</label>
                    <input class="input_text" v-model="editcampus"  type="text" >
                </div>
                <div class="each_input">
                    <label class="input_label" for="">Mobile Number:</label>
                    <input class="input_text" type="text" v-model="editmobile"  >
                </div>
                <button class="button" @click="editStudent()">Edit</button>
            </div>
        </base-dialog>  



        <student-card>
            <h1>Dashboard</h1>
             <div class="card container_flex">
                <div class="edit" @click="opencloseDialog">
                    <i class="far fa-edit"></i>
                </div>
                <div >
                    <div class="each_item"> 
                        <p class="each_item_label">Name:</p>
                        <p class="each_item_answer"> {{student.name}}</p>
                    </div>
                    <div  class="each_item"> 
                        <p class="each_item_label">Student Roll Number:</p>
                        <p  class="each_item_answer"> {{student.rollNo}}</p>
                    </div>
                    <div  class="each_item"> 
                        <p class="each_item_label">Gender:</p>
                        <p  class="each_item_answer"> {{student.sex}}</p>
                    </div>
                    <div  class="each_item"> 
                        <p class="each_item_label">Campus:</p>
                        <p  class="each_item_answer"> {{student.campus}}</p>
                    </div>

                </div>

                <div class="container_flex_item">
                    <div  class="each_item"> 
                        <p class="each_item_label">Department:</p>
                        <p  class="each_item_answer">{{student.department}}</p>
                    </div>

                    <div  class="each_item"> 
                        <p class="each_item_label">Email:</p>
                        <p  class="each_item_answer"> {{student.email}}</p>
                    </div>
                    <div  class="each_item"> 
                        <p class="each_item_label">Mobile Number:</p>
                        <p  class="each_item_answer"> {{student.phoneno}}</p>
                    </div>
                    <div  class="each_item"> 
                        <p class="each_item_label" >Edit Password:</p>
                        <button @click="openclosePasswordDialog()" class="button2">Update</button>
                    </div>
                </div>


                </div>

                <div class="card next_spacing">


                    <div class="container_top" >
                        <div class="container">
                               
                                <div class="container-items1"><div class="elem">   <p class="block">  Pending Publications: </p> <p class="block color">{{publication_count.pending  }}</p></div></div>
                                <div class="container-items2"><div class="elem">   <p class="block">  Claimed Publications: </p> <p class="block color">{{publication_count.claimed  }}</p> </div></div>
                                <div class="container-items3"><div class="elem">  <p class="block"> Accepted Publications: </p> <p class="block color">{{publication_count.accepted }}</p></div></div>
                                <div class="container-items4"><div class="elem"> <p class="block"> Rejected Publications: </p>  <p class="block color">{{publication_count.rejected}}</p></div></div>
                                <div class="container-items5"><div class="elem">  <p class="block"> Total Publications: </p> <p class="block color">{{publication_count.total}}</p> </div></div>
                        </div>            
                        <div class="pcard">
                            <div>
                                <div class="centergraph">
                                    <h3 class="h3_heading">Publication Stastics</h3>
                                    <apexchart width="380" type="donut" :options="publicationchartOptions" :series="publicationseries"></apexchart>
                                </div>
                            </div>
                        </div>
                    </div>  


                </div>
        </student-card>

    </div>
</template>

<script>
import RegisterService from '@/services/RegistrationService.js';
import GetEach from '@/services/GetEach';
export default {
    data(){
        return{
            student:{},
            editname:'',
            editroll:'',
            editdept:'',
            editgender:'',
            editcampus:'',
            editmobile:'',
            editemail:'',
            showDialog:false,
            showPasswordDialog:false,
            editpass:'',
            publication_count:{},
            publicationchartOptions: {
                            chart: {fontFamily: 'Montserrat, sans-serif'},
                            colors:['#13a608','#ff9a1f','#4e6321','#f72027'],
                            stroke: {
                                    width:0
                                },
                            dataLabels: {
                                    style: {
                                        colors: ['#e6e6e6'] }
                                },
                            labels:['Accepted','Pending','Claimed','Rejected']
                        },

            publicationseries: [], 
        }
    },
    created(){
         if(this.$store.getters.checkStudent)
         {
               this.loadeachstudent(); 
               this.loadthePublications();
         }
         else{
                this.student= this.$store.getters.getLoggedInStudent;
                this.publication_count={'pending':this.$store.getters.getPendingPublication.length,
                'claimed':this.$store.getters.getClaimedPublication.length,
                'accepted':this.$store.getters.getAcceptedPublication.length,
                'rejected':this.$store.getters.getRejectedPublication.length,
                'total':this.$store.getters.getTotal}
                var listArray = []
                listArray.push(this.$store.getters.getAcceptedPublication.length)
                listArray.push(this.$store.getters.getPendingPublication.length)
                listArray.push(this.$store.getters.getClaimedPublication.length)
                listArray.push(this.$store.getters.getRejectedPublication.length)
                this.publicationseries=listArray;
                this.editname=this.student.name
                this.editroll=this.student.rollNo
                this.editdept=this.student.department
                this.editgender=this.student.sex
                this.editcampus=this.student.campus
                this.editmobile=this.student.phoneno
                this.editemail=this.student.email
         }

        
    },
    methods:{
        opencloseDialog(){
             this.showDialog=!this.showDialog;  
        },  
        async updatePassword(){
            this.showPasswordDialog=!this.showPasswordDialog;
            await RegisterService.changePassword({'username':this.student.rollNo,'pass':this.editpass});
            this.editpass=''
        },
        openclosePasswordDialog(){
            this.showPasswordDialog=!this.showPasswordDialog;
        },
        async loadeachstudent(){
              await this.$store.dispatch("loadstudent");
              this.student= this.$store.getters.getLoggedInStudent;
                this.editname=this.student.name
                this.editroll=this.student.rollNo
                this.editdept=this.student.department
                this.editgender=this.student.sex
                this.editcampus=this.student.campus
                this.editmobile=this.student.phoneno
                this.editemail=this.student.email
          },
        async loadthePublications(){
            await this.$store.dispatch("loadpublication");
            this.publication_count={'pending':this.$store.getters.getPendingPublication.length,
            'accepted':this.$store.getters.getAcceptedPublication.length,
            'claimed':this.$store.getters.getClaimedPublication.length,
            'rejected':this.$store.getters.getRejectedPublication.length,
            'total':this.$store.getters.getTotal}
            var listArray = []
            listArray.push(this.$store.getters.getAcceptedPublication.length)
            listArray.push(this.$store.getters.getPendingPublication.length)
            listArray.push(this.$store.getters.getClaimedPublication.length)
            listArray.push(this.$store.getters.getRejectedPublication.length)
            this.publicationseries=listArray;
        },
        async editStudent(){
            this.showDialog=!this.showDialog;  
            await GetEach.editEachStudent({"s_id":this.student.sID,"editname":this.editname,"editroll":this.editroll,
            "editdept":this.editdept,"editgender":this.editgender,"editcampus":this.editcampus,"editmobile":this.editmobile,"editemail":this.editemail})
            await this.loadeachstudent();
        }
    }
}
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Montserrat:wght@500&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Lato&display=swap');
.margin_Correct{
    margin-bottom: 2rem;
    overflow: hidden;
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

.container_flex_item{
    width:38%;
}
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
.edit{
    position:absolute;
    right:1rem;
    top:1rem;
    font-size:1.5rem;
}
h1{
    text-align: center;
    font-family: 'Montserrat', sans-serif;
     font-weight: bold;

}
.card{
    background-color:rgba(129, 145, 150, 0.822);
    position: relative;
    border-radius: 24px 24px 24px 24px;
}
.next_spacing{
    margin-top:2rem;
}
.container_flex{
    padding-top:2rem;
    padding-bottom:2rem;
    padding-left:4rem;
    padding-right:4rem;
    display: flex;
    justify-content:space-between;
}
.each_item{
    display: flex;
    
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



/*graph*/

.container_top{
    padding-top: 2rem;
}
.elem{
    min-height:4rem;
    display: flex;
    text-align: center;
    justify-content:center;
    flex-direction: column;
    width:100%;
    margin:0;
    padding:0;
    
    
}
.block{
    padding-top:0.2rem;
    padding-bottom:0;
    margin:0;
    display: inline-block;
    padding-left:2px;
    font-family: 'Montserrat', sans-serif;     
    font-weight:600; 
     
   
    
}
.container-items1{
    display: flex;
    width:100%;
    justify-content: center;
     background-color:rgb(209, 199, 199);
    
    border-radius: 24px 0 0 0;
    align-items: center;
}
.container-items2{
    display: flex;
    width:100%;
    border-left:2px solid rgb(70, 69, 69);
     background-color:rgb(209, 199, 199);
    justify-content: center;
    
    align-items: center;
}
.container-items3{
    display: flex;
    width:100%;
    border-left:2px solid rgb(70, 69, 69);
      background-color:rgb(209, 199, 199);
    justify-content: center;
    
    align-items: center;
}
.container-items4{
    display: flex;
    width:100%;
    border-left:2px solid rgb(70, 69, 69);
     background-color:rgb(209, 199, 199);
    justify-content: center;
    border-radius: 0 0 0 0;
    
    align-items: center;
}
.container-items5{
    display: flex;
    width:100%;
    border-left:2px solid rgb(70, 69, 69);
     background-color:rgb(209, 199, 199);
    justify-content: center;
    border-radius: 0 24px 0 0;
    
    align-items: center;
}
.pcard {
  margin:auto;
  border-radius: 0 0 12px 12px;
  padding: 1rem;
  background-color: transparent;
  width: 90%;
  display: flex;
  justify-content: center;
}

.centergraph{
    margin:auto;
    display: flex;
    justify-content: center;
    align-items: center;
}
.h3_heading{
        font-family: 'Quicksand', sans-serif;
        text-align: center;
}
.container{
    margin:auto;
    
    width: 90%;
    display: flex;
    justify-content: space-around;
    align-items: center;  
}

.button2{
    width:8rem;
    margin-top:0.6rem;
    margin-left:1rem;
    height:40px;
    background-color: rgb(24, 11, 99);
    font-family: 'Montserrat', sans-serif;
    font-size:1rem;
    border-radius:12px;
    color:rgb(212, 206, 195);
    cursor: pointer;
    border-style:none;
}
.button2:hover{
    background-color: rgba(69, 70, 82, 0.753);
    color:white;
}
</style>