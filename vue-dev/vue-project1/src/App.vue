<!-- 定义 JS, 控制模板部分的数据和行为(JS) -->
<script setup>
import { ref } from 'vue';

//生命一个响应式数据 message
const message = ref('Hello Vue3');
</script>

模板部分, 控制的是页面的结构(HTML)
<template>
  <h1>{{ message }}</h1>
</template>

<!-- 当前组件的 CSS 样式 -->
<style scoped></style>
