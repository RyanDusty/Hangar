import type {
  NamedPermission,
  Category,
  Platform,
  Prompt,
  Announcement,
  RoleData,
  Security,
  Validations,
  CategoryData,
  Tag,
  TagData,
  PermissionData,
  PlatformData,
  VisibilityData,
  ColorData,
  FlagReasonData,
  PromptData,
} from "~/types/backend";

export interface BackendData {
  projectCategories: Map<Category, CategoryData>;
  tags: Map<Tag, TagData>;
  permissions: Map<NamedPermission, PermissionData>;
  platforms: Map<Platform, PlatformData>;
  validations: Validations;
  prompts: Map<Prompt, PromptData>;
  announcements: Announcement[];
  visibilities: VisibilityData[];
  licenses: string[];
  orgRoles: RoleData[];
  projectRoles: RoleData[];
  globalRoles: RoleData[];
  channelColors: ColorData[];
  flagReasons: FlagReasonData[];
  loggedActions: string[];
  security: Security;
}

export interface ServerBackendData {
  projectCategories: CategoryData[];
  tags: TagData[];
  permissions: PermissionData[];
  platforms: PlatformData[];
  validations: Validations;
  prompts: PromptData[];
  announcements: Announcement[];
  visibilities: VisibilityData[];
  licenses: string[];
  orgRoles: RoleData[];
  projectRoles: RoleData[];
  globalRoles: RoleData[];
  channelColors: ColorData[];
  flagReasons: FlagReasonData[];
  loggedActions: string[];
  security: Security;

  meta: {
    lastGenerated: string;
    apiUrl: string;
    version: number;
  };
}
