<template>
  <div class="tile is-child box">
    <p class="title">
      <nuxt-link :to="'/resources/' + resource.id">
        {{resource.name}}
      </nuxt-link>
    </p> 
    v{{resource.version}} by {{resource.authors}}
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
