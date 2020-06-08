<template>
  <div class="container">
    <h1 class="title">New Resource</h1>

    <b-field label="Tags:" label-position="on-border">
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

    <b-field label="Name">
      <b-input ref="name" :value="name" maxlength="30" />
    </b-field>

    <b-field label="Version">
      <b-input ref="version" :value="version" maxlength="30" />
    </b-field>

    <b-field label="Description">
      <b-input ref="description" :value="description" maxlength="30" />
    </b-field>

    <b-field label="Content">
      <b-input ref="content" type="textarea" :value="content" />
    </b-field>

    <div class="buttons">
      <b-button class="button" type="button" @click="back">Back</b-button>
      <b-button
        class="button is-primary"
        :loading="loading"
        @click.prevent="createResource"
        >New Resource</b-button
      >
    </div>
  </div>
</template>

<script>
export default {
  name: 'New',
  data() {
    return {
      name: null,
      version: null,
      description: null,
      content: null,
      loading: false,
    }
  },
  methods: {
    back() {
      this.$router.go(-1)
    },
    createResource() {
      this.$buefy.toast.open('Creating resource..')
      this.loading = true
      // simulate network delay
      setTimeout(() => {
        this.loading = false
        this.$emit('close')
        // do something! createResource({})
      }, 500)
    },
  },
}
</script>

<style scoped></style>
