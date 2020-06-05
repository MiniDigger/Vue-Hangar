<template>
  <div id="__page">
    <NavBar />

    <SubNav />

    <section class="main-content columns">
      <div class="container column is-12">
        <nuxt/>
      </div>
    </section>

    <Footer />
  </div>
</template>

<script>
import NavBar from "../components/nav/NavBar";
import SubNav from "../components/nav/SubNav";
import Footer from "../components/nav/Footer";

export default {
  components: {
    NavBar, SubNav, Footer
  },
  data() {
    return {
      items: [
        {
          title: 'Home',
          icon: 'home',
          to: {name: 'index'}
        },
        {
          title: 'Inspire',
          icon: 'lightbulb',
          to: {name: 'inspire'}
        }
      ]
    }
  }
}
</script>

<style>
.navbar-brand img {
  height: 1.75rem;
}

html, body, #__nuxt, #__layout, #__page {
  height: 100%;
}
</style>
