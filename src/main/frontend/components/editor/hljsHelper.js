import hljs from 'highlight.js/lib/highlight'
import java from 'highlight.js/lib/languages/java'
import javascript from 'highlight.js/lib/languages/javascript'
import json from 'highlight.js/lib/languages/json'
import diff from 'highlight.js/lib/languages/diff'
import yaml from 'highlight.js/lib/languages/yaml'
import kotlin from 'highlight.js/lib/languages/kotlin'
import plaintext from 'highlight.js/lib/languages/plaintext'
import xml from 'highlight.js/lib/languages/xml'

hljs.registerLanguage('java', java)
hljs.registerLanguage('javascript', javascript)
hljs.registerLanguage('json', json)
hljs.registerLanguage('yaml', yaml)
hljs.registerLanguage('diff', diff)
hljs.registerLanguage('kotlin', kotlin)
hljs.registerLanguage('plaintext', plaintext)
hljs.registerLanguage('xml', xml)

export default hljs
