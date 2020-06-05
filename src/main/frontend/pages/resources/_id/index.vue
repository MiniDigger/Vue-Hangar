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
          <p class="title">One</p>
        </div>
        <div class="tile is-child box">
          <p class="title">Two</p>
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
