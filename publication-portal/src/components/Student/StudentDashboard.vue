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
                        <p class="each_item_label">Mobile Number:</p>
                        <p  class="each_item_answer"> {{student.phoneno}}</p>
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

export default {
    data(){
        return{
            student:{},
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
         }
        
    },
    methods:{
        async loadeachstudent(){
              await this.$store.dispatch("loadstudent");
              this.student= this.$store.getters.getLoggedInStudent;
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
</style>