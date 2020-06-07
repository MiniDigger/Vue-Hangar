<template>
  <b-container>
    <b-navbar toggleable="lg" variant="transparent" type="light">
      <b-navbar-brand to="/">Hangar</b-navbar-brand>

      <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>

      <b-collapse id="nav-collapse" is-nav>
        <b-navbar-nav class="mr-auto">
          <b-nav-item>Forums</b-nav-item>
          <b-nav-item-dropdown text="Resources">
            <b-dropdown-item>All Resources</b-dropdown-item>
            <b-dropdown-item>New Resources</b-dropdown-item>
            <!-- when authed
            <b-dropdown-item>Your Resources</b-dropdown-item>
            <b-dropdown-item>Watched Resources</b-dropdown-item>
            <b-dropdown-item>Watched Categories</b-dropdown-item>
            -->
          </b-nav-item-dropdown>
        </b-navbar-nav>

        <b-navbar-nav class="mx-auto">
          <b-nav-form class="search">
            <b-form-input size="sm" placeholder="Search for a resource..." />
          </b-nav-form>
        </b-navbar-nav>

        <b-navbar-nav class="ml-auto">
          <b-nav-item-dropdown>
            <template #button-content>
              Account
              <!-- show username when authed -->
            </template>
            <b-dropdown-item href="#">Log In</b-dropdown-item>
            <b-dropdown-item href="#">Sign Up</b-dropdown-item>
          </b-nav-item-dropdown>
        </b-navbar-nav>
      </b-collapse>
    </b-navbar>
  </b-container>
</template>

<script>
export default {
  name: 'NavBar',
  data() {
    return {
      showLogin: false,
    }
  },
  computed: {
    user() {
      return this.$store.state.user.user
    },
  },
}
</script>

<style lang="scss" scoped>
.search {
  width: 400px;

  input {
    width: 400px;
  }
}
</style>
