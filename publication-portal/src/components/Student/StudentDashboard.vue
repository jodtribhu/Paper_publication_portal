<template>
    <div class="margin_Correct">
        <student-card>
            <h1>Dashboard</h1>
             <div class="card container_flex">
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

                <div>
                    <div  class="each_item"> 
                        <p class="each_item_label">Department:</p>
                        <p  class="each_item_answer">{{student.department}}</p>
                    </div>
                    <div  class="each_item"> 
                        <p class="each_item_label">Grace Marks:</p>
                        <p  class="each_item_answer"> {{student.graceMarks}}</p>
                    </div>
                    <div  class="each_item"> 
                        <p class="each_item_label">Email:</p>
                        <p  class="each_item_answer"> {{student.email}}</p>
                    </div>
                    <div  class="each_item"> 
                        <p class="each_item_label">Mobile:</p>
                        <p  class="each_item_answer"> {{student.phoneNO}}</p>
                    </div>
                </div>


                </div>

                <div class="card next_spacing">


                    <div class="container_top" >
                        <div class="container">
                               
                                <div class="container-items1"><p class="block">{{publication_count.accepted}}</p> <p class="block">  Accepted Publications </p> </div>
                                <div class="container-items2"><p class="block">{{publication_count.rejected}}</p><p class="block"> Rejected Publications </p></div>
                                <div class="container-items3"><p class="block">{{publication_count.pending}}</p><p class="block"> Pending Publications </p></div>
                                <div class="container-items4"><p class="block">{{publication_count.total}}</p><p class="block"> Total Publications</p> </div>
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
import GetEach from '@/services/GetEach.js';

import EachStudentPublication from '@/services/EachStudentPublication.js';
export default {
    data(){
        return{
            student:{},
            publication_count:{},
            publicationchartOptions: {
                            chart: {fontFamily: 'Montserrat, sans-serif'},
                            colors:['#13a608','#ff9a1f','#f72027'],
                            stroke: {
                                    width:0
                                },
                            dataLabels: {
                                    style: {
                                        colors: ['#e6e6e6'] }
                                },
                            labels:['Accepted','Pending','Rejected']
                        },

            publicationseries: [], 
        }
    },
    created(){
        this.loadeachstudent();
        this.loadthePublications();
    },
    methods:{
        async loadeachstudent(){
              const response =await GetEach.getEachStudent();
              this.student=response.data;
          },
        async loadthePublications(){
            const response =await EachStudentPublication.getEachStudentPublciation();
            console.log("IN "+response.data.publications[0].title);
            this.pending_publication = response.data.publications.filter(function (e) {
                        return e.p_status =="Pending";
            });

            console.log("All pending "+this.pending_publication[0].title );
            this.accepted_publication = response.data.publications.filter(function (e) {
                        return e.p_status=="Accepted";
            });
            this.rejected_publication = response.data.publications.filter(function (e) {
                        return e.p_status=="Rejected";
            });
            var total=this.pending_publication.length+this.accepted_publication.length+this.rejected_publication.length;
            this.publication_count={'pending':this.pending_publication.length,'accepted':this.accepted_publication.length,'rejected':this.rejected_publication.length,'total':total}
            var listArray = []
            listArray.push(this.accepted_publication.length)
            listArray.push(this.pending_publication.length)
            listArray.push(this.rejected_publication.length)

            this.publicationseries=listArray;
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
h1{
    text-align: center;
    font-family: 'Montserrat', sans-serif;
     font-weight: bold;

}
.card{
    background-color:rgba(129, 145, 150, 0.822);
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
.block{
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
    
    width: 80%;
    display: flex;
    justify-content: space-around;
    align-items: center;
    
}
</style>