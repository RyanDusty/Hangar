<script setup lang="ts">
import Homepage from "~/components/Homepage.vue";
import { Category } from "~/types/backend";

//const settingsStore = useSettingsStore();

</script>

<template>
  <Homepage :category="Category.SidePlugin" category-name="Side Plugins">
    <template #announcement>
      <div class="max-w-screen-md mx-auto">
        <h1 class="text-4xl font-bold uppercase text-center mt-4 flex flex-col w-full">Side Plugins</h1>
        <div class="text-1xl text-center mb-2 mt-2">
          Here you can find all side plugins for ProjectKorra! These can be ability packs, new custom elements, or custom GUIs to use on your server!
        </div>
      </div>
    </template>
    <template #installation>
      <Card alternate-background class="min-w-300px max-w-300px flex flex-col gap-4">
        <h2 class="font-bold text-xl -mb-2">Installation</h2>
        <p>
          Side plugins are installed the same way as ProjectKorra. Simply drag and drop the <code>.jar</code> file into the <code>/plugins/</code> folder of your server.
        </p>
        <p>
          When installing a side plugin, make sure to restart your server before trying to use them.
        </p>
      </Card>
    </template>
  </Homepage>
</template>
