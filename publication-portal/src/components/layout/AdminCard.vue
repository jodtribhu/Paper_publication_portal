<template>
    <div class="card ">
        <slot></slot>
    </div>
</template>


<style scoped>
.card {
  position: relative;
  border-radius: 0 24px 24px 24px;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.26);
  padding-bottom: 2rem;
  margin-top:0;
  margin-left:3.5rem;
  margin-right:3.5rem;
  margin-bottom:3.5rem;
  background-color: #dbd0d3;
  max-width: 100%;
  border-width:0.4rem 0.4rem 0.4rem 0.4rem;
    border-style: hidden solid solid solid;
    border-color: #6d1a2e;
  background:linear-gradient(to right,transparent 38%,  #6d1a2e 20%) top;
  background-repeat: no-repeat;
  background-size:100% 0.4rem;
   
}


</style>