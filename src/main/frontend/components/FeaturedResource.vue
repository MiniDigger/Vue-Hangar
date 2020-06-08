<template>
  <b-card :title="name" :img-src="image" :img-alt="name" img-top>
    <b-card-text>
      {{ truncatedDesc }}
    </b-card-text>

    <b-button :href="url">See more</b-button>
  </b-card>
</template>

<script>
export default {
  name: 'FeaturedResource',
  props: {
    image: {
      type: String,
      required: true,
    },
    name: {
      type: String,
      required: true,
    },
    description: {
      type: String,
      required: true,
    },
    url: {
      type: String,
      required: true,
    },
  },
  computed: {
    truncatedDesc() {
      if (this.description.length <= 197) {
        return this.description
      }

      return this.description.substring(0, 196).trim() + '...'
    },
  },
}
</script>

<style lang="scss" scoped>
.card {
  .card-img-top {
    height: 175px;
  }

  height: 450px;
}
</style>
