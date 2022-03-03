<template>
  <h1>Complaints</h1>
  <div class="complaints">
    <ComplaintCard
      v-for="complaint in complaints"
      :key="complaint.id"
      :complaint="complaint"
    />
  </div>
</template>

<script>
import EventService from "@/services/EventService.js";
import ComplaintCard from "@/components/ComplaintCard";
export default {
  name: "EventList",
  components: {
    ComplaintCard,
  },
  data() {
    return {
      complaints: null,
    };
  },
  created() {
    EventService.getComplaints()
      .then((response) => {
        this.complaints = response.data;
      })
      .catch((error) => {
        console.log(error);
      });
  },
};
</script>

<style scoped>
.complaints {
  display: flex;
  flex-direction: column;
  align-items: center;
}
</style>
