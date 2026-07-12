![GitHub License](https://img.shields.io/github/license/whiteh4cker-tr/BoostXP)
[![CodeFactor](https://www.codefactor.io/Content/badges/APlus.svg)](https://www.codefactor.io/repository/github/whiteh4cker-tr/boostxp)

<big>Supported Platforms</big><br>
[![spigot software](https://cdn.jsdelivr.net/npm/@intergrav/devins-badges@3.2.0/assets/compact-minimal/supported/spigot_vector.svg)](https://www.spigotmc.org/)
[![paper software](https://cdn.jsdelivr.net/npm/@intergrav/devins-badges@3/assets/compact-minimal/supported/paper_vector.svg)](https://papermc.io/)
[![purpur software](https://cdn.jsdelivr.net/npm/@intergrav/devins-badges@3/assets/compact-minimal/supported/purpur_vector.svg)](https://purpurmc.org/)

Give players configurable experience for breaking logs, brewing, and harvesting fully grown crops.

## Configuration

The plugin generates a `config.yml` on first start. All values can be adjusted to your liking:

```yaml
experience:
  # XP given when breaking a log
  log-breaking: 1
  # XP given when brewing completes
  brewing: 5
  # XP given when harvesting a fully grown crop
  crop-harvesting: 2
```

Changes take effect on server restart.
