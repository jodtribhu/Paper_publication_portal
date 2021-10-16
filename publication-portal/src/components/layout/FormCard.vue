<template>
    <div class="f_card">
        <slot></slot>
    </div>
</template>


<style scoped>
.f_card {
  border-radius: 12px;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.26);
  padding: 2rem;
  background-color: rgba(231, 231, 233, 0.966);
  margin:1rem auto 1rem auto;
  border-top: 7px solid rgb(73, 40, 40);
  width: 80%;
  
overflow: hidden;
}

</style>