package io.papermc.hangar.model.db.serverlist;

import io.papermc.hangar.model.db.Table;
import org.jdbi.v3.core.enums.EnumByName;
import org.jdbi.v3.core.mapper.reflect.JdbiConstructor;

import java.time.OffsetDateTime;
import java.util.List;

public class ServerTable extends Table {

    private long id; // Explicitly included even though also in Table
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
    private long ownerId;
    private Status status;

    public enum Status {
        PENDING,
        APPROVED,
        REJECTED
    }

    public ServerTable(final long id, final String name, final int ip, final int port, final String description,
                       final String bannerImage, final String logoImage, final List<String> serverTags,
                       final String websiteUrl, final String discordUrl, final int minecraftVersion,
                       final int playerCount, final long ownerId, @EnumByName final Status status) {
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

    @JdbiConstructor
    public ServerTable(final OffsetDateTime createdAt, final long id, final String name, final int ip, final int port,
                       final String description, final String bannerImage, final String logoImage,
                       final List<String> serverTags, final String websiteUrl, final String discordUrl,
                       final int minecraftVersion, final int playerCount, final long ownerId,
                       @EnumByName final Status status) {
        super(createdAt, id);
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

    public long getServerId() { return this.id; }
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
    public long getServerOwnerId() { return this.ownerId; }
    public Status getServerStatus() { return this.status;}

    public void setServerId(long id) { this.id = id; }
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
    public void setServerOwnerId(long ownerId) { this.ownerId = ownerId; }
    public void setServerStatus(Status status) { this.status = status; }

    @Override
    public String toString() {
        return "ServerTable{" +
            "id=" + this.id +
            ", name='" + this.name + '\'' +
            ", ip=" + this.ip +
            ", port=" + this.port +
            ", description='" + this.description + '\'' +
            ", bannerImage='" + this.bannerImage + '\'' +
            ", logoImage='" + this.logoImage + '\'' +
            ", serverTags=" + this.serverTags +
            ", websiteUrl='" + this.websiteUrl + '\'' +
            ", discordUrl='" + this.discordUrl + '\'' +
            ", minecraftVersion=" + this.minecraftVersion +
            ", playerCount=" + this.playerCount +
            ", ownerId=" + this.ownerId +
            ", status=" + this.status +
            "} " + super.toString();
    }
}
