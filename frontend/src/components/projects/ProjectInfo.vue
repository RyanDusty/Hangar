<script setup lang="ts">
import { type HangarProject, NamedPermission, Tag } from "~/types/backend";

const props = defineProps<{
  project?: HangarProject;
}>();
const i18n = useI18n();
const namespace = computed(() => props.project?.namespace?.owner + "/" + props.project?.name);
</script>

<template>
  <Card>
    <template #header>
      <h2>{{ i18n.t("project.info.title") }}</h2>
    </template>
    <template #default>
      <table class="w-full">
        <tbody>
          <tr>
            <th class="text-left">{{ i18n.t("project.category.info") }}</th>
            <td v-if="project">{{ i18n.t("project.category." + project.category) }}</td>
            <td v-else><Skeleton /></td>
          </tr>
          <tr>
            <th class="text-left">{{ i18n.t("project.info.publishDate") }}</th>
            <td v-if="project">{{ i18n.d(project.createdAt, "date") }}</td>
            <td v-else><Skeleton /></td>
          </tr>
          <tr>
            <th class="text-left">{{ i18n.t("project.info.license") }}</th>
            <td v-if="project && (project.settings.license?.type === '(custom)' || project.settings.license?.type === 'Other')">
              <Link v-if="project?.settings.license.url" :href="project.settings.license.url" target="_blank" rel="noreferrer noopener">
                {{ project.settings.license.name }}
              </Link>
              <template v-else>
                {{ project?.settings.license.name }}
              </template>
            </td>
            <td v-else-if="project">
              <Link v-if="project.settings.license.url" :href="project.settings.license.url" target="_blank" rel="noreferrer noopener">
                {{ project.settings.license.type }}
              </Link>
              <template v-else>
                {{ project.settings.license.type }}
              </template>
            </td>
            <td v-else><Skeleton /></td>
          </tr>
          <tr v-if="hasPerms(NamedPermission.IsSubjectMember)">
            <th class="text-left">{{ i18n.t("project.info.views", project?.stats?.views || 0) }}</th>
            <td v-if="project">
              {{ project.stats.views.toLocaleString("en-US") }}
            </td>
            <td v-else><Skeleton /></td>
          </tr>
          <tr>
            <th class="text-left">{{ i18n.t("project.info.totalDownloads", project?.stats?.downloads || 0) }}</th>
            <td v-if="project">
              {{ project.stats.downloads.toLocaleString("en-US") }}
            </td>
            <td v-else><Skeleton /></td>
          </tr>
          <tr>
            <th class="text-left">
              <Link :to="`/${namespace}/stars`">
                {{ i18n.t("project.info.stars", 0) }}
              </Link>
            </th>
            <td v-if="project">{{ project?.stats?.stars.toLocaleString("en-US") }}</td>
            <td v-else><Skeleton /></td>
          </tr>
          <tr>
            <th class="text-left">
              <Link :to="`/${namespace}/watchers`">
                {{ i18n.t("project.info.watchers", 0) }}
              </Link>
            </th>
            <td v-if="project">{{ project?.stats?.watchers.toLocaleString("en-US") }}</td>
            <td v-else><Skeleton /></td>
          </tr>
        </tbody>
      </table>

      <div v-for="tag in project?.settings?.tags" :key="tag">
        <div class="inline-flex items-center">
          <IconMdiPuzzleOutline v-if="tag === Tag.CUSTOM_ABILITY" />
                <IconMdiFileDocumentMultiple v-else-if="tag === Tag.ABILITY_PACK" />
                <IconMdiAllInclusiveBox v-else-if="tag === Tag.PASSIVE_ABILITY" />
                <IconMdiNumeric v-else-if="tag === Tag.COMBO_ABILITY" />
                <IconMdiNumeric9BoxMultiple v-else-if="tag === Tag.MULTI_ABILITY" />
                <IconMdiNewBox v-else-if="tag === Tag.CUSTOM_ELEMENT" />
                <IconMdiMonitor v-else-if="tag === Tag.GUI" />
                <IconMdiDecagram v-else-if="tag === Tag.ELEMENT_AVATAR" />
                <IconMdiDecagramOutline v-else-if="tag === Tag.ELEMENT_DARK_AVATAR" />
                <IconMdiFire v-else-if="tag === Tag.ELEMENT_FIRE" />
                <IconMdiFlare v-else-if="tag === Tag.ELEMENT_COMBUSTION" />
                <IconMdiFlash v-else-if="tag === Tag.ELEMENT_LIGHTNING" />
                <IconMdiWater v-else-if="tag === Tag.ELEMENT_WATER" />
                <IconMdiSnowflake v-else-if="tag === Tag.ELEMENT_ICE" />
                <IconMdiWaterOpacity v-else-if="tag === Tag.ELEMENT_BLOOD" />
                <IconMdiLeaf v-else-if="tag === Tag.ELEMENT_PLANT" />
                <IconMdiHospital v-else-if="tag === Tag.ELEMENT_HEALING" />
                <IconMdiEarth v-else-if="tag === Tag.ELEMENT_EARTH" />
                <IconMdiBeach v-else-if="tag === Tag.ELEMENT_SAND" />
                <IconMdiNut v-else-if="tag === Tag.ELEMENT_METAL" />
                <IconMdiFireCircle v-else-if="tag === Tag.ELEMENT_LAVA" />
                <IconMdiWeatherWindy v-else-if="tag === Tag.ELEMENT_AIR" />
                <IconMdiAirplane v-else-if="tag === Tag.ELEMENT_FLIGHT" />
                <IconMdiMeditation v-else-if="tag === Tag.ELEMENT_SPIRITUAL" />
                <IconMdiKarate v-else-if="tag === Tag.ELEMENT_CHI" />
                <IconMdiGhost v-else-if="tag === Tag.ELEMENT_SPIRIT" />
                <IconMdiRabbit v-else-if="tag === Tag.ELEMENT_LIGHT_SPIRIT" />
                <IconMdiSpider v-else-if="tag === Tag.ELEMENT_DARK_SPIRIT" />
                <IconMdiPaw v-else-if="tag === Tag.MOBS" />
                <IconMdiEarthBox v-else-if="tag === Tag.WORLD" />
                <IconMdiLibrary v-else-if="tag === Tag.LIBRARY" />
                <IconMdiPuzzle v-else-if="tag === Tag.MISC" />

          <span class="ml-1">{{ i18n.t("project.settings.tags." + tag + ".title") }}</span>
        </div>
      </div>
    </template>
    <template #footer>
      <DropdownButton v-if="project && hasPerms(NamedPermission.IsStaff)" :name="i18n.t('project.actions.adminActions')" class="mb-2">
        <DropdownItem :to="`/${namespace}/flags`">
          {{ i18n.t("project.actions.flagHistory", [project.info.flagCount ?? 0]) }}
        </DropdownItem>
        <DropdownItem :to="`/${namespace}/notes`">
          {{ i18n.t("project.actions.staffNotes", [project.info.noteCount ?? 0]) }}
        </DropdownItem>
        <DropdownItem :to="`/admin/log?authorName=${project.namespace.owner}&projectSlug=${project.namespace.slug}`">
          {{ i18n.t("project.actions.userActionLogs") }}
        </DropdownItem>
      </DropdownButton>
      <VisibilityChangerModal
        v-if="project && hasPerms(NamedPermission.SeeHidden)"
        type="project"
        :prop-visibility="project.visibility"
        :post-url="`projects/visibility/${project.projectId}`"
        class="min-h-10"
      />
      <DonationModal
        v-if="project?.settings?.donation?.enable && false"
        :donation-subject="project!.settings.donation.subject"
        :donation-target="project!.namespace.owner + '/' + project!.name"
      />
    </template>
  </Card>
</template>
