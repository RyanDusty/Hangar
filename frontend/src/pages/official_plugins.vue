<script setup lang="ts">
import Homepage from "~/components/Homepage.vue";
import { Platform, Category } from "~/types/backend";
</script>

<template>
  <Homepage :category="Category.OFFICIAL_PLUGINS" category-name="Official Plugins" />
</template>
