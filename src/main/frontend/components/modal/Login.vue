<template>
  <b-modal
    id="login-modal"
    title="Login"
    ok-title="Login"
    @ok="login"
    @cancel="cancel"
    @show="cancel"
    @shown="$refs.username.focus()"
  >
    <b-overlay :show="loading" rounded="sm">
      <b-form-group label="Username">
        <b-form-input
          ref="username"
          v-model="$v.form.username.$model"
          :state="validateState('username')"
          placeholder="Your username"
        />
        <b-form-invalid-feedback>
          Please enter your username
        </b-form-invalid-feedback>
      </b-form-group>

      <b-form-group label="Password">
        <b-form-input
          v-model="$v.form.password.$model"
          :state="validateState('password')"
          type="password"
          placeholder="Your password"
        />
        <b-form-invalid-feedback>
          Please enter your password
        </b-form-invalid-feedback>
      </b-form-group>

      <b-form-checkbox v-model="form.rememberMe">Remember me</b-form-checkbox>

      <b-alert v-model="showError" class="mt-3" dismissible>
        {{ errorMsg }}
      </b-alert>
    </b-overlay>
  </b-modal>
</template>

<script>
import { mapActions, mapMutations } from 'vuex'
import { validationMixin } from 'vuelidate'
import { required } from 'vuelidate/lib/validators'

export default {
  name: 'Login',
  mixins: [validationMixin],
  data() {
    return {
      form: {
        username: null,
        password: null,
        rememberMe: false,
      },
      errorMsg: null,
      showError: false,
      loading: false,
    }
  },
  methods: {
    ...mapActions({
      doLogin: 'user/login',
    }),
    ...mapMutations({
      stayLoggedIn: 'user/stayLoggedIn',
    }),
    login(e) {
      this.$v.form.$touch()
      e.preventDefault() // dont close
      if (this.$v.form.$anyError) {
        return
      }

      this.stayLoggedIn(this.form.rememberMe)
      this.loading = true
      this.doLogin({
        username: this.form.username,
        password: this.form.password,
      })
        .then(() => {
          this.loading = false
          this.$bvModal.hide('login-modal')
        })
        .catch((err) => {
          this.showError = true
          this.errorMsg = err
          this.loading = false
        })
    },
    clear() {
      this.form = {
        username: null,
        password: null,
        rememberMe: false,
      }
      this.loading = false
      this.showError = false
      this.errorMsg = null

      this.$v.form.$reset()
    },
    cancel() {
      this.clear()
      this.$bvModal.hide('login-modal')
    },
    validateState(name) {
      const { $dirty, $error } = this.$v.form[name]
      return $dirty ? !$error : null
    },
  },
  validations: {
    form: {
      username: {
        required,
      },
      password: {
        required,
      },
    },
  },
}
</script>

<style scoped></style>
