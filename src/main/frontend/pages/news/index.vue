<template>
  <div>
    <section>
      <h1>News</h1>
      <div>
        <Announcement
          v-for="a in announcements"
          :key="a.slug"
          :headline="a.headline"
          :content="a.content"
          :slug="a.slug"
          :show-full="false"
        />
      </div>
    </section>
  </div>
</template>

<script>
import { mapActions } from 'vuex'
import Announcement from '../../components/Announcement'

export default {
  name: 'Index',
  components: {
    Announcement,
  },
  computed: {
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

<style lang="scss" scoped>
.jumbotron {
  padding-top: 3%;
}
</style>
