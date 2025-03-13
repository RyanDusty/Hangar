<script setup lang="ts">
import Homepage from "~/components/Homepage.vue";
import { Category } from "~/types/backend";
</script>

<template>
  <Homepage :category="Category.OfficialPlugins" category-name="Official Plugins" />
</template>
