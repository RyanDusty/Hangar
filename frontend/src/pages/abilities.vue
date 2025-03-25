<script setup lang="ts">
import Homepage from "~/components/Homepage.vue";
import { Category } from "~/types/backend";
</script>

<template>
  <Homepage :category="Category.Ability" category-name="Abilities">
    <template #announcement>
      <div class="max-w-screen-md mx-auto">
        <h1 class="text-4xl font-bold uppercase text-center mt-4 flex flex-col w-full">ProjectKorra Abilities</h1>
        <div class="text-1xl text-center mb-2 mt-2">
          Here you can find all singular abilities for ProjectKorra! These are custom abilities that can be added to your server to enhance your bending experience!
        </div>
      </div>
    </template>
    <template #installation>
      <Card alternate-background class="min-w-300px max-w-300px flex flex-col gap-4">
        <h2 class="font-bold text-xl -mb-2">Installation</h2>
        <p>
          Abilities are jar files containing a single custom ability for ProjectKorra. To install them, simply drag and drop the <code>.jar</code> file into the <code>/plugins/ProjectKorra/Abilities/</code> folder of your server. Then use <code>/b reload</code> to refresh your loaded abilities.
        </p>
      </Card>
    </template>
  </Homepage>
</template>
