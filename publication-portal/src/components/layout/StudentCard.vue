<template>
    <div class="card">
        <slot></slot>
    </div>
</template>


<style scoped>
.card {
  position: relative;
  border-radius: 12px;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.26);
  padding: 1rem;
  margin: 2rem auto;
 background-color:rgba(143, 160, 165, 0.781);
  max-width: 90%;
  overflow: hidden; 
}

</style>