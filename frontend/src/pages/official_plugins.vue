<script setup lang="ts">
import Homepage from "~/components/Homepage.vue";
import { Category } from "~/types/backend";
</script>

<template>
  <Homepage :category="Category.OfficialPlugins" category-name="Official Plugins">
    <template #announcement>
      <div class="max-w-screen-md mx-auto">
        <h1 class="text-4xl font-bold uppercase text-center mt-4 flex flex-col w-full">ProjectKorra Downloads</h1>
        <div class="text-1xl text-center mb-2 mt-2">
          Here you can find all downloads related to ProjectKorra! Including official plugins, side plugins, custom abilities, and more!
        </div>
      </div>
    </template>
    <template #installation>
      <Card alternate-background class="min-w-300px max-w-300px flex flex-col gap-4">
        <h2 class="font-bold text-xl -mb-2">Installation</h2>
        <p>
          Official plugins are installed the same way as regular spigot plugins. Simply drag and drop the <code>.jar</code> file into the <code>/plugins/</code> folder of your server.
        </p>
        <p>
          Remember to restart your server after installation!
        </p>
      </Card>
    </template>
  </Homepage>
</template>
