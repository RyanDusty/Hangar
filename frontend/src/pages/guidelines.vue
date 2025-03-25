<script lang="ts" setup>
const i18n = useI18n();
const route = useRoute("guidelines");

// language=Markdown
const text = `
# Resource Guidelines

Remember that these are just guidelines and that the ProjectKorra team may choose to allow or disallow an action that is not
explicitly listed here at our own discretion.

## Resource Updates

While the rate-limit for uploading new versions is very lenient to allow sometimes necessary hotfixes, you should not
unnecessarily push a large number of updates to the release channel, solely to bump the update date of your project or to
flood watching users with notifications.

## Artificially Inflating Stats

Artificially increasing the download count, stars, or watcher count of projects (i.e. by creating multiple accounts to star
a project or making an auto-updater re-download the already present version over and over again) will result in your account(s)
and/or project being removed. If you have reason to believe that one of your project is being botted by someone else, please
contact our support.

## Advertising

Advertisements are not allowed, with the exception of informative mentions of (optional) platform or plugin dependencies.
Revenue generating links (such as adfly) are not permitted.

On the resource page, you may link to the following:

* Related resources, such as projects you took inspiration from, dependencies, and *free* versions of the same resource
  on other websites.
* Related documents, such as documentation, tutorials, source code, and support Discords, including paid support.
* Donation links - you can also go to your project's donation settings to display them more prominently.

## Obfuscation

To circumvent license issues and the effort involved in reviewing obfuscated code, we do not allow submitted plugins to be
obfuscated in any capacity.

## EULA

We aim to comply with the [Minecraft EULA](https://account.mojang.com/documents/minecraft_eula). Any plugins, services,
posts, and/or links suspected of violating the EULA may be removed at the discretion of the ProjectKorra staff.

### Offline-mode Support

Projects that explicitly state they are designed for such uses are not allowed. Some projects, such as authentication
systems, may have functionality that can be useful for servers regardless of the server's use of Mojang authentication,
but they may not promote this additional usage or be specifically designed for servers avoiding Mojang auth. Projects
designed for proxies requiring \`online-mode=false\` are allowed, provided they are not written to facilitate
circumvention of Minecraft account ownership.

## Forks of Existing Projects

You are not allowed to re-upload resources of other authors as-is. Forks are permitted as long as they meet the
requirements as stated below. Staff have the final say in what constitutes an accepted fork.

Your project must either:

- Contain significant changes warranting the creation of a new project. This is to avoid "I changed the message colors in Plugin X and now I claim credit!", or
- Continue a plugin that has been abandoned, with the author no longer answering messages or having stated that the project will no longer be updated.

You have to acknowledge or credit the past plugin and its developers. Essentially, do not claim it is a new plugin and exclusively your creation.

## Project Category

The category you choose should be accurate. Your project should use the most fitting category rather than any category
that only slightly applies. If no category appears accurate, the Miscellaneous category should be used.

## Platform Selection

A resource must state which versions of Minecraft and ProjectKorra it is compatible with. If the resource is compatible with multiple versions,
all compatible versions should be selected.

## Malicious Code

Plugins must not grant or revoke feature access to any particular user or group of users determined by the plugin
developer. This includes the author granting themselves access to all features in the plugin without the server owner's consent.

Other malicious actions, such as deleting a server's data or banning random players, are also prohibited.

---
These guidelines are loosely based on [Ore's plugin submission guidelines](https://docs.spongepowered.org/stable/en/ore/guidelines.html),
licensed under the [CC BY-SA 4.0](https://creativecommons.org/licenses/by-sa/4.0/).

Last updated: April 25, 2025

`;

useSeo(computed(() => ({ title: i18n.t("pages.guidelinesTitle"), route })));
</script>

<template>
  <div>
    <Markdown :raw="text" />
  </div>
</template>
