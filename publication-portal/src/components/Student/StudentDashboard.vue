<template>
    <div>
        <student-card>
            <h1>Dashboard</h1>
             <div class="card container_flex">
                <div >
                    <div class="each_item"> 
                        <p class="each_item_label">Name:</p>
                        <p class="each_item_answer"> Sample Name</p>
                    </div>
                    <div  class="each_item"> 
                        <p class="each_item_label">Student Roll Number:</p>
                        <p  class="each_item_answer"> Sample Student  Roll</p>
                    </div>
                    <div  class="each_item"> 
                        <p class="each_item_label">Gender:</p>
                        <p  class="each_item_answer"> Sample Gender</p>
                    </div>
                    <div  class="each_item"> 
                        <p class="each_item_label">Campus:</p>
                        <p  class="each_item_answer"> Sample Campus</p>
                    </div>
                </div>

                <div>
                    <div  class="each_item"> 
                        <p class="each_item_label">Department:</p>
                        <p  class="each_item_answer"> Sample Department</p>
                    </div>
                    <!-- <div  class="each_item"> 
                        <p class="each_item_label">Designation:</p>
                        <p  class="each_item_answer"> Sample Designation</p>
                    </div> -->
                    <div  class="each_item"> 
                        <p class="each_item_label">Email:</p>
                        <p  class="each_item_answer"> Sample Email</p>
                    </div>
                    <div  class="each_item"> 
                        <p class="each_item_label">Mobile:</p>
                        <p  class="each_item_answer"> Sample Mobile</p>
                    </div>
                </div>

                </div>

                <div class="card next_spacing">


                    <div class="container_top" >
                        <div class="container">
                                <div class="container-items1"><p class="block">10</p> <p class="block">  Accepted Publications </p> </div>
                                <div class="container-items2"><p class="block">2</p><p class="block"> Rejected Publications </p></div>
                                <div class="container-items3"><p class="block">4</p><p class="block"> Pending Publications </p></div>
                                <div class="container-items4"><p class="block">16</p><p class="block"> Total Publications</p> </div>
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
            publicationchartOptions: {
                            chart: {fontFamily: 'Montserrat, sans-serif'},
                            colors:['#17780e','#9e5105','#78150e'],
                            stroke: {
                                    width:0
                                },
                            dataLabels: {
                                    style: {
                                        colors: ['#e6e6e6'] }
                                },
                            labels:['Accepted','Pending','Rejected']
                        },

            publicationseries: [10,4,2], 
        }
    }
}
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Montserrat:wght@500&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Lato&display=swap');
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
    background-color:rgb(179, 174, 174);
    border-radius: 24px 0 0 0;
    align-items: center;
}
.container-items2{
    display: flex;
    width:100%;
    border-left:2px solid rgb(70, 69, 69);
     background-color:rgb(179, 174, 174);
    justify-content: center;
    
    align-items: center;
}
.container-items3{
    display: flex;
    width:100%;
    border-left:2px solid rgb(70, 69, 69);
     background-color:rgb(179, 174, 174);
    justify-content: center;
    
    align-items: center;
}
.container-items4{
    display: flex;
    width:100%;
    border-left:2px solid rgb(70, 69, 69);
    background-color:rgb(179, 174, 174);
    justify-content: center;
    border-radius: 0 24px 0 0;
    
    align-items: center;
}
.pcard {
  margin:auto;
  border-radius: 0 0 12px 12px;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.26);
  padding: 1rem;
  margin-bottom: 20px;
  background-color: transparent;
  width: 100%;
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