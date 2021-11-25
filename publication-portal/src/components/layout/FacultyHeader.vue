<template>
    <header class="flex-gap">
        <nav>
            <h1>
              <div class="logo_container">
                <img class="logo" :src="require(`../../assets/images/amrita-logo.png`)" alt="">
                <router-link to="/" class="logo_text"> Amrita Paper Publication Portal </router-link>
              </div>

            </h1>
            <ul>
                <li v-if=" userId=='' " ><router-link to="/login">Login</router-link></li>
                <li v-if=" userId!='' "><router-link to="/login" @click="logout()">Logout</router-link></li>
            </ul>
        </nav>
    </header>
</template>


<script>

export default {
  data(){
    return {userId:''}
  },
  created(){
   this.userId=localStorage.getItem("userId");
  },
  methods:{
    logout(){
      this.$store.dispatch('logout');
      this.$router.replace('/login');
    }
  }
}
</script>
<style scoped>

@import url('https://fonts.googleapis.com/css2?family=Montserrat:wght@500&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Noto+Sans+Mono:wght@200&display=swap');
.logo_container{
  display:flex;

}
.logo{
 height:4rem;
}
.logo_text{
  color:white;
  font-family: 'Noto Sans Mono', monospace;
  font-weight: normal;
  padding-left: 2rem;
}


header {
  width: 100%;
  height: 4.6rem;
  background-color: #a4123f;
  display: flex;

  font-family: 'Montserrat', sans-serif;
  justify-content: center;
  align-items: center;
}

header a {
  text-decoration: none;
  color: #d8b0a0;
  display: inline-block;
  padding: 0.75rem 0.5rem;
  border: 1px solid transparent;
}

a:active,
a:hover,
a.router-link-active {
  border: 1px solid #c9a293;
}

h1 {
  margin: 0;
}

h1 a {
  color: #fb743e;
  margin: 0;
}

h1 a:hover,
h1 a:active,
h1 a.router-link-active {
  border-color: transparent;
}

header nav {
  width: 95%;
  margin: auto;
  display: flex;
  justify-content: space-between;
  align-items: center;
}

header ul {
  list-style: none;
  margin: 0;
  padding: 0;
  display: flex;
  justify-content: center;
  align-items: center;
}

li {
  margin: 0 0.5rem;
}
</style>