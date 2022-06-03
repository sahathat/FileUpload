<script setup>
import { ref, onBeforeMount } from "vue";
import { useRoute, useRouter } from "vue-router";

let user = ref({});

let { params } = useRoute();

const getUserInfo = async () => {
  let res = await fetch("http://localhost:8080/api/users/" + params.id);
  if (res.status === 200) {
    user.value = await res.json();
    console.log("select successful");
  } else {
    console.log("error by status " + res.status);
  }
};
onBeforeMount(getUserInfo);

let appRouter = useRouter();

const home = () => {
  appRouter.push({ name: "Home" });
};

let deleteUser = async () => {
  if (confirm("are you sure delete this user?") === true) {
    let res = await fetch("http://localhost:8080/api/users/" + params.id, {
      method: "DELETE",
    });
    if (res.status === 200) {
      appRouter.push({ name: "Home" });
      console.log("id " + id + " delete success");
    } else {
      console.log("error by status " + res.status);
    }
  }
};
</script>

<template>
  <div>
    <h1>User Detail</h1>
    <p>Name: {{ user.name }}</p>
    <p>Credit: {{ user.credit }}</p>
    <button @click="deleteUser">delete</button> <br />
    <button @click="home">back</button>
  </div>
</template>

<style></style>
