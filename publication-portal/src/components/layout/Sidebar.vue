<template>
    
        <div class="sidebar">
            <div :class="{ 'shadow1' : tabbed_view === 'Dashboard'}"  @click="executeDashboard" class="sidebar_item tab1">
                <div class="sidebar_icon">
                    <i class="fas fa-user-alt"></i>
                </div>
                <div class="sidebar_text">
                     <p >Dashboard</p>
                </div>     
            </div>
            <hr>
             <div :class="{ 'shadow2' : tabbed_view === 'Publication'}" @click="executePublication" class="sidebar_item tab2">
                <div class="sidebar_icon">
                     <i class="fas fa-scroll"></i>
                </div>
                <div class="sidebar_text">
                     <p >Student Publications</p>
                </div>     
            </div>
            <hr>
            <div :class="{ 'shadow3' : tabbed_view === 'Accepted'}"  @click="executeApproved" class="sidebar_item tab3">
                <div class="sidebar_icon">
                     <i class="far fa-check-circle"></i>
                </div>
                <div class="sidebar_text">
                     <p>Approved Publications</p>
                </div>     
            </div>
            <hr>
            <div :class="{ 'shadow4' : tabbed_view === 'Rejected'}"  @click="executeRejected" class="sidebar_item tab4">
                <div class="sidebar_icon">
                     <i class="far fa-times-circle"></i>
                </div>
                <div class="sidebar_text">
                     <p  >Rejected Publications</p>
                </div>     
            </div>
            <div>                
            </div>
            
        </div>
  
</template>

<script>
export default {
        props: ['tabbed_view'],
        methods:{
        executePublication(){
            this.$emit('messageFromChild','Publication')
        },
        executeApproved(){
             this.$emit('messageFromChild','Accepted')
        },
        executeRejected(){
             this.$emit('messageFromChild', 'Rejected')
        },
        executeDashboard(){
             this.$emit('messageFromChild','Dashboard')
        }
    }
}
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Noto+Sans+Mono:wght@200&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Montserrat:wght@500&display=swap');
.sidebar{
    min-width:100%;
    min-height:75%;
    background-color:#6d1a2e;
    border-radius: 0px 24px 24px 0px;
}
.sidebar_item{
    
    padding:8%;
}
.sidebar_icon{
    font-size:200%;
    text-align:center;
}
.sidebar_text{
    font-size:1.12rem;
    text-align:center;
}
p{
    text-decoration: none;
    color:rgb(136, 127, 127);
    font-family: 'Montserrat', sans-serif;
  
}
.fa-user-alt{
    color:wheat;
    padding-top:1rem;
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
hr{
    margin:0;
}
.tab1:hover{
     background-color:#352f30c0;
      border-radius: 0px 24px 0 0px;
}
.tab2:hover{
     background-color:#352f30c0;
     border-radius: 0px 0px 0 0px;
}

.tab3:hover{
     background-color:#352f30c0;
}
.tab4:hover{
     background-color:#352f30c0;
      border-radius: 0px 0px 24px 0px;
}
.shadow1{
     background-color:#352f30c0;
      border-radius: 0px 24px 0 0px;
}
.shadow2{
     background-color:#352f30c0;
     border-radius: 0px 0px 0 0px;
}

.shadow3{
     background-color:#352f30c0;
}
.shadow4{
     background-color:#352f30c0;
      border-radius: 0px 0px 24px 0px;
}
</style>