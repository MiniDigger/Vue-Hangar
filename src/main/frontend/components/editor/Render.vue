<template>
  <viewer :initial-value="content" :options="options" />
</template>

<script>
import '@toast-ui/editor/dist/toastui-editor-viewer.css'
import 'tui-color-picker/dist/tui-color-picker.css'
import 'highlight.js/styles/github.css'

import { Viewer } from '@toast-ui/vue-editor'
import colorSyntax from '@toast-ui/editor-plugin-color-syntax'
import codeSyntaxHighlight from '@toast-ui/editor-plugin-code-syntax-highlight'
import hljs from './hljsHelper'

export default {
  name: 'Render',
  components: {
    Viewer,
  },
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
        // TODO renderer doesnt seem to support this?
        plugins: [colorSyntax, [codeSyntaxHighlight, { hljs }]],
      },
    }
  },
}
</script>

<style scoped></style>
