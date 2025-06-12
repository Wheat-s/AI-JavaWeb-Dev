<script setup>
import { ref,onMounted } from 'vue';
import axios from 'axios';

//钩子函数 页面加载完毕后,执行 搜索函数
onMounted(() => {
  search();
})
// 查询
const search = async () => {
   const result = await axios.get('https://m1.apifoxmock.com/m1/6374871-6071167-default/depts?apifoxApiId=308186010');
   if (result.data.code) { // JS 隐式类型转换  0 - false, 其他数字 - true; '' - false, 其他都是 true; null, undefined -- false
    deptList.value = result.data.data;
   }
}

const deptList = ref([]);
</script>

<template>
  <h1>部门管理</h1>
  <div class="container">
    <el-button type="primary">+ 新增部门</el-button>
  </div>
  <div class="container">
    <el-table :data="deptList" border style="width: 100%" height="500">
      <el-table-column fixed type="index" label="序号" width="100" align="center" />
      <el-table-column prop="name" label="部门名称" width="260" align="center" />
      <el-table-column prop="updateTime" label="最后操作时间" width="300" align="center" />
      <el-table-column label="操作">
        <template #default="scope">
          <el-button size="small" type="primary"><el-icon><EditPen /></el-icon>编辑</el-button>
          <el-button size="small" type="danger"><el-icon><Delete /></el-icon>删除</el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<style scoped>
.container {
  margin: 10px 0;
}
</style>
