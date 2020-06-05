<template>
  <div class="container">
    <h1 class="title">Register</h1>
    <b-field label="Email">
      <b-input type="email"
               ref="email"
               :value="email"
               maxlength="30"/>
    </b-field>

    <b-field label="Username">
      <b-input
        ref="username"
        :value="username"
        maxlength="30"/>
    </b-field>

    <b-field label="Password">
      <b-input type="password"
               ref="password"
               :value="password"
               password-reveal
               @input="clearPasswordValidation"/>
    </b-field>

    <b-field label="Repeat Password" :type="pwValidation.type" :message="pwValidation.message">
      <b-input type="password"
               ref="repeatedPassword"
               :value="repeatedPassword"
               password-reveal
               @input="clearPasswordValidation"
               @blur="validate"/>
    </b-field>

    <div class="buttons">
      <b-button class="button" type="button" @click="back">Back</b-button>
      <b-button class="button is-primary" @click.prevent="register" :loading="loading">Register</b-button>
    </div>
  </div>
</template>

<script>
export default {
  name: "register",
  data() {
    return {
      email: null,
      username: null,
      password: null,
      repeatedPassword: null,
      loading: false,
      pwValidation: {
        type: null,
        message: null
      }
    }
  },
  methods: {
    back() {
      this.$router.go(-1);
    },
    register() {
      if (this.validate()) {
        this.$buefy.toast.open('Logging in... ');
        this.loading = true;
        // simulate network delay
        setTimeout(() => {
          this.loading = false;
          this.$emit('close')
          this.commitLogin({id: "1", name: "MiniDigger"})
        }, 500);
      }
    },
    validate() {
      const htmlValidated = this.$refs.email.checkHtml5Validity() && this.$refs.username.checkHtml5Validity() && this.$refs.password.checkHtml5Validity() && this.$refs.repeatedPassword.checkHtml5Validity();
      if (!htmlValidated) {
        return false;
      }

      if (this.password !== this.repeatedPassword) {
        this.pwValidation.type = "is-danger";
        this.pwValidation.message = "Password does not match!";
        return false;
      }

      return true;
    },
    clearPasswordValidation() {
      this.pwValidation.type = null;
      this.pwValidation.message = null;
    }
  }
}
</script>

<style scoped>

</style>
