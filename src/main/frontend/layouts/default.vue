<template>
  <div id="__page">
    <NavBar />

    <main>
      <b-container>
        <nuxt />
      </b-container>
    </main>

    <Footer />
  </div>
</template>

<script>
import NavBar from '~/components/nav/NavBar'
import Footer from '~/components/nav/Footer'

export default {
  components: {
    NavBar,
    Footer,
  },
}
</script>

<style lang="scss" scoped>
main {
  margin: 50px 50px;
}
</style>
