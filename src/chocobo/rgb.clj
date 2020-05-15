(ns chocobo.rgb)

(defn equal
  "True se i componenti sono uguali"
  [x y]
  (every?
    (partial = true)
    (map = x y)))

(defn add
  "Somma dei componensi"
  [x y]
  (map + x y))

(defn diff
  "Differenza dei componenti"
  [x y]
  (map - x y))

(defn valid
  "True se tutti i componenti sono dentro al range [0,255]"
  [color]
  (every?
    (partial = true)
    (map
      #(and (>= % 0) (<= % 255))
      color)))

(defn counter
  "Colori in rgb"
  [color coll]
  (count
    (filter
      #(equal color %)
      coll)))