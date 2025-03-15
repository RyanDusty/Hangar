package io.papermc.hangar.model.api.project.settings;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.jdbi.v3.core.enums.EnumByOrdinal;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
@EnumByOrdinal
public enum Tag {

    CUSTOM_ABILITY,
    ABILITY_PACK,
    PASSIVE_ABILITY,
    COMBO_ABILITY,
    MULTI_ABILITY,
    CUSTOM_ELEMENT,
    GUI,
    ELEMENT_AVATAR,
        ELEMENT_DARK_AVATAR (ELEMENT_AVATAR),
    ELEMENT_FIRE,
        ELEMENT_COMBUSTION (ELEMENT_FIRE),
        ELEMENT_LIGHTNING (ELEMENT_FIRE),
    ELEMENT_WATER,
        ELEMENT_ICE (ELEMENT_WATER),
        ELEMENT_PLANT (ELEMENT_WATER),
        ELEMENT_BLOOD (ELEMENT_WATER),
        ELEMENT_HEALING (ELEMENT_WATER),
    ELEMENT_EARTH,
        ELEMENT_SAND (ELEMENT_EARTH),
        ELEMENT_METAL (ELEMENT_EARTH),
        ELEMENT_LAVA (ELEMENT_EARTH),
    ELEMENT_AIR,
        ELEMENT_FLIGHT (ELEMENT_AIR),
        ELEMENT_SPIRITUAL (ELEMENT_AIR),
    ELEMENT_CHI,
    ELEMENT_SPIRIT,
        ELEMENT_LIGHT_SPIRIT (ELEMENT_SPIRIT),
        ELEMENT_DARK_SPIRIT (ELEMENT_SPIRIT),
    MOBS,
    WORLD,
    LIBRARY,
    MISC;

    private static final Map<String, Tag> TAGS = new HashMap<>();

    Tag() {
        this(null);
    }

    Tag(Tag parent) {
        this.parent = parent;
        if (parent != null)
            parent.childen.add(this);
    }

    private Tag parent;
    private Set<Tag> childen = new HashSet<>(0);

    public Tag getParent() {
        return this.parent;
    }

    public Set<Tag> getChilden() {
        return this.childen;
    }

    @Override
    @JsonValue
    public String toString() {
        return super.toString();
    }

    static {
        for (final Tag tag : values()) {
            TAGS.put(tag.name(), tag);
        }
    }

    public static Tag byName(final String name) {
        return TAGS.get(name.toUpperCase(Locale.ROOT));
    }
}
