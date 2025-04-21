package io.papermc.hangar.model.db;

import java.util.List;
import java.util.UUID;

public class ServerTable extends Table {

    public static ServerTable EMPTY = new ServerTable(null, "null", 0, 0, "null", "null", "null", null, "null", "null", 0, 0, null, null  );

    private UUID id;
    private String name;
    private int ip;
    private int port;
    private String description;
    private String bannerImage;
    private String logoImage;
    private List<String> serverTags;
    private String websiteUrl;
    private String discordUrl;
    private int minecraftVersion;
    private int playerCount;
    private UUID ownerId;
    private Boolean status;

    public ServerTable(UUID id, String name, int ip, int port, String description, String bannerImage, String logoImage, List<String> serverTags, String websiteUrl, String discordUrl, int minecraftVersion, int playerCount, UUID ownerId, Boolean status) {
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
    // Return values
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
    // Set values (idk if I need this, it wasn't in any other file but I use this all the time when making mc plugins so fuck it)
    public void setServerId(UUID id) { this.id = id; }
    public void setServerName(String name) { this.name = name; }
    public void setServerIp(int ip) { this.ip = ip; }
    public void setServerPort(int port) { this.port = port; }
    public void setServerDescription(String description) { this.description = description; }
    public void setServerBannerImage(String bannerImage) { this.bannerImage = bannerImage; }
    public void setServerLogoImage(String logoImage) { this.logoImage = logoImage; }
    public void setServerTags(List<String> serverTags) { this.serverTags = serverTags; }
    public void setServerWebsiteUrl(String websiteUrl) { this.websiteUrl = websiteUrl; }
    public void setServerDiscordUrl(String discordUrl) { this.discordUrl = discordUrl; }
    public void setServerMinecraftVersion(int minecraftVersion) { this.minecraftVersion = minecraftVersion; }
    public void setServerPlayerCount(int playerCount) { this.playerCount = playerCount; }
    public void setServerOwnerId(UUID ownerId) { this.ownerId = ownerId; }
    public void setServerStatus(Boolean status) { this.status = status; }
    // I saw this in another file so I put it in here just in case

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


