<script setup lang="ts">
import hangarLogo from "~/assets/hangar-logo.svg";

const { t } = useI18n();

const year = new Date().getFullYear();
</script>

<template>
  <footer class="relative mt-10 py-1 background-default text-light-10">
    <div class="mt-3 mb-3 max-w-screen-xl mx-auto px-4">
      <div class="flex flex-wrap flex-col gap-4 justify-around items-center text-sm">
        <div class="flex flex-row flex-wrap justify-center">
          <a
            href="https://github.com/ProjectKorra/"
            class="flex items-center rounded-md px-6 py-2"
            hover="text-primary-500 bg-primary-0"
            target="_blank"
            rel="noreferrer noopener"
          >
            {{ t("hangar.footer.org") }}
          </a>
          <a
            href="https://discord.gg/pPJe5p3"
            class="flex items-center rounded-md px-6 py-2"
            hover="text-primary-500 bg-primary-0"
            target="_blank"
            rel="noreferrer noopener"
          >
            Discord
          </a>
          <a
            href="https://wiki.projectkorra.com"
            class="flex items-center rounded-md px-6 py-2"
            hover="text-primary-500 bg-primary-0"
            target="_blank"
            rel="noreferrer noopener"
          >
            Wiki
          </a>
          <a
            href="https://javadoc.io/doc/com.projectkorra/projectkorra"
            class="flex items-center rounded-md px-6 py-2"
            hover="text-primary-500 bg-primary-0"
            target="_blank"
            rel="noreferrer noopener"
          >
            Javadocs
          </a>
          
          <NuxtLink :to="{ name: 'terms' }" class="flex items-center rounded-md px-6 py-2" hover="text-primary-500 bg-primary-0">
            {{ t("hangar.footer.terms") }}
          </NuxtLink>
        </div>
        <div class="flex flex-grow-1 lt-md:justify-center">
          <p class="font-bold">© {{ year }} <a href="https://projectkorra.com/">ProjectKorra</a></p>
        </div>
        <div class="flex flex-grow-1 text-opacity-80 font-size-3 font-light text-center max-w-screen-md">
          <p>This website is not an official Minecraft website and is not associated with Mojang Studios or Microsoft. All product and company names are
            trademarks or registered trademarks of their respective holders. Use of these names does not imply any affiliation or endorsement by them.</p>
        </div>
        <div class="flex flex-grow-1 text-opacity-80 font-size-3 font-bold text-center">
          <p class="mt-2"><a href="https://github.com/HangarMC/Hangar/">Website powered by Hangar <img class="relative inline" alt="Hangar Logo" :src="hangarLogo" height="21" width="22" /></a></p>
        </div>
        
      </div>
    </div>
  </footer>
</template>
