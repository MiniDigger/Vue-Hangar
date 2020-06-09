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
import Announcement from '../../components/Announcement'

export default {
  name: 'Index',
  components: {
    Announcement,
  },
  data() {
    return {
      // TODO get from server
      announcements: [
        {
          headline: 'Welcome to Hangar!',
          content: 'This is the new Hangar site for Paper plugins!',
          slug: 'welcome',
        },
      ],
    }
  },
}
</script>

<style lang="scss" scoped>
.jumbotron {
  padding-top: 3%;
}
</style>
