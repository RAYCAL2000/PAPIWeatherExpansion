# Weather Expansion

An expansion to PlaceholderAPI which adds a few new weather related placeholders for usage in GUIS, Menus, etc.

## 📚 Overview

Some important notes:

- `[_world]` is optional. If left out, it defaults to the player's current world. Otherwise, it will gather information from the specified world.

## 🌤️ Placeholders



| Placeholder                         | Description                                           |
|-------------------------------------|-------------------------------------------------------|
| %weather_condition[_world]%              | Current world conditions, consists of the precipitation type, combined with if it is thundering or not. (Rainy & Thunder)                        |
| %weather_precipitation[_world]%           | Current world precipitation. (Rainy, Snowy, Clear)                |
| %weather_thunder[_world]%                 | If the current world has active thunder or not. (true or false)               |
| %weather_duration[_world]%                | The remaining duration of the current weather condition in the world formatted in HH:MM:SS.
