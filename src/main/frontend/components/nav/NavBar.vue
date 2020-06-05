<template>
  <b-navbar type="is-dark" fixed-top>
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
          <b-icon icon="message-text"/>
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
          <b-icon icon="bell"/>
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
</template>

<script>
export default {
  name: "NavBar"
}
</script>

<style scoped>

</style>
