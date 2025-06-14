<script setup>
import { ref, onMounted } from 'vue';
import { queryAllApi, addApi } from '@/api/dept';
import { ElMessage } from 'element-plus'
// import axios from 'axios';

//钩子函数 页面加载完毕后,执行 搜索函数
onMounted(() => {
  search();
})
// 查询
const deptList = ref([]);
// const search = async () => {
//    const result = await axios.get('https://m1.apifoxmock.com/m1/6374871-6071167-default/depts?apifoxApiId=308186010');
//    if (result.data.code) { // JS 隐式类型转换  0 - false, 其他数字 - true; '' - false, 其他都是 true; null, undefined -- false
//     deptList.value = result.data.data;
//    }
// }
const search = async () => {
  const result = await queryAllApi();
  if (result.code) {
    deptList.value = result.data;
  }
}

// Dialog 对话框
const dialogFormVisible = ref(false);
const dept = ref({ name: '' });
const formTitle = ref('');

// 新增部门
const addDept = () => {
  dialogFormVisible.value = true;
  formTitle.value = '新增部门';
  dept.value = { name: '' };
  // 重置校验规则 - 清空提示信息.
  if (deptFormRef.value) {
    deptFormRef.value.resetFields();
  }
}

// 保存部门
const save = async () => {
  //表单的校验
  if (!deptFormRef.value) return;
  deptFormRef.value.validate(async (valid) => { // valid 表示是否校验通过: true - 通过, false - 不通过.
    if (valid) { //通过
      const result = await addApi(dept.value);
      if (result.code) {
        // 提示信息
        ElMessage.success('操作成功');
        // 关闭对话框
        dialogFormVisible.value = false;
        // 查询
        search();
      } else {
        ElMessage.error(result.msg);
      }
    } else { // 不通过
      ElMessage.error('表单校验不通过.');
    }
  })
}

// 表单校验
const rules = ref({
  name: [
    { required: true, message: '部门名称是必填项', trigger: 'blur' },
    { min: 2, max: 10, message: ' 部门名称的长度应该在 2-10 位', trigger: 'blur' },
  ]
})

const deptFormRef = ref();
</script>

<template>
  <h1>部门管理</h1>
  <!-- 新增按钮 -->
  <div class="container">
    <el-button type="primary" @click="addDept">+ 新增部门</el-button>
  </div>
  <!-- 表格区域 -->
  <div class="container">
    <el-table :data="deptList" border style="width: 100%" height="500">
      <el-table-column fixed type="index" label="序号" width="100" align="center" />
      <el-table-column prop="name" label="部门名称" width="260" align="center" />
      <el-table-column prop="updateTime" label="最后操作时间" width="300" align="center" />
      <el-table-column label="操作">
        <template #default="scope">
          <el-button size="small" type="primary"><el-icon>
              <EditPen />
            </el-icon>编辑</el-button>
          <el-button size="small" type="danger"><el-icon>
              <Delete />
            </el-icon>删除</el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>

  <!-- Dialog 对话框 -->
  <el-dialog v-model="dialogFormVisible" :title="formTitle" width="500">
    <el-form :model="dept" :rules="rules" ref="deptFormRef">
      <el-form-item label="部门名称" label-width="80px" prop="name">
        <el-input v-model="dept.name" />
      </el-form-item>
    </el-form>
    <template #footer>
      <div class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取消</el-button>
        <el-button type="primary" @click="save">确定</el-button>
      </div>
    </template>
  </el-dialog>
</template>

<style scoped>
.container {
  margin: 10px 0;
}
</style>
