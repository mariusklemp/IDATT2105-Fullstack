<template>
  <h2>This page have no backend!!!</h2>
  <div class="form-container">
    <form @submit="registerUser()">
      <h3 data-testid="registrationText">Please register!</h3>
      <div>
        <BaseInput
          data-testid="firstnameReg"
          v-model="user.firstname"
          label="FirstName"
          type="text"
        />
        <p>and</p>
        <BaseInput
          data-testid="lastnameReg"
          v-model="user.lastname"
          label="LastName"
          type="text"
        />
        <p>Please write your email, which will be your username</p>
        <BaseInput
          data-testid="emailReg"
          v-model="user.email"
          label="Email"
          type="text"
        />
        <p>Write a strong password</p>
        <BaseInput
          data-testid="passwordReg"
          v-model="user.password"
          label="Password"
          type="text"
        />
      </div>
      <button class="mybtn" type="submit">Sign up</button>
    </form>
  </div>
</template>
<script>
import axios from "axios";

export default {
  props: {
    msg: String,
  },
  data() {
    return {
      user: {
        firstname: "",
        lastname: "",
        email: "",
        password: "",
      },
    };
  },
  methods: {
    registerUser() {
      const user = {
        username: this.user.email,
        passw: this.user.password
      }
      const response = axios.post(
          "http://localhost:8085/demo/signup",
          user
      );
      response.then((resolvedResult) => {
        console.log(resolvedResult.data);
        if(resolvedResult.data=== true){
          alert("You succesfully signedUp!");
          this.$router.push({
            name: "Login",
          });
        }else{
          alert("Something wrong happend")
        }
      });
    }
  }
};


</script>

<style></style>
