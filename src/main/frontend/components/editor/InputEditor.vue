<template>
  <!-- todo figure out why initial value doesnt work (it seems to be added to late?) -->
  <ToastuiEditor
    ref="editor"
    :initial-value="content"
    :initial-edit-type="initialEditType"
    :options="options"
    :preview-style="previewStyle"
    @change="change"
  />
</template>

<script>
export default {
  name: 'InputEditor',
  props: {
    content: {
      type: String,
      default: 'Test',
    },
    format: {
      type: String,
      default: 'markdown',
    },
    previewStyle: {
      type: String,
      default: 'vertical',
    },
  },
  data() {
    return {
      initialEditType: 'wysiwyg',
      options: {
        minHeight: '200px',
        language: 'en-US',
        useCommandShortcut: true,
        useDefaultHTMLSanitizer: true,
        usageStatistics: false,
        hideModeSwitch: false,
        toolbarItems: [
          'heading',
          'bold',
          'italic',
          'strike',
          'divider',
          'hr',
          'quote',
          'divider',
          'ul',
          'ol',
          'task',
          'indent',
          'outdent',
          'divider',
          'table',
          'image',
          'link',
          'divider',
          'code',
          'codeblock',
        ],
      },
    }
  },
  methods: {
    change() {
      // const markdown = this.$refs.editor.invoke('getMarkdown')
    },
  },
}
</script>

<style scoped></style>
