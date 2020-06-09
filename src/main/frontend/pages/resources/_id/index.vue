<template>
  <div class="resourceContainer">
    <b-nav>
      <b-nav-item active>Overview</b-nav-item>
      <b-nav-item>Updates</b-nav-item>
      <b-nav-item>Discussion</b-nav-item>
      <b-nav-item>Version History</b-nav-item>
      <b-nav-item>Contributors</b-nav-item>
    </b-nav>

    <p class="title">{{ params.id }}, {{ params }}</p>

    <b-button class="button is-primary">Discuss Resource</b-button>
    <b-button class="button is-danger">Delete Resource</b-button>

    <b-card-group deck>
      <b-card
        v-if="user"
        title="Resource Tools"
        tag="article"
        style="max-width: 20rem;"
        class="mb-2"
      >
        <b-card-text>
          Some quick example text to build on the card title and make up the
          bulk of the card's content.
        </b-card-text>

        <b-button href="#" variant="primary">Go somewhere</b-button>
      </b-card>

      <b-card
        title="Resource Information"
        tag="article"
        style="max-width: 20rem;"
        class="mb-2"
      >
        <b-card-text>
          Some quick example text to build on the card title and make up the
          bulk of the card's content.
        </b-card-text>

        <b-button href="#" variant="primary">Go somewhere</b-button>
      </b-card>

      <b-card
        title="Latest Version"
        tag="article"
        style="max-width: 20rem;"
        class="mb-2"
      >
        <b-card-text>
          Some quick example text to build on the card title and make up the
          bulk of the card's content.
        </b-card-text>

        <b-button href="#" variant="primary">Go somewhere</b-button>
      </b-card>

      <b-card
        title="More Resources"
        tag="article"
        style="max-width: 20rem;"
        class="mb-2"
      >
        <b-card-text>
          Some quick example text to build on the card title and make up the
          bulk of the card's content.
        </b-card-text>

        <b-button href="#" variant="primary">Go somewhere</b-button>
      </b-card>
    </b-card-group>
  </div>
</template>

<script>
export default {
  name: 'IndexVue',
  computed: {
    params() {
      return this.$route.params
    },
  },
}
</script>

<style lang="scss" scoped>
.resourceContainer {
  background-color: white;
}
</style>
