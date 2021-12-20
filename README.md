# Twist

A skeleton primarily to create Minecraft Manhunt twists.

## Installation

Download the plugin from this repository
```
git clone https://github.com/Zytekaron/Twist
```

## Usage

Modify the [`com.zytekaron.minecraft.twist.Twist`](./src/main/java/com/zytekaron/minecraft/twist/Twist.java) class
by editing the `createHandlers` method with your custom twist. Use the other utility classes in the package to help
with things such as handling events. Make sure to register your event handlers with `registerEvents`.

Example Twist classes can be found in the [examples](./examples) directory.

You can keep a copy of your twists in the root `twists` folder, which is excluded from GitHub.

## Building

Windows:
```shell
cd Twist
./build.sh
cp ./build/libs/Twist-1.0.0-all.jar ~/minecraft-server/plugins
```

Linux:
```sh
cd Twist
.\build.bat
move .\build\libs\Twist-1.0.0.jar C:\Users\username\minecraft-server\plugins
```

## Commands

Twist comes with a set of commands that can be used when running manhunts:
- `/spectator` - set a player to be a spectator (default mode)
- `/runner` - set a player to be a runner
- `/hunter` - set a player to be a hunter
- `/list` - list all players and their roles
- `/clear` - clear all player roles
- `/hunterchat` `/h` - send a message to the hunters and spectators
- `/runnerchat` `/r` - send a message to the runners and spectators
- `/spectatorchat` `/s` - send a message to the spectators

# License

<b>Twist</b> is licensed under the [MIT License](./LICENSE)