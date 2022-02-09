<template>
  <h1>Register a complain</h1>
  <div class="form-container">
    <form @submit.prevent="onSubmit">
      <h3>Register something</h3>

      <label>Name</label>
      <input v-model="info.name" type="text" placeholder="Name" />

      <label>Email</label>
      <input v-model="info.email" type="text" placeholder="Email" />

      <label>Message</label>
      <input type="text" placeholder="Message" />
      <button type="submit">Submit</button>
    </form>
  </div>
</template>
<script>
export default {

  data() {
    return {
      info: {
        name: "",
        email: "",
      },
    };
  },
  methods: {
    onSubmit() {
      alert("blaah");
      this.$store.dispatch("storeInfo", this.info)
          .then( () => {
            this.$router.push({
              name: "Home",
        });
      });
    },
  },
};
</script>
