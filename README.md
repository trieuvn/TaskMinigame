# 🛠️ Minecraft Among Us Tasks Plugin

A lightweight plugin that brings **Among Us-style minigames** into Minecraft!  
Perfect for custom minigame servers, roleplay experiences, or just having fun with friends.

## 🎮 Features

- Simulates iconic **Among Us tasks** as interactive minigames inside Minecraft.
- Simple command to start a task for any player.
- Automatically runs a success command when a task is completed.

## 🧩 Available Tasks

| Task Name    | Description                |
|-------------|----------------------------|
| `wiring`     | Simulate fixing electrical wiring.     |
| `download`   | Mimics downloading data from a panel.  |
| `clean`      | Clean up an area or object.            |
| `garbage`    | Simulate emptying garbage chute.       |
| `navigation` | Adjust ship path (navigation system).  |
| `reactor`    | Fix the meltdown by matching patterns. |

## 🚀 How to Use

Use the `/sus` command to start a task for a player:

```
/sus <task> <player name>
```

- `<task>`: One of the tasks listed above (e.g., `wiring`, `reactor`, etc.)
- `<player name>`: The name of an online player.

📌 **Note:**  
Once the player completes the task, the plugin will automatically run the following command in the console:

```
/ce call <task>_task %player_name%=<player name>
```

This lets you hook into other plugins or systems based on task completion!

---

## 🛠️ Example

```
/sus wiring Steve
```

➡️ When *Steve* finishes the wiring task, the server executes:

```
/ce call wiring_task %player_name%=Steve
```


## 🤝 Contributing

Pull requests and suggestions are always welcome!  
Feel free to fork, customize, or expand the tasks.

---

## 📜 License

This project is open-source and available under the [MIT License](LICENSE).
