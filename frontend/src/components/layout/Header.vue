<script setup lang="ts">

import type { RouteLocationRaw, RouteMap } from "vue-router";
import projectkorraLogo from "~/assets/projectkorra-icon.png";

import IconMdiHome from "~icons/mdi/home";
import IconMdiAccountGroup from "~icons/mdi/account-group";
import IconMdiFileDocumentAlert from "~icons/mdi/file-document-alert";
import IconMdiAlertOutline from "~icons/mdi/alert-outline";
import IconMdiInformationOutline from "~icons/mdi/information-outline";
import IconMdiMessageOutline from "~icons/mdi/message-outline";
import IconMdiCheck from "~icons/mdi/check";
import IconMdiFolderPlusOutline from "~icons/mdi/folder-plus-outline";

import { type HangarNotification, type HangarUser, NamedPermission } from "~/types/backend";
import { useUnreadNotificationCount } from "~/composables/useData";


// @ts-expect-error marker so that you can inspect backend data in dev tools
const backendData = useBackendData;

const settings = useSettingsStore();
const i18n = useI18n();
const t = i18n.t;
const authStore = useAuthStore();
const route = useRoute();

const notifications = ref<HangarNotification[]>([]);
const { unreadNotifications, refreshUnreadNotifications } = useUnreadNotificationCount();
const loadedUnreadNotifications = ref<number>(0);

type NavBarLinks = { link: keyof RouteMap; label: string; icon?: any }[];

const navBarLinks: NavBarLinks = [
  { link: "index", label: t("nav.indexTitle") },
  { link: "official_plugins", label: t("nav.officialPlugins") },
  { link: "side_plugins", label: t("nav.sidePlugins") },
  { link: "abilities", label: t("nav.abilities") },
  { link: "search", label: t("nav.search") },
  
];

const navBarMenuLinksHangar: NavBarLinks = [
  { link: "index", label: t("general.home"), icon: IconMdiHome },
  { link: "guidelines", label: t("guidelines.title"), icon: IconMdiFileDocumentAlert },
  { link: "new", label: t("nav.links.createProject"), icon: IconMdiFolderPlusOutline },
  { link: "neworganization", label: t("nav.links.createOrganization"), icon: IconMdiFolderPlusOutline },
  { link: "authors", label: t("nav.authorsTitle"), icon: IconMdiAccountGroup },
  { link: "staff", label: t("nav.staffTitle"), icon: IconMdiAccountGroup },
];
if (!authStore.user) {
  navBarMenuLinksHangar.splice(2, 2);
}

const auth = useAuth;
authLog("render with user " + authStore.user?.name);

function markNotificationsRead() {
  for (const notification of notifications.value) {
    markNotificationRead(notification);
  }
}

function markNotificationRead(notification: HangarNotification) {
  if (!notification.read) {
    notification.read = true;
    unreadNotifications.value--;
    loadedUnreadNotifications.value--;
    useInternalApi(`notifications/${notification.id}`, "post").catch((err) => handleRequestError(err));
  }
}

function updateNavData() {
  useInternalApi<HangarUser>("users/@me")
    .catch((err) => handleRequestError(err))
    .then((user) => {
      if (!user) return;
      authStore.user = unref(user);
    });
}

function updateNotifications() {
  refreshUnreadNotifications();
  // only actually load them when clicked
  useInternalApi<HangarNotification[]>("recentnotifications?amount=30")
    .catch(handleRequestError)
    .then((v) => {
      if (v) {
        // Only show notifications that are recent or unread (from the last 30 notifications)
        let filteredAmount = 0;
        notifications.value = v.filter((notification: HangarNotification) => {
          if (filteredAmount < 8 && (!notification.read || isRecent(notification.createdAt))) {
            if (!notification.read) {
              loadedUnreadNotifications.value++;
            }

            filteredAmount++;
            return true;
          }
          return false;
        });
      }
    });
}

function toggleVisibility(id: string) {
  const el = document.getElementById(id);
  if (el) {
    el.classList.toggle("show");
  }
}

function isRecent(date: string): boolean {
  const now: Date = new Date();
  return now.getTime() - new Date(date).getTime() < 60 * 60 * 24 * 1000 * 7;
}
</script>

<template>
  <header class="background-default shadow-md">
    <div v-if="useBackendData.announcements">
      <Announcement v-for="(announcement, idx) in useBackendData.announcements" :key="idx" :announcement="announcement" />
    </div>

    <nav class="max-w-screen-xl mx-auto flex flex-wrap justify-end px-4 py-2 gap-3">
      <!-- Left side items -->
      <div class="flex items-center gap-4 navbar navbar-expand-lg">
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation" @click="toggleVisibility('navbarSupportedContent')">
          <IconMdiMenu class="navbar-toggler-icon"></IconMdiMenu>
        </button>

        <NuxtLink to="/" class="flex-shrink-0" v-on="useTracking('nav-logo')">
          <img alt="ProjectKorra Logo" :src="projectkorraLogo" height="34" width="32" />
        </NuxtLink>

        <div id="navbarSupportedContent" class="collapse navbar-collapse">
          <ul class="navbar-nav mr-auto gap-4 hidden sm:flex sm:items-center">
            <li v-for="navBarLink in navBarLinks" :key="navBarLink.label" class="nav-item">
              <NuxtLink
                :to="{ name: navBarLink.link } as RouteLocationRaw"
                class="header-link relative"
                after="absolute content-empty block w-0 top-30px left-1/10 h-4px rounded-8px"
                v-on="useTracking('nav-desktop-link', { link: navBarLink.link })"
              >
                {{ navBarLink.label }}
              </NuxtLink>
            </li>
            <li class="nav-item">
              <a href="https://wiki.projectkorra.com" class="header-link relative" after="absolute content-empty block w-0 top-30px left-1/10 h-4px rounded-8px">Wiki</a>
            </li>

          </ul>
        </div>
      </div> 

      <!-- Gap between the sides -->
      <div class="flex-grow-1" />

      <!-- Right side items -->
      <div class="flex items-center gap-2">
        <div v-if="authStore.user" class="flex items-center lt-sm:hidden">
          <DropdownButton :name="t('nav.new.title')" v-on="useTracking('nav-create-dropdwon')">
            <template #default="{ close }">
              <DropdownItem to="/new" @click="close()" v-on="useTracking('nav-new')">{{ t("nav.new.project") }}</DropdownItem>
              <DropdownItem to="/neworganization" @click="close()" v-on="useTracking('nav-new-org')">{{ t("nav.new.organization") }}</DropdownItem>
            </template>
          </DropdownButton>
        </div>
        <button
          class="flex rounded-md p-2"
          hover="text-primary-500 bg-primary-0 dark:(text-white bg-zinc-700)"
          aria-label="Toogle dark mode"
          @click="settings.toggleDarkMode()"
          v-on="useTracking('nav-theme', { darkMode: settings.darkMode })"
        >
          <icon-mdi-weather-night v-if="settings.darkMode" class="text-[1.2em]" />
          <icon-mdi-white-balance-sunny v-else class="text-[1.2em]" />
        </button>
        <div v-if="authStore.user">
          <Popper placement="bottom-end">
            <button
              class="flex items-center gap-2 rounded-md p-2 hover:(text-primary-500 bg-primary-0 dark:(text-white bg-zinc-700))"
              aria-label="Notifications"
              @click="updateNotifications"
              v-on="useTracking('nav-notifications', { unread: unreadNotifications })"
            >
              <IconMdiBellOutline v-show="unreadNotifications === 0" class="text-[1.2em]" />
              <div v-show="unreadNotifications !== 0" class="relative">
                <!-- This is fine:tm: -->
                <IconMdiBellBadge class="text-[1.2em]" />
                <svg class="absolute top-0.6 left-3.3" width="24" height="24" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg">
                  <circle style="fill: #c83737" r="3.75" cx="3.75" cy="3.75" />
                </svg>
              </div>
            </button>
            <template #content="{ close }">
              <ClientOnly>
                <div class="-mt-1 flex flex-col rounded border-t-2 border-primary-500 background-default filter shadow-default overflow-auto max-w-150">
                  <div v-if="notifications.length === 0">
                    <span class="flex shadow-0 p-2 mt-2 ml-3 mr-2">{{ i18n.t("notifications.empty.recent") }}</span>
                  </div>
                  <div
                    v-for="notification in notifications"
                    v-else
                    :key="notification.id"
                    :class="'text-sm flex shadow-0 p-3 pt-2 pr-4 inline-flex items-center ' + (!notification.read ? 'bg-blue-100 dark:bg-slate-700' : '')"
                    @click="close()"
                  >
                    <span class="text-lg mr-2">
                      <IconMdiInformationOutline v-if="notification.type === 'info'" class="text-sky-600" />
                      <IconMdiCheck v-else-if="notification.type === 'success'" class="text-lime-600" />
                      <IconMdiAlertOutline v-else-if="notification.type === 'warning'" class="text-red-600" />
                      <IconMdiMessageOutline v-else-if="notification.type === 'neutral'" />
                    </span>

                    <NuxtLink
                      v-if="notification.action"
                      :to="'/' + notification.action"
                      active-class=""
                      @click="markNotificationRead(notification)"
                      @click.middle="markNotificationRead(notification)"
                    >
                      {{ i18n.t(notification.message[0], notification.message.slice(1)) }}
                      <div class="text-xs mt-1">{{ lastUpdated(new Date(notification.createdAt)) }}</div>
                    </NuxtLink>
                    <div v-else>
                      {{ i18n.t(notification.message[0], notification.message.slice(1)) }}
                      <div class="text-xs mt-1">{{ lastUpdated(new Date(notification.createdAt)) }}</div>
                    </div>
                  </div>
                  <div class="p-2 mb-1 ml-2 space-x-3 text-sm">
                    <Link to="/notifications" @click="close()">
                      <span :class="loadedUnreadNotifications >= unreadNotifications ? 'font-normal' : ''">
                        {{
                          loadedUnreadNotifications >= unreadNotifications
                            ? i18n.t("notifications.viewAll")
                            : i18n.t("notifications.viewMoreUnread", [unreadNotifications - loadedUnreadNotifications])
                        }}
                      </span>
                    </Link>
                    <span v-if="loadedUnreadNotifications !== 0" class="color-primary hover:(underline cursor-pointer)" @click="markNotificationsRead">
                      {{ i18n.t("notifications.markAsRead") }}
                    </span>
                  </div>
                </div>
              </ClientOnly>
            </template>
          </Popper>
        </div>
      </div>
      <div class="flex items-center gap-2">
        <!-- Profile dropdown -->
        <div v-if="authStore.user">
          <Popper placement="bottom-end">
            <button
              class="flex items-center gap-2 rounded-md p-2 hover:(text-primary-500 bg-primary-0 dark:(text-white bg-zinc-700))"
              @click="updateNavData"
              v-on="useTracking('nav-profile-dropdown')"
            >
              <UserAvatar :username="authStore.user.name" :avatar-url="authStore.user.avatarUrl" size="xs" :disable-link="true" />
              {{ authStore.user.name }}
            </button>
            <template #content="{ close }">
              <div class="-mt-2 py-1 rounded border-t-2 border-primary-500 background-default filter shadow-default flex flex-col" @click="close()">
                <DropdownItem :to="'/' + authStore.user.name">{{ t("nav.user.profile") }}</DropdownItem>
                <DropdownItem to="/notifications">{{ t("nav.user.notifications") }}</DropdownItem>
                <DropdownItem to="/auth/settings/profile">{{ t("nav.user.settings") }}</DropdownItem>
                <hr class="border-zinc-200 dark:border-zinc-700" />
                <DropdownItem v-if="hasPerms(NamedPermission.ModNotesAndFlags)" to="/admin/flags">
                  {{ t("nav.user.flags") }}
                  <span v-if="authStore.user.headerData.unresolvedFlags !== 0">{{ "(" + authStore.user?.headerData.unresolvedFlags + ")" }}</span>
                </DropdownItem>
                <DropdownItem v-if="hasPerms(NamedPermission.ModNotesAndFlags)" to="/admin/approval/projects">
                  {{ t("nav.user.projectApprovals") }}
                  <span v-if="authStore.user.headerData.projectApprovals !== 0">{{ "(" + authStore.user?.headerData.projectApprovals + ")" }}</span>
                </DropdownItem>
                <DropdownItem v-if="hasPerms(NamedPermission.Reviewer)" to="/admin/approval/versions">
                  {{ t("nav.user.versionApprovals") }}
                  <span v-if="authStore.user.headerData.reviewQueueCount !== 0">{{ "(" + authStore.user?.headerData.reviewQueueCount + ")" }}</span>
                </DropdownItem>
                <DropdownItem v-if="hasPerms(NamedPermission.ViewStats)" to="/admin/stats">{{ t("nav.user.stats") }}</DropdownItem>
                <!-- todo -->
                <!--<DropdownItem v-if="hasPerms(NamedPermission.ViewHealth)" to="/admin/health">{{ t("nav.user.health") }}</DropdownItem>-->
                <DropdownItem v-if="hasPerms(NamedPermission.ViewLogs)" to="/admin/log">{{ t("nav.user.log") }}</DropdownItem>
                <DropdownItem v-if="hasPerms(NamedPermission.ManualValueChanges)" to="/admin/settings">
                  {{ t("nav.user.adminSettings") }}
                </DropdownItem>
                <DropdownItem v-if="hasPerms(NamedPermission.EditAllUserSettings)" to="/admin/user/">
                  {{ t("nav.user.userList") }}
                </DropdownItem>
                <hr class="border-zinc-200 dark:border-zinc-700" />
                <DropdownItem @click="auth.logout()">{{ t("nav.user.logout") }}</DropdownItem>
              </div>
            </template>
          </Popper>
        </div>

        <!-- Login/register buttons -->
        <div v-else class="flex gap-2">
          <div class="flex"><NuxtLink
            class="flex items-center rounded-md p-2 hover:(text-primary-500 bg-primary-0 dark:(text-white bg-zinc-700))"
            :to="auth.loginUrl(route.fullPath)"
            rel="nofollow"
          >
            <icon-mdi-key-outline class="mr-1 flex-shrink-0 text-[1.2em]" />
            {{ t("nav.login") }}
          </NuxtLink>
          <NuxtLink
            class="flex items-center rounded-md p-2 hover:(text-primary-500 bg-primary-0 dark:(text-white bg-zinc-700))"
            :to="auth.signupUrl(route.fullPath)"
          >
            <icon-mdi-clipboard-outline class="mr-1 flex-shrink-0 text-[1.2em]" />
            {{ t("nav.signup") }}
          </NuxtLink></div>
          <div class="flex-grow"></div>
        </div>
        
      </div>
    </nav>
  </header>
</template>

<style lang="css" scoped>
nav .router-link-active {
  @apply color-primary;
  font-weight: 700;
}

@media (min-width: 992px) {
  .header-link.router-link-active:after {
    content: "";
    background: linear-gradient(-270deg, var(--primary-500) 0%, var(--primary-400) 100%);
    transition: width 0.2s ease-in;
    width: 80%;
  }

  .header-link:not(.router-link-active):hover:after {
    background: #d3e1f6;
    transition: width 0.2s ease-in;
    width: 80%;
  }

  .navbar-expand-lg .navbar-collapse {
    display: -webkit-box !important;
    display: -ms-flexbox !important;
    display: flex !important;
    -ms-flex-preferred-size: auto;
    flex-basis: auto;
  }

  .navbar-expand-lg .navbar-toggler {
    display: none;
  }

  .navbar-expand-lg .navbar-nav {
    -webkit-box-orient: horizontal;
    -webkit-box-direction: normal;
    -ms-flex-direction: row;
    flex-direction: row;
  }
}

.navbar-toggler {
  padding: .25rem 0;
  font-size: 1.25rem;
  line-height: 1;
  background-color: transparent;
  border: 1px solid transparent;
  border-radius: .25rem;
}

.navbar-collapse {
  -ms-flex-preferred-size: 100%;
  flex-basis: 100%;
  -webkit-box-flex: 1;
  -ms-flex-positive: 1;
  flex-grow: 1;
  -webkit-box-align: center;
  -ms-flex-align: center;
  align-items: start;
}

.navbar-toggler-icon {
  display: inline-block;
  width: 1.5em;
  height: 1.5em;
  vertical-align: middle;
  content: "";
  background: no-repeat center center;
  background-size: 100% 100%;
}

.navbar-nav {
  display: -webkit-box;
  display: -ms-flexbox;
  display: flex;
  text-align: left;
  -webkit-box-orient: vertical;
  -webkit-box-direction: normal;
  -ms-flex-direction: column;
  flex-direction: column;
  padding-left: 0;
  margin-bottom: 0;
  list-style: none;
  align-items: start;
}

.navbar {
  position: relative;
  display: -webkit-box;
  display: -ms-flexbox;
  display: flex;
  -ms-flex-wrap: wrap;
  flex-wrap: wrap;
  -webkit-box-align: center;
  -ms-flex-align: center;
  align-items: center;
  -webkit-box-pack: justify;
  -ms-flex-pack: justify;
  justify-content: left;
  padding: .5rem 1rem;
}

.collapse {
  display: none;
}

.collapse.show {
  display: block;
}
</style>
