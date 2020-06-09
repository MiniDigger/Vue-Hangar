<template>
  <div>
    <ResourceListEntry
      v-for="resource in currentResources"
      :key="resource.id"
      :resource="resource"
    />

    <p class="mt-3">Current Page: {{ currentPage }}</p>
    <b-pagination
      v-model="currentPage"
      :total-rows="rows"
      :per-page="perPage"
      aria-controls="my-table"
    ></b-pagination>
  </div>
</template>

<script>
import ResourceListEntry from './ResourceListEntry'

export default {
  name: 'ResourceList',
  components: {
    ResourceListEntry,
  },
  data() {
    return {
      total: 200,
      currentPage: 10,
      perPage: 10,
    }
  },
  computed: {
    currentResources() {
      return [
        { id: 1, name: 'Test1', version: '1.0.0', authors: 'ExampleUser1' },
        { id: 2, name: 'Test2', version: '1.0.0', authors: 'ExampleUser1' },
        { id: 3, name: 'Test3', version: '1.0.0', authors: 'ExampleUser1' },
        { id: 4, name: 'Test4', version: '1.0.0', authors: 'ExampleUser1' },
      ]
    },
  },
  methods: {
    switchPage(newPage) {
      this.$buefy.toast.open('Open Page ' + newPage)
    },
  },
}
</script>

<style scoped></style>
