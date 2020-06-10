<template>
  <b-container>
    <h1>{{ slug }}</h1>
    <b-form>
      <b-form-group label="Headline:" label-for="headline">
        <b-form-input
          id="headline"
          v-model="$v.form.headline.$model"
          :state="validateState('headline')"
          placeholder="Headline"
        ></b-form-input>
        <b-form-invalid-feedback>
          Please enter a valid headline
        </b-form-invalid-feedback>
      </b-form-group>
    </b-form>
    {{ announcement }}
  </b-container>
</template>

<script>
import { mapActions } from 'vuex'
import { email, required } from 'vuelidate/lib/validators'

export default {
  name: 'Slug',
  computed: {
    slug() {
      return this.$route.params.slug
    },
    announcements() {
      return this.$store.state.announcement.announcements
    },
    announcement() {
      return this.announcements.find((a) => a.slug === this.slug)
    },
  },
  mounted() {
    if (!this.announcement) {
      this.loadBySlug(this.slug)
    }
  },
  methods: {
    ...mapActions({
      loadBySlug: 'announcement/loadBySlug',
    }),
    validateState(name) {
      const { $dirty, $error } = this.$v.form[name]
      return $dirty ? !$error : null
    },
  },
  validations: {
    form: {
      headline: {
        required,
      },
      publishedOn: {
        required,
        email,
      },
      slug: {
        required,
      },
      content: {
        required,
      },
    },
  },
}
</script>

<style scoped></style>
