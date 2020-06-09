import Vue from 'vue'
import { Editor, Viewer } from '@toast-ui/vue-editor'

// import hljs from 'highlight.js/lib/highlight'
// import java from 'highlight.js/lib/languages/java'
// import javascript from 'highlight.js/lib/languages/javascript'
// import json from 'highlight.js/lib/languages/json'
// import diff from 'highlight.js/lib/languages/diff'
// import yaml from 'highlight.js/lib/languages/yaml'
// import kotlin from 'highlight.js/lib/languages/kotlin'
// import plaintext from 'highlight.js/lib/languages/plaintext'
// import xml from 'highlight.js/lib/languages/xml'

// import colorSyntax from '@toast-ui/editor-plugin-color-syntax'
// import codeSyntaxHighlight from '@toast-ui/editor-plugin-code-syntax-highlight'

Vue.component(Editor.name, Editor)
Vue.component(Viewer.name, Viewer)

// hljs.registerLanguage('java', java)
// hljs.registerLanguage('javascript', javascript)
// hljs.registerLanguage('json', json)
// hljs.registerLanguage('yaml', yaml)
// hljs.registerLanguage('diff', diff)
// hljs.registerLanguage('kotlin', kotlin)
// hljs.registerLanguage('plaintext', plaintext)
// hljs.registerLanguage('xml', xml)

// const plugins = [colorSyntax, [codeSyntaxHighlight, { hljs }]]
const plugins = []
export default plugins

// TODO plugins seem to break shit with SSR or smth...
