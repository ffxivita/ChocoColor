(ns chocobo.math)

(defn absolute
  "Valore assoluto di un numero"
  [n]
  (if (< n 0)
    (- n)
    n))

(defn abs
  "Sequenza di valori assoluti"
  [coll]
  (map absolute coll))

(defn sum
  "Somma di valori di una sequenza"
  [coll]
  (reduce + coll))

(defn entropy
  "Entropia (somma dei valori assoluti)"
  [coll]
  (sum (abs coll)))

(defn smallest-entropy
  "Collezione con la minore entropia"
  [coll]
  (first (sort-by entropy coll)))