<template>
  <b-jumbotron :header="headline">
    <p><Render :content="content" /></p>
    <b-button v-if="!showFull" variant="primary" :to="'/news/' + slug"
      >More Info</b-button
    >
  </b-jumbotron>
</template>

<script>
import Render from './editor/Render'
export default {
  name: 'Index',
  components: { Render },
  props: {
    headline: {
      type: String,
      required: true,
    },
    slug: {
      type: String,
      required: true,
    },
    content: {
      type: String,
      required: true,
    },
    showFull: {
      type: Boolean,
      default: true,
    },
  },
}
</script>

<style lang="scss" scoped>
.jumbotron {
  padding-top: 3%;
}
</style>
