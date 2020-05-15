## ChocoColor
Qusto semplice algoritmo risolverà il problema del Feeding del Chocobo in FFXIV per poterlo colorare. Quando avrete inserito il colore attuale del vostro Chocobo e quello desiderato, lo script vi mosterà a video le bacche richieste e l'ordine corretto per assicurarvi il risultato corretto.

### Perchè?
Ho visto parecchi siti dove potete controllare il numero di bacche totali per modificare il colore al Chocobo. Raccomandano di alternare le bacche per evitare di andare oltre il range del valore RGB (da 0 a 255), che causa il fallimento di tutto il processo. Questo algoritmo assicura che non andrete mai fuori scala e asscura quindi l'esito desiderato.

### Uso
Eseguite il file exe o il file jar compilato con due parametri. Il primo sarà il colore di partenza del vostro chocobo, mentre il secondo sarà il colore desiderato. Una corretta scrittura dei colori, vi darà il processo da seguire assieme alle bacche corrette. In caso contrario, mosterà la lista dei colori disponibili.

### Esempi
----
choco-color.exe "Desert Yellow" "Ash Gray"
----
----
java -jar choco-color.jar "Desert Yellow" "Ash Gray" 
----

