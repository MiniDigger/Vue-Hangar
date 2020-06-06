<template>
  <div class="tile is-ancestor is-vertical">
    <div class="tile is-parent is-vertical">
      <div class="tile">
        <p class="title">Resources</p>
      </div>
      <div class="tile" id="filter">
        <b-field label="Filter by:" label-position="on-border">
          <b-taginput
            v-model="tags"
            :data="filteredTags"
            autocomplete
            :allow-new="false"
            :open-on-focus="true"
            field="user.first_name"
            icon="label"
            placeholder="Add a tag"
            ref="taginput"
            @typing="getFilteredTags">
            <template slot-scope="props">
              <strong>{{props.option.id}}</strong>: {{props.option.name}}
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
                @close="$refs.taginput.removeTag(index, $event)">
                {{tag.name}}
              </b-tag>
            </template>
          </b-taginput>
        </b-field>
      </div>
      <div class="tile">
        <nuxt-link :to="'/resources/add'">
          <b-button class="button is-primary">Add Resource</b-button>
        </nuxt-link>
      </div>
    </div>

    <div class="tile is-parent">
      <div class="tile is-parent">
        <div class="tile is-child box">
          <ResourceList />
        </div>
      </div>

      <div class="tile is-4 is-vertical is-parent">
        <div class="tile is-child box">
          <p class="title">Categories</p>
        </div>
        <div class="tile is-child box">
          <p class="title">Top Resources</p>
        </div>
        <div class="tile is-child box">
          <p class="title">Most Resources</p>
        </div>
      </div>
    </div>
  </div>
</template>
<script>

import ResourceList from '~/components/ResourceList'

export default {
  name: 'Resources',

  components: {
    ResourceList
  },
  data() {
    return {
      data: [
        { id: 1, name: "Test1" },
        { id: 2, name: "Test2" },
        { id: 3, name: "Test3" },
      ],
      filteredTags: this.data,
      tags: []
    }
  },
  methods: {
    getFilteredTags(text) {
      this.filteredTags = this.data.filter((option) => {
        return option.name
          .toLowerCase()
          .indexOf(text.toLowerCase()) >= 0
      })
    }
  }
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
