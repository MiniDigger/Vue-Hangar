<template>
  <b-container>
    <b-navbar toggleable="lg" variant="transparent" type="light">
      <b-navbar-brand to="/">Hangar</b-navbar-brand>

      <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>

      <b-collapse id="nav-collapse" is-nav>
        <b-navbar-nav class="mr-auto">
          <b-nav-item>Forums</b-nav-item>
          <b-nav-item-dropdown text="Resources">
            <b-dropdown-item to="/resources">All Resources</b-dropdown-item>
            <b-dropdown-item>New Resources</b-dropdown-item>
            <template v-if="user">
              <b-dropdown-item>Your Resources</b-dropdown-item>
              <b-dropdown-item>Watched Resources</b-dropdown-item>
              <b-dropdown-item>Watched Categories</b-dropdown-item>
            </template>
          </b-nav-item-dropdown>
          <b-nav-item to="/test">Test</b-nav-item>
        </b-navbar-nav>

        <b-navbar-nav class="mx-auto">
          <b-nav-form class="search">
            <b-form-input size="sm" placeholder="Search for a resource..." />
          </b-nav-form>
        </b-navbar-nav>

        <!-- anon nav -->
        <b-navbar-nav v-if="!user" class="ml-auto">
          <b-nav-item-dropdown>
            <template #button-content>
              Account
            </template>
            <b-dropdown-item v-b-modal.login-modal>Log In</b-dropdown-item>
            <b-dropdown-item to="/register">Sign Up</b-dropdown-item>
          </b-nav-item-dropdown>
        </b-navbar-nav>

        <!-- logged in nav -->
        <b-navbar-nav v-else class="ml-auto">
          <b-nav-item-dropdown>
            <template #button-content>
              {{ user.username }}
            </template>
            <b-dropdown-item href="#">Settings</b-dropdown-item>
            <b-dropdown-item @click="logout">Log out</b-dropdown-item>
          </b-nav-item-dropdown>
        </b-navbar-nav>
      </b-collapse>
    </b-navbar>

    <Login />
  </b-container>
</template>

<script>
import { mapActions } from 'vuex'
import Login from '../modal/Login'

export default {
  name: 'NavBar',
  components: {
    Login,
  },
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
  mounted() {
    this.init()
  },
  methods: {
    ...mapActions({
      doLogout: 'user/logout',
      init: 'user/init',
    }),
    logout() {
      this.doLogout()
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
