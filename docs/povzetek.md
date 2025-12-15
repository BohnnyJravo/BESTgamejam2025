# Jammers
- Matic Škrjanc, designer, coder, the idea man

## Building Snowman
Because balls even out of snow are great.

## Povzetek
Kot kepa snega se premikaš po principu klasične igre Snake in pobiraš sneg s čimer se tudi večaš in dobivaš točke.

Cilj igre pa je zbrati dovolj snega za 3 kepe.

Ideja je prišla z nostalgijo gradnje snežakov in, sploh v zadnjih letih, jih čim blje obdržati :).

## Mehanike
Kepa se premika gor, dol, levo, desno s puščicami, implementirana je možnost ustavitve igre in ponastavitve stanj s P in R tipko.

Kepa mora zbrati sneg in se ne razdreti/staliti.

V napoto so ti:
- ogenj, ki ogreje območje in karkoli pride vanj, posledično ti zbije točke in zmanjša površino kepi,
- Rumen sneg ;) ki te umaže in uniči strukturo snega,
- rob okna, ki kepo razbije če se prevečkrt zaleti vanj

Cilj igre pa je zbrati dovolj snega za 3 kepe (prva manjša 250 točk, druga srednja 500 točk, tretja največja 1000 točk).


## Orodja
GIMP, LibGDX, Java, AndroidStudio

## Glavno
Ponosen sem na assete, ki so mi res dobro uspeli in implementacijo ognja, kjer sem z algoritmom evklidove razdalje našel plošče, ki skupaj z ognjem segrevajo okolico.


## Reference
- [Snow For Santa](https://www.1001freefonts.com/snow-for-santa.font) font by dcoxy
- ChatGPT za dve metodi (GameStateVars.spawnCampfire() in Player.overlap(Rectangle))
- Campfire Sound Effect by [Jurij](https://pixabay.com/users/soundreality-31074404/?utm_source=link-attribution&utm_medium=referral&utm_campaign=music&utm_content=439573") from [Pixabay](https://pixabay.com/sound-effects//?utm_source=link-attribution&utm_medium=referral&utm_campaign=music&utm_content=439573)
- Snow Sound Effect by [freesound_community](https://pixabay.com/users/freesound_community-46691455/?utm_source=link-attribution&utm_medium=referral&utm_campaign=music&utm_content=33462) from [Pixabay](https://pixabay.com/sound-effects//?utm_source=link-attribution&utm_medium=referral&utm_campaign=music&utm_content=33462)
- asseti in ostalo narejeno ročno


## Sitrep
Glaven del igre je narejen in se mi zdi da je nastala kar zabavna igra. Dodelati oz. sploh ustvariti bi bilo potrebno UI, zvočne efekte in dodati zaključek igri (nek final scene).
