<template>
  <b-container>
    <h1>Admin Announcements</h1>
    <nuxt-child v-if="hasChild" />
    <b-list-group v-else>
      <b-list-group-item
        v-for="a in announcements"
        :key="a.slug"
        :to="'/admin/announcements/' + a.slug"
        active-class="active"
        :exact="true"
        >{{ a.headline }}</b-list-group-item
      >
    </b-list-group>
  </b-container>
</template>

<script>
import { mapActions } from 'vuex'
export default {
  name: 'Announcements',
  computed: {
    hasChild() {
      return !this.$route.fullPath.endsWith('announcements')
    },
    announcements() {
      return this.$store.state.announcement.announcements
    },
  },
  mounted() {
    this.load()
  },
  methods: {
    ...mapActions({
      load: 'announcement/load',
    }),
  },
}
</script>

<style scoped></style>
