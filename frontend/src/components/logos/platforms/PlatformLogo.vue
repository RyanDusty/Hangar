<script lang="ts" setup>
import { Platform } from "~/types/backend";

withDefaults(
  defineProps<{
    platform: Platform;
    size?: number;
  }>(),
  {
    size: 72,
  }
);
</script>
<template>
  <PaperLogo v-if="platform === Platform.PAPER" v-bind="$attrs" :width="size" :height="size" />
  <AssetLogo v-if="platform === Platform.ASSET" v-bind="$attrs" :width="size" :height="size" />
  <MinecraftLogo v-else-if="platform === Platform.MINECRAFT" v-bind="$attrs" :width="size" :height="size" />
  <ProjectKorraLogo v-else-if="platform === Platform.PROJECTKORRA" v-bind="$attrs" :width="size" :height="size" />
</template>
