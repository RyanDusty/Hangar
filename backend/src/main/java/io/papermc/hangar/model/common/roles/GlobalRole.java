package io.papermc.hangar.model.common.roles;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.papermc.hangar.db.customtypes.RoleCategory;
import io.papermc.hangar.model.common.Color;
import io.papermc.hangar.model.common.Permission;
import io.papermc.hangar.model.db.roles.GlobalRoleTable;
import org.jetbrains.annotations.NotNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import java.util.UUID;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum GlobalRole implements Role<GlobalRoleTable> {

    ADMIN("Admin", 1, Permission.All, "Admin", Color.RED, 10),
    DEV("Dev", 2, Permission.IsStaff.add(Permission.SeeHidden).add(Permission.ViewStats).add(Permission.ViewLogs).add(Permission.ViewHealth), "Developer", Color.PURPLE, 30),
    MOD("Mod", 3, Permission.IsStaff.add(Permission.Reviewer).add(Permission.DeleteVersion).add(Permission.DeleteProject).add(Permission.RestoreVersion).add(Permission.RestoreProject), "Moderator", Color.BLUE, 40),

    DUMMY("Dummy", 42, Permission.ViewPublicInfo, "Dummy", Color.LIME, 42),

    ORGANIZATION("Organization", 100, OrganizationRole.ORGANIZATION_OWNER.getPermissions(), "Organization", Color.ORANGE);

    private final String value;
    private final long roleId;
    private final Permission permissions;
    private final String title;
    private final Color color;
    private final Integer rank;

    GlobalRole(final String value, final long roleId, final Permission permissions, final String title, final Color color) {
        this(value, roleId, permissions, title, color, null);
    }

    GlobalRole(final String value, final long roleId, final Permission permissions, final String title, final Color color, final Integer rank) {
        this.value = value;
        this.roleId = roleId;
        this.permissions = permissions;
        this.title = title;
        this.color = color;
        this.rank = rank;
        Role.registerRole(this);
    }

    @Override
    public @NotNull String getValue() {
        return this.value;
    }

    @Override
    public long getRoleId() {
        return this.roleId;
    }

    @Override
    public @NotNull RoleCategory getRoleCategory() {
        return RoleCategory.GLOBAL;
    }

    @Override
    public @NotNull Permission getPermissions() {
        return this.permissions;
    }

    @Override
    public @NotNull String getTitle() {
        return this.title;
    }

    @Override
    public @NotNull Color getColor() {
        return this.color;
    }

    @Override
    public boolean isAssignable() {
        return false;
    }

    @Override
    public @Nullable Integer rank() {
        return this.rank;
    }

    @Override
    public @NotNull GlobalRoleTable create(final @Nullable Long ignored, final @Nullable UUID principalUuid, final long userId, final boolean ignoredToo) {
        return new GlobalRoleTable(userId, this);
    }

    public static GlobalRole byApiValue(final String apiValue) {
        for (final GlobalRole value : values()) {
            if (value.value.endsWith(apiValue)) {
                return value;
            }
        }
        throw new IllegalArgumentException("No GlobalRole '" + apiValue + "'");
    }
}
