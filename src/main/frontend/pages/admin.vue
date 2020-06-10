<template>
  <b-container>
    <h1>Admin Parent</h1>
    <b-row>
      <b-col cols="4">
        <b-list-group>
          <b-list-group-item to="/admin" active-class="active" :exact="true"
            >Index</b-list-group-item
          >
          <b-list-group-item
            to="/admin/announcements"
            active-class="active"
            :exact="true"
            >Announcements</b-list-group-item
          >
        </b-list-group>
      </b-col>
      <b-col cols="8">
        <nuxt-child />
      </b-col>
    </b-row>
  </b-container>
</template>

<script>
export default {
  name: 'Admin',
}
</script>

<style lang="scss" scoped>
a .nuxt-link-active {
}
</style>
