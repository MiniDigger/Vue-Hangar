<template>
  <div>
    <section>
      <h1>News</h1>
      <div>
        <b-jumbotron
          header="This is an announcement!"
          lead="Bootstrap v4 Components for Vue.js 2"
        >
          <p>For more information visit website</p>
          <b-button variant="primary" href="#">More Info</b-button>
        </b-jumbotron>
      </div>
    </section>
  </div>
</template>

<script>
export default {
  data() {
    return {
      announcements: [
        {
          name: 'Welcome to Hangar!',
          description: 'This is the new Hangar site for Paper plugins!',
          url: '#',
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
