<script setup>
//引入 
import { ref, onMounted } from 'vue';
import axios from 'axios';

//声明响应式数据
const name = ref('');
const gender = ref('');
const job = ref('');

const userList = ref([]);

//声明函数 - 箭头函数 - await & async
const search = async () => {
  //基于axios发送异步请求,请求服务器端加载数据
  const result = await axios.get(`https://web-server.itheima.net/emps/list?name=${name.value}&gender=${gender.value}&job=${job.value}`);
  userList.value = result.data.data;
}

//钩子函数 - 监听DOM元素
onMounted(() => {
  search();
})
</script>

<template>
  <div id="center">
    姓名: <input type="text" name="name" v-model="name">

    性别:
    <select name="gender" v-model="gender">
      <option value="1">男</option>
      <option value="2">女</option>
    </select>

    职位:
    <select name="job" v-model="job">
      <option value="1">班主任</option>
      <option value="2">讲师</option>
      <option value="3">其他</option>
    </select>

    <input class="btn" type="button" value="查询" @click="search">
  </div>
  
  <table>
    <thead>
      <tr>
        <th>序号</th>
        <th>姓名</th>
        <th>头像</th>
        <th>性别</th>
        <th>职位</th>
        <th>入职时间</th>
        <th>更新时间</th>
      </tr>
    </thead>
    <tbody>
      <tr v-for="(user, index) in userList" :key="user.id">
        <td>{{ index + 1 }}</td>
        <td>{{ user.name }}</td>
        <td><img :src="user.image" alt="用户头像"></td>
        <td>
          <span v-if="user.gender == 1">男</span>
          <span v-else-if="user.gender == 2">女</span>
          <span v-else>其他</span>
        </td>
        <td>
          <span v-if="user.job == 1">班主任</span>
          <span v-else-if="user.job == 2">讲师</span>
          <span v-else-if="user.job == 3">学工主管</span>
          <span v-else-if="user.job == 4">教研主管</span>
          <span v-else-if="user.job == 5">咨询师</span>
          <span v-else>其他</span>
        </td>
        <td>{{ user.entrydate }}</td>
        <td>{{ user.updatetime }}</td>
      </tr>
    </tbody>
  </table>
</template>



<style scoped>
  table,th,td {
    border: 1px solid #000;
    border-collapse: collapse;
    line-height: 50px;
    text-align: center;
  }

  #center,table {
    width: 60%;
    margin: auto;
  }

  #center {
    margin-bottom: 20px;
  }

  img {
    width: 50px;
  }

  input,select {
    width: 17%;
    padding: 10px;
    margin-right: 30px;
    border: 1px solid #ccc;
    border-radius: 4px;
  }

  .btn {
    background-color: #ccc;
  }
</style>