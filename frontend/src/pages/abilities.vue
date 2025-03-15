<script setup lang="ts">
import Homepage from "~/components/Homepage.vue";
import { Category } from "~/types/backend";
</script>

<template>
  <Homepage :category="Category.Ability" category-name="Abilities">
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
