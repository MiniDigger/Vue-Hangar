<template>
  <b-modal
    :active.sync="active"
    has-modal-card
    trap-focus
    aria-role="dialog"
    aria-modal
  >
    <form action="">
      <div class="modal-card" style="width: auto;">
        <header class="modal-card-head">
          <p class="modal-card-title">Login</p>
        </header>
        <section class="modal-card-body">
          <b-field label="Username">
            <b-input
              ref="username"
              v-model="username"
              placeholder="Your username"
              required
            >
            </b-input>
          </b-field>

          <b-field label="Password">
            <b-input
              ref="password"
              v-model="password"
              type="password"
              password-reveal
              placeholder="Your password"
              required
            >
            </b-input>
          </b-field>

          <b-checkbox :value="rememberMe">Remember me</b-checkbox>
        </section>
        <footer class="modal-card-foot">
          <b-button class="button" type="button" @click="$emit('close')"
            >Close</b-button
          >
          <b-button
            class="button is-primary"
            :loading="loading"
            @click.prevent="login"
            >Login</b-button
          >
        </footer>
      </div>
    </form>
  </b-modal>
</template>

<script>
import { mapActions } from 'vuex'

export default {
  name: 'Login',
  props: {
    active: {
      type: Boolean,
      required: true,
    },
  },
  data() {
    return {
      username: '',
      password: '',
      rememberMe: false,
      loading: false,
    }
  },
  methods: {
    ...mapActions({
      doLogin: 'user/login',
    }),
    login() {
      if (
        this.$refs.username.checkHtml5Validity() &&
        this.$refs.password.checkHtml5Validity()
      ) {
        this.loading = true
        this.doLogin({ username: this.username, password: this.password })
          .then(() => {
            this.loading = false
            this.$emit('close')
          })
          .catch((err) => {
            this.$buefy.toast.open('Error! ' + err)
            this.loading = false
          })
      }
    },
  },
}
</script>

<style scoped></style>
