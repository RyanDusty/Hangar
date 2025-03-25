<script setup lang="ts" generic="T">

import type { TagData} from "~/types/backend";
import { Tag } from "~/types/backend";

const i18n = useI18n();

const emit = defineEmits<{
  (e: "update:modelValue", value?: T): void;
}>();
const internalVal = computed({
  get: () => props.modelValue,
  set: (val) => emit("update:modelValue", val),
});
const props = defineProps<{
  modelValue?: T;
  label?: string;
  disabled?: boolean;
  value?: string;
  tag: TagData;
  showHelp?: boolean
}>();

const showChildren = ref(false);

function toggleChildren() {
  showChildren.value = !showChildren.value;
}

const hasChildren = computed(() => props.tag.children.length > 0);

// uses InputGroup for validation
const { v } = useValidation(props.label, undefined, internalVal);
</script>

<template>
  <label class="customCheckbox group relative flex items-center select-none" :cursor="disabled ? 'auto' : 'pointer'">
    <input
      v-model="internalVal"
      v-bind="$attrs"
      type="checkbox"
      class="appearance-none h-4 w-4 bg-gray-300 mr-2 rounded-sm shrink-0 group-hover:bg-gray-400 !checked:bg-primary-500"
      dark="bg-gray-600 group-hover:bg-gray-500"
      :cursor="disabled ? 'auto' : 'pointer'"
      :disabled="disabled"
      :value="value"
      @blur="v.$touch()"
    />
    <icon-mdi-check-bold class="absolute h-4 w-4 opacity-0 text-white" />
    <slot name="label">
      <IconMdiPuzzleOutline v-if="tag.name === Tag.CUSTOM_ABILITY" />
      <IconMdiFileDocumentMultiple v-else-if="tag.name === Tag.ABILITY_PACK" />
      <IconMdiAllInclusiveBox v-else-if="tag.name === Tag.PASSIVE_ABILITY" />
      <IconMdiNumeric v-else-if="tag.name === Tag.COMBO_ABILITY" />
      <IconMdiNumeric9BoxMultiple v-else-if="tag.name === Tag.MULTI_ABILITY" />
      <IconMdiNewBox v-else-if="tag.name === Tag.CUSTOM_ELEMENT" />
      <IconMdiMonitor v-else-if="tag.name === Tag.GUI" />
      <IconMdiDecagram v-else-if="tag.name === Tag.ELEMENT_AVATAR" />
      <IconMdiDecagramOutline v-else-if="tag.name === Tag.ELEMENT_DARK_AVATAR" />
      <IconMdiFire v-else-if="tag.name === Tag.ELEMENT_FIRE" />
      <IconMdiFlare v-else-if="tag.name === Tag.ELEMENT_COMBUSTION" />
      <IconMdiFlash v-else-if="tag.name === Tag.ELEMENT_LIGHTNING" />
      <IconMdiWater v-else-if="tag.name === Tag.ELEMENT_WATER" />
      <IconMdiSnowflake v-else-if="tag.name === Tag.ELEMENT_ICE" />
      <IconMdiWaterOpacity v-else-if="tag.name === Tag.ELEMENT_BLOOD" />
      <IconMdiLeaf v-else-if="tag.name === Tag.ELEMENT_PLANT" />
      <IconMdiHospital v-else-if="tag.name === Tag.ELEMENT_HEALING" />
      <IconMdiEarth v-else-if="tag.name === Tag.ELEMENT_EARTH" />
      <IconMdiBeach v-else-if="tag.name === Tag.ELEMENT_SAND" />
      <IconMdiNut v-else-if="tag.name === Tag.ELEMENT_METAL" />
      <IconMdiFireCircle v-else-if="tag.name === Tag.ELEMENT_LAVA" />
      <IconMdiWeatherWindy v-else-if="tag.name === Tag.ELEMENT_AIR" />
      <IconMdiAirplane v-else-if="tag.name === Tag.ELEMENT_FLIGHT" />
      <IconMdiMeditation v-else-if="tag.name === Tag.ELEMENT_SPIRITUAL" />
      <IconMdiKarate v-else-if="tag.name === Tag.ELEMENT_CHI" />
      <IconMdiGhost v-else-if="tag.name === Tag.ELEMENT_SPIRIT" />
      <IconMdiRabbit v-else-if="tag.name === Tag.ELEMENT_LIGHT_SPIRIT" />
      <IconMdiSpider v-else-if="tag.name === Tag.ELEMENT_DARK_SPIRIT" />
      <IconMdiPaw v-else-if="tag.name === Tag.MOBS" />
      <IconMdiEarthBox v-else-if="tag.name === Tag.WORLD" />
      <IconMdiLibrary v-else-if="tag.name === Tag.LIBRARY" />
      <IconMdiPuzzle v-else-if="tag.name === Tag.MISC" />

      <span class="ml-1">{{ i18n.t("project.settings.tags." + tag.name + ".title") }}</span>

      <Tooltip v-if="showHelp">
            <template #content> {{ i18n.t("project.settings.tags." + tag.name + ".description") }} </template>
            <IconMdiHelpCircleOutline class="ml-1 text-gray-500 dark:text-gray-400 text-sm" />
      </Tooltip>
    </slot>
    <template v-if="hasChildren">
        <button type="button" class="ml-2" @click.stop="toggleChildren" @blur="{}">
          <icon-mdi-chevron-down v-if="!showChildren" />
          <icon-mdi-chevron-up v-else />
        </button>
      </template>
  </label>
  <div v-if="showChildren" class="ml-6">
      <InputTagCheckbox
        v-for="childTag in tag.children"
        :key="childTag"
        :tag="{name: childTag,children: [], parent: tag.name as Tag}"
        :value="childTag" 
      >
      </InputTagCheckbox>
    </div>
</template>

<style>
.customCheckbox input:checked ~ svg {
  @apply opacity-100;
}
</style>
