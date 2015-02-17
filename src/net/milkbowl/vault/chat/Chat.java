package net.milkbowl.vault.chat;

import net.milkbowl.vault.permission.Permission;
import org.bukkit.OfflinePlayer;
import org.bukkit.World;
import org.bukkit.entity.Player;

public abstract class Chat
{
  private Permission perms;
  
  public Chat(Permission perms)
  {
    this.perms = perms;
  }
  
  public abstract String getName();
  
  public abstract boolean isEnabled();
  
  @Deprecated
  public abstract String getPlayerPrefix(String paramString1, String paramString2);
  
  public String getPlayerPrefix(String world, OfflinePlayer player)
  {
    return getPlayerPrefix(world, player.getName());
  }
  
  @Deprecated
  public String getPlayerPrefix(World world, String player)
  {
    return getPlayerPrefix(world.getName(), player);
  }
  
  public String getPlayerPrefix(Player player)
  {
    return getPlayerPrefix(player.getWorld().getName(), player);
  }
  
  @Deprecated
  public abstract void setPlayerPrefix(String paramString1, String paramString2, String paramString3);
  
  public void setPlayerPrefix(String world, OfflinePlayer player, String prefix)
  {
    setPlayerPrefix(world, player.getName(), prefix);
  }
  
  @Deprecated
  public void setPlayerPrefix(World world, String player, String prefix)
  {
    setPlayerPrefix(world.getName(), player, prefix);
  }
  
  public void setPlayerPrefix(Player player, String prefix)
  {
    setPlayerPrefix(player.getWorld().getName(), player, prefix);
  }
  
  @Deprecated
  public abstract String getPlayerSuffix(String paramString1, String paramString2);
  
  public String getPlayerSuffix(String world, OfflinePlayer player)
  {
    return getPlayerSuffix(world, player.getName());
  }
  
  @Deprecated
  public String getPlayerSuffix(World world, String player)
  {
    return getPlayerSuffix(world.getName(), player);
  }
  
  public String getPlayerSuffix(Player player)
  {
    return getPlayerSuffix(player.getWorld().getName(), player);
  }
  
  @Deprecated
  public abstract void setPlayerSuffix(String paramString1, String paramString2, String paramString3);
  
  public void setPlayerSuffix(String world, OfflinePlayer player, String suffix)
  {
    setPlayerSuffix(world, player.getName(), suffix);
  }
  
  @Deprecated
  public void setPlayerSuffix(World world, String player, String suffix)
  {
    setPlayerSuffix(world.getName(), player, suffix);
  }
  
  public void setPlayerSuffix(Player player, String suffix)
  {
    setPlayerSuffix(player.getWorld().getName(), player, suffix);
  }
  
  public abstract String getGroupPrefix(String paramString1, String paramString2);
  
  public String getGroupPrefix(World world, String group)
  {
    return getGroupPrefix(world.getName(), group);
  }
  
  public abstract void setGroupPrefix(String paramString1, String paramString2, String paramString3);
  
  public void setGroupPrefix(World world, String group, String prefix)
  {
    setGroupPrefix(world.getName(), group, prefix);
  }
  
  public abstract String getGroupSuffix(String paramString1, String paramString2);
  
  public String getGroupSuffix(World world, String group)
  {
    return getGroupSuffix(world.getName(), group);
  }
  
  public abstract void setGroupSuffix(String paramString1, String paramString2, String paramString3);
  
  public void setGroupSuffix(World world, String group, String suffix)
  {
    setGroupSuffix(world.getName(), group, suffix);
  }
  
  public int getPlayerInfoInteger(String world, OfflinePlayer player, String node, int defaultValue)
  {
    return getPlayerInfoInteger(world, player.getName(), node, defaultValue);
  }
  
  @Deprecated
  public abstract int getPlayerInfoInteger(String paramString1, String paramString2, String paramString3, int paramInt);
  
  @Deprecated
  public int getPlayerInfoInteger(World world, String player, String node, int defaultValue)
  {
    return getPlayerInfoInteger(world.getName(), player, node, defaultValue);
  }
  
  public int getPlayerInfoInteger(Player player, String node, int defaultValue)
  {
    return getPlayerInfoInteger(player.getWorld().getName(), player, node, defaultValue);
  }
  
  public void setPlayerInfoInteger(String world, OfflinePlayer player, String node, int value)
  {
    setPlayerInfoInteger(world, player.getName(), node, value);
  }
  
  @Deprecated
  public abstract void setPlayerInfoInteger(String paramString1, String paramString2, String paramString3, int paramInt);
  
  @Deprecated
  public void setPlayerInfoInteger(World world, String player, String node, int value)
  {
    setPlayerInfoInteger(world.getName(), player, node, value);
  }
  
  public void setPlayerInfoInteger(Player player, String node, int value)
  {
    setPlayerInfoInteger(player.getWorld().getName(), player, node, value);
  }
  
  public abstract int getGroupInfoInteger(String paramString1, String paramString2, String paramString3, int paramInt);
  
  public int getGroupInfoInteger(World world, String group, String node, int defaultValue)
  {
    return getGroupInfoInteger(world.getName(), group, node, defaultValue);
  }
  
  public abstract void setGroupInfoInteger(String paramString1, String paramString2, String paramString3, int paramInt);
  
  public void setGroupInfoInteger(World world, String group, String node, int value)
  {
    setGroupInfoInteger(world.getName(), group, node, value);
  }
  
  public double getPlayerInfoDouble(String world, OfflinePlayer player, String node, double defaultValue)
  {
    return getPlayerInfoDouble(world, player.getName(), node, defaultValue);
  }
  
  @Deprecated
  public abstract double getPlayerInfoDouble(String paramString1, String paramString2, String paramString3, double paramDouble);
  
  @Deprecated
  public double getPlayerInfoDouble(World world, String player, String node, double defaultValue)
  {
    return getPlayerInfoDouble(world.getName(), player, node, defaultValue);
  }
  
  public double getPlayerInfoDouble(Player player, String node, double defaultValue)
  {
    return getPlayerInfoDouble(player.getWorld().getName(), player, node, defaultValue);
  }
  
  public void setPlayerInfoDouble(String world, OfflinePlayer player, String node, double value)
  {
    setPlayerInfoDouble(world, player.getName(), node, value);
  }
  
  @Deprecated
  public abstract void setPlayerInfoDouble(String paramString1, String paramString2, String paramString3, double paramDouble);
  
  @Deprecated
  public void setPlayerInfoDouble(World world, String player, String node, double value)
  {
    setPlayerInfoDouble(world.getName(), player, node, value);
  }
  
  public void setPlayerInfoDouble(Player player, String node, double value)
  {
    setPlayerInfoDouble(player.getWorld().getName(), player, node, value);
  }
  
  public abstract double getGroupInfoDouble(String paramString1, String paramString2, String paramString3, double paramDouble);
  
  public double getGroupInfoDouble(World world, String group, String node, double defaultValue)
  {
    return getGroupInfoDouble(world.getName(), group, node, defaultValue);
  }
  
  public abstract void setGroupInfoDouble(String paramString1, String paramString2, String paramString3, double paramDouble);
  
  public void setGroupInfoDouble(World world, String group, String node, double value)
  {
    setGroupInfoDouble(world.getName(), group, node, value);
  }
  
  public boolean getPlayerInfoBoolean(String world, OfflinePlayer player, String node, boolean defaultValue)
  {
    return getPlayerInfoBoolean(world, player.getName(), node, defaultValue);
  }
  
  @Deprecated
  public abstract boolean getPlayerInfoBoolean(String paramString1, String paramString2, String paramString3, boolean paramBoolean);
  
  @Deprecated
  public boolean getPlayerInfoBoolean(World world, String player, String node, boolean defaultValue)
  {
    return getPlayerInfoBoolean(world.getName(), player, node, defaultValue);
  }
  
  public boolean getPlayerInfoBoolean(Player player, String node, boolean defaultValue)
  {
    return getPlayerInfoBoolean(player.getWorld().getName(), player, node, defaultValue);
  }
  
  public void setPlayerInfoBoolean(String world, OfflinePlayer player, String node, boolean value)
  {
    setPlayerInfoBoolean(world, player.getName(), node, value);
  }
  
  @Deprecated
  public abstract void setPlayerInfoBoolean(String paramString1, String paramString2, String paramString3, boolean paramBoolean);
  
  @Deprecated
  public void setPlayerInfoBoolean(World world, String player, String node, boolean value)
  {
    setPlayerInfoBoolean(world.getName(), player, node, value);
  }
  
  public void setPlayerInfoBoolean(Player player, String node, boolean value)
  {
    setPlayerInfoBoolean(player.getWorld().getName(), player, node, value);
  }
  
  public abstract boolean getGroupInfoBoolean(String paramString1, String paramString2, String paramString3, boolean paramBoolean);
  
  public boolean getGroupInfoBoolean(World world, String group, String node, boolean defaultValue)
  {
    return getGroupInfoBoolean(world.getName(), group, node, defaultValue);
  }
  
  public abstract void setGroupInfoBoolean(String paramString1, String paramString2, String paramString3, boolean paramBoolean);
  
  public void setGroupInfoBoolean(World world, String group, String node, boolean value)
  {
    setGroupInfoBoolean(world.getName(), group, node, value);
  }
  
  public String getPlayerInfoString(String world, OfflinePlayer player, String node, String defaultValue)
  {
    return getPlayerInfoString(world, player.getName(), node, defaultValue);
  }
  
  @Deprecated
  public abstract String getPlayerInfoString(String paramString1, String paramString2, String paramString3, String paramString4);
  
  @Deprecated
  public String getPlayerInfoString(World world, String player, String node, String defaultValue)
  {
    return getPlayerInfoString(world.getName(), player, node, defaultValue);
  }
  
  public String getPlayerInfoString(Player player, String node, String defaultValue)
  {
    return getPlayerInfoString(player.getWorld().getName(), player, node, defaultValue);
  }
  
  public void setPlayerInfoString(String world, OfflinePlayer player, String node, String value)
  {
    setPlayerInfoString(world, player.getName(), node, value);
  }
  
  @Deprecated
  public abstract void setPlayerInfoString(String paramString1, String paramString2, String paramString3, String paramString4);
  
  @Deprecated
  public void setPlayerInfoString(World world, String player, String node, String value)
  {
    setPlayerInfoString(world.getName(), player, node, value);
  }
  
  public void setPlayerInfoString(Player player, String node, String value)
  {
    setPlayerInfoString(player.getWorld().getName(), player, node, value);
  }
  
  public abstract String getGroupInfoString(String paramString1, String paramString2, String paramString3, String paramString4);
  
  public String getGroupInfoString(World world, String group, String node, String defaultValue)
  {
    return getGroupInfoString(world.getName(), group, node, defaultValue);
  }
  
  public abstract void setGroupInfoString(String paramString1, String paramString2, String paramString3, String paramString4);
  
  public void setGroupInfoString(World world, String group, String node, String value)
  {
    setGroupInfoString(world.getName(), group, node, value);
  }
  
  public boolean playerInGroup(String world, OfflinePlayer player, String group)
  {
    return this.perms.playerInGroup(world, player.getName(), group);
  }
  
  @Deprecated
  public boolean playerInGroup(String world, String player, String group)
  {
    return this.perms.playerInGroup(world, player, group);
  }
  
  @Deprecated
  public boolean playerInGroup(World world, String player, String group)
  {
    return playerInGroup(world.getName(), player, group);
  }
  
  public boolean playerInGroup(Player player, String group)
  {
    return playerInGroup(player.getWorld().getName(), player, group);
  }
  
  public String[] getPlayerGroups(String world, OfflinePlayer player)
  {
    return this.perms.getPlayerGroups(world, player.getName());
  }
  
  @Deprecated
  public String[] getPlayerGroups(String world, String player)
  {
    return this.perms.getPlayerGroups(world, player);
  }
  
  @Deprecated
  public String[] getPlayerGroups(World world, String player)
  {
    return getPlayerGroups(world.getName(), player);
  }
  
  public String[] getPlayerGroups(Player player)
  {
    return getPlayerGroups(player.getWorld().getName(), player);
  }
  
  public String getPrimaryGroup(String world, OfflinePlayer player)
  {
    return this.perms.getPrimaryGroup(world, player.getName());
  }
  
  @Deprecated
  public String getPrimaryGroup(String world, String player)
  {
    return this.perms.getPrimaryGroup(world, player);
  }
  
  @Deprecated
  public String getPrimaryGroup(World world, String player)
  {
    return getPrimaryGroup(world.getName(), player);
  }
  
  public String getPrimaryGroup(Player player)
  {
    return getPrimaryGroup(player.getWorld().getName(), player);
  }
  
  public String[] getGroups()
  {
    return this.perms.getGroups();
  }
}
