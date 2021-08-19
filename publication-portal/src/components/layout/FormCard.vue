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
  background-color: rgba(231, 231, 233, 0.966);
  margin:auto;
  
  width: 90%;
  min-height: 90vh;
}

</style>