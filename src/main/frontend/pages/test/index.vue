<template>
  <b-card>
    <Render
      content='# Test

      <span style="color:#f40000\">Test</span>'
    />

    <input-editor content="# Test" />
  </b-card>
</template>

<script>
import Render from '../../components/editor/Render'
import InputEditor from '../../components/editor/InputEditor'
export default {
  name: 'Index',
  components: { InputEditor, Render },
}
</script>

<style scoped></style>
