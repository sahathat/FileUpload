<script setup>
import { ref, onBeforeMount} from 'vue';
import { useRouter } from 'vue-router';

const users = ref([])

const getAllUser = async () => {
  let res = await fetch("http://localhost:8080/api/users")
  if (res.status === 200) {
    users.value = await res.json();
    console.log("select successful");
  } else {
    console.log("error by status " + res.status);
  }
}
onBeforeMount(
  getAllUser
)

let appRouter = useRouter()

const upload = () => {
    appRouter.push({ name: "Upload"})
}

const detail = (id) => {
    appRouter.push({ name: "Detail", params: {id: id}})
}

</script>

<template>
<div>
  <h1>My User</h1>
  
  <button @click="upload">Upload user</button>

  <hr>
  <ol>
    <li v-for="(item,index) in users" :key="index">
      name: {{item.name}}, credit: {{item.credit}} <button @click="detail(item.id)">view detail</button>
    </li>
  </ol>
</div>
</template>

<style>
</style>
