<template>
<dashboard-card>
    <div class="card">
        <div class="paper_item">
            <p class="paper_item_title">Paper Under Process:</p>
            <p class="paper_item_no"> <span class="yellow"> <span class="center">{{faculty_publication_count.pending}}</span> </span>  </p>
        </div>

        <div class="paper_item"> 
            <p class="paper_item_title">Accepted:</p>
            <p class="paper_item_no"><span class="green"><span class="center">{{faculty_publication_count.accepted}}</span></span></p>
        </div>
        <div class="paper_item">
            <p class="paper_item_title">Rejected:</p>
            <p class="paper_item_no"><span class="red"><span class="center">{{faculty_publication_count.rejected}}</span></span></p>
        </div>

        <div class="paper_item">
            <p class="paper_item_title">Total:</p>
            <p class="paper_item_no"><span class="orange"> <span class="center">{{faculty_publication_count.total}}</span></span></p>
        </div>

    </div>
</dashboard-card>

    
</template>
<script>
export default {
    props:['faculty_publication_count']
}
</script>
<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Montserrat:wght@500&display=swap');
.paper_item{
    display: flex;
    justify-content: space-evenly;
   
}
.card{
    background-color:rgba(143, 160, 165, 0.781);
    border-radius: 0 24px 24px 24px;
}
.paper_item_no{
    width:30%;    
}
.paper_item_title{
    text-align:center;
    width:70%;
    font-family: 'Montserrat', sans-serif;
    font-weight: bold;
    font-size:1.2rem;
    
}
.yellow{
    font-family: 'Montserrat', sans-serif;
    font-weight: bold;
    background-color:rgb(209, 209, 12);
    border-radius:24px;
    display: inline-block;
   
    width:5rem;
    height:2rem;
    text-align:center;

}
.orange{
    font-family: 'Montserrat', sans-serif;
    background-color:orange;
    font-weight: bold;
    border-radius:24px;
    display: inline-block;
    width:5rem;
    height:2rem;
    text-align:center;
}
.green{
    font-family: 'Montserrat', sans-serif;
    background-color:green;
    font-weight: bold;
    border-radius:24px;
    display: inline-block;
    width:5rem;
    height:2rem;
    text-align:center;
}
.red{
    font-family: 'Montserrat', sans-serif;
    background-color:rgb(211, 38, 38);
    font-weight: bold;
    border-radius:24px;
    display: inline-block;
    width:5rem;
    height:2rem;
    text-align:center;
}
.center{
    display: flex;
    margin-top:6%;
    justify-content: center;
    align-items: center;
}
</style>