<template>
  <b-form @submit.prevent="onSubmit" @reset="onReset">
    <b-card>
      <b-card-header>
        Register
      </b-card-header>
      <b-card-body>
        <b-form-group
          label="Email address:"
          label-for="email"
          description="We'll never share your email with anyone else."
        >
          <b-form-input
            id="email"
            v-model="$v.form.email.$model"
            type="email"
            :state="validateState('email')"
            placeholder="Enter your email"
          ></b-form-input>
          <b-form-invalid-feedback>
            Please enter a valid email
          </b-form-invalid-feedback>
        </b-form-group>

        <b-form-group label="Your Username:" label-for="username">
          <b-form-input
            id="username"
            v-model="$v.form.username.$model"
            :state="validateState('username')"
            placeholder="Enter your username"
          ></b-form-input>
          <b-form-invalid-feedback>
            Please enter a valid username
          </b-form-invalid-feedback>
        </b-form-group>

        <b-form-group label="Your Password:" label-for="password">
          <b-form-input
            id="password"
            v-model="$v.form.password.$model"
            :state="validateState('password')"
            type="password"
            placeholder="Enter your password"
          ></b-form-input>
          <b-form-invalid-feedback>
            Please enter a valid password. It has to be at least 8 characters
            long
          </b-form-invalid-feedback>
        </b-form-group>

        <b-form-group description="Please repeat your password">
          <b-form-input
            id="passwordRepeated"
            v-model="$v.form.passwordRepeated.$model"
            :state="validateState('passwordRepeated')"
            type="password"
            placeholder="Enter your password"
          ></b-form-input>
          <b-form-invalid-feedback>
            Please repeat your password
          </b-form-invalid-feedback>
        </b-form-group>

        <b-alert v-model="showError" class="mt-3" dismissible>
          {{ errorMsg }}
        </b-alert>
      </b-card-body>
      <b-card-footer>
        <b-button type="submit" variant="primary">Register</b-button>
        <b-button type="reset" variant="danger">Back</b-button>
      </b-card-footer>
    </b-card>
  </b-form>
</template>

<script>
import { mapMutations } from 'vuex'
import { sameAs, email, required } from 'vuelidate/lib/validators'
import { validationMixin } from 'vuelidate'

export default {
  name: 'Register',
  mixins: [validationMixin],
  data() {
    return {
      form: {
        email: '',
        username: '',
        password: null,
        passwordRepeated: null,
      },
      showError: false,
      errorMsg: null,
    }
  },
  methods: {
    ...mapMutations({
      commitLogin: 'user/login',
    }),
    onReset() {
      this.$router.go(-1)
    },
    onSubmit() {
      this.$v.form.$touch()
      if (this.$v.form.$anyError) {
        return
      }
      this.loading = true
      // simulate network delay
      setTimeout(() => {
        this.loading = false
        this.$emit('close')
        // TODO properly implement register
        this.commitLogin({ id: '1', name: 'MiniDigger' })
      }, 500)
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
      email: {
        required,
        email,
      },
      password: {
        required,
      },
      passwordRepeated: {
        required,
        sameAsPassword: sameAs('password'),
      },
    },
  },
}
</script>

<style lang="scss" scoped>
.card-header,
.card-footer {
  background-color: unset;
}
</style>
