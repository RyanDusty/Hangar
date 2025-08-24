package io.papermc.hangar.model.api.project.settings;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;
import org.jdbi.v3.core.enums.EnumByOrdinal;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
@EnumByOrdinal
public enum ServerTag {
    SURVIVAL,
    CREATIVE,
    HARDCORE,
    CROSSPLAY,
    FACTIONS,
    TOWNY,
    MINIGAMES,
    PVP,
    LIFESTEAL,
    PVE,
    ECONOMY,
    MCMMO,
    EVENTS,
    LAND_CLAIM,
    PARKOUR,
    RANKS,
    SMP,
    BOSSES,
    RPG,
    JOBS,
    CASUAL,
    COMPETITIVE,
    BUILD,
    ANARCHY,
    MISC;

    private static final Map<String, ServerTag> SERVERTAGS = new HashMap<>();

    ServerTag() {
        this(null);
    }


    ServerTag(ServerTag parent) {
        this.parent = parent;
        if (parent != null)
            parent.children.add(this);

    }

    private ServerTag parent;
    private Set<ServerTag> children = new HashSet<>(0);

    public ServerTag getParent() {
        return this.parent;
    }

    public Set<ServerTag> getChildren() {
        return this.children;
    }

    @Override
    @JsonValue
    public String toString() {
        return super.toString();
    }

    static {
        for (final ServerTag serverTag : values()) {
            SERVERTAGS.put(serverTag.name(), serverTag);
        }
    }
}

