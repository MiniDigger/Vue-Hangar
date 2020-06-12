<template>
  <footer class="footer">
    <div class="text-center">
      <p>
        Made with <fa :icon="['fas', 'heart']" /> and
        <fa :icon="['fas', 'beer']" /> by
        <a
          href="https://github.com/MiniDigger/Hangar/graphs/contributors"
          target="_blank"
        >
          these contributors</a
        >!
      </p>
    </div>
  </footer>
</template>

<script>
export default {
  name: 'Footer',
}
</script>

<style lang="scss" scoped>
.footer {
  font-size: 0.875rem;
  background-color: #f7f7f7;
  padding: 2rem 2rem;
}
</style>
