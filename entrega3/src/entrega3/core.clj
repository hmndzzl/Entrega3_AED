;; Algoritmos y Estructuras de Datos
;; Entrega #3 Programa de Ejemplo
;; Autor: Hugo Méndez - 241265


;; Este programa en Clojure se encarga de procesar un texto para identificar las palabras más frecuentes.
;; Utiliza funciones para limpiar el texto, contar las palabras y obtener las más frecuentes.
;;

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