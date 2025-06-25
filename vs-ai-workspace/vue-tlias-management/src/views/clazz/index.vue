<script setup>
import { ref, watch, onMounted } from 'vue'
import { queryPageApi } from '@/api/clazz'


// 钩子函数
onMounted(() => {
  search();
})
// 搜索表单对象
const searchClazz = ref({
  name: '',
  date: [],
  begin: '',
  end: '',
})

// 使用 watch() 侦听searchEmp的 date 属性
watch(() => searchClazz.value.date, (newVal, odlVal) => {
  if (newVal.length == 2) {
    searchClazz.value.begin = newVal[0];
    searchClazz.value.end = newVal[1];
  } else {
    searchClazz.value.begin = '';
    searchClazz.value.begin = '';
  }
})

// 查询班级列表
const search = async () => {
  const result = await queryPageApi(
    searchClazz.value.name,
    searchClazz.value.begin,
    searchClazz.value.end,
    currentPage.value,
    pageSize.value,
  );
  if (result.code) {
    total.value = result.data.total;
    clazzList.value = result.data.rows;
  }
}

// 清空搜索栏
const clear = () => {
  searchClazz.value = { name: '', date: [], begin: '', end: '' };
  search();
}
// 添加班级
const addClazz = () => {
  dialogFormVisible.value = true;
  dialogTitle.value = '新增班级';
}
// 添加班级和修改班级的表单
const clazz = ref({
  id: '',
  name: '',
  room: '',
  beginDate: '',
  endDate: '',
  subject: '',
  masterId: ''
})

// 班级表格数据 - 列表展示数据
const clazzList = ref([])

// 分页组件
const currentPage = ref(1);
const pageSize = ref(10);
const background = ref(false);
const total = ref(0);
// 每页展示记录数变化
const handleSizeChange = (val) => {
  search();
}
// 页码变化是触发
const handleCurrentChange = (val) => {
  search();
}
// 添加班级对话框显示
const dialogFormVisible = ref(false);
const dialogTitle = ref('新增员工');


</script>

<template>
  <h1>班级管理</h1>
  <!-- 搜索表单 -->
  <div class="container">
    {{ searchClazz }}
    <el-form :inline="true" :model="searchClazz" class="demo-form-inline">
      <el-form-item label="班级名称">
        <el-input v-model="searchClazz.name" placeholder="请输入班级名称" clearable />
      </el-form-item>
      <el-form-item label="节课时间">
        <el-date-picker v-model="searchClazz.date" type="daterange" range-separator="至" start-placeholder="开始时间"
          end-placeholder="结束时间" value-format="YYYY-MM-DD" />
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
    <el-table :data="clazzList" border style="width: 100%">
      <el-table-column type="index" label="序号" width="55" align="center" />
      <el-table-column prop="name" label="班级名称" width="240" align="center" />
      <el-table-column prop="room" label="班级教室" width="100" align="center" />
      <el-table-column prop="masterName" label="班主任" width="100" align="center" />
      <el-table-column prop="beginDate" label="开课时间" width="130" align="center" />
      <el-table-column prop="endDate" label="结课时间" width="130" align="center" />
      <el-table-column prop="status" label="状态" width="100" align="center">
      </el-table-column>
      <el-table-column prop="updateTime" label="最后操作时间" width="220" align="center" />
      <el-table-column label="操作" align="center">
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
    {{ pageSize }} : {{ currentPage }}
    <el-pagination v-model:current-page="currentPage" v-model:page-size="pageSize" :page-sizes="[5, 10, 20, 30, 40, 50]"
      :background="background" layout="total, sizes, prev, pager, next, jumper" :total="total"
      @size-change="handleSizeChange" @current-change="handleCurrentChange" />
  </div>

  <!-- 新增班级/修改班级 -->
  <div class="container">
    <el-dialog v-model="dialogFormVisible" :title="dialogTitle" width="500">
      <el-form :model="clazz">
        <el-form-item label="班级姓名">
          <el-input v-model="clazz.name" placeholder="请输入班级名称, 如: 西安黑马JavaEE就业100期" clearable />
        </el-form-item>
        <el-form-item label="班级教室">
          <el-input v-model="clazz.room" placeholder="请填写班级教室" clearable />
        </el-form-item>
        <el-form-item label="开课时间">
          <el-date-picker v-model="clazz.beginDate" type="date" placeholder="请选择开课时间" value-format="YYYY-MM-DD" style="width: 100%;"/>
        </el-form-item>
        <el-form-item label="结课时间">
          <el-date-picker v-model="clazz.endDate" type="date" placeholder="请选择结课时间" value-format="YYYY-MM-DD" style="width: 100%;"/>
        </el-form-item>
        <el-form-item label="班主任">
          <el-select v-model="clazz.masterId" placeholder="请选择">
            <template #default="scope">
            </template>
          </el-select>
        </el-form-item>
        <el-form-item label="学科">
          <el-select v-model="clazz.subject" placeholder="请选择">
            <el-option label="Zone No.1" value="shanghai" />
            <el-option label="Zone No.2" value="beijing" />
          </el-select>
        </el-form-item>
      </el-form>
      <template #footer>
        <div class="dialog-footer">
          <el-button type="primary" @click="">保存</el-button>
          <el-button type="info" @click="dialogFormVisible = false">取消</el-button>
        </div>
      </template>
    </el-dialog>
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