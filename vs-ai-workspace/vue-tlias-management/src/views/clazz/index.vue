<script setup>
import { ref } from 'vue'


// 搜索表单对象
const searchClazz = ref({
  name: '',
  date: [],
  begin: '',
  end: '',
})

// 班级表格数据
const tableData = [
  {
    date: '2016-05-03',
    name: 'Tom',
    address: 'No. 189, Grove St, Los Angeles',
  },
  {
    date: '2016-05-02',
    name: 'Tom',
    address: 'No. 189, Grove St, Los Angeles',
  },
  {
    date: '2016-05-04',
    name: 'Tom',
    address: 'No. 189, Grove St, Los Angeles',
  },
  {
    date: '2016-05-01',
    name: 'Tom',
    address: 'No. 189, Grove St, Los Angeles',
  },
]

// 分页器
const currentPage4 = ref(1)
const pageSize4 = ref(10)
const background = ref(false)
const total = ref(0)
// 每页展示记录数变化
const handleSizeChange = (val) => {
  console.log(`${val} items per page`)
}
// 页码变化是触发
const handleCurrentChange = (val) => {
  console.log(`current page: ${val}`)
}

</script>

<template>
  <h1>班级管理</h1>
  <!-- 搜索表单 -->
  <div class="container">
    <el-form :inline="true" :model="searchClazz" class="demo-form-inline">
      <el-form-item label="班级名称">
        <el-input v-model="searchClazz.user" placeholder="请输入班级名称" clearable />
      </el-form-item>
      <el-form-item label="节课时间">
        <el-date-picker v-model="value1" type="daterange" range-separator="至" start-placeholder="开始时间"
          end-placeholder="结束时间" :size="size" />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="search">查询</el-button>
        <el-button type="info" @click="clear">清空</el-button>
      </el-form-item>
    </el-form>
  </div>

  <!-- 新增班级按钮 -->
  <div class="container">
    <el-button type="primary" @click="addClazz">+ 新增班级</el-button>
  </div>

  <!-- 班级表格列表 -->
  <div class="container">
    <el-table :data="tableData" border style="width: 100%">
      <el-table-column type="index" label="序号" width="55" align="center" />
      <el-table-column prop="date" label="班级名称" width="240" align="center" />
      <el-table-column prop="name" label="班级教室" width="100" align="center" />
      <el-table-column prop="name" label="班主任" width="100" align="center" />
      <el-table-column prop="name" label="开课时间" width="130" align="center" />
      <el-table-column prop="name" label="结课时间" width="130" align="center" />
      <el-table-column prop="name" label="状态" width="100" align="center" />
      <el-table-column prop="name" label="最后操作时间" width="220" align="center" />
      <el-table-column prop="address" label="操作" align="center">
        <template #default="scope">
          <el-button type="primary" @click=""><el-icon>
              <EditPen />
            </el-icon>编辑</el-button>
          <el-button type="danger" @click=""><el-icon>
              <Delete />
            </el-icon>删除</el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>

  <!-- 分页条 -->
  <div class="container">
    <el-pagination v-model:current-page="currentPage4" v-model:page-size="pageSize4"
      :page-sizes="[5, 10, 20, 30, 40, 50]" :background="background" layout="total, sizes, prev, pager, next, jumper"
      :total="total" @size-change="handleSizeChange" @current-change="handleCurrentChange" />
  </div>
</template>

<style scoped>
.container {
  margin: 10px 0px;
}

.demo-form-inline .el-input {
  --el-input-width: 220px;
}

.demo-form-inline .el-select {
  --el-select-width: 220px;
}

.demo-pagination-block+.demo-pagination-block {
  margin-top: 10px;
}

.demo-pagination-block .demonstration {
  margin-bottom: 16px;
}
</style>