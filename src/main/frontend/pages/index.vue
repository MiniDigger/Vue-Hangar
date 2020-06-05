<template>
  <div>
    <section class="hero">
      <div class="hero-body">
        <div class="container">
          <h1 class="title">
            Hangar
          </h1>
          <h2 class="subtitle">
            Launch your Paper Planes/Plugins from this awesome hangar!
          </h2>
        </div>
      </div>
    </section>
    <section class="section">
      <div class="columns is-mobile">
        <card
          title="Free"
          icon="github-circle"
        >
          Open source on <a href="https://github.com/buefy/buefy">
          GitHub
        </a>
        </card>

        <card
          title="Responsive"
          icon="cellphone-link"
        >
          <b class="has-text-grey">
            Every
          </b> component is responsive
        </card>

        <card
          title="Modern"
          icon="alert-decagram"
        >
          Built with <a href="https://vuejs.org/">
          Vue.js
        </a> and <a href="http://bulma.io/">
          Bulma
        </a>
        </card>

        <card
          title="Lightweight"
          icon="arrange-bring-to-front"
        >
          No other internal dependency
        </card>
      </div>
    </section>
  </div>
</template>

<script>
import Card from '~/components/Card'

export default {
  name: 'HomePage',

  components: {
    Card
  }
}
</script>
