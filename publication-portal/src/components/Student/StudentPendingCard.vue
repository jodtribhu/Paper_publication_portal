<template>
    <div class='paper'>  
        <base-dialog :show=showDialog  title="Team Mates" @close="opencloseDialog">
            <div>
                <div v-for="member in pendingdetails_team(student.sID)" :key=member.name>
                        <div class="student_name">
                            <p> <span class="boldit">Student Name</span>  : <span>{{member.mate_name}}</span> </p>
                        </div>
                        
                        <div class="student_name">
                            <p> <span class="boldit">Paper Status</span>  : <span>{{getStatus(member.mate_status,member.mate_claimed_status)}}</span> </p>
                        </div>
                        <hr v-if="pendingdetails_team(student.sID).length>1">
                </div>
            </div>
        </base-dialog>  
         <div class="stuinfo">
            <p class="title">{{pendingdetails.title}}</p>
            <div class="container_name">    
                <div class="stu_info_child">
                    <p class="constsize_title ">Student Name : </p>
                    <p class="constsize_title2 "> {{student.name}}</p>
                </div>
                <i @click="toggleButton()" class="far fa-caret-square-down"></i>
            </div>
        </div>
        
        <div v-if="isActive==true">
        <hr class="line">
             <div>        
                <div class="flex-ele ">
                    <p class="constsize"><span class="centeralign">Roll Number:</span></p>
                    <p class="ele_result constsize2">{{student.rollNo}}</p>
                </div>
            </div>
            <div class="flex-ele ">
                <p class="constsize"><span class="centeralign">Eligibility:</span></p>
                <p v-if="pendingdetails.is_eligible_dist=='Yes'" class="eli_result constsize2">Distinction</p>
                <p v-if="pendingdetails.is_eligible_grace=='Yes'" class="eli_result constsize2">Grace Marks</p>
            </div>
            <div class="flex-ele ">
                <p class="constsize"><span class="centeralign">Submitted On:</span></p>
                <p class="gra_result constsize2">{{pendingdetails.s_date}}</p>
            </div>
            <button class="button" @click="claimPublication(pendingdetails.sp_id)">Claim</button>   
            <button class="button" @click="openPDF(pendingdetails.link)">Open PDF</button>  
            <button class="button" @click="opencloseDialog()" v-if="pendingdetails_team(student.sID).length>0">Team Status</button>                  
        </div>
    </div>
</template>

<script>
import EachStudentPublication from '@/services/EachStudentPublication.js';
export default {
    
    props:['pendingdetails','student'],
    data(){
        return{
            isActive:false,
            showDialog:false,
        }
    },
    methods:{
        toggleButton(){
            this.isActive=!this.isActive; console.log(this.pendingdetails);
        },
        openPDF(link){
            console.log(link);
                window.open(link, "_blank");
          },
        async claimPublication(sp_id){
            console.log("inside refresh 0");
            await EachStudentPublication.claimPublication({"sp_id":sp_id,"value":1});
            this.$emit('claimedit');
        
          },

        opencloseDialog(){
             this.showDialog=!this.showDialog;  
        },  
        pendingdetails_team(id){
          var team2=this.pendingdetails.team.filter(function (e) {
                    return e.mate_id != id;
        });
        
            return team2;
        },
        getStatus(status,c_status){
            if(status=="Pending" && c_status=="Yes"){
                return "Claimed"
            }
            else if(status=="Pending" && c_status=="No"){
                return "Claimed"
            }
            else{
                return status;
            }              
        }
    }
}
</script>

<style scoped>
.fa-caret-square-down{
    font-size: 2rem;
    padding:1.5rem 1rem 1rem 2rem;
}
.container_name{
    display: flex;
    justify-content: flex-end;
}
.paper{
    border:0.15rem solid ;
    border-color: #754207;
    background-color: white;
    border-radius: 15px;
    height:max-content;
    width:80%;
    text-align: center;
    padding-bottom: 10px;
    margin:auto;
    margin-bottom:2rem;
}
.boldit{
    font-weight: bold;
    font-size:1.2rem;
}
.title{
    font-family: 'Montserrat', sans-serif;
    font-weight: bold;
    font-size: 1.2rem;
    padding:10px 0px 0px 20px;
    text-align: center;
    max-width:430px;
}
.constsize_title{
    font-family: 'Montserrat', sans-serif;
    font-weight: bold;
     font-size: 1.2rem;
    padding:10px 0px 0px 20px;
    text-align: center;
    max-width:100%;
}
.constsize_title2{
    font-family: 'Montserrat', sans-serif;
    padding:10px 0px 0px 20px;
     font-size: 1.2rem;
    text-align: center;
    max-width:100%;
}
.line{
    width:80%
}


.intro{
    display:flex;
    justify-content: space-around;
}
.flex-ele{
    display:flex;
    justify-content:space-around    ;
    max-height: 30px;
    align-items:center;
    font-size: 20px;
    width: 100%;
    margin:auto;
}
.ele_result{
    color:black;
}
.stuinfo{
    display:flex;
    width: 100%;
    justify-content: space-between;
    margin-right: 3rem;
}
.stu_info_child{
    display:flex;
}
.eli_result{
    color:green;
}

.centeralign{
    text-align: left;
    width: 45%;
    display: inline-block;
}
.constsize{
        font-family: 'Montserrat', sans-serif;
    font-weight: bold;
    display: flex;
    justify-content: flex-end;
    width:50%;
}
.constsize2{
      font-family: 'Montserrat', sans-serif;
    width:50%;
    text-align: left;
}
.button{
    margin-top: 25px;
    margin-left:1rem;
    margin-right:1rem;
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

.button2{
    margin-top: 25px;
    width:8rem;
    height:40px;
    background-color: rgb(24, 11, 99);
    font-family: 'Montserrat', sans-serif;
    font-size:1rem;
    border-radius:12px;
    color:rgb(212, 206, 195);
    cursor: pointer;
    border-style:none;
    margin-left:0.2rem;
}
.button2:hover{
    background-color: rgba(69, 70, 82, 0.753);
    color:white;
}
</style>