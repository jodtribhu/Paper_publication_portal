<template>
    <div>
      <the-header></the-header>
      
        <div class="box">
            <h1>Login</h1>

            <div class="input-block">
              <input type="email"  name="input-text" id="input-text"  v-model="email" placeholder="Email" required>
              <span class="placeholder"> Email </span>
            </div>
    
            <div class="input-block">
              <input type="password"  name="input-text" id="input-text"  v-model="password" placeholder="Password" required>
              <span class="placeholder"> Password </span>
            </div>
                
              
            <div>
              <p class="error" v-if="error!=''">{{error}}</p>
            </div>

            <button v-if="incorrect_login" @click="login">Login</button>

             <p class="forgotpassword" @click="forgotpassword">Forgot Password </p>
        </div>       
    </div>
</template>

<script>
  import RegisterService from '@/services/RegistrationService.js';
  export default {
      data(){
          return{
              email:'',
              password:'',
              error:'',
              incorrect_login:true,
              nooftimes:0
          };
      },
      methods:{
        forgotpassword(){
          this.$router.push("/ForgotPassword")
        },
      async login(){    
          const response=await RegisterService.login({uname:this.email,password:this.password})          
          if(response.data.logged_in==true){
            await this.$store.dispatch("setUser",response.data);
          }
          
        var isAdmin= localStorage.getItem("isAdmin");
        var isFaculty=localStorage.getItem("isFaculty");
        if(isAdmin=="Yes"){
          this.$router.push({path: '/admin'});
        }
        else if(isFaculty=="Yes"){
          this.$router.push({path: '/faculty'});
        }
        else if(isFaculty=="No"){
          this.$router.push({path: '/student'});
        }
      },
    }
  }
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Noto+Sans+Mono:wght@200&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Montserrat:wght@500&display=swap');
.box input[type = "email"],.box input[type = "password"]{
  background: none;
  display: block;
  margin: 20px auto;
  text-align: center;
  border: 2px solid #876a27;
  padding: 14px 10px;
  width: 200px;
  outline: none;
  border-radius: 4px;
}

div.input-block {
  position: relative;
}
div.input-block input {
  font-weight: 500;
  font-size: 1rem;
  
}
div.input-block span.placeholder {
  position: absolute;
  margin-left:25%;
  padding: 0 4px;
  font-family: 'Montserrat', sans-serif;
  color:rgba(255, 255, 255, 0);
  display: flex;
  align-items: center;
  font-size: 1rem;
  top: 1rem;
  left: 4.2rem;
  transition: all 0.2s;
  transform-origin: 0% 0%;
  background: none;
  pointer-events: none;
}


div.input-block input:valid + span.placeholder,
div.input-block input:focus + span.placeholder {
  transform: scale(0.8) translateY(-1.8rem) translateX(-7.5rem);
  background: #872744;
}

div.input-block input:focus + span.placeholder {
  color: wheat;
}

div.input-block input:valid + span.placeholder{
   color: rgba(245, 222, 179, 0.014);
   background-color: transparent;
}

.error{
    color: #a75864;
}
.box{
  border-radius: 5%;
  width: 300px;
  padding: 20px;
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%,-50%);
  background: #872744;
  text-align: center;
}
.box h1{
  color: white;
  text-transform: uppercase;
  font-family: 'Noto Sans Mono', monospace;
  font-weight: normal;
  
}
input{
  color:white;
  font-family: 'Montserrat', sans-serif;
}

.forgotpassword{
  color: rgba(192, 175, 175, 0.671);
}


.box button{
  font-family: 'Montserrat', sans-serif;
  background: none;
  display: block;
  margin: 20px auto;
  text-align: center;
  padding: 14px 40px;
  outline: none;
  color:white;
  background: #6e3647;
  border-radius: 24px;
  transition: 0.25s;
  cursor: pointer;
}

</style>