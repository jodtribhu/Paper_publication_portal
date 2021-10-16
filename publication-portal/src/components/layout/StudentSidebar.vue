<template>
    
        <div class="sidebar">
            <div :class="{ 'shadow1' : tabbed_view === 'Dashboard'}"  @click="executeDashboard()" class="sidebar_item tab1">
                <div class="sidebar_icon">
                    <i class="fas fa-user-graduate"></i>
                </div>
                <div class="sidebar_text">
                     <p >Dashboard</p>
                </div>     
            </div>
            <hr>
             <div :class="{ 'shadow2' : tabbed_view === 'Publication'}" @click="executePublication()" class="sidebar_item tab2">
                <div class="sidebar_icon">
                     <i class="fas fa-scroll"></i>
                </div>
                <div class="sidebar_text">
                     <p >My Publications</p>
                </div>     
            </div>    
            <hr>
             <div :class="{ 'shadow3' : tabbed_view === 'Form'}" @click="executeForm()" class="sidebar_item tab3">
                <div class="sidebar_icon">
                    <i class="fab fa-wpforms"></i>
                </div>
                <div class="sidebar_text">
                     <p >Student Form</p>
                </div>     
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
        executeForm(){
             this.$emit('messageFromChild','Form')
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
    min-height:30%;
    background-color:#21213f;
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
.fa-user-graduate{
    color:wheat;
    padding-top:1rem;
}
.fa-scroll{
    color:wheat;
}
.fa-wpforms{
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
     background-color:#393446c0;
      border-radius: 0px 24px 0 0px;
}
.tab3:hover{
     background-color:#393446c0;
     border-radius: 0px 0px 24px 0px;
}
.tab2:hover{
     background-color:#393446c0;
     border-radius: 0px 0px 0px 0px;
}

.shadow1{
     background-color:#352f30c0;
      border-radius: 0px 24px 0 0px;
}
.shadow3{
     background-color:#352f30c0;
     border-radius: 0px 0px 24px 0px;
}
.shadow2{
     background-color:#352f30c0;
     border-radius: 0px 0px 0px 0px;
}

</style>