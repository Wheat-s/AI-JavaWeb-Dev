<script setup>
//引入 ref 函数
import { onMounted, ref } from 'vue';

//生命响应式数据
const count = ref(0);

//生命函数 - 在组合api中没有this
function increment() {
  count.value++;
}

//钩子函数
onMounted(() => {
  console.log('Vue mounted...');
})
</script>

<template>
  <button @click="increment">count: {{ count }}</button>
</template>

<style scoped></style>