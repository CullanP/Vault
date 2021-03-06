package net.milkbowl.vault.permission.plugins;

import java.util.List;
import java.util.logging.Logger;
import net.milkbowl.vault.permission.Permission;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.server.PluginDisableEvent;
import org.bukkit.event.server.PluginEnableEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import ru.tehkode.permissions.PermissionGroup;
import ru.tehkode.permissions.PermissionManager;
import ru.tehkode.permissions.PermissionUser;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class Permission_PermissionsEx
  extends Permission
{
  private final String name = "PermissionsEx";
  private PermissionsEx permission = null;
  
  public Permission_PermissionsEx(Plugin plugin)
  {
    this.plugin = plugin;
    Bukkit.getServer().getPluginManager().registerEvents(new PermissionServerListener(this), plugin);
    if (this.permission == null)
    {
      Plugin perms = plugin.getServer().getPluginManager().getPlugin("PermissionsEx");
      if ((perms != null) && 
        (perms.isEnabled()))
      {
        try
        {
          if (Double.valueOf(perms.getDescription().getVersion()).doubleValue() < 1.16D) {
            log.info(String.format("[%s][Permission] %s below 1.16 is not compatible with Vault! Falling back to SuperPerms only mode. PLEASE UPDATE!", new Object[] { plugin.getDescription().getName(), "PermissionsEx" }));
          }
        }
        catch (NumberFormatException e) {}
        this.permission = ((PermissionsEx)perms);
        log.info(String.format("[%s][Permission] %s hooked.", new Object[] { plugin.getDescription().getName(), "PermissionsEx" }));
      }
    }
  }
  
  public boolean isEnabled()
  {
    if (this.permission == null) {
      return false;
    }
    return this.permission.isEnabled();
  }
  
  public class PermissionServerListener
    implements Listener
  {
    Permission_PermissionsEx permission = null;
    
    public PermissionServerListener(Permission_PermissionsEx permission)
    {
      this.permission = permission;
    }
    
    @EventHandler(priority=EventPriority.MONITOR)
    public void onPluginEnable(PluginEnableEvent event)
    {
      if (this.permission.permission == null)
      {
        Plugin perms = event.getPlugin();
        if (perms.getDescription().getName().equals("PermissionsEx"))
        {
          try
          {
            if (Double.valueOf(perms.getDescription().getVersion()).doubleValue() < 1.16D)
            {
              Permission_PermissionsEx.log.info(String.format("[%s][Permission] %s below 1.16 is not compatible with Vault! Falling back to SuperPerms only mode. PLEASE UPDATE!", new Object[] { Permission_PermissionsEx.this.plugin.getDescription().getName(), "PermissionsEx" }));
              return;
            }
          }
          catch (NumberFormatException e) {}
          this.permission.permission = ((PermissionsEx)perms);
          Permission_PermissionsEx.log.info(String.format("[%s][Permission] %s hooked.", new Object[] { Permission_PermissionsEx.this.plugin.getDescription().getName(), "PermissionsEx" }));
        }
      }
    }
    
    @EventHandler(priority=EventPriority.MONITOR)
    public void onPluginDisable(PluginDisableEvent event)
    {
      if ((this.permission.permission != null) && 
        (event.getPlugin().getDescription().getName().equals("PermissionsEx")))
      {
        this.permission.permission = null;
        Permission_PermissionsEx.log.info(String.format("[%s][Permission] %s un-hooked.", new Object[] { Permission_PermissionsEx.this.plugin.getDescription().getName(), "PermissionsEx" }));
      }
    }
  }
  
  public String getName()
  {
    return "PermissionsEx";
  }
  
  public boolean playerInGroup(String worldName, OfflinePlayer op, String groupName)
  {
    PermissionUser user = getUser(op);
    if (user == null) {
      return false;
    }
    return user.inGroup(groupName, worldName);
  }
  
  public boolean playerInGroup(String worldName, String playerName, String groupName)
  {
    return PermissionsEx.getPermissionManager().getUser(playerName).inGroup(groupName, worldName);
  }
  
  public boolean playerAddGroup(String worldName, OfflinePlayer op, String groupName)
  {
    PermissionGroup group = PermissionsEx.getPermissionManager().getGroup(groupName);
    PermissionUser user = getUser(op);
    if ((group == null) || (user == null)) {
      return false;
    }
    user.addGroup(groupName, worldName);
    return true;
  }
  
  public boolean playerAddGroup(String worldName, String playerName, String groupName)
  {
    PermissionGroup group = PermissionsEx.getPermissionManager().getGroup(groupName);
    PermissionUser user = PermissionsEx.getPermissionManager().getUser(playerName);
    if ((group == null) || (user == null)) {
      return false;
    }
    user.addGroup(groupName, worldName);
    return true;
  }
  
  public boolean playerRemoveGroup(String worldName, OfflinePlayer op, String groupName)
  {
    PermissionUser user = getUser(op);
    user.removeGroup(groupName, worldName);
    return true;
  }
  
  public boolean playerRemoveGroup(String worldName, String playerName, String groupName)
  {
    PermissionsEx.getPermissionManager().getUser(playerName).removeGroup(groupName, worldName);
    return true;
  }
  
  public boolean playerAdd(String worldName, OfflinePlayer op, String permission)
  {
    PermissionUser user = getUser(op);
    if (user == null) {
      return false;
    }
    user.addPermission(permission, worldName);
    return true;
  }
  
  public boolean playerAdd(String worldName, String playerName, String permission)
  {
    PermissionUser user = getUser(playerName);
    if (user == null) {
      return false;
    }
    user.addPermission(permission, worldName);
    return true;
  }
  
  public boolean playerRemove(String worldName, OfflinePlayer op, String permission)
  {
    PermissionUser user = getUser(op);
    if (user == null) {
      return false;
    }
    user.removePermission(permission, worldName);
    return true;
  }
  
  public boolean playerRemove(String worldName, String playerName, String permission)
  {
    PermissionUser user = getUser(playerName);
    if (user == null) {
      return false;
    }
    user.removePermission(permission, worldName);
    return true;
  }
  
  public boolean groupAdd(String worldName, String groupName, String permission)
  {
    PermissionGroup group = PermissionsEx.getPermissionManager().getGroup(groupName);
    if (group == null) {
      return false;
    }
    group.addPermission(permission, worldName);
    return true;
  }
  
  public boolean groupRemove(String worldName, String groupName, String permission)
  {
    PermissionGroup group = PermissionsEx.getPermissionManager().getGroup(groupName);
    if (group == null) {
      return false;
    }
    group.removePermission(permission, worldName);
    return true;
  }
  
  public boolean groupHas(String worldName, String groupName, String permission)
  {
    PermissionGroup group = PermissionsEx.getPermissionManager().getGroup(groupName);
    if (group == null) {
      return false;
    }
    return group.has(permission, worldName);
  }
  
  private PermissionUser getUser(OfflinePlayer op)
  {
    return PermissionsEx.getPermissionManager().getUser(op.getUniqueId());
  }
  
  private PermissionUser getUser(String playerName)
  {
    return PermissionsEx.getPermissionManager().getUser(playerName);
  }
  
  public String[] getPlayerGroups(String world, OfflinePlayer op)
  {
    PermissionUser user = getUser(op);
    return user == null ? null : (String[])user.getParentIdentifiers(world).toArray(new String[0]);
  }
  
  public String[] getPlayerGroups(String world, String playerName)
  {
    PermissionUser user = getUser(playerName);
    return user == null ? null : (String[])user.getParentIdentifiers(world).toArray(new String[0]);
  }
  
  public String getPrimaryGroup(String world, OfflinePlayer op)
  {
    PermissionUser user = getUser(op);
    if (user == null) {
      return null;
    }
    if (user.getParentIdentifiers(world).size() > 0) {
      return (String)user.getParentIdentifiers(world).get(0);
    }
    return null;
  }
  
  public String getPrimaryGroup(String world, String playerName)
  {
    PermissionUser user = PermissionsEx.getPermissionManager().getUser(playerName);
    if (user == null) {
      return null;
    }
    if (user.getParentIdentifiers(world).size() > 0) {
      return (String)user.getParentIdentifiers(world).get(0);
    }
    return null;
  }
  
  public boolean playerHas(String worldName, OfflinePlayer op, String permission)
  {
    PermissionUser user = getUser(op);
    if (user != null) {
      return user.has(permission, worldName);
    }
    return false;
  }
  
  public boolean playerHas(String worldName, String playerName, String permission)
  {
    PermissionUser user = getUser(playerName);
    if (user != null) {
      return user.has(permission, worldName);
    }
    return false;
  }
  
  public boolean playerAddTransient(String worldName, String player, String permission)
  {
    PermissionUser pPlayer = getUser(player);
    if (pPlayer != null)
    {
      pPlayer.addTimedPermission(permission, worldName, 0);
      return true;
    }
    return false;
  }
  
  public boolean playerAddTransient(String worldName, Player player, String permission)
  {
    PermissionUser pPlayer = getUser(player);
    if (pPlayer != null)
    {
      pPlayer.addTimedPermission(permission, worldName, 0);
      return true;
    }
    return false;
  }
  
  public boolean playerAddTransient(String player, String permission)
  {
    return playerAddTransient(null, player, permission);
  }
  
  public boolean playerAddTransient(Player player, String permission)
  {
    return playerAddTransient(null, player, permission);
  }
  
  public boolean playerRemoveTransient(String worldName, String player, String permission)
  {
    PermissionUser pPlayer = getUser(player);
    if (pPlayer != null)
    {
      pPlayer.removeTimedPermission(permission, worldName);
      return true;
    }
    return false;
  }
  
  public boolean playerRemoveTransient(Player player, String permission)
  {
    return playerRemoveTransient(null, player, permission);
  }
  
  public boolean playerRemoveTransient(String worldName, Player player, String permission)
  {
    PermissionUser pPlayer = getUser(player);
    if (pPlayer != null)
    {
      pPlayer.removeTimedPermission(permission, worldName);
      return true;
    }
    return false;
  }
  
  public boolean playerRemoveTransient(String player, String permission)
  {
    return playerRemoveTransient(null, player, permission);
  }
  
  public String[] getGroups()
  {
    List<PermissionGroup> groups = PermissionsEx.getPermissionManager().getGroupList();
    if ((groups == null) || (groups.isEmpty())) {
      return null;
    }
    String[] groupNames = new String[groups.size()];
    for (int i = 0; i < groups.size(); i++) {
      groupNames[i] = ((PermissionGroup)groups.get(i)).getName();
    }
    return groupNames;
  }
  
  public boolean hasSuperPermsCompat()
  {
    return true;
  }
  
  public boolean hasGroupSupport()
  {
    return true;
  }
}
