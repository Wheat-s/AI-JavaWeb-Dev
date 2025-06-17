<script setup>
import { ref, watch, onMounted } from 'vue';
import { queryPageApi } from '@/api/emp';

// 搜索表单对象
const searchEmp = ref({
  name: '',
  gender: '',
  date: [],
  begin: '',
  end: '',
})

// 使用 watch() 侦听searchEmp的 date 属性
watch(() => searchEmp.value.date, (newVal, odlVal) => {
  if (newVal.length == 2) {
    searchEmp.value.begin = newVal[0];
    searchEmp.value.end = newVal[1];
  } else {
    searchEmp.value.begin = '';
    searchEmp.value.begin = '';
  }
})

// 搜索
const search = async () => {
  const result = await queryPageApi(
    searchEmp.value.name,
    searchEmp.value.gender,
    searchEmp.value.begin,
    searchEmp.value.end,
    currentPage.value,
    pageSize.value,
  );

  if (result.code) {
    empList.value = result.data.rows;
    total.value = result.data.total;
  }
}

// 清空
const clear = () => {
  searchEmp.value = {
    name: '',
    gender: '',
    date: [],
    begin: '',
    end: '',
  };
  search();
}

// 员工列表数据
const empList = ref([]);

// 分页
const currentPage = ref(1); // 页码
const pageSize = ref(10); // 每页展示的记录数
const background = ref(false); // 页码按钮背景色
const total = ref(0); // 总记录数

// 每页展示记录数变化
const handleSizeChange = (val) => {
  search();
}
// 页码变化是出发
const handleCurrentChange = (val) => {
  search();
}

// 钩子函数
onMounted(() => {
  search();
})
</script>

<template>
  <h1>员工管理</h1>
  {{ searchEmp }}

  <!-- 搜索栏 -->
  <div class="container">
    <el-form :inline="true" :model="searchEmp" class="demo-form-inline">
      <el-form-item label="姓名">
        <el-input v-model="searchEmp.name" placeholder="请输入员工姓名" clearable />
      </el-form-item>
      <el-form-item label="性别">
        <el-select v-model="searchEmp.gender" placeholder="性别" clearable>
          <el-option label="男" value="1" />
          <el-option label="女" value="2" />
        </el-select>
      </el-form-item>
      <el-form-item label="入职时间">
        <el-date-picker v-model="searchEmp.date" type="daterange" range-separator="到" start-placeholder="开始日期"
          end-placeholder="结束日期" value-format="YYYY-MM-DD" />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="search">查询</el-button>
        <el-button type="info" @click="clear">清空</el-button>
      </el-form-item>
    </el-form>
  </div>

  <!-- 功能按钮 -->
  <div class="container">
    <el-button type="primary" @click="">+ 新增员工</el-button>
    <el-button type="danger" @click="">- 批量删除</el-button>
  </div>

  <!-- 员工列表 -->
  <div class="container">
    <el-table :data="empList" border style="width: 100%">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column prop="name" label="姓名" width="120" align="center" />
      <el-table-column label="性别" width="120" align="center">
        <template #default="scope">
          {{ scope.row.gender == 1 ? '男' : '女' }}
        </template>
      </el-table-column>
      <el-table-column label="头像" width="120" align="center">
        <template #default="scope">
          <img :src="scope.row.image" height="40px">
        </template>
      </el-table-column>
      <el-table-column prop="deptName" label="所属部门" width="120" align="center" />
      <el-table-column prop="job" label="职位" width="120" align="center">
        <template #default="scope">
          <span v-if="scope.row.job == 1">班主任</span>
          <span v-else-if="scope.row.job == 2">讲师</span>
          <span v-else-if="scope.row.job == 3">学工主管</span>
          <span v-else-if="scope.row.job == 4">学工主管</span>
          <span v-else-if="scope.row.job == 5">教研主管</span>
          <span v-else-if="scope.row.job == 6">咨询师</span>
          <span v-else>其他</span>
        </template>
      </el-table-column>
      <el-table-column prop="entryDate" label="入职日期" width="180" align="center" />
      <el-table-column prop="updateTime" label="最后操作时间" width="200" align="center" />
      <el-table-column label="操作">
        <el-button type="primary" @click="">编辑</el-button>
        <el-button type="danger" @click="">删除</el-button>
      </el-table-column>
    </el-table>
  </div>

  <!-- 分页条 -->
  <div class="container">
    {{ currentPage }} : {{ pageSize }}
    <el-pagination v-model:current-page="currentPage" v-model:page-size="pageSize"
      :page-sizes="[5, 10, 20, 30, 50, 75, 100]" :background="background"
      layout="total, sizes, prev, pager, next, jumper" :total="total" @size-change="handleSizeChange"
      @current-change="handleCurrentChange" />
  </div>
</template>

<style scoped>
.container {
  margin: 10px 0px;
}
</style>