package io.papermc.hangar.model.db.projects;

import java.util.List;
import java.util.UUID;

public class ProjectServer {

    public static ProjectServer EMPTY = new ProjectServer(null, "null", 0, 0, "null", "null", "null", null, "null", "null", 0, 0, null, null  );

    private final UUID id;
    private final String name;
    private final int ip;
    private final int port;
    private final String description;
    private final String bannerImage;
    private final String logoImage;
    private final List<String> serverTags;
    private final String websiteUrl;
    private final String discordUrl;
    private final int minecraftVersion;
    private final int playerCount;
    private final UUID ownerId;
    private final Boolean status;

    public ProjectServer(UUID id, String name, int ip, int port, String description,String bannerImage, String logoImage, List<String> serverTags, String websiteUrl, String discordUrl, int minecraftVersion, int playerCount, UUID ownerId, Boolean status) {
        this.id = id;
        this.name = name;
        this.ip = ip;
        this.port = port;
        this.description = description;
        this.bannerImage = bannerImage;
        this.logoImage = logoImage;
        this.serverTags = serverTags;
        this.websiteUrl = websiteUrl;
        this.discordUrl = discordUrl;
        this.minecraftVersion = minecraftVersion;
        this.playerCount = playerCount;
        this.ownerId = ownerId;
        this.status = status;

    }
    public UUID getServerId() { return this.id; }
    public String getServerName() { return this.name; }
    public int getServerIp() { return this.ip; }
    public int getServerPort() { return this.port; }
    public String getServerDescription() { return this.description; }
    public String getServerBannerImage() { return this.bannerImage; }
    public String getServerLogoImage() { return this.logoImage; }
    public List<String> getServerTags() { return this.serverTags; }
    public String getServerWebsiteUrl() { return this.websiteUrl; }
    public String getServerDiscordUrl() { return this.discordUrl; }
    public int getServerMinecraftVersion() { return this.minecraftVersion; }
    public int getServerPlayerCount() { return this.playerCount; }
    public UUID getServerOwnerId() { return this.ownerId; }
    public Boolean getServerStatus() { return this.status; }

    @Override
    public String toString() {
        return "ProjectCompact{" +
            "id=" + this.id +
            ", name='" + this.name + '\'' +
            ", ip=" + this.ip +
            ", port=" + this.port +
            ", description=" + this.description +
            ", bannerImage=" + this.bannerImage +
            ", logoImage=" + this.logoImage +
            ", serverTags=" + this.serverTags +
            ", websiteUrl=" + this.websiteUrl +
            ", discordUrl=" + this.discordUrl +
            ", minecraftVersion=" + this.minecraftVersion +
            ", playerCount=" + this.playerCount +
            ", ownerId=" + this.ownerId +
            ", status=" + this.status +
            "} " + super.toString();
    }
}


