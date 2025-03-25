<script setup lang="ts">
import Homepage from "~/components/Homepage.vue";
</script>

<template>
  <Homepage category-name="Search">
    <template #announcement>
      <div class="max-w-screen-md mx-auto">
        <h1 class="text-4xl font-bold uppercase text-center mt-4 flex flex-col w-full">Search All Resources</h1>
        <div class="text-1xl text-center mb-2 mt-2">
          Here you can search all categories, including the more niche categories like Resource Packs, Data Packs and Worlds!</div>
        <div class="text-1xl text-center mb-2 mt-2">
          You can also search for version compatible resources by clicking on either "Minecraft" or "ProjectKorra" and then selecting which versions you want to filter by.
        </div>
      </div>
    </template>
  </Homepage>
</template>
