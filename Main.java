package uk.morrnd.dice;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
	@Override
	public void onEnable() {
		getCommand("roll").setExecutor(new Command());
	}
	
}
