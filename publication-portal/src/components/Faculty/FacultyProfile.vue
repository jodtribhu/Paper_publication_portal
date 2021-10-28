<template>
<div class="margin">
    <dashboard-card >
    <div class="card container_flex">
        <div >
            <div class="each_item"> 
                <p class="each_item_label">Name:</p>
                <p class="each_item_answer"> {{faculty.name}}</p>
            </div>
            <div  class="each_item"> 
                <p class="each_item_label">Faculty ID Number:</p>
                <p  class="each_item_answer"> {{faculty.IDNO}}</p>
            </div>
            <div  class="each_item"> 
                <p class="each_item_label">Campus:</p>
                <p  class="each_item_answer"> {{faculty.campus}}</p>
            </div>
        </div>

        <div>
            <div  class="each_item"> 
                <p class="each_item_label">Department:</p>
                <p  class="each_item_answer"> {{faculty.department}}</p>
            </div>
            <div  class="each_item"> 
                <p class="each_item_label">Designation:</p>
                <p  class="each_item_answer"> {{faculty.designation}}</p>
            </div>
            <div  class="each_item"> 
                <p class="each_item_label">Email:</p>
                <p  class="each_item_answer"> {{faculty.email}}</p>
            </div>
            <div  class="each_item"> 
                <p class="each_item_label">Mobile:</p>
                <p  class="each_item_answer"> {{faculty.phoneNO}}</p>
            </div>
        </div>

    </div>

    </dashboard-card>
</div>

</template>

<script>
export default {
    props:['faculty'],
}
</script>
<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Montserrat:wght@500&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Lato&display=swap');

.card{
    background-color:rgba(143, 160, 165, 0.781);
    border-radius: 0 24px 24px 24px;
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
</style>