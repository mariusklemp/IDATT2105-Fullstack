<template>
  <div class="home">
    <Calculator msg="Welcome to my CLCLTR" />
    <Log msg="This is a log of the recent equations" />
  </div>
</template>

<script>
// @ is an alias to /src
import Calculator from "@/components/Calculator.vue";
import Log from "@/components/Log.vue";

export default {
  name: "Home",
  components: {
    Calculator,
    Log,
  },
};
</script>
