<template>
  <div class="log">
    <ul>
      <li v-for="n in logArray" :key="n">{{ n }}</li>
    </ul>
  </div>
</template>

<script>
export default {
  props: {
    logArray: Array,
  },
  methods: {},
};
</script>
<style>
.log {
  width: 500px;
  vertical-align: center;
  margin: 0 auto;
  color: #252525;
}
</style>
