(ns entrega3.core
  (:gen-class))

(defn limpiar-texto [texto]
  (clojure.string/lower-case
   (clojure.string/replace texto #"[^\w\s]" "")))

(defn contar-palabras [texto]
  (frequencies (clojure.string/split (limpiar-texto texto) #"\s+")))

(defn palabras-mas-frecuentes [texto n]
  (take n (sort-by val > (contar-palabras texto))))

(defn -main []
  (let [texto "Clojure es un lenguaje de programación funcional. Clojure es poderoso y elegante."
        resultado (palabras-mas-frecuentes texto 3)]
    (println "Las palabras más frecuentes son:")
    (doseq [[palabra frecuencia] resultado]
      (println palabra ":" frecuencia))))