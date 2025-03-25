import backendData from "~/generated/backendData.json";
import type { Option } from "~/types/components/ui/InputAutocomplete";
import { NamedPermission, type CategoryData, type PermissionData, type RoleData } from "~/types/backend";
import type { BackendData, ServerBackendData } from "~/types/backendData";

const serverBackendData = { ...backendData } as unknown as ServerBackendData;
const typedBackendData = { ...serverBackendData } as unknown as BackendData;

// convert to bigint
const permissionResult = serverBackendData.permissions?.map(
  ({ value, frontendName, permission }) =>
    ({
      value,
      frontendName,
      permission: BigInt("0b" + permission).toString(),
    }) as PermissionData
);

// convert to maps
typedBackendData.projectCategories = convertToMap(serverBackendData.projectCategories, (value) => value.apiName);
typedBackendData.permissions = convertToMap(permissionResult, (value) => value.value);
typedBackendData.platforms = convertToMap(serverBackendData.platforms, (value) => value.name.toUpperCase());
typedBackendData.prompts = convertToMap(serverBackendData.prompts, (value) => value.name);

// main export
export const useBackendData = typedBackendData;

export function getRole(id: number): RoleData | undefined {
  return (
    getRoleFromRoles(id, typedBackendData.globalRoles) || getRoleFromRoles(id, typedBackendData.projectRoles) || getRoleFromRoles(id, typedBackendData.orgRoles)
  );
}

export function getRoleByValue(id: string): RoleData | undefined {
  return (
    getRoleFromRolesValue(id, typedBackendData.globalRoles) ||
    getRoleFromRolesValue(id, typedBackendData.projectRoles) ||
    getRoleFromRolesValue(id, typedBackendData.orgRoles)
  );
}

function getRoleFromRolesValue(id: string, roles: RoleData[]): RoleData | undefined {
  return roles.find((r) => r.value === id);
}

function getRoleFromRoles(id: number, roles: RoleData[]): RoleData | undefined {
  return roles.find((r) => r.roleId === id);
}

// helpers
export const useVisibleCategories = computed<CategoryData[]>(() => [...(useBackendData.projectCategories?.values() || [])].filter((value) => value.visible));
export const useVisibleCategoriesPost = computed<CategoryData[]>(() => [...(useBackendData.projectCategories?.values() || [])].filter((value) => value.visible && (value.apiName !== "official_plugins" || hasPerms(NamedPermission.IsStaff))));
export const useVisiblePlatforms = computed(() => (useBackendData.platforms ? [...useBackendData.platforms.values()].filter((value) => value.visible) : []));

export const useParentTags = computed(() => [...useBackendData.tags.values()].filter((value) => value.parent === null));

export const useLicenseOptions = computed<Option<string>[]>(() => useBackendData.licenses.map<Option<string>>((l) => ({ value: l, text: l })));
export const useCategoryOptions = computed<Option<string>[]>(() =>
  useVisibleCategories.value.map<Option<string>>((c) => ({ value: c.apiName, text: c.title }))
);
export const useCategoryOptionsPost = computed<Option<string>[]>(() =>
  useVisibleCategoriesPost.value.map<Option<string>>((c) => ({ value: c.apiName, text: c.title }))
);

function convertToMap<E, T>(values: T[] = [], toStringFunc: (value: T) => string): Map<E, T> {
  const map = new Map<E, T>();
  for (const value of values) {
    const key: E = toStringFunc(value) as unknown as E;
    if (key == undefined) {
      throw new Error("Could not find an enum for " + value);
    }
    map.set(key, value);
  }
  return map;
}
