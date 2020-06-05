<template>
  <div>
    <b-navbar type="is-dark">
      <template slot="brand">
        <b-navbar-item tag="router-link" :to="{ path: '/' }">
          <img
            src="~assets/paper-logo.svg"
            alt="Hangar"
          >
          - Hangar
        </b-navbar-item>
      </template>

      <template slot="end">
        <b-navbar-dropdown label="User" collapsible right>
          <b-navbar-item href="#">
            Option 1
          </b-navbar-item>
          <b-navbar-item href="#">
            Option 2
          </b-navbar-item>
        </b-navbar-dropdown>

        <b-navbar-dropdown arrowless collapsible right>
          <template slot="label">
            <b-icon icon="message-text" />
          </template>
          <b-navbar-item href="#">
            Message 1
          </b-navbar-item>
          <b-navbar-item href="#">
            Message 2
          </b-navbar-item>
        </b-navbar-dropdown>

        <b-navbar-dropdown arrowless collapsible right>
          <template slot="label">
            <b-icon icon="bell" />
          </template>
          <b-navbar-item href="#">
            Alert 1
          </b-navbar-item>
          <b-navbar-item href="#">
            Alert 2
          </b-navbar-item>
        </b-navbar-dropdown>
      </template>
    </b-navbar>

    <section class="main-content columns">
      <div class="container column is-12">
        <nuxt/>
      </div>
    </section>
  </div>
</template>

<script>
export default {
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
</style>
