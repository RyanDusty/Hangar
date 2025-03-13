package io.papermc.hangar.model.common.projects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.jdbi.v3.core.enums.EnumByOrdinal;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
@EnumByOrdinal
public enum Category {
    OFFICIAL_PLUGINS(0, "mdi-shield-crown", "official_plugins", true),
    ABILITY(1, "mdi-paw", "ability"),
    SIDE_PLUGIN(2, "mdi-puzzle", "side_plugin"),
    DATA_PACK(3, "mdi-package-variant-closed", "data_pack"),
    RESOURCE_PACK(4, "mdi-texture-box", "resource_pack"),
    WORLD(5, "mdi-earth", "world"),
    CONFIG(6, "mdi-cog", "config"),
    OTHER(7, "mdi-help-box", "other"),
    UNDEFINED(10, "", "undefined", false);

    public static final List<Category> VALID_CATEGORIES = Arrays.stream(values()).filter(c -> c != UNDEFINED).toList();

    private final int value;
    private final String icon;
    private final boolean isVisible;
    private final String apiName;

    Category(final int value, final String icon, final String apiName) {
        this(value, icon, apiName, true);
    }

    Category(final int value, final String icon, final String apiName, final boolean isVisible) {
        this.value = value;
        this.icon = icon;
        this.apiName = apiName;
        this.isVisible = isVisible;
    }

    @JsonIgnore
    public int getValue() {
        return this.value;
    }

    public String getIcon() {
        return this.icon;
    }

    public boolean isVisible() {
        return this.isVisible;
    }

    public String getApiName() {
        return this.apiName;
    }

    @Override
    @JsonValue
    public String toString() {
        return this.apiName;
    }

    @JsonCreator
    public static Category fromValue(final String text) {
        for (final Category b : values()) {
            if (b.apiName.equalsIgnoreCase(text)) {
                return b;
            }
        }
        return null;
    }

    public static List<Category> fromString(final String str) {
        final List<Category> categories = new ArrayList<>();
        Arrays.stream(str.split(",")).forEach(s -> {
            try {
                final int id = Integer.parseInt(s);
                categories.add(Category.VALUES[id]);
            } catch (final NumberFormatException | ArrayIndexOutOfBoundsException ignored) {
            }
        });
        return categories;
    }

    public static Set<Category> visible() {
        return Arrays.stream(values()).filter(Category::isVisible).collect(Collectors.toSet());
    }

    private static final Category[] VALUES = values();

    public static Category[] getValues() {
        return VALUES;
    }
}
