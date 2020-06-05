<template>
  <div class="tile is-child box">
    <p class="title">
      <a :href="'/resources/' + resource.id">
        {{resource.name}}
      </a>
    </p>
  </div>
</template>

<script>
export default {
  name: "ResourceListEntry",
  props: {
    resource: {
      type: Object,
      required: true
    }
  }
}
</script>

<style scoped>

</style>
