import winsound
# Play Windows exit sound.
winsound.playSound("SystemExit", winsound.SND_ALIAS)

# Probably play Windows default sound, if any is registered (because
# "*" probably isn't the registered name of any sound).
winsound.playSound("*", winsound.SND_ALIAS)
