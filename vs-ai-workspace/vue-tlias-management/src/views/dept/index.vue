<script setup>
import { ref } from 'vue';
const tableData = ref([
  {
    "id": 1,
    "name": "学工部",
    "createTime": "2022-09-01T23:06:29",
    "updateTime": "2022-09-01T23:06:29"
  },
  {
    "id": 1,
    "name": "学工部",
    "createTime": "2022-09-01T23:06:29",
    "updateTime": "2022-09-01T23:06:29"
  },
  {
    "id": 1,
    "name": "学工部",
    "createTime": "2022-09-01T23:06:29",
    "updateTime": "2022-09-01T23:06:29"
  },
  {
    "id": 1,
    "name": "学工部",
    "createTime": "2022-09-01T23:06:29",
    "updateTime": "2022-09-01T23:06:29"
  },
  {
    "id": 1,
    "name": "学工部",
    "createTime": "2022-09-01T23:06:29",
    "updateTime": "2022-09-01T23:06:29"
  },
  {
    "id": 1,
    "name": "学工部",
    "createTime": "2022-09-01T23:06:29",
    "updateTime": "2022-09-01T23:06:29"
  },
  {
    "id": 1,
    "name": "学工部",
    "createTime": "2022-09-01T23:06:29",
    "updateTime": "2022-09-01T23:06:29"
  }, {
    "id": 1,
    "name": "学工部",
    "createTime": "2022-09-01T23:06:29",
    "updateTime": "2022-09-01T23:06:29"
  },
  {
    "id": 1,
    "name": "学工部",
    "createTime": "2022-09-01T23:06:29",
    "updateTime": "2022-09-01T23:06:29"
  },
  {
    "id": 1,
    "name": "学工部",
    "createTime": "2022-09-01T23:06:29",
    "updateTime": "2022-09-01T23:06:29"
  }, {
    "id": 1,
    "name": "学工部",
    "createTime": "2022-09-01T23:06:29",
    "updateTime": "2022-09-01T23:06:29"
  },
  {
    "id": 1,
    "name": "学工部",
    "createTime": "2022-09-01T23:06:29",
    "updateTime": "2022-09-01T23:06:29"
  },
  {
    "id": 1,
    "name": "学工部",
    "createTime": "2022-09-01T23:06:29",
    "updateTime": "2022-09-01T23:06:29"
  },
  {
    "id": 1,
    "name": "学工部",
    "createTime": "2022-09-01T23:06:29",
    "updateTime": "2022-09-01T23:06:29"
  },
  {
    "id": 1,
    "name": "学工部",
    "createTime": "2022-09-01T23:06:29",
    "updateTime": "2022-09-01T23:06:29"
  },
  {
    "id": 1,
    "name": "学工部",
    "createTime": "2022-09-01T23:06:29",
    "updateTime": "2022-09-01T23:06:29"
  },
  {
    "id": 1,
    "name": "学工部",
    "createTime": "2022-09-01T23:06:29",
    "updateTime": "2022-09-01T23:06:29"
  },
  {
    "id": 1,
    "name": "学工部",
    "createTime": "2022-09-01T23:06:29",
    "updateTime": "2022-09-01T23:06:29"
  },
  {
    "id": 1,
    "name": "学工部",
    "createTime": "2022-09-01T23:06:29",
    "updateTime": "2022-09-01T23:06:29"
  },
  {
    "id": 1,
    "name": "学工部",
    "createTime": "2022-09-01T23:06:29",
    "updateTime": "2022-09-01T23:06:29"
  },
  {
    "id": 1,
    "name": "学工部",
    "createTime": "2022-09-01T23:06:29",
    "updateTime": "2022-09-01T23:06:29"
  },
  {
    "id": 1,
    "name": "学工部",
    "createTime": "2022-09-01T23:06:29",
    "updateTime": "2022-09-01T23:06:29"
  },
  {
    "id": 1,
    "name": "学工部",
    "createTime": "2022-09-01T23:06:29",
    "updateTime": "2022-09-01T23:06:29"
  },
  {
    "id": 1,
    "name": "学工部",
    "createTime": "2022-09-01T23:06:29",
    "updateTime": "2022-09-01T23:06:29"
  },
  {
    "id": 1,
    "name": "学工部",
    "createTime": "2022-09-01T23:06:29",
    "updateTime": "2022-09-01T23:06:29"
  },
  {
    "id": 1,
    "name": "学工部",
    "createTime": "2022-09-01T23:06:29",
    "updateTime": "2022-09-01T23:06:29"
  },
  {
    "id": 1,
    "name": "学工部",
    "createTime": "2022-09-01T23:06:29",
    "updateTime": "2022-09-01T23:06:29"
  },



])
</script>

<template>
  <h1>部门管理</h1>
  <div class="container">
    <el-button type="primary">+ 新增部门</el-button>
  </div>
  <div class="container">
    <el-table :data="tableData" border style="width: 100%" height="500">
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
