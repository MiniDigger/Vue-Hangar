<template>
  <b-container>
    <b-jumbotron
      header="Resources"
      lead="Launch your Paper Planes (plugins)!"
    ></b-jumbotron>

    <nuxt-link :to="'/resources/new'">
      <b-button class="button is-primary">New Resource</b-button>
    </nuxt-link>

    <b-form-tags
      v-model="value"
      input-id="tags-basic"
      class="mb-2"
    ></b-form-tags>

    <ResourceList />

    <!-- <div id="filter" class="tile">
      <b-field label="Filter by:" label-position="on-border">
        <b-taginput
          ref="taginput"
          v-model="tags"
          :data="filteredTags"
          autocomplete
          :allow-new="false"
          :open-on-focus="true"
          field="user.first_name"
          icon="label"
          placeholder="Add a tag"
          @typing="getFilteredTags"
        >
          <template slot-scope="props">
            <strong>{{ props.option.id }}</strong
            >: {{ props.option.name }}
          </template>
          <template slot="empty">
            There are no items
          </template>
          <template slot="selected" slot-scope="props">
            <b-tag
              v-for="(tag, index) in props.tags"
              :key="index"
              rounded
              :tabstop="false"
              ellipsis
              closable
              @close="$refs.taginput.removeTag(index, $event)"
            >
              {{ tag.name }}
            </b-tag>
          </template>
        </b-taginput>
      </b-field>
    </div> -->
  </b-container>
</template>
<script>
import ResourceList from '~/components/ResourceList'

export default {
  name: 'Resources',

  components: {
    ResourceList,
  },
  data() {
    return {
      data: [
        { id: 1, name: 'Test1' },
        { id: 2, name: 'Test2' },
        { id: 3, name: 'Test3' },
      ],
      filteredTags: this.data,
      tags: [],
    }
  },
  methods: {
    getFilteredTags(text) {
      this.filteredTags = this.data.filter((option) => {
        return option.name.toLowerCase().includes(text.toLowerCase())
      })
    },
  },
}
</script>

<style scoped>
.title {
  margin-bottom: 1%;
}
#filter {
  margin-bottom: 1%;
}
</style>

<style lang="scss" scoped>
.jumbotron {
  background-color: unset;
  padding: 0;
}
</style>
