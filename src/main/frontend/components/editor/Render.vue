<template>
  <ToastuiEditorViewer :initial-value="content" :options="options" />
</template>

<script>
export default {
  name: 'Render',
  props: {
    content: {
      type: String,
      required: true,
    },
    format: {
      type: String,
      default: 'markdown',
    },
  },
  data() {
    return {
      options: {
        usageStatistics: false,
      },
    }
  },
}
</script>

<style scoped></style>
