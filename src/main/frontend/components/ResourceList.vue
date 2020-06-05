<template>
  <div class="tile is-parent is-vertical">
    <ResourceListEntry v-for="resource in currentResources" :key="resource.id" :resource="resource" />

    <b-pagination
      @change="switchPage"
      :total="total"
      :current.sync="current"
      :per-page="perPage"
      order="is-centered"
      aria-next-label="Next page"
      aria-previous-label="Previous page"
      aria-page-label="Page"
      aria-current-label="Current page">
    </b-pagination>
  </div>
</template>

<script>
import ResourceListEntry from "./ResourceListEntry";

export default {
  name: "ResourceList",
  components: {
    ResourceListEntry
  },
  data() {
    return {
      total: 200,
      current: 10,
      perPage: 10,
    }
  },
  computed: {
    currentResources() {
      return [
        {id: 1, name: "Test1"},
        {id: 2, name: "Test2"},
        {id: 3, name: "Test3"},
        {id: 4, name: "Test4"},
      ]
    }
  },
  methods: {
    switchPage(newPage) {
      this.$buefy.toast.open('Open Page ' + newPage)
    }
  }
}
</script>

<style scoped>

</style>
