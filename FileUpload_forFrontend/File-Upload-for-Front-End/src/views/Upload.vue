<script setup>
import { useRouter } from "vue-router";

let appRouter = useRouter()

const home = () => {
  appRouter.push({ name: "Home" });
};
</script>
 
<template>
<h1>User Form</h1>
<button @click="home">back</button>
</template>
 
<style>

</style>