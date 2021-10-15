<template>
    <div class="card">
        <slot></slot>
    </div>
</template>


<style scoped>
.card {
  position: relative;
  border-radius: 0 24px 24px 24px;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.26);
  padding: 0;
  margin: 0 auto;
  background-color: #f6f6f6;
  max-width: 90%;
}

</style>