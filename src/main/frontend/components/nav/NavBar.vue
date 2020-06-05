<template>
  <div>
    <b-navbar type="is-dark" fixed-top>
      <template slot="brand">
        <b-navbar-item tag="nuxt-link" :to="{ path: '/' }">
          <img
            src="~assets/paper-logo.svg"
            alt="Hangar"
          >
          - Hangar
        </b-navbar-item>
      </template>

      <template slot="end" v-if="user">
        <b-navbar-dropdown :label="user.username" collapsible right>
          <b-navbar-item>
            Option 1
          </b-navbar-item>
          <b-navbar-item @click="logout">
            Logout
          </b-navbar-item>
        </b-navbar-dropdown>

        <b-navbar-dropdown arrowless collapsible right>
          <template slot="label">
            <b-icon icon="message-text"/>
          </template>
          <b-navbar-item>
            Message 1
          </b-navbar-item>
          <b-navbar-item>
            Message 2
          </b-navbar-item>
        </b-navbar-dropdown>

        <b-navbar-dropdown arrowless collapsible right>
          <template slot="label">
            <b-icon icon="bell"/>
          </template>
          <b-navbar-item>
            Alert 1
          </b-navbar-item>
          <b-navbar-item>
            Alert 2
          </b-navbar-item>
        </b-navbar-dropdown>
      </template>

      <template slot="end" v-else>
        <b-navbar-item tag="div">
          <div class="buttons">
            <nuxt-link class="button is-primary" to="register">
              <strong>Sign up</strong>
            </nuxt-link>
            <a class="button is-light" @click="showLogin = true">
              Log in
            </a>
          </div>
        </b-navbar-item>
      </template>
    </b-navbar>

    <Login :active="showLogin" @close="showLogin = false"/>
  </div>
</template>

<script>
import { mapMutations } from 'vuex';
import Login from "../modal/Login";

export default {
  name: "NavBar",
  components: {
    Login
  },
  methods: {
    ...mapMutations({
      commitLogout: 'user/logout'
    }),
    logout() {
      this.commitLogout();
      // TODO clear cookie and shit
    }
  },
  computed: {
    user() {
      return this.$store.state.user.user
    }
  },
  data() {
    return {
      showLogin: false
    }
  }
}
</script>

<style scoped>

</style>
