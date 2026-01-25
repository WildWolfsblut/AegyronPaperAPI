# Aegyron Paper API

Public API for developing Paper plugins that integrate with **Aegyron Core**.

## 📦 Installation

### Gradle (Kotlin DSL)
```kotlin
repositories {
    maven("https://maven.pkg.github.com/ItsJxsper/aegyron-network")
}

dependencies {
    compileOnly("de.itsjxsper:aegyron-api-paper:1.0.0")
}
```

### Gradle (Groovy)
```groovy
repositories {
    maven {
        url 'https://maven.pkg.github.com/ItsJxsper/aegyron-network'
    }
}

dependencies {
    compileOnly 'de.itsjxsper:aegyron-api-paper:1.0.0'
}
```

### Maven
```xml
<repositories>
    <repository>
        <id>github</id>
        <url>https://maven.pkg.github.com/ItsJxsper/aegyron-network</url>
    </repository>
</repositories>

<dependencies>
    <dependency>
        <groupId>de.itsjxsper</groupId>
        <artifactId>aegyron-api-paper</artifactId>
        <version>1.0.0</version>
        <scope>provided</scope>
    </dependency>
</dependencies>
```

## 🚀 Quick Start

### 1. Add Dependency in plugin.yml
```yaml
name: YourPlugin
version: 1.0.0
main: com.example.YourPlugin
api-version: '1.21'
depend: [Aegyron-Paper]  # <-- Important!
```

### 2. Get API Instance
```java
import de.itsjxsper.aegyronapipaper.AegyronPaperAPI;

public class YourPlugin extends JavaPlugin {
    
    private AegyronPaperAPI aegyronAPI;
    
    @Override
    public void onEnable() {
        // Get API instance
        this.aegyronAPI = AegyronPaperAPI.getInstance();
        
        // Check if ready
        if (!aegyronAPI.isReady()) {
            getLogger().warning("Aegyron API is not ready yet!");
            return;
        }
        
        getLogger().info("Aegyron API loaded: " + aegyronAPI.getVersion());
    }
}
```

## 📚 Features & Examples

### Messaging API
Send messages, broadcasts, and create interactive components.

```java
// Simple message
api.messaging().sendMessage(player, "<green>Hello World!");

// Broadcast to all servers
api.messaging().broadcast("<red>Server restart in 5 minutes!");

// Broadcast to specific group
api.messaging().broadcastToGroup("survival", "Event started!");

// Interactive message with click events
api.messaging().builder()
    .text("<gold>Click here ")
    .clickCommand("/spawn")
    .hoverText("Teleport to spawn")
    .then("<gray>or ")
    .then("<red>here")
    .clickUrl("https://example.com")
    .hoverText("Visit website")
    .send(player);

// Title with custom timings
api.messaging().sendTitle(player, 
    "<rainbow>CONGRATULATIONS!", 
    "<yellow>You won the lottery!",
    10, 70, 20  // fadeIn, stay, fadeOut in ticks
);

// Action bar
api.messaging().sendActionBar(player, "<aqua>Health: ❤ 20/20");
```

### Group API
Query server groups and check group membership.

```java
// Get current server's group
Optional<ServerGroup> group = api.group().getCurrentGroup();
group.ifPresent(g -> {
    getLogger().info("Server is in group: " + g.getName());
    getLogger().info("Servers in group: " + g.getServers());
});

// Check if server is in a group
if (api.group().isInGroup("survival")) {
    // Do something specific for survival servers
}

// Get all servers in a group
api.group().getServersInGroup("lobby").thenAccept(servers -> {
    getLogger().info("Lobby servers: " + servers);
});

// Check if feature is enabled
if (api.group().hasFeature("pvp")) {
    // Enable PvP mechanics
}

// Get player count in group
api.group().getPlayerCount("minigames").thenAccept(count -> {
    getLogger().info("Players in minigames: " + count);
});
```

### Player Data API
Access and synchronize player data across servers.

```java
// Get player data
Optional<AegyronPlayer> aPlayer = api.playerData().getPlayer(player);
aPlayer.ifPresent(ap -> {
    long playtime = ap.getPlaytime();
    String primaryGroup = ap.getPrimaryGroup();
    
    // Custom data
    ap.setCustomData("last_dungeon", "dragon_lair");
    Object lastDungeon = ap.getCustomData("last_dungeon");
});

// Save player data (async)
api.playerData().savePlayerData(player).thenRun(() -> {
    getLogger().info("Player data saved!");
});

// Load player data from backend
api.playerData().loadPlayerData(uuid).thenRun(() -> {
    getLogger().info("Player data loaded!");
});

// Get statistics
api.playerData().getStats(uuid).thenAccept(stats -> {
    if (stats.isPresent()) {
        PlayerStats s = stats.get();
        getLogger().info("Total playtime: " + s.getTotalPlaytime() + "s");
        getLogger().info("Join count: " + s.getTotalJoinCount());
    }
});

// Check if player is online
api.playerData().isOnline(uuid).thenAccept(online -> {
    if (online) {
        getLogger().info("Player is online!");
    }
});
```

### Home API
Manage cross-server homes.

```java
// Get player's homes
api.home().getHomes(player).thenAccept(homes -> {
    for (Home home : homes) {
        getLogger().info("Home: " + home.getName() + 
                       " at " + home.getLocation());
    }
});

// Create a home
api.home().createHome(player, "base", player.getLocation())
    .thenAccept(home -> {
        player.sendMessage("Home created: " + home.getName());
    })
    .exceptionally(error -> {
        player.sendMessage("Failed to create home: " + error.getMessage());
        return null;
    });

// Teleport to home (with warmup/cooldown)
api.home().teleportToHome(player, "base").thenAccept(success -> {
    if (success) {
        player.sendMessage("Teleporting to home...");
    }
});

// Instant teleport (bypass warmup)
api.home().teleportToHomeInstantly(player, "spawn");

// Check limits
int limit = api.home().getHomeLimit(player);
api.home().getRemainingHomes(player).thenAccept(remaining -> {
    player.sendMessage("Homes: " + remaining + "/" + limit + " remaining");
});

// Check if can teleport (cooldown check)
if (api.home().canTeleport(player)) {
    api.home().teleportToHome(player, "base");
} else {
    long cooldown = api.home().getRemainingCooldown(player);
    player.sendMessage("Cooldown: " + cooldown + "s");
}

// Delete home
api.home().deleteHome(player, "old_base").thenAccept(deleted -> {
    if (deleted) {
        player.sendMessage("Home deleted!");
    }
});
```

## 🎯 Event System

Listen to Aegyron events in your plugin:

```java
import de.itsjxsper.aegyronapipaper.events.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class MyListener implements Listener {
    
    // When player changes groups (server switch)
    @EventHandler
    public void onGroupChange(GroupChangeEvent event) {
        Player player = event.getPlayer();
        String from = event.getFromGroup();
        String to = event.getToGroup();
        
        if (to.equals("survival")) {
            // Give starter kit
            giveStarterKit(player);
        }
    }
    
    // When player data is synced
    @EventHandler
    public void onDataSync(PlayerDataSyncEvent event) {
        if (event.isSuccess()) {
            getLogger().info("Data synced for " + event.getPlayerUUID());
        }
    }
    
    // When a home is created
    @EventHandler
    public void onHomeCreate(HomeCreateEvent event) {
        Player player = event.getPlayer();
        String homeName = event.getHomeName();
        
        // You can cancel the event
        if (homeName.contains("bad")) {
            event.setCancelled(true);
            player.sendMessage("Invalid home name!");
        }
    }
    
    // When player teleports to home
    @EventHandler
    public void onHomeTeleport(HomeTeleportEvent event) {
        Player player = event.getPlayer();
        Home home = event.getHome();
        
        getLogger().info(player.getName() + " teleporting to " + home.getName());
    }
    
    // When a vote is received
    @EventHandler
    public void onVote(VoteReceivedEvent event) {
        UUID uuid = event.getPlayerUUID();
        String service = event.getServiceName();
        
        // Reward the player
        rewardPlayer(uuid);
    }
    
    // When vote party triggers
    @EventHandler
    public void onVoteParty(VotePartyEvent event) {
        // Give rewards to all online players
        Bukkit.getOnlinePlayers().forEach(this::giveVotePartyReward);
    }
}
```

## 📖 API Reference

### Main API
- `AegyronPaperAPI.getInstance()` - Get API instance
- `api.messaging()` - Access messaging API
- `api.group()` - Access group API
- `api.playerData()` - Access player data API
- `api.home()` - Access home API
- `api.isReady()` - Check if API is ready
- `api.getVersion()` - Get API version

### Events
- `GroupChangeEvent` - Player changes server group
- `GroupConfigUpdateEvent` - Group config updated
- `PlayerDataSyncEvent` - Player data synchronized
- `PlayerDataLoadEvent` - Player data loaded
- `PlayerDataSaveEvent` - Player data saved
- `HomeCreateEvent` - Home created (cancellable)
- `HomeDeleteEvent` - Home deleted (cancellable)
- `HomeTeleportEvent` - Player teleports to home (cancellable)
- `VoteReceivedEvent` - Vote received
- `VotePartyEvent` - Vote party triggered
- `VoteStreakEvent` - Vote streak changed
- `CoreReloadEvent` - Core reloaded
- `CoreShutdownEvent` - Core shutting down

## ⚙️ Best Practices

### 1. Always use async methods properly
```java
// ❌ BAD - Blocking main thread
List<Home> homes = api.home().getHomes(player).join();

// ✅ GOOD - Async handling
api.home().getHomes(player).thenAccept(homes -> {
    // Handle homes asynchronously
});
```

### 2. Check API readiness
```java
@Override
public void onEnable() {
    if (!AegyronPaperAPI.getInstance().isReady()) {
        getLogger().warning("Aegyron not ready, disabling...");
        getServer().getPluginManager().disablePlugin(this);
        return;
    }
}
```

### 3. Handle errors gracefully
```java
api.home().createHome(player, "base", location)
    .exceptionally(error -> {
        if (error instanceof HomeLimitExceededException) {
            player.sendMessage("You've reached your home limit!");
        } else {
            player.sendMessage("Failed to create home.");
            getLogger().log(Level.WARNING, "Home creation failed", error);
        }
        return null;
    });
```

### 4. Use event priorities wisely
```java
// Run early to modify/cancel
@EventHandler(priority = EventPriority.LOW)
public void onHomeCreate(HomeCreateEvent event) {
    // Validation logic
}

// Run late to observe final state
@EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
public void onHomeCreateMonitor(HomeCreateEvent event) {
    // Logging/statistics
}
```

---

**Made with ❤️ by ItsJxsper**