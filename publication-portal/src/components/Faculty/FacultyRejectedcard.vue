<template>
    <div class='paper'>   
    <base-dialog :show=showDialog class="dialogbox " title=" Additional Details" @close="opencloseDialog" >
            <div class="student_name">
                <p> <span class="boldit">Student Email :</span>   <span>{{rj_publication.email}}</span> </p>
            </div>
            <div class="student_name">
                <p> <span class="boldit">Student Roll Number :</span>   <span>{{rj_publication.rollNo}}</span> </p>
            </div>
            <div class="student_name">
                <p> <span class="boldit">Student Phone Number :</span>  <span>{{rj_publication.phoneno}}</span> </p>
            </div>
            <div class="student_name">
                <p> <span class="boldit">Publication Link :</span>  <span><a :href="rj_publication.link">Click Here</a></span> </p>
            </div>
            <div class="student_name" v-if="rj_publication.jname!=0">
                <p><span class="boldit">Journal Name :</span>  <span >{{rj_publication.jname}}</span>
                <span v-if="rj_publication.jname==0">: Not in a Journal</span>
                </p>
            </div>
            <div class="student_name"  v-if="rj_publication.cname!=0">
                <p><span class="boldit">Conference Name : </span> <span>{{rj_publication.cname}}</span>
                <span v-if="rj_publication.cname==0">:Not presented in a Conference</span>
                </p>
            </div>
            <div class="student_name">
                <p> <span class="boldit">Scopus Indexed :</span>  <span>{{rj_publication.scp_index}} </span> </p>
            </div>
            <div class="student_name">
                <p> <span class="boldit">Remarks:</span>  <span>{{rj_publication.remarks}} </span> </p>
            </div>
            
            
            <div class="student_name" v-if="getTemsize(rj_publication.team)>0">
                <p><span class="boldit">Team  : </span> 
                <span v-for="(member,index)  in rj_publication.team" :key="member.mate_id" > <span v-if="index!=0"> , </span> {{member.mate_name}}  </span>
                </p>
            </div>

     </base-dialog>


         <div class="stuinfo">
            <p class="title">{{rj_publication.title}}</p>
            <div class="container_name">    
                <div class="stu_info_child">
                    <p class="constsize_title ">Student Name : </p>
                    <p class="constsize_title2 ">{{rj_publication.name}}</p>
                </div>
                <i @click="toggleButton()" class="far fa-caret-square-down"></i>
            </div>
        </div>
        
        <div v-if="isActive==true">
        <hr class="line">
             <div>        
                <div class="flex-ele ">
                    <p class="constsize"><span class="centeralign">Roll Number:</span></p>
                    <p class="ele_result constsize2">{{rj_publication.rollNo}}</p>
                </div>
            </div>
            <div class="flex-ele ">
                <p class="constsize"><span class="centeralign">Eligibility:</span></p>
                <p v-if="rj_publication.is_eligible_dist=='Yes'" class="eli_result constsize2">Distinction</p>
                <p v-if="rj_publication.is_eligible_grace=='Yes'" class="eli_result constsize2">Grace Marks</p>
            </div>
            <div class="flex-ele ">
                <p class="constsize"><span class="centeralign">Grace Marks:</span></p>
                <p class="gra_result constsize2">{{rj_publication.marks}}</p>
            </div>
            <button class="button"  @click="openPDF(rj_publication.link)">Open PDF</button>   
            <button class="button" @click="undo(rj_publication.SP_ID,rj_publication.PF_ID)">Undo</button>      
            <button class="button" @click="opencloseDialog"> View Details</button>             
        </div>
    </div>
</template>

<script>
import EachFacultyPublication from '@/services/EachFacultyPublication';
export default {
    props:['rj_publication'],
    data(){
        return{
            isActive:false,
            showDialog:false,
        }
    },
    methods:{
        toggleButton(){
            this.isActive=!this.isActive;
        },
        openPDF(link){
                window.open(link, "_blank");
          },

        async undo(SP_ID,PF_ID){
           await EachFacultyPublication.undo({SP_ID:SP_ID,PF_ID:PF_ID}) 
           this.$emit("refreshpublication")
        },
        opencloseDialog(){
            this.showDialog=!this.showDialog;           
        },
        getTemsize(teamarray){
            return teamarray.length
        },
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
    border-color: #920404;
    background-color: white;
    border-radius: 15px;
    height:max-content;
    width:80%;
    text-align: center;
    padding-bottom: 10px;
    margin:auto;
    margin-bottom:2rem;
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
.boldit{
    font-size:1.12rem;
    font-weight: bold;
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
.gra_result{
    color:blue;
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
</style>