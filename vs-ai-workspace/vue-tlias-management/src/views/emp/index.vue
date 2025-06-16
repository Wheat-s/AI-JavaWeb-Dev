<script setup>
import { ref, watch } from 'vue';

// 搜索表单对象
const searchEmp = ref({
  name: '',
  gender: '',
  date: [],
  begin: '',
  end: '',
})

// 使用 watch() 侦听searchEmp的 date 属性
watch(() => searchEmp.value.date,(newVal, odlVal) => {
  if (newVal.length == 2) {
    searchEmp.value.begin = newVal[0];
    searchEmp.value.end = newVal[1];
  } else {
    searchEmp.value.begin = '';
    searchEmp.value.begin = '';
  }
})

// 搜索
const search = () => {
  console.log(searchEmp.value);

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
</template>

<style scoped>
.container {
  margin: 15px 0px;
}
</style>