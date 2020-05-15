(ns chocobo.feeding
    (:require [chocobo.math :as math]
              [chocobo.rgb :as rgb]))
  
  (def berry-data [{:rgb [5 -5 -5] :name "Xelphatol Apple"},
                   {:rgb [-5 5 -5] :name "Mamook Pear"},
                   {:rgb [-5 -5 5] :name "O'Ghomoro Berries"},
                   {:rgb [-5 5 5] :name "Doman Plum"},
                   {:rgb [5 -5 5] :name "Valfruit"},
                   {:rgb [5 5 -5] :name "Cieldalaes Pineapple"}])
  
  (defn find-by-color
    "Il valore della bacca in RGB"
    [color]
    (first
      (filter
        #(rgb/equal color (:rgb %))
        berry-data)))
  
  (defn find-name
    "Transforma il valore rgb nel nome della bacca"
    [color]
    (:name (find-by-color color)))
  
  (def closeness 6)
  
  (defn close-enough
    "Ritorna true se il vaore rgb ha i componenti uguali"
    [x y]
    (every?
      (partial > closeness)
      (math/abs
        (rgb/diff x y))))
  
  (defn feed
    "Ritorna una collezione con ogni colore ottenibile con le bacche scelte"
    [color]
    (map
      (partial rgb/add color)
      (map :rgb berry-data)))
  
  (defn best-choice
    "Ritorna la prossima bacca che dovrebbe essere data al Chocobo per ottenere il colore prescelto dal colore di partenza prescelto"
    [current target]
    (rgb/diff target
      (rgb/add current
        (math/smallest-entropy
          (map
            (partial rgb/diff target)
            (filter
              rgb/valid
              (feed current)))))))
  
  (defn feed-chain
    "Ritorna la lita ordinata delle bacche (valori rgb) necessari per dar da mangiare al Chocobo dal colore di partenza a quello di arrivo"
    ([current target]
     (feed-chain current target []))
    ([current target berries]
     (if (close-enough current target)
       berries
       (let [next (best-choice current target)]
         (recur
           (rgb/add current next)
           target
           (conj berries next))))))
  
  (defn feed-chain-totals
    "Ritorna il totale delle bacche richieste per una chain"
    [chain]
    (map
      #(let [total (rgb/counter % chain)
             name (find-name %)]
        (if (> total 0)
          (str name " x" total)))
      (map #(:rgb %) berry-data)))
  
  (defn feed-chain-names
    "Ritorna la list dei valori rgb associaldoli ai nomi delle bacche"
    [chain]
    (map find-name chain))