<template>
  <b-modal :active.sync="active"
           has-modal-card
           trap-focus
           aria-role="dialog"
           aria-modal>
    <form action="">
      <div class="modal-card" style="width: auto">
        <header class="modal-card-head">
          <p class="modal-card-title">Login</p>
        </header>
        <section class="modal-card-body">
          <b-field label="Email">
            <b-input
              ref="email"
              type="email"
              :value="email"
              placeholder="Your email"
              required>
            </b-input>
          </b-field>

          <b-field label="Password">
            <b-input
              ref="password"
              type="password"
              :value="password"
              password-reveal
              placeholder="Your password"
              required>
            </b-input>
          </b-field>

          <b-checkbox :value="rememberMe">Remember me</b-checkbox>
        </section>
        <footer class="modal-card-foot">
          <b-button class="button" type="button" @click="$emit('close')">Close</b-button>
          <b-button class="button is-primary" @click.prevent="login" :loading="loading">Login</b-button>
        </footer>
      </div>
    </form>
  </b-modal>
</template>

<script>
import { mapMutations } from 'vuex';

export default {
  name: "Login",
  props: {
    active: {
      type: Boolean,
      required: true
    }
  },
  data() {
    return {
      email: '',
      password: '',
      rememberMe: false,
      loading: false
    }
  },
  methods: {
    ...mapMutations({
      commitLogin: 'user/login'
    }),
    login() {
      if(this.$refs.email.checkHtml5Validity() && this.$refs.password.checkHtml5Validity()) {
        this.$buefy.toast.open('Logging in... ');
        this.loading = true;
        // simulate network delay
        setTimeout(() => {
          this.loading = false;
          this.$emit('close')
          this.commitLogin({id: "1", name: "MiniDigger"})
        }, 500);
      }
    }
  }
}
</script>

<style scoped>

</style>
