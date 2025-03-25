<script lang="ts" setup>
const { version } = useVersionInfo();
const route = useRoute("version");
useSeo(computed(() => ({ title: "Hangar Version", route })));
</script>

<template>
  <div>
    <PageTitle>Hangar Version</PageTitle>
    <template v-if="version">
      <p mb="2">This instance is running <Link href="https://github.com/StrangeOne101/Hangar">Hangar</Link> {{ version.version }}</p>
      <p mb="2">
        The most recent commit is <Link :href="'https://github.com/StrangeOne101/Hangar/commit/' + version.commit">{{ version.commitShort }}</Link> by
        <span class="font-bold">{{ version.committer }}</span> at {{ version.time }} with message: <br />
        {{ version.message }}
      </p>
      <p v-if="version.tag" mb="2">Last Tag: {{ version.tag }} ({{ version.behind || 0 }} commits since tag)</p>
      <p mt="6">
        Please report bugs and other problems you encounter to our <Link href="https://github.com/StrangeOne101/Hangar/issues/new/choose">issue tracker</Link>.
      </p>
    </template>
    <Alert v-else mt="4" type="danger"> Version info couldn't be loaded! </Alert>
  </div>
</template>
