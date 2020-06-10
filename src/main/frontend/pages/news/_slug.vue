<template>
  <Announcement
    v-if="announcement"
    :headline="announcement.headline"
    :content="announcement.content"
    :slug="announcement.slug"
    :show-full="true"
  />
</template>

<script>
import { mapActions } from 'vuex'
import Announcement from '../../components/Announcement'

export default {
  name: 'Slug',
  components: {
    Announcement,
  },
  computed: {
    announcements() {
      return this.$store.state.announcement.announcements
    },
    announcement() {
      return this.announcements.find((a) => a.slug === this.slug)
    },
    slug() {
      return this.$route.params.slug
    },
  },
  methods: {
    ...mapActions({
      loadBySlug: 'announcement/loadBySlug',
    }),
  },
  mounted() {
    if (!this.announcement) {
      this.loadBySlug(this.slug)
    }
  },
}
</script>

<style lang="scss" scoped>
@media (min-width: 576px) {
  .jumbotron {
    padding: 2rem;
  }
}
</style>
