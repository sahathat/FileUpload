<script setup>
import { ref } from "vue";
import { useRouter } from "vue-router";

let appRouter = useRouter();

let user = ref({ name: "", credit: 0 , image: "" });

let createdUser = async (newUser) => {
  console.log(newUser)
  let res = await fetch("http://localhost:8080/api/users", {
    method: "POST",
    headers: {
      "content-type": "application/json",
    },
    body: JSON.stringify({
      name: newUser.name,
      credit: newUser.credit,
      image: newUser.image,
    }),
  });
  if (res.status === 201) {
    home()
  } else {
    console.log("error by status " + res.status);
  }
};

let uploadImage = async (event) => {
  let formData = new FormData();
  formData.append("file", event.target.files[0]);

  let res = await fetch("http://localhost:8080/api/files", {
    method: "POST",
    body: formData,
  });
  if (res.status === 200) {
    res = await fetch(
      "http://localhost:8080/api/files/" + event.target.files[0].name
    );
    user.value.image = res.url;
    console.log("add successful");
  } else {
    console.log("error by status " + res.status);
  }
};

const home = async () => {
  // if(user.value.image != "" ){
  //   await fetch(user.value.image, {
  //     method: 'DELETE'
  //   })
  // }
  appRouter.push({ name: "Home" });
};
</script>

<template>
  <h1>User Form</h1>
  <p>Name: <input type="text" v-model="user.name" /></p>
  <p>Credit: <input type="number" min="0" max="100000" step="100" v-model="user.credit" /></p>
  <p>
    Upload Image: <br/>
    <input type="file" @change="uploadImage" />
  </p>
  <p>
  <p v-if="user.image != '' ">
  <img
    :src="user.image"
    width=400
    height=400
  >
  </p>

  </p>

  <button @click="createdUser(user)">submit</button>
  <button @click="home">back</button>
</template>

<style></style>
