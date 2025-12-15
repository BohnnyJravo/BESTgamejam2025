# Proces
Vse se začne z dobro idejo. No to je bila najboljša ki sem jo lahko našel preden sem zaspal v petek zvečer.
Sledile so sličice v Gimp-u, ki res presenetljivo niso vzele veliko časa.
Vse sem prenesel v generiran LibGDX projekt in pričel z osnovnimi razredi ki so sprva omogočali le izris.
Na koncu pa sem se lotil še logike, pasti in HUD-a.

# Mehanike
Kepa se premika s stalno hitrostjo in ob pritisku puščic spremeni smer. Ogenj se generira na naključnjih koordinatah na intervalu od 0 do # plošč v vrstici/stolpcu in ob naključnem času, kar omogoča res nepredvidljivo izkušnjo. Sneg ima 90% možnosti da se generira umazan.

# Tehnika
Arhitektura je standardno Objekto usmerjeno programiranje in sama logika in mehanika tudi nista zahtevali veliko naprezanja. Igra je enostavne narave, kar je po svoje tudi plus.

# Vizualno zvočni del
Vizualno izgleda super, razen tega da ni pravega uporabniškega vmesnika. Zvočni efekti predstavljajo sproščenost in igrivost na snegu. Zvočni efekti so pridobljeni iz interneta [tukaj](pixi).

# Zagon
Datoteke za zagon najdemo v lwjgl3/build/libs (jar) in lwgjl3/executables (.exe). Priporočen je zagon z jar, saj exe ni testiran.

# AI
uporabljal sem chatGPT standardni chat na spletu, ki mi je pomagal s kompleksnejšimi rešitvami/algoritmi, pri katerih se mi je morda zataknilo.

# Dodatno
Ideja je bila za nadaljevanje, torej bi lahko v neskončnost gradil snežake in bil umeščen na leaderboard. Upal sem tudi na UI in nastavitne, ki bi izboljšale uporabniško izkušnjo (otežile/olajšale nivo težavnosti).
