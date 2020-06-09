<template>
  <!-- todo figure out why initial value doesnt work -->
  <editor
    ref="editor"
    :inital-value="content"
    :initial-edit-type="initialEditType"
    :options="options"
    :preview-style="previewStyle"
    @change="change"
  />
</template>

<script>
import 'codemirror/lib/codemirror.css'
import '@toast-ui/editor/dist/toastui-editor.css'
import 'tui-color-picker/dist/tui-color-picker.css'
import 'highlight.js/styles/github.css'

import { Editor } from '@toast-ui/vue-editor'
import colorSyntax from '@toast-ui/editor-plugin-color-syntax'
import codeSyntaxHighlight from '@toast-ui/editor-plugin-code-syntax-highlight'

import hljs from './hljsHelper.js'

export default {
  name: 'InputEditor',
  components: {
    Editor,
  },
  props: {
    content: {
      type: String,
      default: '',
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
        plugins: [colorSyntax, [codeSyntaxHighlight, { hljs }]],
      },
    }
  },
  methods: {
    change() {
      const markdown = this.$refs.editor.invoke('getMarkdown')
      console.log('markdown now: ' + markdown)
    },
  },
}
</script>

<style scoped></style>
