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
      alert("You have now pressed a button");
    },
  },
};
</script>

<style></style>
