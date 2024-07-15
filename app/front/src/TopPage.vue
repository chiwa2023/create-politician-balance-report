<script setup lang="ts">
//import { ref, Ref } from 'vue';
//import axios from 'axios';
//import SelectOptionDto from './dto/selectOptionDto';

//const options:Ref<SelectOptionDto[]> = ref([]);
//async function getOptions(){
//    alert("押す");
//    options.value = await axios.get('http://localhost:8080/trial-api-rest')
//    .then((response) => {return response.data})
//    .catch((error) => {alert(error)});
//} 
</script>
<template>
    <h1>(仮)Top Page</h1>

    <RouterLink to="/add_politician_orgnization">政治団体設立届</RouterLink><br>
    <RouterLink to="/read_fin_institution_csv">一般CSVを読みとってデータの仕分けをする</RouterLink><br>
    <RouterLink to="/publish_submisson">発行した収支報告書XMLを提出する</RouterLink><br>
    <RouterLink to="/component">コンポーネント作成台紙</RouterLink><br>
</template>
<style scoped></style>
