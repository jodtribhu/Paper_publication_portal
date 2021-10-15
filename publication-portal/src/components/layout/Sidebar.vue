<template>
    
        <div class="sidebar">
            <div class="sidebar_item">
                <div class="sidebar_icon">
                    <i class="fas fa-user-alt"></i>
                </div>
                <div class="sidebar_text">
                     <a href="">Dashboard</a>
                </div>     
            </div>
            <hr>
             <div class="sidebar_item">
                <div class="sidebar_icon">
                     <i class="fas fa-scroll"></i>
                </div>
                <div class="sidebar_text">
                     <a href="">Student Publications</a>
                </div>     
            </div>
            <hr>
            <div class="sidebar_item">
                <div class="sidebar_icon">
                     <i class="far fa-check-circle"></i>
                </div>
                <div class="sidebar_text">
                     <a href="">Approved Publications</a>
                </div>     
            </div>
            <hr>
            <div class="sidebar_item">
                <div class="sidebar_icon">
                     <i class="far fa-times-circle"></i>
                </div>
                <div class="sidebar_text">
                     <a href="">Rejected Publications</a>
                </div>     
            </div>
            <div>                
            </div>
            
        </div>
  
</template>

<script>
export default {
    
}
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Noto+Sans+Mono:wght@200&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Montserrat:wght@500&display=swap');
.sidebar{
    width:100%;
    height:65%;
    background-color:#6d1a2e;
    border-radius: 0px 24px 24px 0px;
}
.sidebar_item{
    
    padding:10px;
}
.sidebar_icon{
    font-size:200%;
    text-align:center;
}
.sidebar_text{
    font-size:1.2em;
    text-align:center;
}
a{
    text-decoration: none;
    color:rgb(136, 127, 127);
    font-family: 'Montserrat', sans-serif;
  
}
.fa-user-alt{
    color:wheat;
    padding-top:12px;
}
.fa-scroll{
    color:wheat;
}
.fa-check-circle{
    color:green;
}
.fa-times-circle{
    color:red;
}
</style>