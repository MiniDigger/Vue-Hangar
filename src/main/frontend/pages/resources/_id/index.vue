<template>
  <div class="tile is-ancestor is-vertical">
    <div class="tile is-parent is-vertical">
      <div class="tile">
        <p class="title">{{params.id}}</p>
      </div>
    </div>

    <div class="tile is-parent">
      <div class="tile is-parent">
        <div class="tile is-child box">
          {{ params }}
        </div>
      </div>

      <div class="tile is-4 is-vertical is-parent">
        <div class="tile is-child box">
          <p class="title">Resource Tools</p>
        </div>
        <div class="tile is-child box">
          <p class="title">Resource Information</p>
        </div>
        <div class="tile is-child box">
          <p class="title">Latest Version</p>
        </div>
        <div class="tile is-child box">
          <p class="title">More Resources</p>
        </div>
        <div class="buttons">
          <b-button class="button is-primary">Discuss Resource</b-button>
          <b-button class="button is-danger">Delete Resource</b-button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "index.vue",
  computed: {
    params() {
      return this.$route.params;
    }
  }
}
</script>

<style scoped>

</style>
