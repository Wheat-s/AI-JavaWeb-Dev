<script setup>
import { ref } from 'vue'

// 表格数据
const tableData = [
  { date: '2016-05-03', name: 'Tom', address: 'No. 189, Grove St, Los Angeles', },
  { date: '2016-05-02', name: 'Tom', address: 'No. 189, Grove St, Los Angeles', },
  { date: '2016-05-04', name: 'Tom', address: 'No. 189, Grove St, Los Angeles', },
  { date: '2016-05-01', name: 'Tom', address: 'No. 189, Grove St, Los Angeles', },
]

// 分页组件
const currentPage4 = ref(4); // 当前页码
const pageSize4 = ref(10); // 每页展示的记录数
const total = ref(400) // 总记录数
const background = ref(true); // 是否有背景色
const handleSizeChange = (val) => { console.log(`每页展示:${val} 条`) }
const handleCurrentChange = (val) => { console.log(`当前页码: ${val}`) }
const dialogTableVisible = ref(false)

// 表单组件
const user = ref({
  name: '',
  gender: '',
  birthday: '',
})

const onSubmit = () => {
  console.log(user.value)
}

</script>

<template>
  <div class="common-layout">
    <el-container>
      <el-header>Header</el-header>
      <el-main>
        <!-- 按钮 -->
        <div class="mb-4">
          <el-button>Default</el-button>
          <el-button type="primary">Primary</el-button>
          <el-button type="success">Success</el-button>
          <el-button type="info">Info</el-button>
          <el-button type="warning">Warning</el-button>
          <el-button type="danger">Danger</el-button>
        </div>

        <div class="mb-4">
          <el-button plain>Plain</el-button>
          <el-button type="primary" plain>Primary</el-button>
          <el-button type="success" plain>Success</el-button>
          <el-button type="info" plain>Info</el-button>
          <el-button type="warning" plain>Warning</el-button>
          <el-button type="danger" plain>Danger</el-button>
        </div>

        <!-- 表格 -->
        <div class="mb-4">
          <el-table :data="tableData" :border="true" :stripe="true" style="width: 100%">
            <el-table-column prop="date" label="生日" width="280" align="center" />
            <el-table-column prop="name" label="姓名" width="100" align="center" />
            <el-table-column prop="address" label="地址" />
          </el-table>
        </div>

        <!-- 分页条 -->
        <div class="mb-4">
          <el-pagination v-model:current-page="currentPage4" v-model:page-size="pageSize4"
            :page-sizes="[10, 20, 30, 40, 50, 60, 70, 80, 90, 100]" :background="background"
            layout="total, sizes, prev, pager, next, jumper" :total="total" @size-change="handleSizeChange"
            @current-change="handleCurrentChange" />
        </div>

        <!-- 对话框 -->
        <div class="mb-4">
          <el-button plain @click="dialogTableVisible = true">打开Dialog对话框</el-button>

          <el-dialog v-model="dialogTableVisible" title="收货地址" width="800">
            <el-table :data="tableData">
              <el-table-column property="date" label="日期" width="150" align="center" />
              <el-table-column property="name" label="姓名" width="200" align="center" />
              <el-table-column property="address" label="地址" />
            </el-table>
          </el-dialog>
        </div>

        <!-- 表单组件 -->
        <div class="mb-4">
          <el-form :inline="true" :model="user" class="demo-form-inline">
            <el-form-item label="姓名">
              <el-input v-model="user.name" placeholder="请输入姓名" clearable />
            </el-form-item>
            <el-form-item label="性别">
              <el-select v-model="user.gender" placeholder="请选择">
                <el-option label="男" value="1" />
                <el-option label="女" value="2" />
              </el-select>
            </el-form-item>
            <el-form-item label="生日">
              <el-date-picker v-model="user.birthday" type="date" placeholder="请选择" value-format="YYYY-MM-DD" />
            </el-form-item>
            <el-form-item>
              <el-button type="primary" @click="onSubmit">Query</el-button>
            </el-form-item>
          </el-form>
        </div>
      </el-main>
      <el-footer>Footer</el-footer>
    </el-container>
  </div>

</template>

<style scoped>
.mb-4 {
  margin-bottom: 10px;
}

/* 新增表头背景色样式 */
.mb-4 ::v-deep .el-table th {
  background-color: #e6f3ff;
  /* 使用淡蓝色背景 */
}

.demo-form-inline .el-input {
  --el-input-width: 220px;
}

.demo-form-inline .el-select {
  --el-select-width: 220px;
}
</style>
