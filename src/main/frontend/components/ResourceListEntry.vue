<template>
  <div>
    <b-list-group-item href="#" class="flex-column align-items-start">
      <div class="d-flex w-100 justify-content-between">
        <h5 class="mb-1">
          <nuxt-link :to="'/resources/' + resource.id">
            {{ resource.name }}
          </nuxt-link>
        </h5>
        <small>3 days ago</small>
      </div>

      <p class="mb-1">
        Donec id elit non mi porta gravida at eget metus. Maecenas sed diam eget
        risus varius blandit.
      </p>

      <small>v{{ resource.version }} by {{ resource.authors }}</small>
    </b-list-group-item>
  </div>
</template>

<script>
export default {
  name: 'ResourceListEntry',
  props: {
    resource: {
      type: Object,
      required: true,
    },
  },
}
</script>

<style scoped></style>
