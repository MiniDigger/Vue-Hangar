<template>
  <nav class="level" id="subnav">
    <p class="level-item has-text-centered">
      <nuxt-link class="link is-info" to="/">Home</nuxt-link>
    </p>
    <p class="level-item has-text-centered">
      <a class="link is-info">Forums</a>
    </p>
    <p class="level-item has-text-centered">
      <nuxt-link class="link is-info" to="/resources">Resources</nuxt-link>
    </p>
    <p class="level-item has-text-centered">
      <a class="link is-info">Your Resources</a>
    </p>
    <p class="level-item has-text-centered">
      <a class="link is-info">New Resource...</a>
    </p>
    <p class="level-item has-text-centered">
      <a class="link is-info">Watched Resources</a>
    </p>
    <div class="level-item">
      <b-field>
        <b-input placeholder="Search..."
                 type="search"
                 icon-right="magnify"
                 icon-right-clickable
                 @icon-right-click="search">
        </b-input>
      </b-field>
    </div>
  </nav>
</template>

<script>
export default {
  name: "SubNav",
  methods: {
    search() {
      this.$buefy.toast.open('Search')
    }
  }
}
</script>

<style scoped>
#subnav {
  background-color: #47494E;
  color: white;
  padding: 5px 0 5px 0;
}

#subnav a {
  color: white;
}
</style>
